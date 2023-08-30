package medical_services.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.border.CompoundBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrmInitialScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Connection conn;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrmInitialScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmInitialScreen.class.getResource("/medical_services/resources/health-check.png")));
		setBounds(new Rectangle(400, 400, 400, 400));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				String url = "jdbc:mysql://localhost:3306/medicalservices?useSSL=false";
				String username = MedicalServices.loginFrame.txtUserName.getText().toString();
				//String password = MedicalServices.loginFrame.passwordField.getPassword().toString();
				String password = MedicalServices.loginFrame.passwordField.getText().toString();
				try {
					conn = DriverManager.getConnection(url, username, password);
				}catch (SQLException ex) {
				    throw new IllegalStateException("Cannot connect the database!", ex);
				}	
			}
			@Override
			public void windowOpened(WindowEvent e) {
				String url = "jdbc:mysql://localhost:3306/medicalservices?useSSL=false";
				String username = MedicalServices.loginFrame.txtUserName.getText().toString();
				String password = MedicalServices.loginFrame.passwordField.getText().toString();
				try {
					conn = DriverManager.getConnection(url, username, password);
				}catch (Exception ex) {
					throw new IllegalStateException("Cannot connect the database!", ex);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 718, 494);
		setTitle("Ιατρικές Υπηρεσίας");

		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		ImageIcon initialNurse = new ImageIcon(FrmInitialScreen.class.getResource("/medical_services/resources/Hospital nurse.png")); 
		Image initialNurseImage = initialNurse.getImage(); 
		Image modifiedNurseImage = initialNurseImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
		ImageIcon newNurseIcon = new ImageIcon(modifiedNurseImage);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 0, 109, 435);
		panelButtons.setBackground(Color.LIGHT_GRAY);
		
		JButton btnDoctors = new JButton("");
		btnDoctors.setIcon(new ImageIcon(FrmInitialScreen.class.getResource("/medical_services/resources/icons8-medical-doctor-94.png")));
		btnDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.mainFrame.setEnabled(false);
	            MedicalServices.InsertDoctorsFrame.setVisible(true);
			}
		});
		btnDoctors.setForeground(new Color(0, 0, 0));
		btnDoctors.setBackground(Color.WHITE);
		
		JButton btnPatients = new JButton("");
		btnPatients.setIcon(new ImageIcon(FrmInitialScreen.class.getResource("/medical_services/resources/icons8-patient-care-50.png")));
		btnPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.InsertPatientsFrame.setVisible(true);
				MedicalServices.mainFrame.setEnabled(false);
			}
		});
		btnPatients.setForeground(new Color(0, 0, 0));
		btnPatients.setBackground(Color.WHITE);
		
		JLabel lblAppoitments = new JLabel("Ραντεβού");
		lblAppoitments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppoitments.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnAppoitments = new JButton("");
		btnAppoitments.setIcon(newNurseIcon);
		
		btnAppoitments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.initialScreenFrame.setEnabled(true);
				MedicalServices.mainFrame.setVisible(true);
				MedicalServices.initialScreenFrame.setEnabled(false);			
					 
			}
		});
		contentPane.setLayout(null);
		btnAppoitments.setBackground(Color.WHITE);
		
		JLabel lblPatients = new JLabel("Ασθενείς");
		lblPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatients.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblDoctors = new JLabel("Ιατροί");
		lblDoctors.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctors.setFont(new Font("Tahoma", Font.BOLD, 10));
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAppoitments, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
						.addGroup(gl_panelButtons.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblPatients, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDoctors, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDoctors, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE))
						.addGroup(gl_panelButtons.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblAppoitments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPatients, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
					.addGap(8))
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(5)
					.addComponent(lblDoctors, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnDoctors, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPatients, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPatients, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAppoitments, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAppoitments, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(44))
		);
		panelButtons.setLayout(gl_panelButtons);
		contentPane.add(panelButtons);
		
				JPanel panelImage = new JPanel();
				panelImage.setBounds(111, 0, 593, 435);
				panelImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JLabel lblImage = new JLabel("");
				lblImage.setBackground(Color.WHITE);
				lblImage.setHorizontalTextPosition(SwingConstants.CENTER);
				lblImage.setHorizontalAlignment(SwingConstants.CENTER);
				lblImage.setBounds(2, 2, 591, 431);
				ImageIcon initialIcon = new ImageIcon(FrmInitialScreen.class.getResource("/medical_services/resources/health-care.png")); 
				Image initialImage = initialIcon.getImage(); 
				Image modifiedImage = initialImage.getScaledInstance(310, 220, Image.SCALE_SMOOTH); 
				ImageIcon newIcon = new ImageIcon(modifiedImage);
				lblImage.setIcon(newIcon);
				
				contentPane.add(panelImage);
				panelImage.setLayout(null);
				panelImage.add(lblImage);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//--------------------------------------------------------------------------------
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenu appMenuInFileMenu = new JMenu("App");
		fileMenu.add(appMenuInFileMenu);

		final JMenuItem itemCloseInAppMenu = new JMenuItem("Close");
		itemCloseInAppMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(itemCloseInAppMenu, "Είστε σίγουρος ότι θέλετε να κλείσετε την εφαρμογή ;");
				if (ret == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.loginFrame.setVisible(true);
				MedicalServices.initialScreenFrame.setEnabled(false);
			}
		});
		appMenuInFileMenu.add(mntmLogin);
		itemCloseInAppMenu.setIcon(null);
		appMenuInFileMenu.add(itemCloseInAppMenu);
		
		JMenu mnHelp = new JMenu("Βοήθεια");
		menuBar.add(mnHelp);

		JMenuItem mntmVersion = new JMenuItem("Έκδοση");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.versionFrame.setVisible(true);
				MedicalServices.mainFrame.setEnabled(false);
			}
		});
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.aboutFrame.setVisible(true);
				MedicalServices.initialScreenFrame.setEnabled(false);
			}
		});
		mnHelp.add(mntmAbout);
		mnHelp.add(mntmVersion);

	}
}
