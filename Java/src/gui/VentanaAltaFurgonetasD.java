package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.Furgonetas;
import service.ServicePrincipal;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VentanaAltaFurgonetasD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea respuesta;
	private JLabel lblAltaFurgonetaMatricula;
	private JLabel lblRutadesde;
	private JLabel lblAltaFurgonetaRutaHasta;
	private JTextField txtMatricula;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaAltaFurgonetasD dialog = new VentanaAltaFurgonetasD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAltaFurgonetasD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAltaFurgonetasD.class.getResource("/img/logo.png")));
		setResizable(false);
		setModal(true);
		setTitle("Alta Furgonetas");
		setBounds(100, 100, 521, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ServicePrincipal sp = new ServicePrincipal();
						Furgonetas f = sp.buscarFurgoneta(txtMatricula.getText());
						if (f != null) {
							respuesta.setText("Ya existe una furgoneta con esa matricula");
						} else {
							respuesta.setText(validarYGuardar(sp));
						}
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.setLayout(null);
		
		contentPanel.add(getRespuesta());
		contentPanel.add(getLblAltaFurgonetaMatricula());
		contentPanel.add(getLblRutadesde());
		contentPanel.add(getLblAltaFurgonetaRutaHasta());
		contentPanel.add(getTxtMatricula());
		contentPanel.add(getTxtDesde());
		contentPanel.add(getTxtHasta());
		contentPanel.add(getLblNewLabel());
	}
	
	private JTextArea getRespuesta() {
		if (respuesta == null) {
			respuesta = new JTextArea();
			respuesta.setFont(new Font("Monospaced", Font.BOLD, 13));
			respuesta.setEditable(false);
			respuesta.setBorder(null);
			respuesta.setBackground(UIManager.getColor("Button.background"));
			respuesta.setBounds(21, 101, 474, 23);
			respuesta.setColumns(10);
		}
		return respuesta;
	}

	private JLabel getLblAltaFurgonetaMatricula() {
		if (lblAltaFurgonetaMatricula == null) {
			lblAltaFurgonetaMatricula = new JLabel("Matricula");
			lblAltaFurgonetaMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAltaFurgonetaMatricula.setBounds(37, 135, 53, 17);
		}
		return lblAltaFurgonetaMatricula;
	}

	private JLabel getLblRutadesde() {
		if (lblRutadesde == null) {
			lblRutadesde = new JLabel("Ruta Desde");
			lblRutadesde.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRutadesde.setBounds(188, 135, 71, 17);
		}
		return lblRutadesde;
	}

	private JLabel getLblAltaFurgonetaRutaHasta() {
		if (lblAltaFurgonetaRutaHasta == null) {
			lblAltaFurgonetaRutaHasta = new JLabel("Ruta Hasta");
			lblAltaFurgonetaRutaHasta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAltaFurgonetaRutaHasta.setBounds(353, 135, 67, 17);
		}
		return lblAltaFurgonetaRutaHasta;
	}

	private JTextField getTxtMatricula() {
		if (txtMatricula == null) {
			txtMatricula = new JTextField();
			txtMatricula.setToolTipText("introduce la matricula\r\n");
			txtMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtMatricula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtMatricula.getText().length()>=7) {
							e.consume();
						}
					}
				
			});
			txtMatricula.setBounds(37, 158, 117, 28);
			txtMatricula.setColumns(10);
		}
		return txtMatricula;
	}

	private JTextField getTxtDesde() {
		if (txtDesde == null) {
			txtDesde = new JTextField();
			txtDesde.setToolTipText("El codigo postal desde el que repartira");
			txtDesde.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtDesde.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtDesde.getText().length()>=5) {
							e.consume();
						}
					}
				
			});
			txtDesde.setColumns(10);
			txtDesde.setBounds(188, 158, 123, 28);
		}
		return txtDesde;
	}

	private JTextField getTxtHasta() {
		if (txtHasta == null) {
			txtHasta = new JTextField();
			txtHasta.setToolTipText("El codigo postal hasta el que repartira");
			txtHasta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtHasta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				
						if(txtHasta.getText().length()>=5) {
							e.consume();
						}
					}
				
			});
			txtHasta.setColumns(10);
			txtHasta.setBounds(353, 159, 123, 27);
		}
		return txtHasta;
	}

	protected String validarYGuardar(ServicePrincipal sp) {
		if (txtMatricula.getText().length() != 7) {
			return "las matriculas tienen que tener 7 digitos";
		}
		if (txtDesde.getText().length() != 5 || txtHasta.getText().length() != 5 || !isNumeric(txtDesde.getText())
				|| !isNumeric(txtHasta.getText())) {
			return "los CP tienen que tener 5 digitos numericos";
		}

		int d = Integer.parseInt(txtDesde.getText());
		int h = Integer.parseInt(txtHasta.getText());

		if (d < 33000 || d > 33999) {
			return "Los rangos de CP tiene que ser de asturias (33000-33999)";
		}
		if (h < 33000 || h > 33999) {
			return "Los rangos de CP tiene que ser de asturias (33000-33999)";
		}
		if (d > h) {
			return ("desde no puede ser mayor que hasta");
		}
		String respuesta =sp.AltaFurgoneta(txtMatricula.getText(), txtDesde.getText(), txtHasta.getText());
		txtDesde.setText("");
		txtHasta.setText("");
		txtMatricula.setText("");
		
		return respuesta;
		
		
	}

	public static boolean isNumeric(String str) {
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(139, 11, 181, 79);
			
			ImageIcon imagen =	new ImageIcon(VentanaLogin.class.getResource("/img/logo furgoneta.jpg"));
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), 1));
			lblNewLabel.setIcon(icono);
		}
		return lblNewLabel;
	}
}
