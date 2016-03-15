package gui.br.com.supermarket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pagamento {

	private JFrame frame;
	private JTextField receivedValueTB;
	private double change;
	private MainWindow hostWindow;
	private JLabel totalValueDisplay;
	private JLabel changeDisplay;
	private JButton btnPago;

	/**
	 * Create the application.
	 */
	public Pagamento(MainWindow hostWindow) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.hostWindow = hostWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 268, 172);
		frame.setDefaultCloseOperation(1);
		frame.getContentPane().setLayout(null);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(10, 11, 66, 14);
		frame.getContentPane().add(lblValorTotal);
		
		totalValueDisplay = new JLabel("");
		totalValueDisplay.setBounds(106, 11, 60, 14);
		totalValueDisplay.setText(hostWindow.getValorTotalDisplay().getText());
		frame.getContentPane().add(totalValueDisplay);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido:");
		lblValorRecebido.setBounds(10, 36, 95, 14);
		frame.getContentPane().add(lblValorRecebido);
		
		receivedValueTB = new JTextField();
		receivedValueTB.setBounds(106, 33, 86, 20);
		frame.getContentPane().add(receivedValueTB);
		receivedValueTB.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblTroco);
		
		changeDisplay = new JLabel("");
		changeDisplay.setBounds(106, 64, 60, 14);
		frame.getContentPane().add(changeDisplay);
		
		JButton btnPagar = new JButton("Calcular");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					change = Double.valueOf(receivedValueTB.getText()) - Double.valueOf(totalValueDisplay.getText());
					changeDisplay.setText(Double.toString(change));
					if(change >= 0){
						btnPago.setVisible(true);
					}
				}catch(Exception e){
					e.getStackTrace();
				}
			}
		});
		btnPagar.setBounds(4, 99, 89, 23);
		frame.getContentPane().add(btnPagar);
		
		btnPago = new JButton("Pago");
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hostWindow.getBtnFinalizar().setVisible(true);
				hostWindow.getAddToListButton().setVisible(false);
				frame.dispose();
			}
		});
		btnPago.setBounds(153, 99, 89, 23);
		btnPago.setVisible(false);
		frame.getContentPane().add(btnPago);
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
