import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BMI_Calc {

	private JFrame frmBmiCalculator;
	private JTextField txt_weight;
	private JTextField txt_height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_Calc window = new BMI_Calc();
					window.frmBmiCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI_Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBmiCalculator = new JFrame();
		frmBmiCalculator.setTitle("BMI Calculator");
		frmBmiCalculator.setBounds(100, 100, 450, 300);
		frmBmiCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmiCalculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BMI Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 11, 164, 27);
		frmBmiCalculator.getContentPane().add(lblNewLabel);
		
		JLabel lbl_Weight = new JLabel("Your Weight");
		lbl_Weight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Weight.setBounds(44, 51, 92, 27);
		frmBmiCalculator.getContentPane().add(lbl_Weight);
		
		JLabel lbl_Weight_1 = new JLabel("Your Height");
		lbl_Weight_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Weight_1.setBounds(44, 96, 92, 27);
		frmBmiCalculator.getContentPane().add(lbl_Weight_1);
		
		txt_weight = new JTextField();
		txt_weight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_weight.setBounds(143, 49, 110, 34);
		frmBmiCalculator.getContentPane().add(txt_weight);
		txt_weight.setColumns(10);
		
		txt_height = new JTextField();
		txt_height.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_height.setColumns(10);
		txt_height.setBounds(143, 94, 110, 34);
		frmBmiCalculator.getContentPane().add(txt_height);
		
		JLabel lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(263, 55, 46, 19);
		frmBmiCalculator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("cm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(261, 100, 46, 19);
		frmBmiCalculator.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lbl_Weight_1_1 = new JLabel("Your BMI");
		lbl_Weight_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Weight_1_1.setBounds(44, 150, 92, 27);
		frmBmiCalculator.getContentPane().add(lbl_Weight_1_1);
		
		JLabel lbl_anzr = new JLabel("");
		lbl_anzr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_anzr.setBounds(143, 150, 110, 27);
		frmBmiCalculator.getContentPane().add(lbl_anzr);
		
		JButton btn_calc = new JButton("Calculate");
		btn_calc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{
					double weight = Double.valueOf(txt_weight.getText());
					double height = Double.valueOf(txt_height.getText());
					
					if ((height!=0) & (weight!=0))
					{
						double answer = weight / (Math.pow(height/100, 2));
						String anzr_rounded = String.format("%.2f", answer);
						
						lbl_anzr.setText(anzr_rounded);
					}
					else 
					{
						JOptionPane.showMessageDialog(frmBmiCalculator, "Enter valued height and weight.","Value Error",JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(frmBmiCalculator, "Enter valued height and weight.","Value Error",JOptionPane.WARNING_MESSAGE);
					txt_height.setText("");
					txt_weight.setText("");
					lbl_anzr.setText("");
					txt_weight.requestFocus();
				}
				
			}
		});
		btn_calc.setBounds(77, 188, 98, 34);
		frmBmiCalculator.getContentPane().add(btn_calc);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_height.setText("");
				txt_weight.setText("");
				lbl_anzr.setText("");
				txt_weight.requestFocus();
			}
		});
		btn_clear.setBounds(246, 188, 98, 34);
		frmBmiCalculator.getContentPane().add(btn_clear);
		
		JLabel lblNewLabel_2 = new JLabel("@XCletus3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(346, 231, 64, 19);
		frmBmiCalculator.getContentPane().add(lblNewLabel_2);

	}
}
