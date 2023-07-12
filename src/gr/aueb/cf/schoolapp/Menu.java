package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	
	private static final long serialVersionUID = 123456;
	private JPanel contentPanel;
	private static Connection connection;
	
	public Menu() {
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String username = "schooldbuser";
				String password = System.getenv("SCHOOL_DB_USER_PASSWD");
				String url = "jdbc:mysql://localhost:3306/schoolDB?serverTimezone=UTC";
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url, username, password);
					System.out.println("Connection established");					
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Stelios\\eclipse-workspace\\SchoolApp\\bin\\resources\\MicrosoftTeams-image (3).png"));
		setTitle("Μενού Διαχείρισης Σχολικού Συστήματος");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 532, 428);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JButton teachersBtn = new JButton("");
		teachersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setVisible(true);
				Main.getMenu().setEnabled(false);
			}
		});
		teachersBtn.setBounds(43, 258, 45, 45);
		contentPanel.add(teachersBtn);
		
		JLabel lblNewLabel = new JLabel("Εκπαιδευτές");
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(115, 270, 100, 19);
		contentPanel.add(lblNewLabel);
		
		JLabel lblEdyQuality1 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblEdyQuality1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdyQuality1.setBounds(127, 24, 225, 51);
		contentPanel.add(lblEdyQuality1);
		
		JLabel lblStudents = new JLabel("Μαθητές");
		lblStudents.setForeground(new Color(255, 0, 51));
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudents.setBounds(115, 185, 100, 19);
		contentPanel.add(lblStudents);
		
		JButton studentsBtn = new JButton("");
		studentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentsBtn.setBounds(43, 175, 45, 45);
		contentPanel.add(studentsBtn);
		
		JLabel lblEdyQuality2 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblEdyQuality2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdyQuality2.setBounds(127, 25, 347, 48);
		contentPanel.add(lblEdyQuality2);
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
