package medical_services.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import java.awt.Dimension;

public class FrmAbout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton btnClose = new JButton("Close");
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public FrmAbout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAbout.class.getResource("/medical_services/resources/health-check.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		
		
		// add scrollPane to JFrame
		JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalServices.aboutFrame.setVisible(false);
				MedicalServices.initialScreenFrame.setVisible(true);
				MedicalServices.initialScreenFrame.setEnabled(true);			
			}
		});
		panel.add(btnClose);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(sp, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(sp, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addGap(8))
		);
		
		textArea = new JTextArea();
		textArea.setMaximumSize(new Dimension(300, 300));
		textArea.setBounds(new Rectangle(10, 10, 10, 10));
		textArea.setBorder(null);
		textArea.setTabSize(4);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setText("Η εφαρμογή αυτή αποτελεί την τελική εργασία στα πλαίσια του προγράμματος \"Προγραμματισμός με Java: Από το Α στο Ω\" διάρκειας 12 εβδομάδων ή 300 ωρών.\r\nΤο πρόγραμμα διεξήχθη  μέσω πλατφόρμας εξ αποστάσεως εκπαίδευσης e-learning.\r\n\r\nΗ εφαρμογή αφορά την πρώτη προσέγγιση μιας μηχανογραφικής υποστήριξης της λειτουργίας ενός κέντρου παροχής ιατρικών υπηρεσιών.\r\n\r\nΟι κύριες ενότητες της εφαρμογής είναι:\r\n\r\n1. Login μηχανισμός για την ασφαλή πρόσβαση στην εφαρμογή και στην βάση δεδομένων\r\n2. Εγγραφή Ιατρού για την στελέχωση του ιατρικού κέντρου.\r\n3. Εγγραφή ασθενούς για την δημιουργία φακέλου ασθενή.\r\n4. Αναζήτηση, δημιουργία, ακύρωση και εκτέλεση ενός ραντεβού.\r\n5. Διεξαγωγή της συνεδρίας που προκύπτει από ένα κλεισμένο ραντεβού.\r\n\r\nΣε επόμενες εκδόσεις, η εφαρμογή θα αναβαθμιστεί με αναβαθμίσεις και νέες λειτουργικότητες.\r\n\r\nΜε εκτίμηση,\r\n");
		sp.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
