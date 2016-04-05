package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import businessLayer.Person;
import businessLayer.Customer;

public class CustomerData extends JFrame {

	private JPanel contentPane;
	private JTextField idClient;
	private JTextField nameClient;
	private JTextField lastnameClient;
	private JTextField phoneClient;
	private Customer customer;
	private CustomerManagement mc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerData frame = new CustomerData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 811, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("C\u00E9dula");
		label.setBounds(10, 27, 57, 14);
		panel.add(label);
		
		idClient = new JTextField();
		idClient.setColumns(10);
		idClient.setBounds(71, 24, 86, 20);
		panel.add(idClient);
		
		JLabel label_1 = new JLabel("Nombres");
		label_1.setBounds(173, 27, 69, 14);
		panel.add(label_1);
		
		nameClient = new JTextField();
		nameClient.setColumns(10);
		nameClient.setBounds(232, 24, 144, 20);
		panel.add(nameClient);
		
		JLabel label_2 = new JLabel("Apellidos");
		label_2.setBounds(386, 27, 65, 14);
		panel.add(label_2);
		
		lastnameClient = new JTextField();
		lastnameClient.setColumns(10);
		lastnameClient.setBounds(446, 24, 142, 20);
		panel.add(lastnameClient);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono");
		label_3.setBounds(598, 27, 69, 14);
		panel.add(label_3);
		
		phoneClient = new JTextField();
		phoneClient.setColumns(10);
		phoneClient.setBounds(666, 24, 100, 20);
		panel.add(phoneClient);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setBounds(10, 96, 57, 14);
		panel.add(label_4);
		
		JTextPane direction = new JTextPane();
		direction.setBounds(71, 79, 292, 60);
		panel.add(direction);
		
		JButton save = new JButton("Guardar");
		save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				try
				{
				customer = new Customer(Long.parseLong(idClient.getText()), nameClient.getText(), lastnameClient.getText(), 
						direction.getText(), Long.parseLong(phoneClient.getText()));
				customer.save();
				
				} catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, "¡Datos incorrectos!\n" + "Por Favor verifique los datos e"
							+ " intentelo de nuevo");
				}
			}
		});
		save.setBounds(571, 216, 89, 23);
		contentPane.add(save);
		
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		cancel.setBounds(702, 216, 89, 23);
		contentPane.add(cancel);
	}
}
