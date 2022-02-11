package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import shoppingMall.*;
import store.*;
public class Login {
	static JFrame loginFrame = new JFrame("HP Store LogIn");
	static Container contentpane = loginFrame.getContentPane();
	public static void addForm() {
		loginFrame.setLocationRelativeTo(null);
		contentpane.setLayout(null);
		// contentpane.setBackground(new Color(134,197,229, 50));
		contentpane.setBackground(new Color(102,178,255, 95));
		JLabel id= new JLabel("아이디");
		Font f1 = new Font("Aharoni", Font.PLAIN, 20);
		contentpane.setFont(f1); 
		id.setBounds(80, 50, 50, 30);
		JLabel pswd = new JLabel("비밀번호");
		Font f2 = new Font("Aharoni", Font.PLAIN, 20);
		contentpane.setFont(f2);
		pswd.setBounds(80, 100, 50, 30);
		JTextField idinput = new JTextField();
		idinput.setBounds(200, 50, 170, 30);
		JPasswordField pswdinput = new JPasswordField();
		pswdinput.setBounds(200, 100, 170, 30);
		JButton signin = new JButton("로그인");
		JButton signup = new JButton("회원가입");
		signin.setBackground(Color.white);
		signup.setBackground(Color.white);
		signin.setBounds(100, 200, 130, 40);
		signup.setBounds(250, 200, 130, 40);
		contentpane.add(signin);
		contentpane.add(signup);
		contentpane.add(id);
		contentpane.add(pswd);
		contentpane.add(idinput);
		contentpane.add(pswdinput);
		
		signin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idinput.getText();
				@SuppressWarnings("deprecation")
				String pswd = pswdinput.getText();
				if(id.equals("admin") && pswd.equals("admin"))
					AdminGui.main(null);
				else if(Store.userMgr.find(id) == null)
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다");
				else {
					MainGUI.loggedinuser = Store.userMgr.find(id);
					if(MainGUI.loggedinuser.passwordMatch(pswd)) {
						MainGUI.mainFrame.setVisible(true);
						loginFrame.dispose();
						}
					else
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
				}
			}
		});
		
		signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Signin in = new Signin();
			}
		});
	}

	public void main(String[] args) {
		loginFrame.setSize(500,300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addForm();
		loginFrame.setVisible(true);
	}
}