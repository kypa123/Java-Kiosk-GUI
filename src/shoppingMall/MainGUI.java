package shoppingMall;

import java.awt.*;

import javax.swing.*;

import login.*;
import store.*;

public class MainGUI {
	static JPanel menuPanel = new JPanel();
	static JPanel products = new JPanel();
	static JPanel leftView = new JPanel();
	static public JFrame mainFrame = new JFrame("행복한 판매팀");
	static Container mainPane = mainFrame.getContentPane();
	static JPanel basketpanel = new JPanel();
	static Store store = new Store();
	public static Login login = new Login();
	public static User loggedinuser = new User();
	public static BasketGui basket = new BasketGui();
	static void addComponentsToPane() {
		GuiMenu guimenu = new GuiMenu();
		GuiUppermenu upmenu = new GuiUppermenu();
		ProductGui productgui = new ProductGui();
		
		guimenu.addMenu();
		upmenu.addMenu();
		basket.addBasket();
		productgui.addproduct();
		mainPane.add(menuPanel, BorderLayout.LINE_END);
		mainPane.add(basketpanel);
		basketpanel.setVisible(false);
		mainPane.add(leftView);
	}
	public static void createAndShowGUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 700);
		mainFrame.setLocationRelativeTo(null);
		MainGUI.addComponentsToPane();
		mainFrame.setVisible(false);
	}
	public static void main(String[] args) {
		store.run();
		MainGUI.createAndShowGUI();
		login.main(args);
	}
}