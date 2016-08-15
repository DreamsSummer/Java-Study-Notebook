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
	
	//�����ı���JLabel��
	//���������JTextField��
	//�ĸ���ť��JButton���󣩣�һ��JOptionPane����
	
	public JLabel pnameLabel = new JLabel("����");
	private JLabel pnumberLabel = new JLabel("�绰");
	
	public JTextField pnameTextField = new JTextField(22); //�����ı���ĳ���
	private JTextField pnumberTextField = new JTextField(22);
	
	private JButton addButton = new JButton("����");
	private JButton updateButton = new JButton("�޸�");
	private JButton selButton = new JButton("��ѯ");
	private JButton delButton = new JButton("ɾ��");
	
	public JOptionPane option = new JOptionPane();
	
	
	public AddView(){
		//��˳����ӿؼ���������
		this.add(pnameLabel);
		this.add(pnameTextField);
		this.add(pnumberLabel);
		this.add(pnumberTextField);
		
		this.add(addButton);
		this.add(updateButton);
		this.add(delButton);
		this.add(selButton);
		
		//���ô����С
		this.setSize(300,200);
		//���ô��岼��Ϊ��ģʽ
		this.setLayout(new FlowLayout());
		//���ô���ı���
		this.setTitle("ͨѶ¼");
		//���ô���λ�þ���
		this.setLocationRelativeTo(null);
		//���ô������ʾ
		this.setVisible(true);
		
	//	this.pack();
		BtnClickHandler btnClick = new BtnClickHandler();
		this.addButton.addActionListener(btnClick);
		this.updateButton.addActionListener(btnClick);
		this.delButton.addActionListener(btnClick);
		this.selButton.addActionListener(btnClick);
	}
	
	
//	������
	class BtnClickHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nameanniuString = e.getActionCommand();
			fangfa ff = new fangfa();
			//System.out.println(nameanniuString);
			switch (nameanniuString) {
			case "��ѯ":
				
				try {
					String tel = ff.Select(pnameTextField.getText());
					pnumberTextField.setText(tel);
					
				} catch (Exception e2) {
					option.showMessageDialog(null, "��Ҫ���ҵ���Ա������");
				}
				break;
				
			case "����":
				try {
					//option.showMessageDialog(null, pnameTextField.getText() + pnumberTextField.getText());
					ff.add(pnameTextField.getText(), pnumberTextField.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					option.showMessageDialog(null, "��Ҫ��ӵ���Ա�Ѿ�����");
				}
				break;
				
			case "�޸�":
				try {
					ff.updatePer(pnameTextField.getText(), pnumberTextField.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				break;
			case "ɾ��":
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




