package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachersUpdateDeleteForm extends JFrame {
	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;
	private PreparedStatement ps = null;
	private ResultSet rs = null;	
	
	public TeachersUpdateDeleteForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
				Connection connection = Menu.getConnection();
				
				
				try {
					ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ps.setString(1,  Main.getTeachersSearchForm().getLastname() + "%");
					rs = ps.executeQuery();
					
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						JOptionPane.showMessageDialog(null, "No Teachers found", "Teachers", JOptionPane.WARNING_MESSAGE);
						Main.getTeachersUpdateDeleteForm().setVisible(false);
						Main.getTeachersSearchForm().setEnabled(true);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(127, 24, 17, 14);
		contentPane.add(lblNewLabel);
		
		idTxt = new JTextField();
		idTxt.setBackground(new Color(255, 255, 183));
		idTxt.setEditable(false);
		idTxt.setBounds(154, 21, 70, 20);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setColumns(10);
		firstnameTxt.setBackground(new Color(255, 255, 255));
		firstnameTxt.setBounds(154, 65, 160, 20);
		contentPane.add(firstnameTxt);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setForeground(new Color(139, 0, 0));
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setBounds(96, 68, 48, 14);
		contentPane.add(firstnameLbl);
		
		JLabel firstnameLbl_1 = new JLabel("Επώνυμο");
		firstnameLbl_1.setForeground(new Color(139, 0, 0));
		firstnameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl_1.setBounds(79, 112, 65, 14);
		contentPane.add(firstnameLbl_1);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBackground(Color.WHITE);
		lastnameTxt.setBounds(154, 109, 160, 20);
		contentPane.add(lastnameTxt);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(42, 11, 310, 142);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.first()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/First record.png")));
		btnNewButton.setBounds(78, 164, 35, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.previous()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.first();
					}					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/Previous_record.png")));
		btnNewButton_1.setBounds(121, 164, 35, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.last();
					}					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/Next_track.png")));
		btnNewButton_1_1.setBounds(162, 164, 35, 33);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.last()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/Last_Record.png")));
		btnNewButton_1_1_1.setBounds(199, 164, 35, 33);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton updateBtn = new JButton("Ενημέρωση");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
				
				try {
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					
					String firstname = firstnameTxt.getText().trim();
					String lastname = lastnameTxt.getText().trim();
					String id = idTxt.getText().trim();
					
					if (firstname.equals("") || lastname.equals("")) {
						JOptionPane.showMessageDialog(null,  "Empty firstname / lastname", "Input Error", JOptionPane.ERROR_MESSAGE);;
						return;
					}
							
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setInt(3, Integer.parseInt(id));
					
					int n = ps.executeUpdate();
					
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "Successful Update", "Update", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Update Error", "Update", JOptionPane.INFORMATION_MESSAGE);
					}					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (ps != null) {
							ps.close();
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		updateBtn.setForeground(SystemColor.textHighlight);
		updateBtn.setBounds(100, 210, 89, 29);
		contentPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("Διαγραφή");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELTE FROM TEACHERS WHERE ID = ?";
				
				try {
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt( idTxt.getText()));
					
					int response = JOptionPane.showConfirmDialog(null,  "Είστε σίγουρος", "Warning", JOptionPane.YES_NO_OPTION);
					if (response == JOptionPane.YES_OPTION) {
						int n = ps.executeUpdate();
						JOptionPane.showMessageDialog(null, n + " rows affected", "Delete", JOptionPane.INFORMATION_MESSAGE);
					} else {
						return;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		deleteBtn.setForeground(SystemColor.textHighlight);
		deleteBtn.setBounds(195, 210, 89, 29);
		contentPane.add(deleteBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setEnabled(true);
				Main.getTeachersUpdateDeleteForm().setVisible(false);
			}
		});
		closeBtn.setForeground(SystemColor.textHighlight);
		closeBtn.setBounds(294, 210, 89, 29);
		contentPane.add(closeBtn);
	}
}
