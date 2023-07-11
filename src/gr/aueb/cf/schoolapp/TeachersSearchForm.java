package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachersSearchForm extends JFrame {
	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField lastnameTxt;
	private String lastname = "";

	/**
	 * Create the frame.
	 */
	public TeachersSearchForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 412);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setBounds(234, 41, 149, 36);
		contentPane.add(lastnameTxt);
		lastnameTxt.setColumns(10);
		
		JLabel LabelLastname = new JLabel("Επώνυμο");
		LabelLastname.setBounds(272, 11, 72, 20);
		LabelLastname.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelLastname.setForeground(new Color(255, 0, 0));
		contentPane.add(LabelLastname);
		
		JButton searchBtn = new JButton("Αναζήτηση");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastname = lastnameTxt.getText();
				Main.getTeachersUpdateDeleteForm().setVisible(true);
				Main.getTeachersSearchForm().setEnabled(false);
			}
		
		});
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		searchBtn.setForeground(new Color(30, 144, 255));
		searchBtn.setBounds(245, 101, 127, 46);
		contentPane.add(searchBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(183, 11, 251, 161);
		contentPane.add(panel);
		
		JButton insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersInsertForm().setVisible(true);
				Main.getTeachersSearchForm().setEnabled(false);
			}
		});
		insertBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertBtn.setBounds(231, 236, 154, 23);
		contentPane.add(insertBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(183, 204, 251, 87);
		contentPane.add(panel_1);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setEnabled(true);
				Main.getTeachersSearchForm().setVisible(false);
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		closeBtn.setBounds(268, 309, 81, 36);
		contentPane.add(closeBtn);
	}

	public String getLastname() {
		return lastname;
	}
}
