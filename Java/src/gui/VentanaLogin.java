package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import service.ServiceLogin;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JLabel lblUser;
	private JLabel lblpass;
	private JPasswordField contraseña;
	public JTextField respuesta;
	private JButton btnAceptar;
	private String logueado;
	private JButton btnLoginRegistrarse;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setResizable(false);
		setTitle("Login Asturexpress");
		 
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getUsuario());
		contentPane.add(getLblUser());
		contentPane.add(getLblpass());
		contentPane.add(getContraseña());
		contentPane.add(getRespuesta());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnLoginRegistrarse());
		contentPane.add(getLblNewLabel());
		setLocationRelativeTo(null);
	}

	private JTextField getUsuario() {
		if (usuario == null) {
			usuario = new JTextField();
			usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
			usuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(usuario.getText().length()>=25) {
							e.consume();
						}
					}
				
			});
			usuario.setBounds(41, 143, 133, 22);
			usuario.setColumns(10);
		}
		return usuario;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Usuario");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUser.setBounds(41, 118, 93, 22);
		}
		return lblUser;
	}

	private JLabel getLblpass() {
		if (lblpass == null) {
			lblpass = new JLabel("Contrase\u00F1a");
			lblpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblpass.setBounds(226, 114, 93, 30);
		}
		return lblpass;
	}

	private JPasswordField getContraseña() {
		if (contraseña == null) {
			contraseña = new JPasswordField();
			contraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
			contraseña.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String pass = new String(contraseña.getPassword());
						if(pass.length()>=25) {
							e.consume();
						}
					}
				
			});
			
			contraseña.setBounds(226, 143, 185, 22);
		}
		return contraseña;
	}

	public JTextField getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextField();
			respuesta.setEditable(false);
			respuesta.setBorder(null);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setBounds(41, 175, 335, 20);
			respuesta.setColumns(10);
		}
		return respuesta;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String con = new String(contraseña.getPassword());
					ServiceLogin sl = new ServiceLogin();
					if (con.length() < 6) {
						respuesta.setText("La contraseña tiene que tener al menos 6 caracteres");
					} else {
						boolean comprobacion = sl.comprobar(usuario.getText(), con);

						if (comprobacion) {
							
							VInicio va = new VInicio(usuario.getText());
							va.setVisible(true);
							dispose();
							
						} else {
							respuesta.setText("usuario o pass incorrecto");
						}
					}

				}
			});
			btnAceptar.setBounds(257, 206, 119, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnLoginRegistrarse() {
		if (btnLoginRegistrarse == null) {
			btnLoginRegistrarse = new JButton("Registrarse");
			btnLoginRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnLoginRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					VentanaAlta frame = new VentanaAlta();
					frame.setVisible(true);
					dispose();
				}
			});
			btnLoginRegistrarse.setBounds(60, 206, 114, 23);
		}
		return btnLoginRegistrarse;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(41, 11, 335, 96);
			ImageIcon imagen =	new ImageIcon(VentanaLogin.class.getResource("/img/icono login.jpg"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), 1));
			lblNewLabel.setIcon(icono);
			
		}
		return lblNewLabel;
	}
}
