package com.alura;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Font;

public class Main {

	private JFrame frmConversor;
	private JTextField txt_primerValor;
	private JTextField txt_segundoValor;
	private boolean seleccionadorConversor; //Lo utilizamos como bandera para verificar que valores vamos a mostrar en el JComboBox, a traves de lo seleccionado en el JRadioBoton

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmConversor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ButtonGroup grupoRadioBoton = new ButtonGroup();
		frmConversor = new JFrame();
		frmConversor.setFont(new Font("Alef", Font.PLAIN, 24));
		frmConversor.setTitle("Conversor de Moneda / Temperatura");
		frmConversor.setType(Type.UTILITY);
		frmConversor.setResizable(false);
		frmConversor.setBounds(100, 100, 595, 286);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.getContentPane().setLayout(null);
		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 586, 251);
		frmConversor.getContentPane().add(background);
		background.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 200, 111));
		panel.setBounds(0, 0, 302, 309);
		background.add(panel);
		panel.setLayout(null);
		
		JComboBox combo_box= new JComboBox();
		combo_box.setBounds(10, 24, 279, 22);
		panel.add(combo_box);
		combo_box.setVisible(true);
		
		
		JLabel lbl_primerValor = new JLabel("");
		lbl_primerValor.setBounds(10, 72, 152, 14);
		panel.add(lbl_primerValor);
		
		
		txt_primerValor = new JTextField();
		txt_primerValor.setBounds(10, 108, 86, 20);
		panel.add(txt_primerValor);
		txt_primerValor.setEditable(false);
		txt_primerValor.setColumns(10);
		
		
		JLabel lbl_segundoValor = new JLabel("");
		lbl_segundoValor.setBounds(10, 160, 152, 14);
		panel.add(lbl_segundoValor);
		
		
		txt_segundoValor = new JTextField();
		txt_segundoValor.setBounds(10, 205, 86, 20);
		panel.add(txt_segundoValor);
		txt_segundoValor.setEditable(false);
		txt_segundoValor.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(114, 115, 116));
		panel_1.setBounds(302, 0, 283, 118);
		background.add(panel_1);
		panel_1.setLayout(null);
		
		
		JRadioButton jradio_temperatura = new JRadioButton("Conversor de Temperatura");
		jradio_temperatura.setBounds(23, 64, 215, 23);
		panel_1.add(jradio_temperatura);
		jradio_temperatura.setSelected(false);		
		//anexamos el boton al grupo
		grupoRadioBoton.add(jradio_temperatura);
		
		
		JRadioButton jradio_monedas = new JRadioButton("Conversor de Monedas");
		jradio_monedas.setBounds(23, 22, 215, 23);
		panel_1.add(jradio_monedas);
		jradio_monedas.setSelected(false);
		//anexamos el boton al grupo
		grupoRadioBoton.add(jradio_monedas);
		
		JLabel lbl_image_alura = new JLabel("");
		lbl_image_alura.setIcon(new ImageIcon(Main.class.getResource("/com/images/alura.png")));
		lbl_image_alura.setBounds(333, 137, 213, 85);
		background.add(lbl_image_alura);
		
		
		
		
		/*
		 * Agregamos los eventos para los JRadioBoton dependendiendo 
		 * de lo seleccionado se mostrara la informacion en el JComboBox
		 */
		
		jradio_monedas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				combo_box.removeAllItems();
				combo_box.addItem("Convertir Pesos Mexicanos / Dolar");
				combo_box.addItem("Convertir Pesos Mexicanos / Euro");
				combo_box.addItem("Convertir Pesos Mexicanos / Libras Esterlinas");
				combo_box.addItem("Convertir Pesos Mexicanos / Yen Japones");
				combo_box.addItem("Convertir Pesos Mexicanos / Won sul-coreano");
				
				lbl_primerValor.setText("Peso Mexicano"); lbl_segundoValor.setText("Dolar"); //Ponemos los valores "predefinidos"
				
				//definios la bandera en verdadero para decir que usaremos la conversion de monedas
				seleccionadorConversor = true;
				
				//habilitamos las cajas de texto para escribir los valores
				txt_primerValor.setEditable(true); txt_primerValor.setText(0 + "");
				txt_segundoValor.setEditable(true); txt_segundoValor.setText(0 + "");
				
			}
		});
		
		
		jradio_temperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				combo_box.removeAllItems();
				combo_box.addItem("Celsius / Fahrenheit");
				combo_box.addItem("Celcius / Kelvin");
				combo_box.addItem("Fahrenheit / Kelvin");
				lbl_primerValor.setText(""); lbl_segundoValor.setText("");
				
				lbl_primerValor.setText("Celcius"); lbl_segundoValor.setText("Fahrenheit"); //Ponemos los valores "predefinidos"
				
				//definios la bandera en falso para decir que usaremos la conversion temperatura
				seleccionadorConversor = false;
				
				//habilitamos las cajas de texto para escribir los valores
				txt_primerValor.setEditable(true); txt_primerValor.setText(0 + "");
				txt_segundoValor.setEditable(true); txt_segundoValor.setText(0 + "");
			
			}
		});
		
		
		
		/*
		 * Una vez seleccionado lo que vamos a convertir del JRadioBoton.
		 * 
		 * Mostramos en los labels la informacion que contendra los TextField dependiendo del JComboBox.
		 * 
		 * El primer label, va por defecto en Peso Mexicanos para la conversion de moneda.
		 */
		combo_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccionadorConversor) {
					switch (combo_box.getSelectedIndex()) {
					case 0: {
						lbl_segundoValor.setText("Dolar");
						break;
					}
					case 1: {
						lbl_segundoValor.setText("Euro");
						break;
					}
					case 2: {
						lbl_segundoValor.setText("Libras Esterlinas");
						break;
					}
					case 3: {
						lbl_segundoValor.setText("Yen japones");
						break;
					}
					case 4: {
						lbl_segundoValor.setText("Won sul-coreano");
						break;
					}
					default:
						break;
					}
				}
				else {
					switch (combo_box.getSelectedIndex()) {
					case 0: {
						lbl_primerValor.setText("Celsius");
						lbl_segundoValor.setText("Fahrenheit");
						break;
					}
					case 1: {
						lbl_primerValor.setText("Celsius");
						lbl_segundoValor.setText("Kelvin");
						break;
					}
					case 2: {
						lbl_primerValor.setText("Fahrenheit");
						lbl_segundoValor.setText("Kelvin");
						break;
					}
					default:
						break;
					}
					
				}
			}
		});
		
		
		
		
		/*
		 * 
		 * Validamos que los campos solo se puedan recibir numeros en el primer campo
		 * 
		 */
		txt_primerValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			        e.consume();

			    if (txt_primerValor.getText().trim().length() == 5)
			        e.consume();
			}
		});
		
		txt_segundoValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57;
			        
			    if (!numeros)
			        e.consume();

			    if (txt_segundoValor.getText().trim().length() == 5)
			        e.consume();
			}
		});
		
		
		
		/*
		 * Mandamos a llamar la clase Conversor para que haga la accion a proceder dependiendo de lo que se esta solicitando, ya sea conversor de Temperatura/Moneda
		 * 
		 *  Pasamos como dato el valor de la lista del JComboBox para decir que operación va a realizar. Ej: Peso a Dolar, Celsius a Kelvin.
		 *  
		 *  Y llamamos al Listener o ejecutor en ambos TextField para hacer un cambio de la conversion. Positivo para monedas. Negativo para temperatura.
		 */
		
		txt_primerValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversor conversor = new Conversor();
				double valorObtenido;
				if(seleccionadorConversor) {
					valorObtenido = conversor.convertidorMoneda(true, Double.parseDouble(txt_primerValor.getText()), 0.0, combo_box.getSelectedItem().toString());
					txt_segundoValor.setText(valorObtenido + "");
					
				}
				else {
					valorObtenido = conversor.convertidorTemperatura(true, Double.parseDouble(txt_primerValor.getText()), 0.0, combo_box.getSelectedItem().toString());
					txt_segundoValor.setText(valorObtenido + "");
				}
			}
		});
		
		txt_segundoValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversor conversor = new Conversor();
				double valorObtenido;
				if(seleccionadorConversor) {
					valorObtenido = conversor.convertidorMoneda(false, 0.0, Double.parseDouble(txt_segundoValor.getText()), combo_box.getSelectedItem().toString());
					txt_primerValor.setText(valorObtenido + "");
					
				}
				else {
					valorObtenido = conversor.convertidorTemperatura(false, 0.0, Double.parseDouble(txt_segundoValor.getText()), combo_box.getSelectedItem().toString());
					txt_primerValor.setText(valorObtenido + "");
				}
				
			}
		});
	}
}
