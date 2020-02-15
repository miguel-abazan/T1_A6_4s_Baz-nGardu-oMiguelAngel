import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


class ConvertidorTemperaturas extends JFrame implements ActionListener{
	
	JTextField cajaGradosC, cajaResultado;
	JComboBox<String> comboBoxTemperaturas,comboBoxTemperaturas2;
	JLabel con,con2,con3;

	DecimalFormat f = new DecimalFormat("#,###.000°");

	public ConvertidorTemperaturas() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CONVERSOR");
		setSize(260,120);
		setLocationRelativeTo(null);
		setVisible(true);	
		
		
		con=new JLabel("Convertir:");
		con.setBounds(10, 10, 60, 25);
		add(con);
		
		
		cajaGradosC = new JTextField("70",10);
		cajaGradosC.setBounds(70, 10, 40, 25);
		add(cajaGradosC); 
		
	
		String [] med = {"° Centigrados", "° Fahrenheit", "° Kelvin", "° Rankin"};
		comboBoxTemperaturas = new JComboBox<String>(med);
		comboBoxTemperaturas.setBounds(120, 10, 105, 25);
		add(comboBoxTemperaturas); 
		
		con2=new JLabel("A: ");
		con2.setBounds(10, 40, 20, 25);
		add(con2);
		
		comboBoxTemperaturas2 = new JComboBox<>(med); 
		comboBoxTemperaturas2.setBounds(30, 40, 105, 25);
		add(comboBoxTemperaturas2); 
		comboBoxTemperaturas2.addActionListener(this);
		
		
		con3=new JLabel("=");
		con3.setBounds(140, 40, 10, 25);
		add(con3);
		
		cajaResultado = new JTextField(10);
		cajaResultado.setBounds(160, 40, 70, 25);
		add(cajaResultado);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(comboBoxTemperaturas.getSelectedIndex() == 0) {
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(cajaGradosC.getText());
			}else if(comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf(f.format((Double.parseDouble(cajaGradosC.getText()) * 9/5) + 32)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText()) + 273.15)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(f.format((Double.parseDouble(cajaGradosC.getText()) * 9/5 + 491.67))));
			}
		}else if(comboBoxTemperaturas.getSelectedIndex() == 1) { 
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(f.format((Double.parseDouble(cajaGradosC.getText()) - 32) * 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(cajaGradosC.getText());
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(f.format((Double.parseDouble(cajaGradosC.getText()) - 32) * 5/9 + 273.15)));
				
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText()) + 459.67)));
			}
		
		}else if(comboBoxTemperaturas.getSelectedIndex() == 2) {
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText()) - 273.15)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf((f.format((Double.parseDouble(cajaGradosC.getText())-273.15 ) * 9/5) + 32)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(cajaGradosC.getText());
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText())*1.8)));
			}
		}else if(comboBoxTemperaturas.getSelectedIndex() == 3) {
			if(comboBoxTemperaturas2.getSelectedIndex() == 0) {
				cajaResultado.setText(String.valueOf(f.format(( Double.parseDouble(cajaGradosC.getText()) -  491.67) * 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 1) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText()) - 459.67)));
				
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 2) {
				cajaResultado.setText(String.valueOf(f.format(Double.parseDouble(cajaGradosC.getText())* 5/9)));
			}else if (comboBoxTemperaturas2.getSelectedIndex() == 3) {
				cajaResultado.setText(cajaGradosC.getText());
			}
		}
	}
}
public class Convertidor {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ConvertidorTemperaturas();
			}
		});

	}

}
