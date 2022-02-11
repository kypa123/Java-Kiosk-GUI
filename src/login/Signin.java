package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import store.Item;
import store.Store;
import store.User;

public class Signin extends JFrame{
	private JPanel contentPane;
	private JLabel lblJoin;
	private JButton joinCompleteBtn;
	private JTextField Id;
	private JTextField Password;
	private JTextField Phone;
	private JTextField Address;
	private JButton cancelBtn;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Signin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("HP Store Join");
		setSize(430, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102,178,255, 95));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJoin = new JLabel("회원가입");
		Font f1 = new Font("Aharoni", Font.BOLD, 20);
		lblJoin.setFont(f1); 
		lblJoin.setBounds(159, 41, 101, 20);
		lblJoin.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblJoin);
		
		JLabel name = new JLabel("이름");
		Font f2 = new Font("Aharoni", Font.PLAIN, 12);
		name.setFont(f2);
		name.setBounds(69, 113, 69, 20);
		contentPane.add(name);
		
		JLabel password = new JLabel("비밀번호");
		password.setFont(f2);
		password.setBounds(69, 163, 69, 20);
		contentPane.add(password);
		
		
		JLabel address = new JLabel("주소");
		address.setFont(f2);
		address.setBounds(69, 213, 69, 20);
		contentPane.add(address);
		
		JLabel phone = new JLabel("전화번호");
		phone.setFont(f2);
		phone.setBounds(69, 260, 69, 20);
		contentPane.add(phone);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(159, 106, 186, 35);
		contentPane.add(Id);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(159, 156, 186, 35);
		contentPane.add(Password);
		
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(159, 203, 186, 35);
		contentPane.add(Address);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(159, 250, 186, 35);
		contentPane.add(Phone);
		
		joinCompleteBtn = new JButton("회원가입");
		Font f6 = new Font("Aharoni", Font.PLAIN, 12);
		joinCompleteBtn.setFont(f2);
		joinCompleteBtn.setBounds(80, 363, 120, 29);
		joinCompleteBtn.setBackground(Color.white);
		contentPane.add(joinCompleteBtn);
		
		cancelBtn = new JButton("취소");
		cancelBtn.setFont(f2);
		cancelBtn.setBounds(225, 363, 120, 29);
		cancelBtn.setBackground(Color.white);
		contentPane.add(cancelBtn);
		
		setVisible(true);
		joinCompleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User usr = new User();
				usr.userId = Id.getText();
				usr.pwd = Password.getText();
				usr.address = Address.getText();
				usr.phoneNum = Phone.getText();
				Store.userMgr.mList.add(usr);
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				dispose();
			}
		});

	}


}