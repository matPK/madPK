package gui.br.com.supermarket;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backend.br.com.supermarket.Functions;
import classes.br.com.supermarket.Product;

import javax.swing.JTextField;

public class MainWindow {
	
	private JButton btnFinalizar;
	private Functions f;
	private JFrame frame;
	private JButton btnBuscarPorCdigo;
	private JLabel displayProduct;
	private JLabel labelProduct;
	private JLabel valorTotalDisplay;
	private MainWindow mW = this;
	private Product[] prodList = new Product[0];
	private int numProducts = 0;
	private Window w1;
	private JButton addToListButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public MainWindow() {
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
		this.f = new Functions();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Buscar por Código de Barras");
		
		btnBuscarPorCdigo = new JButton("Buscar Produto por Codigo de Barras");
		btnBuscarPorCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				w1 = new Window(mW);
			}
		});
		btnBuscarPorCdigo.setBounds(10, 11, 246, 23);
		frame.getContentPane().add(btnBuscarPorCdigo);
		
		displayProduct = new JLabel("");
		displayProduct.setBounds(10, 78, 200, 23);
		frame.getContentPane().add(displayProduct);
		
		labelProduct = new JLabel("Produto:");
		labelProduct.setBounds(10, 45, 193, 22);
		frame.getContentPane().add(labelProduct);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 104, 299, 160);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		frame.getContentPane().add(textArea);
		
		addToListButton = new JButton("Adicionar");
		addToListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setProdList(f.Append(prodList));
				prodList[numProducts++] = w1.getP();
				textArea.setText(f.refreshList(prodList));
				valorTotalDisplay.setText(
						Double.toString(f.calculateTotal(prodList))
				);
			}
		});
		addToListButton.setBounds(220, 78, 89, 23);
		frame.getContentPane().add(addToListButton);
		
		JLabel valorTotalLabel = new JLabel("Valor Total: R$");
		valorTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valorTotalLabel.setBounds(10, 275, 94, 35);
		frame.getContentPane().add(valorTotalLabel);
		
		valorTotalDisplay = new JLabel("0.00");
		valorTotalDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		valorTotalDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valorTotalDisplay.setBounds(103, 275, 89, 35);
		frame.getContentPane().add(valorTotalDisplay);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prodList = null;
				prodList = new Product[0];
				textArea.setText(f.refreshList(prodList));
				valorTotalDisplay.setText("0.00");
				numProducts = 0;
			}
		});
		btnCancelar.setBounds(220, 283, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pagamento p1 = new Pagamento(mW);
			}
		});
		btnPagamento.setBounds(10, 315, 107, 23);
		frame.getContentPane().add(btnPagamento);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.finalize(prodList);
				JOptionPane.showMessageDialog(null, "Compra finalizada, próximo cliente!");
				frame.dispose();
			}
		});
		btnFinalizar.setBounds(220, 315, 89, 23);
		btnFinalizar.setVisible(false);
		frame.getContentPane().add(btnFinalizar);
		
		
	}

	public JLabel getDisplayProduct() {
		return displayProduct;
	}

	public MainWindow getmW() {
		return mW;
	}

	public void setDisplayProduct(JLabel displayProduct) {
		this.displayProduct = displayProduct;
	}

	public void setmW(MainWindow mW) {
		this.mW = mW;
	}

	public Product[] getProdList() {
		return prodList;
	}

	public void setProdList(Product[] prodList) {
		this.prodList = prodList;
	}

	public JLabel getValorTotalDisplay() {
		return valorTotalDisplay;
	}

	public void setValorTotalDisplay(JLabel valorTotalDisplay) {
		this.valorTotalDisplay = valorTotalDisplay;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}

	public JButton getAddToListButton() {
		return addToListButton;
	}

	public void setAddToListButton(JButton addToListButton) {
		this.addToListButton = addToListButton;
	}
}
