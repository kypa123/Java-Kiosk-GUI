package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;
public class GuiUppermenu {
	    JPanel upperMenu = new JPanel();
//		JLabel sortMenuLabel = new JLabel();
//		JLabel selectedSort = new JLabel();
//		String sortMenus[] = {"옷 종류", "색상", "사이즈", "소재", "빠른 배송"};
	void addMenu() {
//		upperMenu.setPreferredSize(new Dimension(1050,130));
//		sortMenuLabel.setPreferredSize(new Dimension(1000,55));
//		sortMenuLabel.setLayout(null);
//		upperMenu.setBackground(Color.white);
//		for(int i=0; i<sortMenus.length; i++) {
//			JButton button = new JButton(sortMenus[i]);
//			sortMenuLabel.add(button);
//			int xcode = 30;										//버튼의 x값 초기위치
//			xcode += i*(180);
//			button.setBounds(xcode, 5, 150, 50);
//			button.setBackground(Color.white);
//			if(i == 0) {
//				button.setForeground(Color.red);
//				}
//				else if(i==1) {
//					button.setForeground(Color.magenta);
//				}
//				else if(i==2) {
//					button.setForeground(Color.green);
//				}
//				else if(i==3) {
//					button.setForeground(Color.blue);
//				}
//				else if(i==4) {
//					button.setForeground(Color.cyan);
//				}
//				else if(i==5) {
//					button.setForeground(Color.ORANGE);
//				}					
//		}
//		upperMenu.add(sortMenuLabel);
//		
//		selectedSort.setPreferredSize(new Dimension(1000, 130));
//		selectedSort.setLayout(null);
//		JButton reset = new JButton("초기화");
//		
//		for(int i=0;i<sortMenus.length; i++) {
//			int xcode = 70;										
//			xcode += i*(160);
//
//			JLabel sortLabel = new JLabel("["+sortMenus[i]+"] :");
//			if(i == 0) {
//			sortLabel.setForeground(Color.red);
//			}
//			else if(i==1) {
//				sortLabel.setForeground(Color.magenta);
//			}
//			else if(i==2) {
//				sortLabel.setForeground(Color.green);
//			}
//			else if(i==3) {
//				sortLabel.setForeground(Color.blue);
//			}
//			else if(i==4) {
//				sortLabel.setForeground(Color.cyan);
//			}
//			else if(i==5) {
//				sortLabel.setForeground(Color.ORANGE);
//			}
//			selectedSort.add(sortLabel);
//			sortLabel.setBounds(xcode, 0, 200, 50);
//		}
//		selectedSort.add(reset);
//		reset.setBounds(905, 0, 80, 40);
//		reset.setBackground(Color.white);
//		upperMenu.add(selectedSort);
		ImageIcon logo = getImg("logo2.png", 130);
		JButton imglogo = new JButton(logo);
		imglogo.setBackground(Color.white);
		imglogo.setBorderPainted(false);
		imglogo.setBounds(600, 0, 130, 130);
		
		
		upperMenu.add(imglogo);
		
		
		MainGUI.leftView.add(upperMenu);
	}
	ImageIcon getImg(String imgnum, int num) {
			ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
			Image img = pruductImg.getImage();
			Image changeImg= img.getScaledInstance(num,num, Image.SCALE_SMOOTH);	
			ImageIcon productimg = new ImageIcon(changeImg);
			return productimg;
		}
	
}