package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

import mgr.*;
import store.*;

public class ProductGui {
	LocalDate curDate = LocalDate.now();
	Order od = new Order();
	int newOrderid = Store.orderMgr.mList.get
			(Store.orderMgr.mList.size()-1).orderId + 1;
	Font font = new Font("Serif",Font.BOLD, 20);
	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	String imgnum;
	LocalDate arrivalDate;
	void addproduct() {	
		productPanel.setPreferredSize(new Dimension(1000,7000));
		productPanel.setLayout(new GridLayout(25,4, 20, 20));
		for(int i=0; i<100; i++) {
			
			Item itm = Store.itemMgr.mList.get(i);
			imgnum = itm.primg;
			ImageIcon productimg =getImg(imgnum, 150);
			
			JButton product = new JButton(productimg);
			product.setBackground(Color.white);
			productPanel.add(product);
			product.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
						 productInfo(itm);
				}
			});
		}
		
		scroll.setPreferredSize(new Dimension(1000, 550));
		MainGUI.leftView.add(BorderLayout.LINE_START,scroll);
		
	}
	
	
	void productInfo(Item clickeditem) {			//클릭하면 나오는 구매창
		JFrame productInfoframe = new JFrame("구매");
		productInfoframe.setSize(800, 600);
		productInfoframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container pane = productInfoframe.getContentPane();
		pane.setLayout(null);
		
		
		ImageIcon productimg = getImg(clickeditem.primg, 300);
		JButton productimage = new JButton(productimg);
		productimage.setBounds(10, 10, 300, 300);
		pane.add(productimage);
		
		LocalDate Date = curDate.plusDays(clickeditem.prDeliver);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
		String prDate = Date.format(formatter);
		JLabel arrivaldate = new JLabel("배송예정일: " + prDate);
		arrivaldate.setFont(font);
		arrivaldate.setBounds(10, 310, 300 , 50);
		pane.add(arrivaldate);
		
		String prprice = Integer.toString(clickeditem.prPrice);
		JLabel price = new JLabel("가격 :" +prprice);
		price.setFont(font);
		price.setBounds(10, 350, 300, 50);
		pane.add(price);
		
		String prsize = clickeditem.prSize;
		JLabel size = new JLabel("사이즈 :" + prsize);
		size.setFont(font);
		size.setBounds(10, 400, 300, 50);
		pane.add(size);
		
		String prtype = clickeditem.prType;
		JLabel type = new JLabel("소재 :" + prtype);
		type.setFont(font);
		type.setBounds(10,450,300,50);
		pane.add(type);
		
		String prcolor = clickeditem.prColor;
		JLabel color = new JLabel("색상 :" + prcolor);
		color.setFont(font);
		color.setBounds(10, 500, 300, 50);
		pane.add(color);
		
		//--------------여기까지가 왼쪽 사진 및 제품정보------------------
		
		
		String prname = clickeditem.prName;
		JLabel name = new JLabel(prname);
		name.setFont(new Font("Serif",Font.BOLD, 20));
		name.setBounds(350, 10, 400, 80);
		pane.add(name);
		
		String prdesc = clickeditem.prDesc;
		JTextArea desc = new JTextArea(prdesc);
		desc.setFont(font);
		desc.setLineWrap(true);
		desc.setBounds(350, 200, 400, 200);
		pane.add(desc);
		
		JLabel qtcheck = new JLabel("수량 :");
		qtcheck.setFont(font);
		qtcheck.setBounds(350, 400, 100, 50);
		pane.add(qtcheck);
		
		JTextField quantity = new JTextField("1");
		quantity.setFont(font);
		quantity.setEditable(false);
		quantity.setBounds(430, 400, 100, 50);
		pane.add(quantity);
		
		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		up.setBounds(570, 400, 80, 40);
		up.setBackground(Color.white);
		down.setBounds(660, 400, 80, 40);
		down.setBackground(Color.white);
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(quantity.getText());
					num ++ ;
					quantity.setText(Integer.toString(num));
			}
		});
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(quantity.getText());
					if(num == 1)
						num = 1;
					else
						--num;
						quantity.setText(Integer.toString(num));
			}
		});
		pane.add(up);
		pane.add(down);
		
		
		
		JButton addtobasket = new JButton("장바구니에 추가");
		addtobasket.setBounds(350, 500, 400,50);
		addtobasket.setBackground(Color.white);
		addtobasket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int qt = 0;
				qt = Integer.parseInt(quantity.getText());
				
				od.orderId = newOrderid;
				od.user = MainGUI.loggedinuser;
				od.address = MainGUI.loggedinuser.address;
				od.orderDate = curDate.toString();
				od.deliveryDate = prDate;
				od.phonenumber = MainGUI.loggedinuser.phoneNum;
				od.orderedItemList.add(clickeditem);
				od.orderedItemCount.add(qt);
				MainGUI.loggedinuser.myOrderList.add(od);
				productInfoframe.dispose();
			}
		});
		addtobasket.setFont(font);
		pane.add(addtobasket);
		
		addtobasket.addActionListener(null);
		
		productInfoframe.setVisible(true);
	}
	
	
	ImageIcon getImg(String imgnum, int num) {
		ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
		Image img = pruductImg.getImage();
		Image changeImg= img.getScaledInstance(num,num, Image.SCALE_SMOOTH);	
		ImageIcon productimg = new ImageIcon(changeImg);
		return productimg;
	}
	
	
	
}