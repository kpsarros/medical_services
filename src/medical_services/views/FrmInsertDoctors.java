package medical_services.views;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

class FrmInsertDoctors extends JFrame {

	private static final long serialVersionUID = 1L;

	//protected static Object conn;

	private JTextField txtDoctorId;
	private JTextField txtSName;
	private JTextField txtSSN;
	private JTextField txtSpecialty;
	private JTextField txtFName;

	/**
	 * Create the frame.
	 */
	public FrmInsertDoctors() {
		initComponents();
	}

	private void initComponents() {

		setPreferredSize(new Dimension(3, 3));

		setTitle("Καταχώρηση Ιατρού");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 429, 307);
		setBackground(SystemColor.activeCaption);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblDoctorId = new JLabel("Κωδικός Ιατρού");
		lblDoctorId.setForeground(new Color(153, 0, 0));
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoctorId.setBounds(20, 26, 121, 16);
		contentPane.add(lblDoctorId);

		JLabel lblSName = new JLabel("Επώνυμο");
		lblSName.setForeground(new Color(153, 0, 0));
		lblSName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSName.setBounds(20, 58, 121, 16);
		contentPane.add(lblSName);

		JLabel lblFName = new JLabel("Όνομα");
		lblFName.setForeground(new Color(153, 0, 0));
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFName.setBounds(20, 90, 121, 16);
		contentPane.add(lblFName);

		JLabel lblSSN = new JLabel("ΑΜΚΑ");
		lblSSN.setForeground(new Color(153, 0, 0));
		lblSSN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSSN.setBounds(20, 122, 121, 16);
		contentPane.add(lblSSN);

		JLabel lblSpecialty = new JLabel("Ειδικότητα");
		lblSpecialty.setForeground(new Color(153, 0, 0));
		lblSpecialty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialty.setBounds(20, 154, 121, 16);
		contentPane.add(lblSpecialty);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get Values
					int id = Integer.parseInt(txtDoctorId.getText());
					String sname = txtSName.getText();
					String fname = txtFName.getText();
					int ssn = Integer.parseInt(txtSSN.getText());
					int specialty = Integer.parseInt(txtSpecialty.getText());

					// Prepare Statement
					String sql = "INSERT INTO medicalservices.doctors VALUES (?, ?, ?, ?, ?)";
					PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql);
					// Set Values
					  ps.setInt(1, id);
					  ps.setString(2, sname);
					  ps.setString(3, fname);
					  ps.setInt(4, ssn);
					  ps.setInt(5, specialty);
					// Execute
					int n = ps.executeUpdate();
					// Show Feedback
					JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", JOptionPane.PLAIN_MESSAGE);
					//Close PreparedStatement
					ps.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Invalid Key for DOCTOR_ID," + " Please try again", "Error",
							JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid Key for DOCTOR_ID 2," + " Please try again", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.setForeground(new Color(0, 0, 153));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.setBounds(231, 239, 85, 21);
		contentPane.add(btnInsert);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.initialScreenFrame.setEnabled(true);
				MedicalServices.InsertDoctorsFrame.setVisible(false);
			}
		});
		btnClose.setBackground(Color.LIGHT_GRAY);
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(320, 239, 85, 21);
		contentPane.add(btnClose);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 3));
		separator.setBounds(20, 209, 370, 2);
		contentPane.add(separator);

		txtDoctorId = new JTextField();
		txtDoctorId.setBounds(151, 26, 108, 19);
		contentPane.add(txtDoctorId);
		txtDoctorId.setColumns(10);

		txtSName = new JTextField();
		txtSName.setBounds(151, 58, 180, 19);
		contentPane.add(txtSName);
		txtSName.setColumns(10);

		txtFName = new JTextField();
		txtFName.setBounds(151, 90, 180, 19);
		contentPane.add(txtFName);
		txtFName.setColumns(10);

		txtSSN = new JTextField();
		txtSSN.setBounds(151, 122, 180, 19);
		contentPane.add(txtSSN);
		txtSSN.setColumns(10);

		txtSpecialty = new JTextField();
		txtSpecialty.setBounds(151, 154, 180, 19);
		contentPane.add(txtSpecialty);
		txtSpecialty.setColumns(10);
	}
}
