package medical_services.views;

import java.awt.EventQueue;

public class MedicalServices {

	protected static MainWindow mainFrame;
	protected static FrmInsertDoctors InsertDoctorsFrame;
	protected static FrmInsertPatients InsertPatientsFrame;
	protected static FrmSearchAppoitments SearchAppoitmentsFrame;
	protected static FrmVersion versionFrame;
	
	protected static FrmSearchPatients searchPatientsFrame;
	protected static FrmInitialScreen initialScreenFrame;
	protected static FrmSearchDoctors searchDoctorsFrame;
	protected static FrmAbout aboutFrame;
	protected static FrmLogin loginFrame;

	public static void main(String[] args) {

			EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {					

				  loginFrame = new FrmLogin(); 
				  loginFrame.setLocationRelativeTo(null);
				  loginFrame.setVisible(true);
				  
				  initialScreenFrame = new FrmInitialScreen();
				  initialScreenFrame.setLocationRelativeTo(null);
				  initialScreenFrame.setVisible(false);
				 
				  mainFrame = new MainWindow(); 
				  mainFrame.setLocationRelativeTo(null); 
				  mainFrame.setVisible(false);
				  
				  InsertDoctorsFrame = new FrmInsertDoctors();
				  InsertDoctorsFrame.setLocationRelativeTo(null);
				  InsertDoctorsFrame.setVisible(false);
				  
				  InsertPatientsFrame = new FrmInsertPatients();
				  InsertPatientsFrame.setLocationRelativeTo(null);
				  InsertPatientsFrame.setVisible(false);
				  
				  SearchAppoitmentsFrame = new FrmSearchAppoitments();
				  SearchAppoitmentsFrame.setLocationRelativeTo(null);
				  SearchAppoitmentsFrame.setVisible(false);
				  
				  versionFrame = new FrmVersion(); 
				  versionFrame.setLocationRelativeTo(null);
				  versionFrame.setVisible(false);
				  

				  aboutFrame = new FrmAbout(); 
				  aboutFrame.setLocationRelativeTo(null);
				  aboutFrame.setVisible(false);
				  
				  searchDoctorsFrame = new FrmSearchDoctors();
				  searchDoctorsFrame.setLocationRelativeTo(null);
				  searchDoctorsFrame.setVisible(false);
				  
				  searchPatientsFrame = new FrmSearchPatients();
				  searchPatientsFrame.setLocationRelativeTo(null);
				  searchPatientsFrame.setVisible(false);					 
    		    } catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
