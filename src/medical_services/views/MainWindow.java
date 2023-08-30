package medical_services.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public static JTextField txtDoctSearchSName;
	static Connection conn;
	protected static Object cbDoctSpecialty;
	protected String varDoctSpecialtyText;
	public int varDoctSpecialtyIndex;
	private JButton btnClose;
	
	public JTextField txtSNDoctor;
	public JTextField txtFNDoctor;
	public JTextField txtIdDoctor;
	public JTextField txtSpIdDoctor;
	public JTextField txtSpDescDoctor;	
	
	public JTextField txtSNPatient;
	public JTextField txtFNPatient;
	public JTextField txtIdPatient;
	

	private JTextField txtApoitmentDate;
	private JTextField txtApotmentTime;
	private JTextField txtPatientSName;
	private JTextField txtPatientFName;
	private JTextField txtPatId;
	private JTextField txtDoctorId;
	private JTextField txtDoctSpecialtyDesc;
	private JTextField txtAppoitmentStatus;
	private JTextField txtDoctFirstName;
	private JTextField txtDoctSpecialtyId;
	private JTextField txtDoctSurName;
	private JTextField txtReason;
	private ResultSet rs;
	private JTextField txtFromDate;
	private JTextField txtToDate;
	private JTextField txtAA;

	

	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/medical_services/resources/health-check.png")));
		
	//setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/medical_services/resources/icons8-medical-care-64.png")));
	setResizable(false);
	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	setTitle("                           Medical Services");
	setBounds(100, 100, 821, 643);

    // Content Pane
    contentPane = new JPanel();
	contentPane.setBackground(new Color(240, 248, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(null);
	setContentPane(contentPane);
//----------------------------------------------------------------------------------
	// Main title Green & Red for shadow
	JLabel lbl_qualityGreen = new JLabel("Ποιότητα στην Yγεία");
    lbl_qualityGreen.setBounds(204, 8, 387, 47);
    lbl_qualityGreen.setHorizontalAlignment(SwingConstants.CENTER);
    lbl_qualityGreen.setForeground(new Color(0, 100, 0));
    lbl_qualityGreen.setFont(new Font("Tahoma", Font.PLAIN, 30));
    contentPane.add(lbl_qualityGreen);

    JLabel lbl_qualityGray = new JLabel("Ποιότητα στην Yγεία");
    lbl_qualityGray.setBounds(204, 8, 387, 47);
    lbl_qualityGray.setHorizontalAlignment(SwingConstants.CENTER);
    lbl_qualityGray.setForeground(Color.GRAY);
    lbl_qualityGray.setFont(new Font("Tahoma", Font.PLAIN, 30));
    contentPane.add(lbl_qualityGray);

    // Separator Line
    JSeparator separator = new JSeparator();
    separator.setBounds(15, 54, 780, 1);
    contentPane.add(separator);

    JPanel pnlSearchAppoitments = new JPanel();
    pnlSearchAppoitments.setBackground(Color.WHITE);
    pnlSearchAppoitments.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), null), "\u039A\u03C1\u03B9\u03C4\u03AE\u03C1\u03B9\u03B1 \u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7\u03C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    pnlSearchAppoitments.setName("");
    pnlSearchAppoitments.setToolTipText("");
    pnlSearchAppoitments.setBounds(10, 71, 224, 449);
    contentPane.add(pnlSearchAppoitments);
    pnlSearchAppoitments.setLayout(null);
    pnlSearchAppoitments.setLayout(null);

    txtFromDate = new JTextField();
    txtFromDate.setBounds(103, 345, 96, 19);
    pnlSearchAppoitments.add(txtFromDate);
    txtFromDate.setColumns(10);

    JLabel lblFromDate = new JLabel("From Date:");
    lblFromDate.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblFromDate.setBounds(10, 345, 83, 13);
    pnlSearchAppoitments.add(lblFromDate);

    JLabel lblToDate = new JLabel("To Date:");
    lblToDate.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblToDate.setBounds(10, 371, 45, 13);
    pnlSearchAppoitments.add(lblToDate);

    txtToDate = new JTextField();
    txtToDate.setBounds(103, 368, 96, 19);
    pnlSearchAppoitments.add(txtToDate);
    txtToDate.setColumns(10);

    JButton btnSelectDoctor = new JButton("Επιλογή Ιατρού");
    btnSelectDoctor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    btnSelectDoctor.setBackground(Color.CYAN);
    btnSelectDoctor.setForeground(Color.BLACK);
    btnSelectDoctor.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MedicalServices.searchDoctorsFrame.setVisible(true);
    		MedicalServices.mainFrame.setEnabled(false);
    	}
    });
    btnSelectDoctor.setHorizontalAlignment(SwingConstants.LEFT);
    btnSelectDoctor.setFont(new Font("Tahoma", Font.BOLD, 10));
    btnSelectDoctor.setBounds(10, 22, 128, 29);
    pnlSearchAppoitments.add(btnSelectDoctor);

    JButton btnSelectPatient = new JButton("Επιλογή Ασθενούς");
    btnSelectPatient.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    btnSelectPatient.setForeground(Color.BLACK);
    btnSelectPatient.setBackground(Color.CYAN);
    btnSelectPatient.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MedicalServices.searchPatientsFrame.setVisible(true);
    		MedicalServices.mainFrame.setEnabled(false);
    	}
    });
    btnSelectPatient.setFont(new Font("Tahoma", Font.BOLD, 10));
    btnSelectPatient.setBounds(10, 183, 128, 29);
    pnlSearchAppoitments.add(btnSelectPatient);

    txtSNDoctor = new JTextField();
    txtSNDoctor.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtSNDoctor.setEditable(false);
    txtSNDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtSNDoctor.setBounds(10, 61, 204, 19);
    pnlSearchAppoitments.add(txtSNDoctor);
    txtSNDoctor.setColumns(10);

    txtSNPatient = new JTextField();
    txtSNPatient.setEditable(false);
    txtSNPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtSNPatient.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtSNPatient.setBounds(10, 222, 199, 19);
    txtSNPatient.setColumns(10);
    pnlSearchAppoitments.add(txtSNPatient);

    txtFNDoctor = new JTextField();
    txtFNDoctor.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtFNDoctor.setEditable(false);
    txtFNDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtFNDoctor.setColumns(10);
    txtFNDoctor.setBounds(10, 90, 204, 19);
    pnlSearchAppoitments.add(txtFNDoctor);

    txtSpIdDoctor = new JTextField();
    txtSpIdDoctor.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtSpIdDoctor.setEditable(false);
    txtSpIdDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtSpIdDoctor.setColumns(10);
    txtSpIdDoctor.setBounds(145, 148, 69, 19);
    pnlSearchAppoitments.add(txtSpIdDoctor);
    
    txtSpDescDoctor = new JTextField();
    txtSpDescDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtSpDescDoctor.setEditable(false);
    txtSpDescDoctor.setColumns(10);
    txtSpDescDoctor.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtSpDescDoctor.setBounds(10, 148, 128, 19);
    pnlSearchAppoitments.add(txtSpDescDoctor);

    txtIdDoctor = new JTextField();
    txtIdDoctor.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtIdDoctor.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtIdDoctor.setEditable(false);
    txtIdDoctor.setColumns(10);
    txtIdDoctor.setBounds(10, 119, 104, 19);
    pnlSearchAppoitments.add(txtIdDoctor);

    txtFNPatient = new JTextField();
    txtFNPatient.setEditable(false);
    txtFNPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtFNPatient.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtFNPatient.setColumns(10);
    txtFNPatient.setBounds(10, 251, 199, 19);
    pnlSearchAppoitments.add(txtFNPatient); 

    JLabel lblApDates = new JLabel("Dates");
    lblApDates.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblApDates.setBounds(10, 322, 90, 13);
    pnlSearchAppoitments.add(lblApDates);
    
    txtIdPatient = new JTextField();
    txtIdPatient.setFont(new Font("Tahoma", Font.BOLD, 12));
    txtIdPatient.setEditable(false);
    txtIdPatient.setColumns(10);
    txtIdPatient.setBorder(new EmptyBorder(0, 0, 0, 0));
    txtIdPatient.setBounds(10, 280, 199, 19);
    pnlSearchAppoitments.add(txtIdPatient);
    
    JButton btnSearchForAppoitments = new JButton("Αναζήτηση Ραντεβού");
    btnSearchForAppoitments.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {

	  		try {
	  			initializeAppoitmentsVariables();
	  			
	  			String sql = "SELECT AP_DATE, AP_TIME, AP_REASON, PATIENT_PATIENT_ID, VISITS_VISIT_ID, "
	  					+ "APPOITMENTSTATUS_STATUS_ID,DOCTORS_DOCTOR_ID, APPOINTMENT_ID, STATUS_DESC FROM medicalservices.appoitmentstatuses "
	  					+ "WHERE PATIENT_PATIENT_ID LIKE ?  AND doctors_doctor_id like ? "; //AND ap_date >= ? and ap_date <= ?";
	  			
	  			PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql,
						  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
	  			// Set Values
	  			  ps.setString(1, txtIdPatient.getText() + '%');
	  			  ps.setString(2, txtIdDoctor.getText() + '%');
				 // ps.setString(3, txtFromDate.getText());
				  //ps.setString(4, txtToDate.getText());
				  // Execute
				  rs = ps.executeQuery();
				  if (rs.next()) {
					  txtApoitmentDate.setText(rs.getString("AP_DATE"));	
					  txtApotmentTime.setText(rs.getString("AP_TIME"));	 
					  txtReason.setText(rs.getString("AP_REASON"));	 
					  txtPatientSName.setText(txtSNPatient.getText().toString());
					  txtPatientFName.setText(txtFNPatient.getText().toString());
					  txtPatId.setText(txtIdPatient.getText().toString()); 
					  txtDoctSurName.setText(txtSNDoctor.getText().toString());
					  txtDoctFirstName.setText(txtFNDoctor.getText().toString());
					  txtDoctorId.setText(rs.getString("DOCTORS_DOCTOR_ID")); 
					  txtDoctSpecialtyId.setText(txtSpIdDoctor.getText().toString());
					  txtDoctSpecialtyDesc.setText(txtSpDescDoctor.getText().toString());
					  txtAppoitmentStatus.setText(rs.getString("STATUS_DESC"));
					  txtAA.setText(rs.getString("APPOINTMENT_ID"));
				  }
			  } catch (SQLException eselect) {
				  eselect.printStackTrace();
			  }
    	}
    });
    
    btnSearchForAppoitments.setForeground(Color.BLACK);
    btnSearchForAppoitments.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnSearchForAppoitments.setBackground(Color.LIGHT_GRAY);
    btnSearchForAppoitments.setBounds(26, 410, 160, 29);
    pnlSearchAppoitments.add(btnSearchForAppoitments);

    JPanel pnlAppoitments = new JPanel();
    pnlAppoitments.setBackground(Color.WHITE);
    pnlAppoitments.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null), "\u03A1\u03B1\u03BD\u03C4\u03B5\u03B2\u03BF\u03CD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    pnlAppoitments.setBounds(230, 71, 567, 449);
    contentPane.add(pnlAppoitments);
    
	 pnlAppoitments.setLayout(null);
	
	 JLabel lblApoitmentDate = new JLabel("Ημερομηνία"); 
	 lblApoitmentDate.setBounds(212, 25, 79, 22);
	 lblApoitmentDate.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblApoitmentDate);
	 
	 JLabel lblApotmentTime = new JLabel("Ώρα");
	 lblApotmentTime.setBounds(407, 25, 45, 22);
	 lblApotmentTime.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblApotmentTime);
	 
	 JLabel lblPatSName = new JLabel("Επώνυμο Ασθενή"); 
	 lblPatSName.setBounds(10, 228, 113, 22);
	 lblPatSName.setFont(new
	 Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblPatSName);
	  
	 JLabel lblPatFName = new JLabel("Όνομα Ασθενή");
	 lblPatFName.setBounds(10, 257, 113, 22);
	 lblPatFName.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblPatFName);
	  
	 JLabel lblPatId = new JLabel("Κωδικός Ασθενή");
	 lblPatId.setBounds(366, 228, 86, 22);
	 lblPatId.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblPatId);
	  
	 JLabel lblDoctSName = new JLabel("Επώνυμο Ιατρού");
	 lblDoctSName.setBounds(10, 297, 86, 13);
	 lblDoctSName.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblDoctSName);
	  
	 JLabel lblDoctFName = new JLabel("Όνομα Ιατρού");
	 lblDoctFName.setFont(new Font("Tahoma", Font.BOLD, 10));
	 lblDoctFName.setBounds(10, 337, 86, 13);
	 pnlAppoitments.add(lblDoctFName);
	 
	 JLabel lblDoctId = new JLabel("Κωδικός Ιατρού");
	 lblDoctId.setFont(new Font("Tahoma", Font.BOLD, 10));
	 lblDoctId.setBounds(366, 292, 86, 22);
	 pnlAppoitments.add(lblDoctId);
	  
	 JLabel lblDoctSpecID = new JLabel("Ειδικότητα");
	 lblDoctSpecID.setBounds(366, 332, 86, 22);
	 lblDoctSpecID.setFont(new Font("Tahoma", Font.BOLD, 10));
	 pnlAppoitments.add(lblDoctSpecID);
	 
	 txtApoitmentDate = new JTextField();
	 txtApoitmentDate.setBounds(301, 27, 96, 19);
	 pnlAppoitments.add(txtApoitmentDate);
	 txtApoitmentDate.setColumns(10);
	 
	 txtApotmentTime = new JTextField();
	 txtApotmentTime.setBounds(458, 27, 96, 19);
	 pnlAppoitments.add(txtApotmentTime);
	 txtApotmentTime.setColumns(10);
	 
	 txtReason = new JTextField();
	 txtReason.setAlignmentY(Component.TOP_ALIGNMENT);
	 txtReason.setAlignmentX(Component.LEFT_ALIGNMENT);
	 txtReason.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
	 txtReason.setHorizontalAlignment(SwingConstants.LEFT);
	 txtReason.setText("fffffffffff");
	 txtReason.setFont(new Font("Tahoma", Font.BOLD, 12));
	 txtReason.setBounds(133, 94, 394, 123);
	 pnlAppoitments.add(txtReason);
	 
	 txtPatientSName = new JTextField();
	 txtPatientSName.setEditable(false);
	 txtPatientSName.setBounds(133, 230, 225, 19);
	 pnlAppoitments.add(txtPatientSName);
	 txtPatientSName.setColumns(10);
	 
	 txtPatientFName = new JTextField();
	 txtPatientFName.setEditable(false);
	 txtPatientFName.setColumns(10);
	 txtPatientFName.setBounds(133, 259, 225, 19);
	 pnlAppoitments.add(txtPatientFName);
	 
	 txtPatId = new JTextField();
	 txtPatId.setEditable(false);
	 txtPatId.setColumns(10);
	 txtPatId.setBounds(458, 230, 96, 19);
	 pnlAppoitments.add(txtPatId);
	 
	 txtDoctSurName = new JTextField();
	 txtDoctSurName.setEditable(false);
	 txtDoctSurName.setColumns(10);
	 txtDoctSurName.setBounds(133, 294, 225, 19);
	 pnlAppoitments.add(txtDoctSurName);
	 
	 txtDoctFirstName = new JTextField();
	 txtDoctFirstName.setEditable(false);
	 txtDoctFirstName.setColumns(10);
	 txtDoctFirstName.setBounds(133, 334, 225, 19);
	 pnlAppoitments.add(txtDoctFirstName);
	 
	 txtDoctorId = new JTextField();
	 txtDoctorId.setEditable(false);
	 txtDoctorId.setColumns(10);
	 txtDoctorId.setBounds(458, 297, 96, 19);
	 pnlAppoitments.add(txtDoctorId);
	 
	 txtDoctSpecialtyId = new JTextField();
	 txtDoctSpecialtyId.setEditable(false);
	 txtDoctSpecialtyId.setColumns(10);
	 txtDoctSpecialtyId.setBounds(458, 334, 96, 19);
	 pnlAppoitments.add(txtDoctSpecialtyId);
	 
	 JLabel lblDoctSpecialtyDesc = new JLabel("Ειδικότητα περιγραφή");
	 lblDoctSpecialtyDesc.setFont(new Font("Tahoma", Font.BOLD, 10));
	 lblDoctSpecialtyDesc.setBounds(10, 366, 113, 13);
	 pnlAppoitments.add(lblDoctSpecialtyDesc);
	 
	 JLabel lblAppoitmentStatus = new JLabel("Status");
	 lblAppoitmentStatus.setFont(new Font("Tahoma", Font.BOLD, 10));
	 lblAppoitmentStatus.setBounds(366, 361, 86, 22);
	 pnlAppoitments.add(lblAppoitmentStatus);
	 
	 txtDoctSpecialtyDesc = new JTextField();
	 txtDoctSpecialtyDesc.setEditable(false);
	 txtDoctSpecialtyDesc.setColumns(10);
	 txtDoctSpecialtyDesc.setBounds(133, 363, 225, 19);
	 pnlAppoitments.add(txtDoctSpecialtyDesc);
	 
	 txtAppoitmentStatus = new JTextField();
	 txtAppoitmentStatus.setColumns(10);
	 txtAppoitmentStatus.setBounds(458, 363, 96, 19);
	 pnlAppoitments.add(txtAppoitmentStatus);
	 
	 JButton btn1stAppoitment = new JButton("");
	 btn1stAppoitment.setBounds(10, 418, 85, 21);
	 pnlAppoitments.add(btn1stAppoitment);
	 btn1stAppoitment.setIcon(new ImageIcon(MainWindow.class.getResource("/medical_services/resources/FirstRecord.png")));
	 btn1stAppoitment.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
				
		  try { 
			  if (rs.first()){
				  txtApoitmentDate.setText(rs.getString("AP_DATE"));	
				  txtApotmentTime.setText(rs.getString("AP_TIME"));	 
				  txtReason.setText(rs.getString("AP_REASON"));	 
				  txtPatientSName = txtSNPatient;
				  txtPatientFName = txtFNPatient;
				  txtPatId.setText(rs.getString("PATIENT_PATIENT_ID")); 
				  txtDoctSurName.setText(""); 
				  txtDoctFirstName.setText(""); 
				  txtDoctorId.setText(rs.getString("DOCTORS_DOCTOR_ID")); 
				  txtDoctSpecialtyId.setText(rs.getString("DOCTORS_DOCTOR_ID"));
				  txtDoctSpecialtyDesc.setText(""); 
				  txtAppoitmentStatus.setText(rs.getString("STATUS_DESC"));
				  txtAA.setText(rs.getString("APPOINTMENT_ID"));
			  } else {
				JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE); 
			  } 
		  } catch (SQLException e2) {
			  e2.printStackTrace(); 
		  }				 
	 	}
	 });	 
	 
	 JButton btnPrAppoitment = new JButton("");
	 btnPrAppoitment.setIcon(new ImageIcon(MainWindow.class.getResource("/medical_services/resources/PreviousRecord.png")));
	 btnPrAppoitment.setBounds(105, 418, 85, 21);
	 pnlAppoitments.add(btnPrAppoitment);
	 btnPrAppoitment.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
		
		  try { 
			  if (rs.previous()){
				  txtApoitmentDate.setText(rs.getString("AP_DATE"));	
				  txtApotmentTime.setText(rs.getString("AP_TIME"));	 
				  txtReason.setText(rs.getString("AP_REASON"));	 
				  txtPatientSName = txtSNPatient;
				  txtPatientFName = txtFNPatient;
				  txtPatId.setText(rs.getString("PATIENT_PATIENT_ID")); 
				  txtDoctSurName.setText(""); 
				  txtDoctFirstName.setText(""); 
				  txtDoctorId.setText(rs.getString("DOCTORS_DOCTOR_ID")); 
				  txtDoctSpecialtyId = txtSpIdDoctor;
				  txtDoctSpecialtyDesc.setText(""); 
				  txtAppoitmentStatus.setText(rs.getString("STATUS_DESC"));
				  txtAA.setText(rs.getString("APPOINTMENT_ID"));
			  } else { 
					  rs.first(); 
			  }
		  } catch (SQLException e2) { 
			  e2.printStackTrace(); 
		  }	 
	 	}
	 });
	 
	 JButton btnNextAppoitment = new JButton("");
	 btnNextAppoitment.setBounds(200, 418, 85, 21);
	 pnlAppoitments.add(btnNextAppoitment);
	 btnNextAppoitment.setIcon(new ImageIcon(MainWindow.class.getResource("/medical_services/resources/NextRecord.png")));
	 btnNextAppoitment.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
				
		  try { 
			  if (rs.next()) {
				  txtApoitmentDate.setText(rs.getString("AP_DATE"));	
				  txtApotmentTime.setText(rs.getString("AP_TIME"));	 
				  txtReason.setText(rs.getString("AP_REASON"));	 
				  txtPatientSName = txtSNPatient;
				  txtPatientFName = txtFNPatient;
				  txtPatId.setText(rs.getString("PATIENT_PATIENT_ID")); 
				  txtDoctSurName.setText(""); 
				  txtDoctFirstName.setText(""); 
				  txtDoctorId.setText(rs.getString("DOCTORS_DOCTOR_ID")); 
				  txtDoctSpecialtyId = txtSpIdDoctor;
				  txtDoctSpecialtyDesc.setText(""); 
				  txtAppoitmentStatus.setText(rs.getString("STATUS_DESC"));
				  txtAA.setText(rs.getString("APPOINTMENT_ID"));
				  
			  } else {
				  rs.last();
			  }}
		  catch (SQLException e4) { 
			  e4.printStackTrace(); 
		  }	 
	 }
	 });	 
	 
	 JButton btnLastAppoitment = new JButton("");
	 btnLastAppoitment.setBounds(293, 418, 85, 21);
	 pnlAppoitments.add(btnLastAppoitment);
	 btnLastAppoitment.setIcon(new ImageIcon(MainWindow.class.getResource("/medical_services/resources/LastRecord.png")));
	 
	 JLabel lblReason = new JLabel("Αιτιολογία Ραντεβού");
	 lblReason.setBounds(10, 72, 113, 22);
	 pnlAppoitments.add(lblReason);
	 lblReason.setFont(new Font("Tahoma", Font.BOLD, 10));	 
	 txtAA = new JTextField();
	 txtAA.setColumns(10);
	 txtAA.setBounds(88, 27, 96, 19);
	 pnlAppoitments.add(txtAA);
	 
	 JLabel lblAA = new JLabel("Α/Α");
	 lblAA.setFont(new Font("Tahoma", Font.BOLD, 10));
	 lblAA.setBounds(10, 25, 79, 22);
	 
	 pnlAppoitments.add(lblAA);
	 btnLastAppoitment.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
				
		  try { 
			  if (rs.last()) {
				  txtApoitmentDate.setText(rs.getString("AP_DATE"));	
				  txtApotmentTime.setText(rs.getString("AP_TIME"));	 
				  txtReason.setText(rs.getString("AP_REASON"));	 
				  txtPatientSName = txtSNPatient;
				  txtPatientFName = txtFNPatient;
				  txtPatId.setText(rs.getString("PATIENT_PATIENT_ID")); 
				  txtDoctSurName.setText(""); 
				  txtDoctFirstName.setText(""); 
				  txtDoctorId.setText(rs.getString("DOCTORS_DOCTOR_ID")); 
				  txtDoctSpecialtyId = txtSpIdDoctor;
				  txtDoctSpecialtyDesc.setText(""); 
				  txtAppoitmentStatus.setText(rs.getString("STATUS_DESC"));
				  txtAA.setText(rs.getString("APPOINTMENT_ID"));
			  } else {
				  JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές",
						  "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE); 
			  } 
		  } catch (SQLException e5) {
			  e5.printStackTrace(); 
		  }	 
	 	}
	 });	 
    
    JPanel panelButtons = new JPanel();
    panelButtons.setBounds(15, 530, 780, 66);
    contentPane.add(panelButtons);
    panelButtons.setLayout(null);
    
    JButton btnNewAppoitment = new JButton("Δημιουργία Ραντεβού");
    btnNewAppoitment.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnNewAppoitment.setBounds(32, 10, 161, 46);
    panelButtons.add(btnNewAppoitment);    
    btnNewAppoitment.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
				// Prepare Statement
				String sql = "INSERT INTO medicalservices.appointments VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql,
						  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
				// Set Values
				  ps.setString(1, txtApoitmentDate.getText().toString());
				  ps.setString(2, txtApotmentTime.getText().toString());
				  ps.setString(3, txtReason.getText().toString());
				  ps.setInt(4, Integer.parseInt(txtPatId.getText()));
				  ps.setInt(5, 0);
				  ps.setInt(6, 1);
				  ps.setInt(7, Integer.parseInt(txtDoctorId.getText()));
				  ps.setInt(8, Integer.parseInt(txtAA.getText()));
				// Execute
				int n = ps.executeUpdate();
				// Show Feedback
				JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", JOptionPane.PLAIN_MESSAGE);
				//Close PreparedStatement
				ps.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Invalid Key1" + " Please try again", "Error",
						JOptionPane.WARNING_MESSAGE);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Invalid Key2" + " Please try again", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
    	}
    });

    JButton btnCnlAppoitment = new JButton("Ακύρωση Ραντεβού");
    btnCnlAppoitment.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnCnlAppoitment.setBounds(223, 10, 161, 46);
    panelButtons.add(btnCnlAppoitment);
    btnCnlAppoitment.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
                String query = "UPDATE medicalservices.appointments set AP_DATE = ?, AP_TIME = ?, AP_REASON = ?, APPOITMENTSTATUS_STATUS_ID = ? where APPOINTMENT_ID = ?";
           	
                PreparedStatement preparedStmt = FrmInitialScreen.conn.prepareStatement(query);
                preparedStmt.setString(1, txtApoitmentDate.getText());
                preparedStmt.setString(2, txtApotmentTime.getText());
                preparedStmt.setString(3, txtReason.getText());
                preparedStmt.setInt(4, 2);
                preparedStmt.setInt(5, Integer.parseInt(txtAA.getText()));
                
                int numberOfRowsAffected = preparedStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                preparedStmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
    	}
    });
    
    JButton btnStartVisit = new JButton("Έναρξη Συνεδρίας");
    btnStartVisit.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnStartVisit.setBounds(400, 10, 161, 46);
    panelButtons.add(btnStartVisit);
    btnStartVisit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });

    btnClose = new JButton("Close");
    btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnClose.setBounds(622, 10, 144, 46);
    panelButtons.add(btnClose);
    btnClose.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MedicalServices.mainFrame.setVisible(false);
    		MedicalServices.initialScreenFrame.setEnabled(true);
    		MedicalServices.initialScreenFrame.setVisible(true);   		
    	}
    });
	}
	
	private void initializeAppoitmentsVariables() {
		 txtApoitmentDate.setText(""); 	
		 txtApotmentTime.setText(""); 		 
		 txtReason.setText("");		 
		 txtPatientSName.setText(""); 
		 txtPatientFName.setText("");
		 txtPatId.setText(""); 
		 txtDoctSurName.setText(""); 
		 txtDoctFirstName.setText(""); 
		 txtDoctorId.setText(""); 
		 txtDoctSpecialtyId.setText("");
		 txtDoctSpecialtyDesc.setText(""); 
		 txtAppoitmentStatus.setText("");
	}
}