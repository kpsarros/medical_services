package medical_services.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class FrmVersion extends JFrame {

	private static final long serialVersionUID = 1L;
	private AbstractButton btnClose;

	public FrmVersion() {
		initComponents();
	}

	private void initComponents() {

		setTitle("Έκδοση");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Label Version
        JLabel lblVersion = new JLabel("Έκδοση 0.1");
        lblVersion.setForeground(new Color(0, 0, 204));
        lblVersion.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblVersion, BorderLayout.CENTER);
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MedicalServices.mainFrame.setEnabled(true);
                MedicalServices.versionFrame.setVisible(false);
        	}
        });        
        
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 17));


        contentPane.add(btnClose, BorderLayout.SOUTH);
	}
}