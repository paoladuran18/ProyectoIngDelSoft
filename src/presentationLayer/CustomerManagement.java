package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLayer.Customer;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dataLayer.ConnectorDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class CustomerManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ConnectorDB con = new ConnectorDB();
	private Connection cn = con.getConnection();
	private Customer cust = new Customer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManagement frame = new CustomerManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public void showCustomers() throws Exception
	{
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Cédula");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dirección");
		model.addColumn("Teléfono");
		
		table.setModel(model);
		
		ArrayList<Customer> cList = new ArrayList();
		cList = cust.consult();
		Iterator l = cList.iterator();
		
		for(int j = 0; j < cList.size() -1; j++)
			model.addRow(new Object[]{cList.get(j).getId(), cList.get(j).getName(), cList.get(j).getLastname(),
				cList.get(j).getDirection(), cList.get(j).getPhon()});
		
		table.setModel(model);
	}
	
	public CustomerManagement() throws Exception {
		setTitle("Gesti\u00F3n de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		
		JButton addCustomer = new JButton("Agregar");
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerData win = new CustomerData();
				win.show();
			}
		});
		
		JLabel lblBuscar = new JLabel("Buscar");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton back = new JButton("Volver");
		
		JButton modifyCustomer = new JButton("Modificar");
		
		JButton deleteCustomer = new JButton("Eliminar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBuscar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
							.addComponent(addCustomer)
							.addGap(18)
							.addComponent(back)
							.addGap(18)
							.addComponent(modifyCustomer)
							.addGap(18)
							.addComponent(deleteCustomer)
							.addGap(39)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBuscar)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(addCustomer)
								.addComponent(back)
								.addComponent(modifyCustomer)
								.addComponent(deleteCustomer))
							.addGap(42))))
		);
		
		table = new JTable();
		showCustomers();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
