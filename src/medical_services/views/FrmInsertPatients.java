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

public class FrmInsertPatients extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtPatientId;
	private JTextField txtSName;
	private JTextField txtSSN;
	private JTextField txtBirhtdate;
	private JTextField txtFName;
	private JTextField txtGender;
	private JTextField txtAlergies;
	private JTextField txtLastVisitDate;
	private JTextField txtComments;
	private JTextField txtPrDoctorId;

	/**
	 * Create the frame.
	 */
	public FrmInsertPatients() {

		setPreferredSize(new Dimension(3, 3));

		setTitle("Καταχώρηση Ασθενούς");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 863, 307);
		setBackground(SystemColor.activeCaption);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblPatientId = new JLabel("Κωδικός Ασθενούς");
		lblPatientId.setForeground(new Color(153, 0, 0));
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatientId.setBounds(34, 26, 136, 16);
		contentPane.add(lblPatientId);

		JLabel lblSName = new JLabel("Επώνυμο");
		lblSName.setForeground(new Color(153, 0, 0));
		lblSName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSName.setBounds(34, 61, 121, 16);
		contentPane.add(lblSName);

		JLabel lblFName = new JLabel("Όνομα");
		lblFName.setForeground(new Color(153, 0, 0));
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFName.setBounds(34, 93, 121, 16);
		contentPane.add(lblFName);

		JLabel lblSSN = new JLabel("ΑΜΚΑ");
		lblSSN.setForeground(new Color(153, 0, 0));
		lblSSN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSSN.setBounds(34, 125, 121, 16);
		contentPane.add(lblSSN);

		JLabel lblBirthdate = new JLabel("Ημερομηνία Γέννησης");
		lblBirthdate.setForeground(new Color(153, 0, 0));
		lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthdate.setBounds(34, 157, 174, 16);
		contentPane.add(lblBirthdate);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get Values
					int id = Integer.parseInt(txtPatientId.getText());
					String sname = txtSName.getText();
					String fname = txtFName.getText();
					int ssn = Integer.parseInt(txtSSN.getText());
					String brthdate = txtBirhtdate.getText();
					String gen = txtGender.getText();
					String alerg = txtAlergies.getText();
					String lvisitdt = txtLastVisitDate.getText();
					String com = txtComments.getText();
					int did = Integer.parseInt(txtPrDoctorId.getText());

					// Prepare Statement
					String sql = "INSERT INTO medicalservices.patients VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql);
					// Set Values
					ps.setInt(1, id);
					ps.setString(2, sname);
					ps.setString(3, fname);
					ps.setInt(4, ssn);
					ps.setString(5, gen);
					ps.setString(6, brthdate);
					ps.setString(7, lvisitdt);
					ps.setString(8, alerg);
					ps.setString(9, com);
					ps.setInt(10, did);

					// Execute
					int n = ps.executeUpdate();
					// Show Feedback
					JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", JOptionPane.PLAIN_MESSAGE);

					ps.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Invalid Key for PATIENT_ID,"
							+ " Please try again", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid Key for PATIENT_ID 2,"
							+ " Please try again", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.setForeground(new Color(0,0, 153));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.setBounds(649, 239, 85, 21);
		contentPane.add(btnInsert);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.initialScreenFrame.setEnabled(true);
				MedicalServices.InsertPatientsFrame.setVisible(false);
			}
		});
		btnClose.setBackground(Color.LIGHT_GRAY);
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(738, 239, 85, 21);
		contentPane.add(btnClose);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(110, 3));
		separator.setBounds(20, 209, 810, 2);
		contentPane.add(separator);

		txtPatientId = new JTextField();
		txtPatientId.setBounds(232, 26, 108, 19);
		contentPane.add(txtPatientId);
		txtPatientId.setColumns(10);

		txtSName = new JTextField();
		txtSName.setBounds(232, 58, 180, 19);
		contentPane.add(txtSName);
		txtSName.setColumns(10);

		txtFName = new JTextField();
		txtFName.setBounds(232, 90, 180, 19);
		contentPane.add(txtFName);
		txtFName.setColumns(10);

		txtSSN = new JTextField();
		txtSSN.setBounds(232, 122, 180, 19);
		contentPane.add(txtSSN);
		txtSSN.setColumns(10);

		txtBirhtdate = new JTextField();
		txtBirhtdate.setBounds(232, 151, 180, 19);
		contentPane.add(txtBirhtdate);
		txtBirhtdate.setColumns(10);

		JLabel lblGender = new JLabel("Φύλλο");
		lblGender.setForeground(new Color(153, 0, 0));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(454, 26, 121, 16);
		contentPane.add(lblGender);

		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(595, 26, 108, 19);
		contentPane.add(txtGender);

		JLabel lblAlergies = new JLabel("Αλεργίες");
		lblAlergies.setForeground(new Color(153, 0, 0));
		lblAlergies.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlergies.setBounds(454, 58, 121, 16);
		contentPane.add(lblAlergies);

		txtAlergies = new JTextField();
		txtAlergies.setColumns(10);
		txtAlergies.setBounds(595, 58, 180, 19);
		contentPane.add(txtAlergies);

		JLabel lblLastVisitDate = new JLabel("Τελευταία Επίσκεψη");
		lblLastVisitDate.setForeground(new Color(153, 0, 0));
		lblLastVisitDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastVisitDate.setBounds(454, 93, 136, 16);
		contentPane.add(lblLastVisitDate);

		txtLastVisitDate = new JTextField();
		txtLastVisitDate.setColumns(10);
		txtLastVisitDate.setBounds(595, 94, 180, 19);
		contentPane.add(txtLastVisitDate);

		JLabel lblComments = new JLabel("Σχόλια");
		lblComments.setForeground(new Color(153, 0, 0));
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComments.setBounds(454, 122, 121, 16);
		contentPane.add(lblComments);

		txtComments = new JTextField();
		txtComments.setColumns(10);
		txtComments.setBounds(595, 122, 180, 19);
		contentPane.add(txtComments);

		JLabel lblPrDoctorId = new JLabel("Υπεύθυνος Ιατρός");
		lblPrDoctorId.setForeground(new Color(153, 0, 0));
		lblPrDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrDoctorId.setBounds(454, 154, 131, 16);
		contentPane.add(lblPrDoctorId);

		txtPrDoctorId = new JTextField();
		txtPrDoctorId.setColumns(10);
		txtPrDoctorId.setBounds(595, 154, 180, 19);
		contentPane.add(txtPrDoctorId);
	}
}
