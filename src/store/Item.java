package store;

import mgr.Manageable;
import java.util.Scanner;


public class Item implements Manageable {
	  public String prCode;
	    public String prType;
	    public String  prName;
	    public int prPrice;
	    public int prStock;
	    public String prSize;
	    public String prMeta;
	    public String prColor;
	    public String prDesc;
	    public String primg;
		public int prDeliver;
		public int prDeliver2;
    
    public void read(Scanner scan) {
        prCode = scan.next();
        System.out.print(prCode);
        prType = scan.next();
        System.out.print(prType);
        prName = scan.next();
        System.out.print(prName);
        prPrice = scan.nextInt();
        System.out.print(prPrice);
        prStock = scan.nextInt();
        System.out.print(prStock);
        prSize = scan.next();
        System.out.print(prSize);
        prMeta = scan.next();
        System.out.print(prMeta);
        prColor = scan.next();
        System.out.print(prColor);
        prDesc = scan.next();
        System.out.print(prDesc);
        primg = scan.next();
        System.out.print(primg);
        prDeliver = scan.nextInt();
        System.out.println(prDeliver);
        prDeliver2 = scan.nextInt();
    }
    
    public void print() { // Item
    	System.out.printf("%s %s %s %d %d %s %s %s %s %d",
			prCode, prType, prName, prPrice, prStock, prSize, prMeta, prColor, prDesc, prDeliver );
    	System.out.println();
    }
    
    public boolean matches(String kwd) {
        if (prName.contains(kwd))
            return true;
        if (kwd.length() > 2 && prCode.contains(kwd))
            return true;
        return false;
    }

    public boolean matches(String[] kwdArr) {
        for (String kwd : kwdArr) {
            if (!matches(kwd))
                return false;
        }
        return true;
    }

	public int getSubtotal(int count) {
		return prPrice * count;
	}
	public String getinfo() {
		String kwd;
		kwd = prCode +"	" + prType +"	" + prName +"	" + prPrice +" " + prStock +"	" + prSize +"	" + prMeta +"	" + prColor +"	" + prDesc +"	"+ primg +"	" + prDeliver +"	" + prDeliver2;
		
		return kwd;
		
	}


}