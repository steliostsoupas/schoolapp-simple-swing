package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeachersInsertForm extends JFrame {
	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;
	private JButton insertBtn;
	private JButton closeBtn;

	public TeachersInsertForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				firstnameTxt.setText("");
				lastnameTxt.setText("");
			}
		});
		setTitle("Εισαγωγή Εκπαιδευτή");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setForeground(new Color(139, 0, 0));
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setBounds(101, 57, 74, 23);
		contentPane.add(firstnameLbl);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(174, 60, 119, 20);
		contentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);
		
		JLabel lastnameLbl = new JLabel("Επώνυμο");
		lastnameLbl.setForeground(new Color(139, 0, 0));
		lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLbl.setBounds(101, 94, 74, 23);
		contentPane.add(lastnameLbl);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(174, 97, 119, 20);
		contentPane.add(lastnameTxt);
		
		insertBtn = new JButton("Εισαγωγή");
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
				
				try {
					String firstname = firstnameTxt.getText().trim();
					String lastname = lastnameTxt.getText().trim();
					
					if (firstname.equals("") || lastname.equals("")) {
						JOptionPane.showMessageDialog(null, "Empty firstname / lastname", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					
					int n = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, n + "row affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		insertBtn.setForeground(new Color(0, 0, 255));
		insertBtn.setBounds(146, 200, 119, 37);
		contentPane.add(insertBtn);
		
		closeBtn = new JButton("Κλείσιμο");
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setEnabled(true);
				Main.getTeachersInsertForm().setVisible(false);
			}
		});
		closeBtn.setForeground(new Color(0, 0, 255));
		closeBtn.setBounds(275, 200, 119, 37);
		contentPane.add(closeBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(43, 11, 343, 154);
		contentPane.add(panel);
	}
}
