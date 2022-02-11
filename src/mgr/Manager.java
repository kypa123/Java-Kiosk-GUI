package mgr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import store.Order;

public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();
	
	public T find(String kwd) {
	    for (T m: mList)
	    	if (m.matches(kwd))
	    		return m;
	    return null;
	}

	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return filein;
	}

	public void printAll() {
		for (T m : mList) {
			m.print();
		}
	}
	public void searchAll(Scanner scan) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (T m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}
	public List<Manageable> findAll(String kwd){
		return null;
	}
	
	
	public void writeAll(String filename, Factory<T> fac) {
		FileWriter writer;
		String kwd = null;
		
		try {
			writer = new FileWriter(filename);
			for(T m: mList) {
				kwd = m.getinfo();
				writer.write(kwd + "\n");
			   System.out.println("write "+kwd+" test");
			}
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block  System.lineSeparator()
			e.printStackTrace();
		} 
		
		 
	}
	@SuppressWarnings("unchecked")
	public void odread(Order od, Factory<T> fac) {
		T m = null;
		m = fac.create();
		m = (T) od;
		mList.add(m);
	}
	


}