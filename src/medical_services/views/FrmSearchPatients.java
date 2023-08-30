package medical_services.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrmSearchPatients extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private ResultSet rs;
	private JTextField txtPatientSName;
	private JTextField txtPatientFName;
	private JTextField txtPatientSSN;
	private JTextField txtPatientGender;
	private JTextField txtPatientBD;
	private JTextField txtPatLastVisitDT;
	private JTextField txtPatientAlegr;
	private JTextField txtPatientPrDoctor;
	private JTextField txtPatientId;
	private JTextArea textAreaDoctComm;
	private JTextField txtSSName;

	/**
	 * Create the frame.
	 */
	public FrmSearchPatients() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(FrmSearchPatients.class.getResource("/medical_services/resources/icons8-medical-care-64.png")));
		setTitle("Εύρεση Ασθενούς");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 749, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel pnDoctorsList = new JPanel();
		pnDoctorsList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), null), "Patient's", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnDoctorsList.setBounds(10, 71, 676, 338);
		contentPane.add(pnDoctorsList);
		pnDoctorsList.setLayout(null);

		  JButton btn1stDoctor = new JButton("");
		  btn1stDoctor.setIcon(new ImageIcon(FrmSearchPatients.class.getResource("/medical_services/resources/FirstRecord.png")));
		  btn1stDoctor.setBounds(9, 132, 39, 25);
		  // Event Handler for clicking First Record Icon
		  btn1stDoctor.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  try {
					  if (rs.first()){
						  txtPatientId.setText(Integer.toString(rs.getInt("PATIENT_ID")));
						  txtPatientSName.setText(rs.getString("PS_NAME"));
						  txtPatientFName.setText(rs.getString("PF_NAME"));
						  txtPatientSSN.setText(rs.getString("PSSN"));
						  txtPatientGender.setText(rs.getString("GENDER"));
						  txtPatientBD.setText(rs.getString("BIRTHDATE"));
						  txtPatLastVisitDT.setText(rs.getString("LAST_VISIT_DATE"));
						  txtPatientAlegr.setText(rs.getString("ALLERGIES"));
						  txtPatientPrDoctor.setText(rs.getString("DOCTORS_DOCTOR_ID"));
						  textAreaDoctComm.setText(rs.getString("NOTES"));
					  } else{
						  	JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές",
						  				"Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
					  } } catch (SQLException e2){
						  	e2.printStackTrace();
				  }
			  }
		  });

			  //btn1stDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource(medical_services/resources/FirstRecord.png")));
			  btn1stDoctor.setBounds(24, 307, 85, 21); pnDoctorsList.add(btn1stDoctor);

			  JButton btnPrDoctor = new JButton("");
			  // Event Handler for clicking Previous Record Icon btnPrDoctor.
			  btnPrDoctor.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  try { if (rs.previous()){
						  txtPatientId.setText(Integer.toString(rs.getInt("PATIENT_ID")));
						  txtPatientSName.setText(rs.getString("PS_NAME"));
						  txtPatientFName.setText(rs.getString("PF_NAME"));
						  txtPatientSSN.setText(rs.getString("PSSN"));
						  txtPatientGender.setText(rs.getString("GENDER"));
						  txtPatientBD.setText(rs.getString("BIRTHDATE"));
						  txtPatLastVisitDT.setText(rs.getString("LAST_VISIT_DATE"));
						  txtPatientAlegr.setText(rs.getString("ALLERGIES"));
						  txtPatientPrDoctor.setText(rs.getString("DOCTORS_DOCTOR_ID"));
						  textAreaDoctComm.setText(rs.getString("NOTES"));
							} else{ rs.first();
							}
					  } catch (SQLException e2) {
						  e2.printStackTrace();
					  }
				  }
			  });

			  btnPrDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/PreviousRecord.png")));
			  btnPrDoctor.setBounds(119, 307, 85, 21);
			  pnDoctorsList.add(btnPrDoctor);

			  JButton btnNextDoctor = new JButton("");
			  btnNextDoctor.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  try {
						  if (rs.next()){
							  txtPatientId.setText(Integer.toString(rs.getInt("PATIENT_ID")));
							  txtPatientSName.setText(rs.getString("PS_NAME"));
							  txtPatientFName.setText(rs.getString("PF_NAME"));
							  txtPatientSSN.setText(rs.getString("PSSN"));
							  txtPatientGender.setText(rs.getString("GENDER"));
							  txtPatientBD.setText(rs.getString("BIRTHDATE"));
							  txtPatLastVisitDT.setText(rs.getString("LAST_VISIT_DATE"));
							  txtPatientAlegr.setText(rs.getString("ALLERGIES"));
							  txtPatientPrDoctor.setText(rs.getString("DOCTORS_DOCTOR_ID"));
							  textAreaDoctComm.setText(rs.getString("NOTES"));
						  } else rs.last();
					  } catch (SQLException e4) {
						  e4.printStackTrace();
					  }
				  }
			});

			  btnNextDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/NextRecord.png")));
			  btnNextDoctor.setBounds(214, 307, 85, 21);
			  pnDoctorsList.add(btnNextDoctor);

			  JButton btnLastDoctor = new JButton("");
			  btnLastDoctor.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  try {
						  if (rs.last()) {
							  txtPatientId.setText(Integer.toString(rs.getInt("PATIENT_ID")));
							  txtPatientSName.setText(rs.getString("PS_NAME"));
							  txtPatientFName.setText(rs.getString("PF_NAME"));
							  txtPatientSSN.setText(rs.getString("PSSN"));
							  txtPatientGender.setText(rs.getString("GENDER"));
							  txtPatientBD.setText(rs.getString("BIRTHDATE"));
							  txtPatLastVisitDT.setText(rs.getString("LAST_VISIT_DATE"));
							  txtPatientAlegr.setText(rs.getString("ALLERGIES"));
							  txtPatientPrDoctor.setText(rs.getString("DOCTORS_DOCTOR_ID"));
							  textAreaDoctComm.setText(rs.getString("NOTES"));
						  } else{
							  JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές",
									  "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
						  }
					  } catch (SQLException e5) {
						  e5.printStackTrace();
					  }
				  }
			  });

			  btnLastDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource( "/medical_services/resources/LastRecord.png")));
			  btnLastDoctor.setBounds(309,307, 85, 21);
			  pnDoctorsList.add(btnLastDoctor);

			  JLabel lblPatientSName = new JLabel("Επώνυμο Ασθενούς:");
			  lblPatientSName.setHorizontalAlignment(SwingConstants.LEFT);
			  lblPatientSName.setFont(new Font("Tahoma", Font.BOLD, 12)); lblPatientSName.setBounds(10, 28, 129, 13);
			  pnDoctorsList.add(lblPatientSName);

			  JLabel lblDoctFName = new JLabel("Όνομα Ασθενούς:");
			  lblDoctFName.setHorizontalAlignment(SwingConstants.LEFT);
			  lblDoctFName.setFont(new Font("Tahoma", Font.BOLD, 12)); lblDoctFName.setBounds(10, 59, 129, 13);
			  pnDoctorsList.add(lblDoctFName);

			  JLabel lblDoctSSN = new JLabel("ΑΜΚΑ:");
			  lblDoctSSN.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblDoctSSN.setBounds(10, 82, 115, 13);
			  pnDoctorsList.add(lblDoctSSN);

			  txtPatientSName = new JTextField();
			  txtPatientSName.setBounds(149, 26, 341, 19);
			  pnDoctorsList.add(txtPatientSName);
			  txtPatientSName.setColumns(10);

			  txtPatientFName = new JTextField();
			  txtPatientFName.setColumns(10);
			  txtPatientFName.setBounds(149, 55, 408, 19);
			  pnDoctorsList.add(txtPatientFName);

			  txtPatientSSN = new JTextField();
			  txtPatientSSN.setColumns(10);
			  txtPatientSSN.setBounds(149, 80, 185, 19);
			  pnDoctorsList.add(txtPatientSSN);

			  JLabel lblPatientGender = new JLabel("Φύλλο:");
			  lblPatientGender.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientGender.setBounds(358, 82, 115, 13);
			  pnDoctorsList.add(lblPatientGender);

			  JLabel lblPatientBD = new JLabel("Ημ/νία Γέννησης:");
			  lblPatientBD.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientBD.setBounds(20, 111, 133, 13);
			  pnDoctorsList.add(lblPatientBD);

			  JLabel lblPatientBD_1 = new JLabel("Ημ/νία Τελευταίας Επίσκεψης:");
			  lblPatientBD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientBD_1.setBounds(320, 111, 185, 13);
			  pnDoctorsList.add(lblPatientBD_1);

			  JLabel lblPatientAlerg = new JLabel("Αλλεργίες:");
			  lblPatientAlerg.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientAlerg.setBounds(10, 140, 129, 13);
			  pnDoctorsList.add(lblPatientAlerg);

			  JLabel lblPatientComments = new JLabel("Σχόλια:");
			  lblPatientComments.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientComments.setBounds(24, 202, 129, 13);
			  pnDoctorsList.add(lblPatientComments);

			  JLabel lblPatientPrDoct = new JLabel("Κύριος Ιατρός:");
			  lblPatientPrDoct.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblPatientPrDoct.setBounds(10, 167, 133, 13);
			  pnDoctorsList.add(lblPatientPrDoct);

			  txtPatientGender = new JTextField();
			  txtPatientGender.setColumns(10);
			  txtPatientGender.setBounds(423, 80, 85, 19);
			  pnDoctorsList.add(txtPatientGender);

			  txtPatientBD = new JTextField();
			  txtPatientBD.setColumns(10);
			  txtPatientBD.setBounds(149, 109, 129, 19);
			  pnDoctorsList.add(txtPatientBD);

			  txtPatLastVisitDT = new JTextField();
			  txtPatLastVisitDT.setColumns(10);
			  txtPatLastVisitDT.setBounds(515, 109, 140, 19);
			  pnDoctorsList.add(txtPatLastVisitDT);

			  txtPatientAlegr = new JTextField();
			  txtPatientAlegr.setColumns(10);
			  txtPatientAlegr.setBounds(149, 138, 506, 19);
			  pnDoctorsList.add(txtPatientAlegr);

			  txtPatientPrDoctor = new JTextField();
			  txtPatientPrDoctor.setColumns(10);
			  txtPatientPrDoctor.setBounds(149, 165, 245, 19);
			  pnDoctorsList.add(txtPatientPrDoctor);

			  JScrollPane scrollPaneDoctComm = new JScrollPane();
			  scrollPaneDoctComm.setBounds(149, 202, 506, 81);
			  pnDoctorsList.add(scrollPaneDoctComm);

			  textAreaDoctComm = new JTextArea();
			  scrollPaneDoctComm.setViewportView(textAreaDoctComm);

			  txtPatientId = new JTextField();
			  txtPatientId.setEditable(false);
			  txtPatientId.setBounds(515, 26, 96, 19);
			  pnDoctorsList.add(txtPatientId);
			  txtPatientId.setColumns(10);

			  JPanel panel = new JPanel();
			  panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); panel.setBounds(10, 10, 715, 45);
			  contentPane.add(panel);
			  panel.setLayout(null);

			  JLabel lblSSName = new JLabel("Επώνυμο:");
			  lblSSName.setHorizontalAlignment(SwingConstants.CENTER);
			  lblSSName.setFont(new Font("Tahoma", Font.BOLD, 12));
			  lblSSName.setBounds(10, 10, 95, 21); panel.add(lblSSName);

			  txtSSName = new JTextField();
			  txtSSName.setBounds(121, 11, 232,21);
			  panel.add(txtSSName);
			  txtSSName.setColumns(10);

			  JButton btnSearchPatients = new JButton("Αναζήτηση");
			  btnSearchPatients.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  try {

						  initiatePatientVariables();

						  String sql = "SELECT PATIENT_ID, PS_NAME, PF_NAME, PSSN, GENDER, BIRTHDATE, LAST_VISIT_DATE, ALLERGIES, NOTES, "
						  		+ "DOCTORS_DOCTOR_ID FROM medicalservices.patients WHERE PS_NAME LIKE ?";
						  PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						  // Set Values
						  ps.setString(1, txtSSName.getText() + '%');
						  //System.out.println("doctVar: " + doctVar);
						  // Execute
						  rs = ps.executeQuery();
						  if (rs.next()) {
							  txtPatientId.setText(Integer.toString(rs.getInt("PATIENT_ID")));
							  txtPatientSName.setText(rs.getString("PS_NAME"));
							  txtPatientFName.setText(rs.getString("PF_NAME"));
							  txtPatientSSN.setText(rs.getString("PSSN"));
							  txtPatientGender.setText(rs.getString("GENDER"));
							  txtPatientBD.setText(rs.getString("BIRTHDATE"));
							  txtPatLastVisitDT.setText(rs.getString("LAST_VISIT_DATE"));
							  txtPatientAlegr.setText(rs.getString("ALLERGIES"));
							  txtPatientPrDoctor.setText(rs.getString("DOCTORS_DOCTOR_ID"));
							  textAreaDoctComm.setText(rs.getString("NOTES"));
						  }
					  } catch (SQLException eselect) {
						  eselect.printStackTrace();
					  }
				  }
			  });
			  btnSearchPatients.setBounds(616, 11, 85, 21); panel.add(btnSearchPatients);

 JPanel pnlbuttons = new JPanel();
 pnlbuttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
 pnlbuttons.setBounds(10, 428, 678, 56);
 contentPane.add(pnlbuttons);
 pnlbuttons.setLayout(null);

 JButton btnDoctDelete = new JButton("Delete");
 btnDoctDelete.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
 		try{
            String query = "DELETE from medicalservices.patients where PATIENT_ID = ?";

            PreparedStatement preparedStmt = FrmInitialScreen.conn.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(txtPatientId.getText()));

            // Execute the prepared statement after confirmation
            int dialogButton;
            dialogButton = JOptionPane.showConfirmDialog (null, "Είστε σίγουρος;",
                    "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberOfRowsAffected = preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog (null, numberOfRowsAffected + " rows deleted successfully",
                        "DELETE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e6) {
            e6.printStackTrace();
        }
 	}
 });

 btnDoctDelete.setBounds(new Rectangle(24, 10, 85, 34));
 btnDoctDelete.setForeground(Color.BLACK);
 btnDoctDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
 btnDoctDelete.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 btnDoctDelete.setBackground(Color.LIGHT_GRAY);
 pnlbuttons.add(btnDoctDelete);

 JButton btnDoctUpdate = new JButton("Update");
 btnDoctUpdate.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
 		try {
            String query = "UPDATE medicalservices.patients set PS_NAME = ?, PF_Name = ? PSSN = ?, GENDER = ?, BIRTHDATE = ?, LAST_VISIT_DATE = ?, "
            		+ "	ALLERGIES = ?, NOTES = ?, DOCTORS_DOCTOR_ID = ? where PATIENT_ID = ?";

            PreparedStatement preparedStmt = FrmInitialScreen.conn.prepareStatement(query);
            preparedStmt.setString(1, txtPatientSName.getText());
            preparedStmt.setString(2, txtPatientFName.getText());
            preparedStmt.setString(3, txtPatientSSN.getText());
            preparedStmt.setString(4, txtPatientGender.getText());
            preparedStmt.setString(5, txtPatientBD.getText());
            preparedStmt.setString(6, txtPatLastVisitDT.getText());
            preparedStmt.setString(7, txtPatientAlegr.getText());
            preparedStmt.setString(6, txtPatientAlegr.getText());
            preparedStmt.setString(8, textAreaDoctComm.getText());
            preparedStmt.setInt(9, Integer.parseInt(txtPatientPrDoctor.getText()));

            int numberOfRowsAffected = preparedStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
            preparedStmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
 	}
 });
 btnDoctUpdate.setBounds(133, 10, 85, 34);
 btnDoctUpdate.setForeground(Color.BLACK);
 btnDoctUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
 btnDoctUpdate.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 btnDoctUpdate.setBackground(Color.LIGHT_GRAY);
 pnlbuttons.add(btnDoctUpdate);

 JButton btnDoctSelect = new JButton("Select");
 btnDoctSelect.addActionListener(new ActionListener() {
	 private AbstractButton txtIdPat;

	public void actionPerformed(ActionEvent e) {
 		MedicalServices.mainFrame.txtSNPatient.setText(txtPatientSName.getText());
		MedicalServices.mainFrame.txtFNPatient.setText(txtPatientFName.getText());
		MedicalServices.mainFrame.txtIdPatient.setText(txtPatientId.getText());
		MedicalServices.mainFrame.setEnabled(true);
		MedicalServices.mainFrame.setVisible(true);
		MedicalServices.searchPatientsFrame.setVisible(false);
 	}
 });
 btnDoctSelect.setBounds(244, 10, 85, 34);
 btnDoctSelect.setForeground(Color.BLACK);
 btnDoctSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
 btnDoctSelect.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 btnDoctSelect.setBackground(Color.LIGHT_GRAY);
 pnlbuttons.add(btnDoctSelect);

 JButton btnDoctClose = new JButton("Close");
 btnDoctClose.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
 		MedicalServices.searchPatientsFrame.setVisible(false);
		MedicalServices.mainFrame.setEnabled(true);
		MedicalServices.mainFrame.setVisible(true);
 	}
 });
 btnDoctClose.setBounds(566, 10, 85, 34);
 btnDoctClose.setForeground(Color.BLACK);
 btnDoctClose.setFont(new Font("Tahoma", Font.BOLD, 12));
 btnDoctClose.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 btnDoctClose.setBackground(Color.LIGHT_GRAY);
 pnlbuttons.add(btnDoctClose);
	}

	private void initiatePatientVariables() {
	  txtPatientId.setText("");
	  txtPatientSName.setText("");
	  txtPatientFName.setText("");
	  txtPatientSSN.setText("");
	  txtPatientGender.setText("");
	  txtPatientBD.setText("");
	  txtPatLastVisitDT.setText("");
	  txtPatientAlegr.setText("");
	  textAreaDoctComm.setText("");
	  txtPatientPrDoctor.setText("");
	}

}
