package gui.br.com.supermarket;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import backend.br.com.supermarket.Functions;
import classes.br.com.supermarket.Product;

public class Window{

	private Functions f;
	private JTextField inputCodBar;
	private JLabel lblCdBar;
	private MainWindow mW;
	private JFrame frame;
	private Product p;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Window(MainWindow hostWindow) {
		super();
		try{
			initialize();
			frame.setVisible(true);
		}catch(Exception e){
			e.getStackTrace();
		}
		this.f = new Functions();
		this.mW = hostWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 250);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(1);
		frame.setTitle("Buscar por Código de Barras");
		
		JButton Equal = new JButton("Buscar");
		Equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = f.getObjByCodBar(Integer.parseInt(inputCodBar.getText()));
				mW.getDisplayProduct().setText(p.getNome_prod());
				frame.dispose();
			}
		});
		Equal.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		Equal.setBounds(10, 78, 89, 23);
		frame.getContentPane().add(Equal);
		
		inputCodBar = new JTextField();
		inputCodBar.setForeground(Color.BLACK);
		inputCodBar.setBounds(10, 44, 200, 23);
		frame.getContentPane().add(inputCodBar);
		inputCodBar.setColumns(10);
		
		lblCdBar = new JLabel("C\u00F3digo de Barras:");
		lblCdBar.setBounds(10, 10, 154, 23);
		frame.getContentPane().add(lblCdBar);
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}
}
