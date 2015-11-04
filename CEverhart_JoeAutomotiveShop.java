/*A very simple JAVA GUI of an automotive shop's billing system created by Christopher Tyler Everhart */

import java.awt.EventQueue;

import javax.swing.JFrame;



import javax.swing.JCheckBox;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;



public class CEverhart_JoeAutomotiveShop {

	private JFrame frame;
	private JTextField additionalParts;
	private JTextField laborHours;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private JTextField totalCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CEverhart_JoeAutomotiveShop window = new CEverhart_JoeAutomotiveShop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CEverhart_JoeAutomotiveShop() {
		initialize();
	}
	//this method will calculate the total cost of a visit to the auto shop
	public static double getTotal(double total, JCheckBox chckbxOilChange, JCheckBox chckbxLubeJob, JCheckBox chckbxRadiatorFlush,
			JCheckBox chckbxTransmissionFlush, JCheckBox chckbxInspection, JCheckBox chckbxMufflerReplacement, JCheckBox chckbxTireRotation,
			JTextField additionalParts, JTextField laborHours)
	{//checks to see what routine jobs were performed and adds their totals to the total cost
		if (chckbxOilChange.isSelected())
		{
			total += 26;
		}
		if (chckbxLubeJob.isSelected())
		{
			total += 18;
		}
		if (chckbxRadiatorFlush.isSelected())
		{
			total += 30;
		}
		if (chckbxTransmissionFlush.isSelected())
		{
			total += 80;
		}
		if (chckbxInspection.isSelected())
		{
			total += 39.75;
		}
		if (chckbxMufflerReplacement.isSelected())
		{
			total += 150;
		}
		if (chckbxTireRotation.isSelected())
		{
			total += 20;
		}
		//this section allows the addition of pricing for parts not listed above
		//as well as allowing the user to add in the number of labor hours
		String inP;
		inP = additionalParts.getText();
		double partCost = Double.parseDouble(inP);
		String inH;
		inH = laborHours.getText();
		double laborCost = Double.parseDouble(inH) * 20; 
		//you could modify the 20 here with whatever your shop will charge
		total += partCost;
		total += laborCost;
		
		
		return total;

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//creating the frame
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double total = 0;
		
		//below are various check boxes for routine operations performed at the auto shop
		JCheckBox chckbxOilChange = new JCheckBox("Oil change - $26.00");

		JCheckBox chckbxLubeJob = new JCheckBox("Lube job - $18.00");
	
		JCheckBox chckbxRadiatorFlush = new JCheckBox("Radiator flush - $30.00");
		
		JCheckBox chckbxTransmissionFlush = new JCheckBox("Transmission flush - $80.00");
		
		JCheckBox chckbxInspection = new JCheckBox("Inspection - $39.75");
		
		JCheckBox chckbxMufflerReplacement = new JCheckBox("Muffler replacement - $150.00");
		
		JCheckBox chckbxTireRotation = new JCheckBox("Tire rotation - $20.00");
		
		//this text field allows entry for additional pricing of parts if applicable
		additionalParts = new JTextField("0");
		additionalParts.setColumns(10);
		JLabel lblNewLabel = new JLabel("Price of Additional Parts:");
		
		//this text field allows entry for the number of labor hours, 
		//it assumes that the auto shop charges $20.00 per hour
		laborHours = new JTextField("0");
		laborHours.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Labor Hours:");
		
		//this button runs the getTotal() method after inputs are finished
		JButton btnCalculateTotal = new JButton("Calculate Total");
		
		//this label displays total cost
		JLabel lblNewLabel_3 = new JLabel("TOTAL COST:");
		totalCost = new JTextField("Your total is:       $" + 				 "0.00");
		totalCost.setEditable(false);
		totalCost.setColumns(10);
		
		
		
		btnCalculateTotal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DecimalFormat formatter = new DecimalFormat("#0.00");
				totalCost.setText("Your total is:       $" + 				formatter.format(getTotal(total, chckbxOilChange, chckbxLubeJob, chckbxRadiatorFlush,
						chckbxTransmissionFlush, chckbxInspection, chckbxMufflerReplacement, chckbxTireRotation, additionalParts, laborHours)));
			}
		});
		//modify the below text to change it to the address of your auto shop
		//as well as the name of your auto shop
		JLabel lblNewLabel_4 = new JLabel("Joe's Automotive Shop");
		lblNewLabel_4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		
		JLabel lblNewLabel_5 = new JLabel("1234 Java Drive");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.ITALIC, 11));
		
		JLabel lblNewLabel_6 = new JLabel("Kingwood, TX 77339");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.ITALIC, 11));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(laborHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(additionalParts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxOilChange)
								.addComponent(chckbxLubeJob)
								.addComponent(chckbxRadiatorFlush)
								.addComponent(chckbxTransmissionFlush)
								.addComponent(chckbxInspection)
								.addComponent(chckbxMufflerReplacement)
								.addComponent(chckbxTireRotation)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(totalCost, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_4)
									.addComponent(btnCalculateTotal, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(41, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5))
							.addGap(102))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_4)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxOilChange)
						.addComponent(lblNewLabel_5))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxLubeJob)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxRadiatorFlush)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxTransmissionFlush)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxInspection)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxMufflerReplacement)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxTireRotation))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6)))
					.addGap(12)
					.addComponent(btnCalculateTotal, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(additionalParts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(laborHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(totalCost, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
