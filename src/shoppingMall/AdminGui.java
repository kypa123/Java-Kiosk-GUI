package shoppingMall;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


import store.*;

public class AdminGui {
	static ActionListener listener = new ButtonListener();
	static public JFrame adminFrame = new JFrame("관리자 GUI");
	static Container pane = adminFrame.getContentPane();
	static Font font = new Font("Serif",Font.PLAIN, 18);	//이쁜폰트 추천받습니다..
	public static void main(String[] args) {
		AdminGui.createAndShowGUI();
	}
	public static void createAndShowGUI() {
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setSize(1200, 700);
		adminFrame.setLayout(null);
		adminFrame.setLocationRelativeTo(null);
		addAdmin();
		addTable();
		pane.setBackground(Color.gray);
		adminFrame.setVisible(true);
	}
	static void addAdmin() {
		JButton searchproduct = new JButton("제품 검색");
		searchproduct.setBounds(1020, 70, 150, 150 );
		searchproduct.setBackground(Color.white);
		searchproduct.setFont(font);
		searchproduct.addActionListener(listener);
		pane.add(searchproduct);
		
		JButton searchuser = new JButton("유저 검색");
		searchuser.setBounds(1020, 260, 150, 150);
		searchuser.setBackground(Color.white);
		searchuser.setFont(font);
		searchuser.addActionListener(listener);
		pane.add(searchuser);
		
		
		JButton logout = new JButton("로그아웃");
		logout.setBounds(1020, 450, 150, 150);	
		logout.setBackground(Color.white);
		logout.setFont(font);
		logout.addActionListener(listener);
		pane.add(logout);
		
		ImageIcon logo = new ImageIcon("./images/logo2.png");			//보노보노이미지 삽입
		Image img = logo.getImage();
		Image changeImg= img.getScaledInstance(180,160, Image.SCALE_SMOOTH);
		ImageIcon logo2 = new ImageIcon(changeImg);
		JButton logobutton = new JButton(logo2);
		logobutton.setBorderPainted(false);
		logobutton.setBackground(Color.white);
		
		logobutton.setBounds(500, 20, 180, 160);
		pane.add(logobutton);
		
	}
	static void addTable() {
		String header[] = {"제품코드", "제품명", "수량", "입고예정일", "입고수량"};
		String contents[][] = {{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
		JTable table = new JTable(contents,header);
		for(int i=0;i<Store.itemMgr.mList.size(); i++) {
			Item item = Store.itemMgr.mList.get(i);
			table.setValueAt(item.prCode, i, 0);
			table.setValueAt(item.prName, i, 1);
			table.setValueAt(Integer.toString(item.prStock), i, 2);
			table.setValueAt("입고예정일", i, 3);
			table.setValueAt("입고수량", i, 4);
		}
		
		
		table.setPreferredSize(new Dimension(800, 1000));
		JScrollPane scroll = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setPreferredSize(new Dimension(820, 700));
		scroll.setBounds(150, 200, 820, 400);
		
		
		pane.add(scroll);
	}
	static class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Item itm = null;
			User usr = null;
			String buttonName = e.getActionCommand();
			if(buttonName.equals("제품 검색")) {
				String productName = JOptionPane.showInputDialog("제품 이름을 입력하세요");
				if(productName == null)
					return;
				for(int i=0;i<Store.itemMgr.mList.size();i++) {
					if(Store.itemMgr.mList.get(i).matches(productName)) {
						itm = Store.itemMgr.mList.get(i);
						JOptionPane.showMessageDialog(null, "제품명: " +itm.prName+"\n제품코드: "+itm.prCode+"\n재고수량: "+ itm.prStock);
					}
				}
			}
			else if(buttonName.equals("유저 검색")) {
				String username = JOptionPane.showInputDialog("유저아이디를 입력하세요");
				if(username == null)
					return;
				for(int i=0;i<Store.userMgr.mList.size();i++){
					if(Store.userMgr.mList.get(i).matches(username)) {
						usr = Store.userMgr.mList.get(i);
						JOptionPane.showMessageDialog(null, "유저아이디: "+usr.userId +"\n비밀번호: "+usr.pwd);
					}
				}		
			}
			else if(buttonName.equals("로그아웃")) {
				adminFrame.dispose();
				MainGUI.login.main(null);
			}
		}
	}
}