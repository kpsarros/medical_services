package medical_services.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

public class FrmSearchDoctors extends JFrame {

	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	private JTextField txtDoctId;
	private JTextField txtDoctSpecialty;
	JTextField txtDoctSName;
	private JTextField txtDoctFName;
	private JTextField txtDoctSSN;
	private JButton btnSearchDoctors;
	private JTextField txtDoctSpecDesc;
	private JComboBox cmbSpecialty;
	private JTextField txtSSName;

	/**
	 * Create the frame.
	 */

	public FrmSearchDoctors() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmSearchDoctors.class.getResource("/medical_services/resources/icons8-medical-doctor-94.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtDoctId.setText("");
				txtDoctSName.setText("");
				txtDoctFName.setText("");
				txtDoctSSN.setText("");
				txtDoctSpecialty.setText("");
			}
			@Override
			public void windowOpened(WindowEvent e) {
				txtDoctId.setText("");
				txtDoctSName.setText("");
				txtDoctFName.setText("");
				txtDoctSSN.setText("");
				txtDoctSpecialty.setText("");
			}
		});

		setTitle("Εύρεση Ιατρού");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(FrmSearchDoctors.class.getResource("/medical_services/resources/icons8-medical-doctor-94.png")));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 749, 456);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


	  JPanel pnDoctorsList = new JPanel(); pnDoctorsList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64),
			  null), "Doctor's", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	  pnDoctorsList.setBounds(10, 81, 676, 268);
	  pnDoctorsList.setLayout(null);
	  contentPane.add(pnDoctorsList);



	  JButton btnPrDoctor = new JButton("");
	  btnPrDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/PreviousRecord.png")));
	  // Event Handler for clicking Previous Record Icon btnPrDoctor.
	  btnPrDoctor.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  try { if (rs.previous()){
					  txtDoctId.setText(Integer.toString(rs.getInt("DOCTOR_ID")));
					  txtDoctSName.setText(rs.getString("S_NAME"));
					  txtDoctFName.setText(rs.getString("F_NAME"));
					  txtDoctSSN.setText(rs.getString("SSN"));
					  txtDoctSpecialty.setText(rs.getString("SPECIALTIES_SPECIALTY_ID"));
					} else{ rs.first();
					}
			  } catch (SQLException e2) {
				  e2.printStackTrace();
			  }
		  }
	  });
	  btnPrDoctor.setBounds(119, 232, 85, 21);
	  pnDoctorsList.add(btnPrDoctor);

	  JButton btnNextDoctor = new JButton("");
	  btnNextDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/NextRecord.png")));
	  btnNextDoctor.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  try {
				  if (rs.next()){
					  txtDoctId.setText(Integer.toString(rs.getInt("DOCTOR_ID")));
					  txtDoctSName.setText(rs.getString("S_NAME"));
					  txtDoctFName.setText(rs.getString("F_NAME"));
					  txtDoctSSN.setText(rs.getString("SSN"));
					  txtDoctSpecialty.setText(rs.getString("SPECIALTIES_SPECIALTY_ID"));
				  } else rs.last();
			  } catch (SQLException e4) {
				  e4.printStackTrace();
			  }
		  }
	});
	  btnNextDoctor.setBounds(214, 232, 85, 21);
	  pnDoctorsList.add(btnNextDoctor);

	  JButton btnLastDoctor = new JButton("");
	  btnLastDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/LastRecord.png")));
	  btnLastDoctor.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  try {
				  if (rs.last()) {
					  txtDoctId.setText(Integer.toString(rs.getInt("DOCTOR_ID")));
					  txtDoctSName.setText(rs.getString("S_NAME"));
					  txtDoctFName.setText(rs.getString("F_NAME"));
					  txtDoctSSN.setText(rs.getString("SSN"));
					  txtDoctSpecialty.setText(rs.getString("SPECIALTIES_SPECIALTY_ID"));
				  } else{
					  JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές",
							  "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
				  }
			  } catch (SQLException e5) {
				  e5.printStackTrace();
			  }
		  }
	  });
	  btnLastDoctor.setBounds(309,232, 85, 21);
	  pnDoctorsList.add(btnLastDoctor);

	  JLabel lblDoctSName = new JLabel("Επώνυμο Ιατρού:");
	  lblDoctSName.setFont(new Font("Tahoma", Font.BOLD, 12)); lblDoctSName.setBounds(24, 28, 115, 13);
	  pnDoctorsList.add(lblDoctSName);

	  JLabel lblDoctFName = new JLabel("Όνομα Ιατρού:");
	  lblDoctFName.setFont(new Font("Tahoma", Font.BOLD, 12)); lblDoctFName.setBounds(24, 57, 115, 13);
	  pnDoctorsList.add(lblDoctFName);

	  JLabel lblDoctSSN = new JLabel("ΑΜΚΑ:");
	  lblDoctSSN.setFont(new Font("Tahoma", Font.BOLD, 12));
	  lblDoctSSN.setBounds(24, 82, 115, 13);
	  pnDoctorsList.add(lblDoctSSN);

	  JLabel lblDoctSpecialty = new JLabel("Ειδικότητα:");
	  lblDoctSpecialty.setFont(new Font("Tahoma", Font.BOLD, 12));
	  lblDoctSpecialty.setBounds(24, 111, 115, 13);
	  pnDoctorsList.add(lblDoctSpecialty);

	  JLabel lblDoctId = new JLabel("Κωδικός Ιατρού:");
	  lblDoctId.setVerifyInputWhenFocusTarget(false);
	  lblDoctId.setEnabled(false);
	  lblDoctId.setFont(new Font("Tahoma", Font.BOLD, 12)); lblDoctId.setBounds(24,179, 115, 13); pnDoctorsList.add(lblDoctId);

	  txtDoctSName = new JTextField();
	  txtDoctSName.setBounds(149, 26, 408, 19);
	  pnDoctorsList.add(txtDoctSName);
	  txtDoctSName.setColumns(10);

	  txtDoctFName = new JTextField();
	  txtDoctFName.setColumns(10);
	  txtDoctFName.setBounds(149, 55, 408, 19);
	  pnDoctorsList.add(txtDoctFName);

	  txtDoctSSN = new JTextField();
	  txtDoctSSN.setColumns(10);
	  txtDoctSSN.setBounds(149, 80, 185, 19);
	  pnDoctorsList.add(txtDoctSSN);

	  txtDoctSpecialty = new JTextField();
	  txtDoctSpecialty.setColumns(10);
	  txtDoctSpecialty.setBounds(149, 109, 60, 19);
	  pnDoctorsList.add(txtDoctSpecialty);

	  txtDoctId = new JTextField();
	  txtDoctId.setBounds(149, 177, 185, 19);
	  pnDoctorsList.add(txtDoctId);
	  txtDoctId.setColumns(10);

	  JButton btn1stDoctor = new JButton("");
	  btn1stDoctor.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
	  		try {
				  if (rs.first()){
					  txtDoctId.setText(Integer.toString(rs.getInt("DOCTOR_ID")));
					  txtDoctSName.setText(rs.getString("S_NAME"));
					  txtDoctFName.setText(rs.getString("F_NAME"));
					  txtDoctSSN.setText(rs.getString("SSN"));
					  txtDoctSpecialty.setText(rs.getString("SPECIALTY_ID"));
				  } else{
					  	JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές",
					  				"Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
				  	}
	  		} catch (SQLException e2){
					  	e2.printStackTrace();
			}
	  	}
	  });
	  btn1stDoctor.setIcon(new ImageIcon(FrmSearchDoctors.class.getResource("/medical_services/resources/FirstRecord.png")));
	  btn1stDoctor.setBounds(24, 232, 85, 21);
	  pnDoctorsList.add(btn1stDoctor);
	  
	  txtDoctSpecDesc = new JTextField();
	  txtDoctSpecDesc.setBounds(219, 109, 309, 19);
	  pnDoctorsList.add(txtDoctSpecDesc);
	  txtDoctSpecDesc.setColumns(10);

	  JPanel panel = new JPanel();
	  panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	  panel.setBounds(10, 10, 715, 45);
	  contentPane.add(panel);
	  panel.setLayout(null);

	  cmbSpecialty = new JComboBox();
	  cmbSpecialty.setEditable(true);
	  cmbSpecialty.setBounds(88, 11, 167, 21);
	  cmbSpecialty.addItem("Καρδιολόγος");
	  cmbSpecialty.addItem("Οφθαλμίατρος");
	  cmbSpecialty.addItem("Παθολόγος");
	  cmbSpecialty.addItem("Ορθοπεδικός");
	  cmbSpecialty.addItem("Ενδοκρινολόγος");
	  cmbSpecialty.addItem("Ωτορινολαρυγγολόγος");

	  cmbSpecialty.setSelectedItem("Επιλέξτε Ειδικότητα");
	  panel.add(cmbSpecialty);

	  JLabel lblSpecialty = new JLabel("Ειδικότητα:");
	  lblSpecialty.setHorizontalAlignment(SwingConstants.RIGHT);
	  lblSpecialty.setFont(new Font("Tahoma", Font.BOLD, 12));
	  lblSpecialty.setBounds(0, 10, 78, 21); panel.add(lblSpecialty);

	  JLabel lblSSName = new JLabel("Επώνυμο:");
	  lblSSName.setHorizontalAlignment(SwingConstants.CENTER);
	  lblSSName.setFont(new Font("Tahoma", Font.BOLD, 12));
	  lblSSName.setBounds(265, 10, 95, 21); panel.add(lblSSName);

	  txtSSName = new JTextField();
	  txtSSName.setBounds(350, 11, 232,21);
	  panel.add(txtSSName);
	  txtSSName.setColumns(10);

	  btnSearchDoctors = new JButton("Αναζήτηση");
	  btnSearchDoctors.addActionListener(new ActionListener() {

		  public void actionPerformed(ActionEvent e) {
	  		try {
	  			initializeDoctorVariables();
	  			String sql = "SELECT DOCTOR_ID, S_NAME, F_NAME, SSN, SPECIALTIES_SPECIALTY_ID, SPECIALTY_DESC FROM medicalservices.doctorspecialties WHERE S_NAME LIKE ? AND SPECIALTIES_SPECIALTY_ID LIKE ?";
	  			PreparedStatement ps = FrmInitialScreen.conn.prepareStatement(sql,
						  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); // Set Values
				  ps.setString(1, txtSSName.getText() + '%');
				  ps.setInt(2, cmbSpecialty.getSelectedIndex());
				  // Execute
				  rs = ps.executeQuery();
				  if (rs.next()) {
					  txtDoctId.setText(Integer.toString(rs.getInt("DOCTOR_ID")));
					  txtDoctSName.setText(rs.getString("S_NAME"));
					  txtDoctFName.setText(rs.getString("F_NAME"));
					  txtDoctSSN.setText(rs.getString("SSN"));
					  txtDoctSpecialty.setText(rs.getString("SPECIALTIES_SPECIALTY_ID"));
					  txtDoctSpecDesc.setText(rs.getString("SPECIALTY_DESC"));
				  }
			  } catch (SQLException eselect) {
				  eselect.printStackTrace();
			  }
	  	}
	  });
		btnSearchDoctors.setBounds(592, 11, 123, 21);
		panel.add(btnSearchDoctors);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlButtons.setBounds(10, 355, 675, 54);
		contentPane.add(pnlButtons);
		pnlButtons.setLayout(null);

		JButton btnDoctDelete = new JButton("Delete");
		btnDoctDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                    String query = "DELETE from medicalservices.doctors where DOCTOR_ID = ?";

                    PreparedStatement preparedStmt = FrmInitialScreen.conn.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(txtDoctId.getText()));

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
		btnDoctDelete.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnDoctDelete.setBackground(Color.LIGHT_GRAY);
		btnDoctDelete.setForeground(Color.BLACK);
		btnDoctDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDoctDelete.setBounds(24, 10, 85, 34);
		pnlButtons.add(btnDoctDelete);

		JButton btnDoctUpdate = new JButton("Update");
		btnDoctUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String query = "UPDATE medicalservices.doctors set S_NAME = ?, F_Name = ? where DOCTOR_ID = ?";

                    PreparedStatement preparedStmt = FrmInitialScreen.conn.prepareStatement(query);
                    preparedStmt.setString(1, txtDoctSName.getText());
                    preparedStmt.setString(2, txtDoctFName.getText());
                    preparedStmt.setInt(3, Integer.parseInt(txtDoctId.getText()));


                    int numberOfRowsAffected = preparedStmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                    preparedStmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

			}
		});
		btnDoctUpdate.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnDoctUpdate.setForeground(Color.BLACK);
		btnDoctUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDoctUpdate.setBackground(Color.LIGHT_GRAY);
		btnDoctUpdate.setBounds(133, 10, 85, 34);
		pnlButtons.add(btnDoctUpdate);

		JButton btnDoctSelect = new JButton("Select");
		btnDoctSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.mainFrame.setEnabled(true);
				
				MedicalServices.mainFrame.txtSNDoctor.setText(txtDoctSName.getText());
				MedicalServices.mainFrame.txtFNDoctor.setText(txtDoctFName.getText());
				MedicalServices.mainFrame.txtIdDoctor.setText(txtDoctId.getText());
				MedicalServices.mainFrame.txtSpIdDoctor.setText(txtDoctSpecialty.getText());
				MedicalServices.mainFrame.txtSpDescDoctor.setText(txtDoctSpecDesc.getText());				
				
				MedicalServices.mainFrame.setVisible(true);
				MedicalServices.searchDoctorsFrame.setVisible(false);
			}
		});
		btnDoctSelect.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnDoctSelect.setForeground(Color.BLACK);
		btnDoctSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDoctSelect.setBackground(Color.LIGHT_GRAY);
		btnDoctSelect.setBounds(244, 10, 85, 34);
		pnlButtons.add(btnDoctSelect);

		JButton btnDoctClose = new JButton("Close");
		btnDoctClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.searchDoctorsFrame.setVisible(false);
				MedicalServices.mainFrame.setEnabled(true);
				MedicalServices.mainFrame.setVisible(true);
			}
		});
		btnDoctClose.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnDoctClose.setForeground(Color.BLACK);
		btnDoctClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDoctClose.setBackground(Color.LIGHT_GRAY);
		btnDoctClose.setBounds(566, 10, 85, 34);
		pnlButtons.add(btnDoctClose);
	  }

		private void initializeDoctorVariables() {
			txtDoctId.setText("");
			txtDoctSName.setText("");
			txtDoctFName.setText("");
			txtDoctSSN.setText("");
			txtDoctSpecialty.setText("");
			txtDoctSpecDesc.setText("");
		}
}