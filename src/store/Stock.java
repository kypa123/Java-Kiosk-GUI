package store;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Stock implements Manageable{
	String prCode2;
	int newStock;
	String tempDate;
	LocalDate StockDate;
	LocalDate testDate;
	int periodDate;
	
	ArrayList<Stock> stockChangeList = new ArrayList<>();
	
	 public void read(Scanner scan) {
	     testDate = LocalDate.now();
		 prCode2 = scan.next();
	     newStock = scan.nextInt();
	     tempDate = scan.next();
	     DateTimeFormatter Ndate = DateTimeFormatter.ofPattern("yyyyMMdd");
	     StockDate = LocalDate.parse(tempDate, Ndate); 
	    
	     periodDate = (int) ChronoUnit.DAYS.between(testDate,StockDate);
	        System.out.print(periodDate);
	        
	    Item item = null;
		item = (Item)Store.itemMgr.find(prCode2);
		item.prDeliver2 = periodDate+2;
		
		stockChangeList.add(this);
	    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return false;
	}
	
	static public void stockChange(String kwd) {
		int alpha; 
		Stock beta = new Stock();
		Item item = (Item)Store.itemMgr.find(kwd);
		item.prDeliver = item.prDeliver2;
		item.prStock = beta.newStock;
		Stock sInfo = null;
		sInfo = (Stock)Store.stockMgr.find(kwd);
		if (sInfo == null)
			return;
		alpha = sInfo.newStock;
		
		item.prStock = alpha; 
		
	}

	@Override
	public String getinfo() {
		// TODO Auto-generated method stub
		return null;
	}
}