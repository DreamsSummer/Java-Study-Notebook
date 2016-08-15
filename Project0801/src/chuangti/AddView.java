package chuangti;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fangfalei.fangfa;

public class AddView extends JFrame{
	
	//两个文本（JLabel）
	//两个输入框（JTextField）
	//四个按钮（JButton对象），一个JOptionPane对象
	
	public JLabel pnameLabel = new JLabel("姓名");
	private JLabel pnumberLabel = new JLabel("电话");
	
	public JTextField pnameTextField = new JTextField(22); //代表文本框的长度
	private JTextField pnumberTextField = new JTextField(22);
	
	private JButton addButton = new JButton("增加");
	private JButton updateButton = new JButton("修改");
	private JButton selButton = new JButton("查询");
	private JButton delButton = new JButton("删除");
	
	public JOptionPane option = new JOptionPane();
	
	
	public AddView(){
		//按顺序添加控件到窗体中
		this.add(pnameLabel);
		this.add(pnameTextField);
		this.add(pnumberLabel);
		this.add(pnumberTextField);
		
		this.add(addButton);
		this.add(updateButton);
		this.add(delButton);
		this.add(selButton);
		
		//设置窗体大小
		this.setSize(300,200);
		//设置窗体布局为流模式
		this.setLayout(new FlowLayout());
		//设置窗体的标题
		this.setTitle("通讯录");
		//设置窗体位置居中
		this.setLocationRelativeTo(null);
		//设置窗体的显示
		this.setVisible(true);
		
	//	this.pack();
		BtnClickHandler btnClick = new BtnClickHandler();
		this.addButton.addActionListener(btnClick);
		this.updateButton.addActionListener(btnClick);
		this.delButton.addActionListener(btnClick);
		this.selButton.addActionListener(btnClick);
	}
	
	
//	监听类
	class BtnClickHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nameanniuString = e.getActionCommand();
			fangfa ff = new fangfa();
			//System.out.println(nameanniuString);
			switch (nameanniuString) {
			case "查询":
				
				try {
					String tel = ff.Select(pnameTextField.getText());
					pnumberTextField.setText(tel);
					
				} catch (Exception e2) {
					option.showMessageDialog(null, "想要查找的人员不存在");
				}
				break;
				
			case "增加":
				try {
					//option.showMessageDialog(null, pnameTextField.getText() + pnumberTextField.getText());
					ff.add(pnameTextField.getText(), pnumberTextField.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					option.showMessageDialog(null, "想要添加的人员已经存在");
				}
				break;
				
			case "修改":
				try {
					ff.updatePer(pnameTextField.getText(), pnumberTextField.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				break;
			case "删除":
				try {
					ff.delete(pnameTextField.getText(), pnumberTextField.getName());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}
	
	
	
}




