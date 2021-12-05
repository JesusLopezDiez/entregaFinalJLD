package gui;


// version 1.10

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import beans.DatosEnvio;
import beans.Estados;
import beans.Furgonetas;
import beans.CargaFurgonetas;
import service.ServicePrincipal;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.SystemColor;

public class VInicio extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel Seguimiento;
	private JPanel Altas;
	private JTextField entrada;
	private JTextArea texto;
	private JButton Buscar;
	private JPanel PDA;
	private JTextField EntradaPDA;
	private JLabel labelEntradaPda;
	private JButton btnBuscarPDA;
	private JTextField txtCliente;
	private JTextField txtLocalidadOrigen;
	private JTextField txtCpOrigen;
	private JTextField txtPeso;
	private JTextField txtVolumen;
	private JTextField txtRespuesta;
	private JLabel lblPeso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblLocalidaOrigen;
	private JLabel lblCpOrigen;
	private JTextField textLocalidadDestino;
	private JTextField destinatario;
	private JTextArea Observaciones;
	private JTextField direccion;
	private JTextField cpDestino;
	private JLabel lblDestinatario;
	private JLabel lblDireccion;
	private JLabel lblObservaciones;
	private JLabel lblLocalidadDestino;
	private JLabel lblCpDestino;
	private JButton DarIncidencia;
	private JTextField textAltasCpOrigen;
	private JLabel lblLAltasLocalidadOrigen;
	private JTextField txtaltasLocalidadOrigen;
	private JLabel lblAltasCpOrigen;
	private JTextField txtAltasPeso;
	private JLabel lblAltasPeso;
	private JTextField txtAltasVolumen;
	private JLabel lblNewLabel_2;
	private JLabel lblAltasDestinatario;
	private JLabel lblAltasCliente;
	private JTextField txtAltasDestinatario;
	private JTextField txtAltasClientes;
	private JLabel lblAltasDireccion;
	private JTextField textAltasDireccion;
	private JTextField txtAltasLocalidadDestino;
	private JLabel lblAltasLocalidadDeDestino;
	private JLabel lblAltasCpDestino;
	private JTextField txtAltasCpDestino;
	private JTextArea txtAltasObservaciones;
	private JLabel lblAltasObservaciones;
	private JLabel lblAltasTitulo;
	private JTextField textAltasRespuesta;
	private JButton btnAltasAlta;
	private String user;
	private JPanel Furgonetas;
	private JLabel lblMatriculaFurgonetas;
	private JTextField txtEntradaFurgonetas;
	private JButton btnBuscarFurgonetas;
	private JButton btnAltaFurgonetas;
	private JTextField respuestaFurgonetas;
	private JTextField txtFurgonetasRutaDesde;
	private JTextField txtFurgonetasRutaHasta;
	private JTextField txtFurgonetasFechaAlta;
	private JTextField txtFurgonetasFechaBaja;
	private JLabel lblFurgonetasRutaDesde;
	private JLabel lblFurgonetasRutaHasta;
	private JLabel lblFurgonetasFechaAltas;
	private JLabel lblFurgonetasFechaBaja;
	private JLabel lblFurgonetasCarga;
	protected JTextArea textAreaCargaEnvios;
	private JButton btnEliminarFurgoneta;
	private JButton btnGestionarCarga;
	private JButton btnEditarFurgonetas;
	private JButton btnGuardarCambios;
	private JPanel Clasificar;
	private JComboBox comboClasificarEnvios;
	private JButton btnClasificar;
	private JComboBox comboBoxFurgonetasPermitidas;
	private ServicePrincipal sp;
	private List<DatosEnvio> sacarTodosEnvios;
	private List<Furgonetas> furgonetasPermitidas;
	private JButton btnClasificarAgregar;
	private JTextField txtClasificarRespuesta;
	private JLabel lblSeguimiento;
	private JLabel lblSeguimientoEstados;
	private JTextField txtSeguimientoTitulo;
	private JTextField txtTituloClasificacion;
	private JLabel lblImagen;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicio frame = new VInicio("paco");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VInicio(String user) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VInicio.class.getResource("/img/logo.png")));

		// Parametros asociados a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Intranet Asturexpress");
		setBounds(0, 0, 796, 496);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		sp = new ServicePrincipal();
		furgonetasPermitidas = new ArrayList();
		sacarTodosEnvios = new ArrayList();
		this.user = user;
		getContentPane().add(getTabbedPane());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tabbedPane.setBounds(0, 0, 796, 461);
			tabbedPane.addTab("Altas", null, getAltas(), null);
			tabbedPane.addTab("PDA", null, getPDA(), null);
			tabbedPane.addTab("Seguimiento", null, getSeguimiento(), null);
			tabbedPane.addTab("Furgonetas", null, getFurgonetas(), null);
			tabbedPane.addTab("Clasificar", null, getClasificar(), null);
		}
		return tabbedPane;
	}

	private JPanel getSeguimiento() {
		if (Seguimiento == null) {
			Seguimiento = new JPanel();
			Seguimiento.setBorder(null);
			Seguimiento.setLayout(null);
			Seguimiento.add(getEntrada());
			Seguimiento.add(getTexto());
			Seguimiento.add(getBuscar());
			Seguimiento.add(getLblSeguimiento());
			Seguimiento.add(getLblSeguimientoEstados());
			Seguimiento.add(getTxtSeguimientoTitulo());
			Seguimiento.add(getLblNewLabel_4());
			Seguimiento.add(getLblNewLabel_4_1());

		}
		return Seguimiento;
	}

	private JPanel getAltas() {
		if (Altas == null) {
			Altas = new JPanel();
			Altas.setLayout(null);
			Altas.add(getTextAltasCpOrigen());
			Altas.add(getLblLAltasLocalidadOrigen());
			Altas.add(getTxtaltasLocalidadOrigen());
			Altas.add(getLblAltasCpOrigen());
			Altas.add(getTxtAltasPeso());
			Altas.add(getLblAltasPeso());
			Altas.add(getTxtAltasVolumen());
			Altas.add(getLblNewLabel_2());
			Altas.add(getLblAltasDestinatario());
			Altas.add(getLblAltasCliente());
			Altas.add(getTxtAltasDestinatario());
			Altas.add(getTxtAltasClientes());
			Altas.add(getLblAltasDireccion());
			Altas.add(getTextAltasDireccion());
			Altas.add(getTxtAltasLocalidadDestino());
			Altas.add(getLblAltasLocalidadDeDestino());
			Altas.add(getLblAltasCpDestino());
			Altas.add(getTxtAltasCpDestino());
			Altas.add(getTxtAltasObservaciones());
			Altas.add(getLblAltasObservaciones());
			Altas.add(getLblAltasTitulo());
			Altas.add(getTextAltasRespuesta());
			Altas.add(getBtnAltasAlta());
			Altas.add(getLblImagen());
		}
		return Altas;
	}

	private JTextField getEntrada() {
		if (entrada == null) {
			entrada = new JTextField();
			entrada.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (entrada.getText().length() >= 15) {
						e.consume();
					}
				}

			});
			entrada.setToolTipText("Introduzca el numero de envio");
			entrada.setFont(new Font("Tahoma", Font.BOLD, 13));
			entrada.setBounds(44, 139, 264, 31);
			entrada.setColumns(10);
		}
		return entrada;
	}

	private JTextArea getTexto() {
		if (texto == null) {
			texto = new JTextArea();
			texto.setFont(new Font("Monospaced", Font.BOLD, 14));
			texto.setWrapStyleWord(true);
			texto.setLineWrap(true);
			texto.setEditable(false);
			texto.setBackground(UIManager.getColor("Button.background"));
			texto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			texto.setBounds(44, 220, 704, 200);

		}
		return texto;
	}

	private JButton getBuscar() {
		if (Buscar == null) {
			Buscar = new JButton("Buscar");
			Buscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			Buscar.setFont(new Font("Tahoma", Font.BOLD, 14));
			Buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					texto.setText("");
					if (entrada.getText().replace(" ", "").length() != 15) {
						texto.setText("Los envios deben tener 15 caracteres");
					} else {
						List<Estados> lista = sp.historico(entrada.getText().replace(" ", ""));
						if (lista.isEmpty()) {
							texto.setText("La busqueda no ha devuelto resultados");
							entrada.setText("");
						} else {
							for (Estados s : lista) {
								texto.setText(texto.getText() + s.toString());
							}
						}
					}

				}
			});
			Buscar.setBounds(328, 138, 174, 31);
		}
		return Buscar;
	}

	private JPanel getPDA() {
		if (PDA == null) {
			PDA = new JPanel();
			PDA.setForeground(new Color(0, 0, 0));
			PDA.setLayout(null);
			PDA.add(getEntradaPDA());
			PDA.add(getLabelEntradaPda());
			PDA.add(getBtnBuscarPDA());
			PDA.add(getTxtCliente());
			PDA.add(getTxtLocalidadOrigen());
			PDA.add(getTxtCpOrigen());
			PDA.add(getTxtPeso());
			PDA.add(getTxtVolumen());
			PDA.add(getTxtRespuesta());
			PDA.add(getLblPeso());
			PDA.add(getLblNewLabel());
			PDA.add(getLblNewLabel_1());
			PDA.add(getLblLocalidaOrigen());
			PDA.add(getLblCpOrigen());
			PDA.add(getTextLocalidadDestino());
			PDA.add(getDestinatario());
			PDA.add(getObservaciones());
			PDA.add(getDireccion());
			PDA.add(getCpDestino());
			PDA.add(getLblDestinatario());
			PDA.add(getLblDireccion());
			PDA.add(getLblObservaciones());
			PDA.add(getLblLocalidadDestino());
			PDA.add(getLblCpDestino());
			PDA.add(getDarIncidencia());
			PDA.add(getLblNewLabel_3());
			PDA.add(getLblNewLabel_3_1());
		}
		return PDA;
	}

	private JTextField getEntradaPDA() {
		if (EntradaPDA == null) {
			EntradaPDA = new JTextField();
			EntradaPDA.setFont(new Font("Tahoma", Font.BOLD, 13));
			EntradaPDA.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (EntradaPDA.getText().length() >= 15) {
						e.consume();
					}
				}

			});
			EntradaPDA.setBounds(34, 35, 290, 32);
			EntradaPDA.setColumns(10);
		}
		return EntradaPDA;
	}

	private JLabel getLabelEntradaPda() {
		if (labelEntradaPda == null) {
			labelEntradaPda = new JLabel("Numero de Envio:");
			labelEntradaPda.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelEntradaPda.setBounds(34, 11, 129, 26);
		}
		return labelEntradaPda;
	}

	private JButton getBtnBuscarPDA() {
		if (btnBuscarPDA == null) {
			btnBuscarPDA = new JButton("Buscar");
			btnBuscarPDA.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnBuscarPDA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					DatosEnvio de = sp.BuscarEnvio(EntradaPDA.getText());
					if (de != null) {
						DarIncidencia.setEnabled(true);
						rellenarDatos(de);
						txtRespuesta.setText("");

					} else {
						txtRespuesta.setText("No hay ningun envio con ese numero");
						DarIncidencia.setEnabled(false);
						rellenarDatosBlanco();
					}

				}

			});
			btnBuscarPDA.setBounds(34, 71, 129, 27);
		}
		return btnBuscarPDA;
	}

	private JTextField getTxtCliente() {
		if (txtCliente == null) {
			txtCliente = new JTextField();
			txtCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtCliente.setEditable(false);
			txtCliente.setBounds(561, 145, 147, 26);
			txtCliente.setColumns(10);
		}
		return txtCliente;
	}

	private JTextField getTxtLocalidadOrigen() {
		if (txtLocalidadOrigen == null) {
			txtLocalidadOrigen = new JTextField();
			txtLocalidadOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtLocalidadOrigen.setEditable(false);
			txtLocalidadOrigen.setBounds(34, 145, 147, 26);
			txtLocalidadOrigen.setColumns(10);
		}
		return txtLocalidadOrigen;
	}

	private JTextField getTxtCpOrigen() {
		if (txtCpOrigen == null) {
			txtCpOrigen = new JTextField();
			txtCpOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtCpOrigen.setEditable(false);
			txtCpOrigen.setBounds(34, 211, 147, 26);
			txtCpOrigen.setColumns(10);
		}
		return txtCpOrigen;
	}

	private JTextField getTxtPeso() {
		if (txtPeso == null) {
			txtPeso = new JTextField();
			txtPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtPeso.setEditable(false);
			txtPeso.setBounds(34, 268, 147, 27);
			txtPeso.setColumns(10);
		}
		return txtPeso;
	}

	private JTextField getTxtVolumen() {
		if (txtVolumen == null) {
			txtVolumen = new JTextField();
			txtVolumen.setEditable(false);
			txtVolumen.setSelectedTextColor(Color.BLACK);
			txtVolumen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtVolumen.setForeground(Color.BLACK);
			txtVolumen.setBounds(35, 327, 147, 26);
			txtVolumen.setColumns(10);
		}
		return txtVolumen;
	}

	private JTextField getTxtRespuesta() {
		if (txtRespuesta == null) {
			txtRespuesta = new JTextField();
			txtRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtRespuesta.setBorder(null);
			txtRespuesta.setEditable(false);
			txtRespuesta.setBounds(384, 35, 361, 32);
			txtRespuesta.setColumns(10);
		}
		return txtRespuesta;
	}

	private JLabel getLblPeso() {
		if (lblPeso == null) {
			lblPeso = new JLabel("Peso:");
			lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPeso.setBounds(35, 248, 67, 26);
		}
		return lblPeso;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Volumen:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(34, 311, 68, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cliente:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(561, 127, 58, 20);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblLocalidaOrigen() {
		if (lblLocalidaOrigen == null) {
			lblLocalidaOrigen = new JLabel("Localidad Origen:");
			lblLocalidaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLocalidaOrigen.setBounds(34, 124, 123, 26);
		}
		return lblLocalidaOrigen;
	}

	private JLabel getLblCpOrigen() {
		if (lblCpOrigen == null) {
			lblCpOrigen = new JLabel("CP Origen:");
			lblCpOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCpOrigen.setBounds(35, 185, 80, 26);
		}
		return lblCpOrigen;
	}

	private JTextField getTextLocalidadDestino() {
		if (textLocalidadDestino == null) {
			textLocalidadDestino = new JTextField();
			textLocalidadDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			textLocalidadDestino.setEditable(false);
			textLocalidadDestino.setColumns(10);
			textLocalidadDestino.setBounds(406, 265, 129, 32);
		}
		return textLocalidadDestino;
	}

	private JTextField getDestinatario() {
		if (destinatario == null) {
			destinatario = new JTextField();
			destinatario.setFont(new Font("Tahoma", Font.BOLD, 13));
			destinatario.setEditable(false);
			destinatario.setColumns(10);
			destinatario.setBounds(404, 145, 147, 26);
		}
		return destinatario;
	}

	private JTextArea getObservaciones() {
		if (Observaciones == null) {
			Observaciones = new JTextArea();
			Observaciones.setWrapStyleWord(true);
			Observaciones.setLineWrap(true);
			Observaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			Observaciones.setBackground(UIManager.getColor("Button.background"));
			Observaciones.setSelectedTextColor(UIManager.getColor("Button.background"));
			Observaciones.setEditable(false);
			Observaciones.setColumns(10);
			Observaciones.setBounds(408, 337, 343, 69);
		}
		return Observaciones;
	}

	private JTextField getDireccion() {
		if (direccion == null) {
			direccion = new JTextField();
			direccion.setFont(new Font("Tahoma", Font.BOLD, 13));
			direccion.setEditable(false);
			direccion.setColumns(10);
			direccion.setBounds(406, 208, 342, 32);
		}
		return direccion;
	}

	private JTextField getCpDestino() {
		if (cpDestino == null) {
			cpDestino = new JTextField();
			cpDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			cpDestino.setEditable(false);
			cpDestino.setColumns(10);
			cpDestino.setBounds(589, 265, 155, 32);
		}
		return cpDestino;
	}

	private JLabel getLblDestinatario() {
		if (lblDestinatario == null) {
			lblDestinatario = new JLabel("Destinatario:");
			lblDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDestinatario.setBounds(406, 127, 80, 20);
		}
		return lblDestinatario;
	}

	private JLabel getLblDireccion() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel("Direccion:");
			lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDireccion.setBounds(404, 177, 68, 26);
		}
		return lblDireccion;
	}

	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel("Observaciones:");
			lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblObservaciones.setBounds(410, 309, 174, 26);
		}
		return lblObservaciones;
	}

	private JLabel getLblLocalidadDestino() {
		if (lblLocalidadDestino == null) {
			lblLocalidadDestino = new JLabel("Localidad Destino:");
			lblLocalidadDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLocalidadDestino.setBounds(406, 242, 123, 32);
		}
		return lblLocalidadDestino;
	}

	private JLabel getLblCpDestino() {
		if (lblCpDestino == null) {
			lblCpDestino = new JLabel("CP Destino:");
			lblCpDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCpDestino.setBounds(592, 244, 80, 26);
		}
		return lblCpDestino;
	}

	private JButton getDarIncidencia() {
		if (DarIncidencia == null) {
			DarIncidencia = new JButton("Dar Incidencia");
			DarIncidencia.setEnabled(false);
			DarIncidencia.setFont(new Font("Tahoma", Font.BOLD, 13));
			DarIncidencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VIncidenciaD va = new VIncidenciaD(EntradaPDA.getText(), comboClasificarEnvios);
					va.setVisible(true);

				}
			});
			DarIncidencia.setBounds(177, 72, 147, 25);
		}
		return DarIncidencia;
	}

	private JTextField getTextAltasCpOrigen() {
		if (textAltasCpOrigen == null) {
			textAltasCpOrigen = new JTextField();
			textAltasCpOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			textAltasCpOrigen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (textAltasCpOrigen.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			textAltasCpOrigen.setColumns(10);
			textAltasCpOrigen.setBounds(45, 192, 147, 26);
		}
		return textAltasCpOrigen;
	}

	private JLabel getLblLAltasLocalidadOrigen() {
		if (lblLAltasLocalidadOrigen == null) {
			lblLAltasLocalidadOrigen = new JLabel("Localidad Origen:");
			lblLAltasLocalidadOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblLAltasLocalidadOrigen.setBounds(45, 102, 123, 26);
		}
		return lblLAltasLocalidadOrigen;
	}

	private JTextField getTxtaltasLocalidadOrigen() {
		if (txtaltasLocalidadOrigen == null) {
			txtaltasLocalidadOrigen = new JTextField();
			txtaltasLocalidadOrigen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtaltasLocalidadOrigen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtaltasLocalidadOrigen.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtaltasLocalidadOrigen.setColumns(10);
			txtaltasLocalidadOrigen.setBounds(45, 129, 147, 26);
		}
		return txtaltasLocalidadOrigen;
	}

	private JLabel getLblAltasCpOrigen() {
		if (lblAltasCpOrigen == null) {
			lblAltasCpOrigen = new JLabel("CP Origen:*");
			lblAltasCpOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasCpOrigen.setBounds(45, 166, 80, 26);
		}
		return lblAltasCpOrigen;
	}

	private JTextField getTxtAltasPeso() {
		if (txtAltasPeso == null) {
			txtAltasPeso = new JTextField();
			txtAltasPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasPeso.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasPeso.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtAltasPeso.setColumns(10);
			txtAltasPeso.setBounds(45, 254, 147, 27);
		}
		return txtAltasPeso;
	}

	private JLabel getLblAltasPeso() {
		if (lblAltasPeso == null) {
			lblAltasPeso = new JLabel("Peso:*");
			lblAltasPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasPeso.setBounds(45, 229, 67, 26);
		}
		return lblAltasPeso;
	}

	private JTextField getTxtAltasVolumen() {
		if (txtAltasVolumen == null) {
			txtAltasVolumen = new JTextField();
			txtAltasVolumen.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasVolumen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasVolumen.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtAltasVolumen.setColumns(10);
			txtAltasVolumen.setBounds(45, 308, 147, 26);
		}
		return txtAltasVolumen;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Volumen:*");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(44, 292, 68, 14);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblAltasDestinatario() {
		if (lblAltasDestinatario == null) {
			lblAltasDestinatario = new JLabel("Destinatario:*");
			lblAltasDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasDestinatario.setBounds(412, 102, 96, 27);
		}
		return lblAltasDestinatario;
	}

	private JLabel getLblAltasCliente() {
		if (lblAltasCliente == null) {
			lblAltasCliente = new JLabel("Cliente:");
			lblAltasCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasCliente.setBounds(567, 102, 54, 26);
		}
		return lblAltasCliente;
	}

	private JTextField getTxtAltasDestinatario() {
		if (txtAltasDestinatario == null) {
			txtAltasDestinatario = new JTextField();
			txtAltasDestinatario.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasDestinatario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasDestinatario.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtAltasDestinatario.setColumns(10);
			txtAltasDestinatario.setBounds(409, 128, 147, 26);
		}
		return txtAltasDestinatario;
	}

	private JTextField getTxtAltasClientes() {
		if (txtAltasClientes == null) {
			txtAltasClientes = new JTextField();
			txtAltasClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasClientes.setText(user);
			txtAltasClientes.setEditable(false);
			txtAltasClientes.setColumns(10);
			txtAltasClientes.setBounds(567, 126, 147, 26);
		}
		return txtAltasClientes;
	}

	private JLabel getLblAltasDireccion() {
		if (lblAltasDireccion == null) {
			lblAltasDireccion = new JLabel("Direccion:*");
			lblAltasDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasDireccion.setBounds(410, 158, 68, 26);
		}
		return lblAltasDireccion;
	}

	private JTextField getTextAltasDireccion() {
		if (textAltasDireccion == null) {
			textAltasDireccion = new JTextField();
			textAltasDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
			textAltasDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (textAltasDireccion.getText().length() >= 100) {
						e.consume();
					}
				}

			});
			textAltasDireccion.setColumns(10);
			textAltasDireccion.setBounds(409, 183, 342, 32);
		}
		return textAltasDireccion;
	}

	private JTextField getTxtAltasLocalidadDestino() {
		if (txtAltasLocalidadDestino == null) {
			txtAltasLocalidadDestino = new JTextField();
			txtAltasLocalidadDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasLocalidadDestino.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasLocalidadDestino.getText().length() >= 40) {
						e.consume();
					}
				}

			});
			txtAltasLocalidadDestino.setColumns(10);
			txtAltasLocalidadDestino.setBounds(412, 246, 129, 32);
		}
		return txtAltasLocalidadDestino;
	}

	private JLabel getLblAltasLocalidadDeDestino() {
		if (lblAltasLocalidadDeDestino == null) {
			lblAltasLocalidadDeDestino = new JLabel("Localidad Destino:*");
			lblAltasLocalidadDeDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasLocalidadDeDestino.setBounds(412, 222, 123, 32);
		}
		return lblAltasLocalidadDeDestino;
	}

	private JLabel getLblAltasCpDestino() {
		if (lblAltasCpDestino == null) {
			lblAltasCpDestino = new JLabel("CP Destino:*");
			lblAltasCpDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasCpDestino.setBounds(595, 222, 80, 26);
		}
		return lblAltasCpDestino;
	}

	private JTextField getTxtAltasCpDestino() {
		if (txtAltasCpDestino == null) {
			txtAltasCpDestino = new JTextField();
			txtAltasCpDestino.setToolTipText("Entre 33000-33999");
			txtAltasCpDestino.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtAltasCpDestino.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasCpDestino.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtAltasCpDestino.setColumns(10);
			txtAltasCpDestino.setBounds(595, 246, 155, 32);
		}
		return txtAltasCpDestino;
	}

	private JTextArea getTxtAltasObservaciones() {
		if (txtAltasObservaciones == null) {
			txtAltasObservaciones = new JTextArea();
			txtAltasObservaciones.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtAltasObservaciones.setWrapStyleWord(true);
			txtAltasObservaciones.setLineWrap(true);
			txtAltasObservaciones.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtAltasObservaciones.getText().length() >= 200) {
						e.consume();
					}
				}

			});
			txtAltasObservaciones.setColumns(10);
			txtAltasObservaciones.setBounds(412, 309, 339, 60);
		}
		return txtAltasObservaciones;
	}

	private JLabel getLblAltasObservaciones() {
		if (lblAltasObservaciones == null) {
			lblAltasObservaciones = new JLabel("Observaciones:");
			lblAltasObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAltasObservaciones.setBounds(412, 280, 174, 26);
		}
		return lblAltasObservaciones;
	}

	private JLabel getLblAltasTitulo() {
		if (lblAltasTitulo == null) {
			lblAltasTitulo = new JLabel("Introduce los datos para dar de alta un envio");
			lblAltasTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblAltasTitulo.setBounds(20, 24, 518, 26);
		}
		return lblAltasTitulo;
	}

	private JTextField getTextAltasRespuesta() {
		if (textAltasRespuesta == null) {
			textAltasRespuesta = new JTextField();
			textAltasRespuesta.setBorder(null);
			textAltasRespuesta.setEditable(false);
			textAltasRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textAltasRespuesta.setBounds(20, 369, 439, 38);
			textAltasRespuesta.setColumns(10);
		}
		return textAltasRespuesta;
	}

	private JButton getBtnAltasAlta() {
		if (btnAltasAlta == null) {
			btnAltasAlta = new JButton("Dar de alta");
			btnAltasAlta.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAltasAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!"OK".equals(validarAlta())) {
						textAltasRespuesta.setText(validarAlta());
					
					} else {

						textAltasRespuesta.setText(sp.altaEnvio(rellenarDatosInverso(generarNenvio())));
						ponerBlanco();
						sacarTodosEnvios = sp.buscarTodosEnvios();
						comboClasificarEnvios.removeAllItems();
						if (sacarTodosEnvios != null) {

							for (int i = 0; i < sacarTodosEnvios.size(); i++) {
								comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: "
										+ sacarTodosEnvios.get(i).getCpDestino());
							}
						}

					}
				}

			});
			btnAltasAlta.setBounds(596, 388, 155, 32);
		}
		return btnAltasAlta;
	}

	protected void ponerBlanco() {
		txtAltasCpDestino.setText("");
		txtAltasDestinatario.setText("");
		textAltasDireccion.setText("");
		txtAltasLocalidadDestino.setText("");
		txtAltasObservaciones.setText("");
		txtaltasLocalidadOrigen.setText("");
		txtAltasPeso.setText("");

		txtAltasVolumen.setText("");

		txtAltasCpDestino.setText("");
		textAltasCpOrigen.setText("");

	}

	private String generarNenvio() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return "E" + dtf.format(LocalDateTime.now());

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	protected JPanel getFurgonetas() {
		if (Furgonetas == null) {
			Furgonetas = new JPanel();
			Furgonetas.setLayout(null);
			Furgonetas.add(getLblMatriculaFurgonetas());
			Furgonetas.add(getTxtEntradaFurgonetas());
			Furgonetas.add(getBtnBuscarFurgonetas());
			Furgonetas.add(getBtnAltaFurgonetas());
			Furgonetas.add(getRespuestaFurgonetas());
			Furgonetas.add(getTextField_1_1());
			Furgonetas.add(getTxtFurgonetasRutaHasta());
			Furgonetas.add(getTxtFurgonetasFechaAlta());
			Furgonetas.add(getTxtFurgonetasFechaBaja());
			Furgonetas.add(getLblFurgonetasRutaDesde());
			Furgonetas.add(getLblFurgonetasRutaHasta());
			Furgonetas.add(getLblFurgonetasFechaAltas());
			Furgonetas.add(getLblFurgonetasFechaBaja());
			Furgonetas.add(getLblFurgonetasCarga());
			Furgonetas.add(getTextAreaCargaEnvios());
			Furgonetas.add(getBtnEliminarFurgoneta());
			Furgonetas.add(getBtnGestionarCarga());
			Furgonetas.add(getBtnEditarFurgonetas());
			Furgonetas.add(getBtnGuardarCambios());
		}
		return Furgonetas;
	}

	private JLabel getLblMatriculaFurgonetas() {
		if (lblMatriculaFurgonetas == null) {
			lblMatriculaFurgonetas = new JLabel("Matricula");
			lblMatriculaFurgonetas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMatriculaFurgonetas.setBounds(32, 11, 156, 23);
		}
		return lblMatriculaFurgonetas;
	}

	private JTextField getTxtEntradaFurgonetas() {
		if (txtEntradaFurgonetas == null) {
			txtEntradaFurgonetas = new JTextField();
			txtEntradaFurgonetas.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtEntradaFurgonetas.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtEntradaFurgonetas.getText().length() >= 7) {
						e.consume();
					}
				}

			});
			txtEntradaFurgonetas.setBounds(32, 36, 303, 30);
			txtEntradaFurgonetas.setColumns(10);
		}
		return txtEntradaFurgonetas;
	}

	private JButton getBtnBuscarFurgonetas() {
		if (btnBuscarFurgonetas == null) {
			btnBuscarFurgonetas = new JButton("Buscar");
			btnBuscarFurgonetas.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscarFurgonetas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Furgonetas f = sp.buscarFurgoneta(txtEntradaFurgonetas.getText());
					if (f != null) {
						btnEditarFurgonetas.setEnabled(true);
						btnEliminarFurgoneta.setEnabled(true);
						btnGestionarCarga.setEnabled(true);
						respuestaFurgonetas.setText("");
						rellenarFurgoneta(f);

					} else {
						respuestaFurgonetas.setText("no se han encontrado datos");
						rellenarFurgonetaBlaco();
						btnEditarFurgonetas.setEnabled(false);
						btnEliminarFurgoneta.setEnabled(false);
						btnGestionarCarga.setEnabled(false);
					}
				}

			});
			btnBuscarFurgonetas.setBounds(32, 77, 88, 23);
		}
		return btnBuscarFurgonetas;
	}

	private JButton getBtnAltaFurgonetas() {
		if (btnAltaFurgonetas == null) {
			btnAltaFurgonetas = new JButton("Nueva ");
			btnAltaFurgonetas.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAltaFurgonetas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaAltaFurgonetasD va = new VentanaAltaFurgonetasD();
					va.setVisible(true);

				}
			});
			btnAltaFurgonetas.setBounds(229, 77, 106, 23);
		}
		return btnAltaFurgonetas;
	}

	private JTextField getRespuestaFurgonetas() {
		if (respuestaFurgonetas == null) {
			respuestaFurgonetas = new JTextField();
			respuestaFurgonetas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			respuestaFurgonetas.setBorder(null);
			respuestaFurgonetas.setEditable(false);
			respuestaFurgonetas.setBounds(359, 43, 380, 37);
			respuestaFurgonetas.setColumns(10);
		}
		return respuestaFurgonetas;
	}

	private JTextField getTextField_1_1() {
		if (txtFurgonetasRutaDesde == null) {
			txtFurgonetasRutaDesde = new JTextField();
			txtFurgonetasRutaDesde.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtFurgonetasRutaDesde.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtFurgonetasRutaDesde.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtFurgonetasRutaDesde.setEditable(false);
			txtFurgonetasRutaDesde.setBounds(54, 156, 168, 30);
			txtFurgonetasRutaDesde.setColumns(10);
		}
		return txtFurgonetasRutaDesde;
	}

	private JTextField getTxtFurgonetasRutaHasta() {
		if (txtFurgonetasRutaHasta == null) {
			txtFurgonetasRutaHasta = new JTextField();
			txtFurgonetasRutaHasta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtFurgonetasRutaHasta.setEditable(false);
			txtFurgonetasRutaHasta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

					if (txtFurgonetasRutaHasta.getText().length() >= 5) {
						e.consume();
					}
				}

			});
			txtFurgonetasRutaHasta.setBounds(54, 229, 168, 30);
			txtFurgonetasRutaHasta.setColumns(10);
		}
		return txtFurgonetasRutaHasta;
	}

	private JTextField getTxtFurgonetasFechaAlta() {
		if (txtFurgonetasFechaAlta == null) {
			txtFurgonetasFechaAlta = new JTextField();
			txtFurgonetasFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtFurgonetasFechaAlta.setEditable(false);
			txtFurgonetasFechaAlta.setBounds(54, 298, 168, 30);
			txtFurgonetasFechaAlta.setColumns(10);
		}
		return txtFurgonetasFechaAlta;
	}

	private JTextField getTxtFurgonetasFechaBaja() {
		if (txtFurgonetasFechaBaja == null) {
			txtFurgonetasFechaBaja = new JTextField();
			txtFurgonetasFechaBaja.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtFurgonetasFechaBaja.setEditable(false);
			txtFurgonetasFechaBaja.setBounds(54, 375, 168, 30);
			txtFurgonetasFechaBaja.setColumns(10);
		}
		return txtFurgonetasFechaBaja;
	}

	private JLabel getLblFurgonetasRutaDesde() {
		if (lblFurgonetasRutaDesde == null) {
			lblFurgonetasRutaDesde = new JLabel("Ruta Desde:");
			lblFurgonetasRutaDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFurgonetasRutaDesde.setBounds(54, 131, 156, 23);
		}
		return lblFurgonetasRutaDesde;
	}

	private JLabel getLblFurgonetasRutaHasta() {
		if (lblFurgonetasRutaHasta == null) {
			lblFurgonetasRutaHasta = new JLabel("Ruta Hasta:");
			lblFurgonetasRutaHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFurgonetasRutaHasta.setBounds(54, 207, 156, 23);
		}
		return lblFurgonetasRutaHasta;
	}

	private JLabel getLblFurgonetasFechaAltas() {
		if (lblFurgonetasFechaAltas == null) {
			lblFurgonetasFechaAltas = new JLabel("Fecha Alta:");
			lblFurgonetasFechaAltas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFurgonetasFechaAltas.setBounds(54, 278, 156, 23);
		}
		return lblFurgonetasFechaAltas;
	}

	private JLabel getLblFurgonetasFechaBaja() {
		if (lblFurgonetasFechaBaja == null) {
			lblFurgonetasFechaBaja = new JLabel("Fecha Baja:");
			lblFurgonetasFechaBaja.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFurgonetasFechaBaja.setBounds(54, 351, 156, 23);
		}
		return lblFurgonetasFechaBaja;
	}

	private JLabel getLblFurgonetasCarga() {
		if (lblFurgonetasCarga == null) {
			lblFurgonetasCarga = new JLabel("Carga de envios:");
			lblFurgonetasCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFurgonetasCarga.setBounds(302, 131, 156, 23);
		}
		return lblFurgonetasCarga;
	}

	protected JTextArea getTextAreaCargaEnvios() {
		if (textAreaCargaEnvios == null) {
			textAreaCargaEnvios = new JTextArea();
			textAreaCargaEnvios.setWrapStyleWord(true);
			textAreaCargaEnvios.setEditable(false);
			textAreaCargaEnvios.setBounds(302, 159, 453, 169);
		}
		return textAreaCargaEnvios;
	}

	private JButton getBtnEliminarFurgoneta() {
		if (btnEliminarFurgoneta == null) {
			btnEliminarFurgoneta = new JButton("Eliminar Furgoneta");
			btnEliminarFurgoneta.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEliminarFurgoneta.setEnabled(false);
			btnEliminarFurgoneta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Furgonetas f = sp.buscarFurgoneta(txtEntradaFurgonetas.getText());

					if (f != null) {
						if (f.getCarga().isEmpty()) {
							String respuesta = sp.EliminarFurgoneta(f.getMatricula());
							if (respuesta.contains("OK")) {
								respuestaFurgonetas.setText(sp.EliminarFurgoneta(f.getMatricula()));
								txtFurgonetasRutaDesde.setText("");
								txtFurgonetasRutaHasta.setText("");
								txtFurgonetasFechaAlta.setText("");
								txtFurgonetasFechaBaja.setText("");
								txtEntradaFurgonetas.setText("");
								btnEditarFurgonetas.setEnabled(false);
								btnEliminarFurgoneta.setEnabled(false);
								btnGestionarCarga.setEnabled(false);
							} else {
								respuestaFurgonetas.setText(sp.EliminarFurgoneta(f.getMatricula()));
							}

						} else {
							respuestaFurgonetas.setText("no puedes dar de baja si tienes envios dentro");
						}
					} else {
						respuestaFurgonetas.setText("no se han encontrado datos");
					}

				}
			});
			btnEliminarFurgoneta.setBounds(598, 351, 157, 23);
		}
		return btnEliminarFurgoneta;
	}

	private void rellenarDatos(DatosEnvio de) {

		txtCliente.setText(de.getCliente());
		if (de.getLocalidadOrigen() != null) {
			txtLocalidadOrigen.setText(de.getLocalidadOrigen());
		}
		if (de.getCpOrigen() != null) {
			txtCpOrigen.setText(de.getCpOrigen());
		}
		if (de.getPeso() != null) {
			txtPeso.setText(String.valueOf(de.getPeso()));
		}
		if (de.getVolumen() != null) {
			txtVolumen.setText(String.valueOf(de.getVolumen()));
		}

		textLocalidadDestino.setText(de.getLocalidadDestino());
		destinatario.setText(de.getDestinatario());
		if (de.getObservaciones() != null) {
			Observaciones.setText(de.getObservaciones());
		}
		direccion.setText(de.getDireccion());
		cpDestino.setText(de.getCpDestino());

	}
	
	private void rellenarDatosBlanco() {

		txtCliente.setText("");
			txtLocalidadOrigen.setText("");
			txtCpOrigen.setText("");
			txtPeso.setText("");
			txtVolumen.setText("");
		textLocalidadDestino.setText("");
		destinatario.setText("");
			Observaciones.setText("");
		direccion.setText("");
		cpDestino.setText("");

	}

	private DatosEnvio rellenarDatosInverso(String nenvio) {

		DatosEnvio salida = new DatosEnvio();
		salida.setCliente(user);
		salida.setCpDestino(txtAltasCpDestino.getText());
		salida.setCpOrigen(textAltasCpOrigen.getText());
		salida.setDestinatario(txtAltasDestinatario.getText());
		salida.setDireccion(textAltasDireccion.getText());
		salida.setLocalidadDestino(txtAltasLocalidadDestino.getText());
		salida.setLocalidadOrigen(txtaltasLocalidadOrigen.getText());
		salida.setObservaciones(txtAltasObservaciones.getText());
		salida.setNenvio(nenvio);
		if (txtAltasPeso.getText().equals("")) {
			salida.setPeso(0D);
		} else {
			salida.setPeso(Double.parseDouble(txtAltasPeso.getText()));
		}

		if (txtAltasVolumen.getText().equals("")) {
			salida.setVolumen(0D);
		} else {
			salida.setVolumen(Double.parseDouble(txtAltasVolumen.getText()));
		}

		return salida;

	}

	private String validarAlta() {
		if (txtAltasCpDestino.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtAltasDestinatario.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (textAltasDireccion.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtAltasLocalidadDestino.getText().isEmpty()) {
			return "hay campos obligatorios vacios";
		}
		if (txtAltasPeso.getText().isEmpty() || !isNumeric(txtAltasPeso.getText())) {
			return "el peso tiene que ser numerico";
		}
		if (txtAltasVolumen.getText().isEmpty() || !isNumeric(txtAltasVolumen.getText())) {
			return "el volumen tiene que ser numerico";
		}
		if ((!isNumeric(txtAltasCpDestino.getText()) || !isNumeric(textAltasCpOrigen.getText())
				|| txtAltasCpDestino.getText().length() != 5 || textAltasCpOrigen.getText().length() != 5)) {
			return "los CP tienen que ser numericos y de 5 digitos";
		}
		if (Integer.parseInt(txtAltasCpDestino.getText()) < 33000
				|| Integer.parseInt(txtAltasCpDestino.getText()) >= 34000) {
			return "El codigo postal de destino tiene que ser de Asturias (33000-33999)";
		}
		return "OK";
	}

	private void rellenarFurgoneta(Furgonetas f) {
		txtFurgonetasFechaAlta.setText(f.getFechaAlta());
		txtFurgonetasFechaBaja.setText(f.getFechaBaja());
		txtFurgonetasRutaDesde.setText(f.getRutaDesde());
		txtFurgonetasRutaHasta.setText(f.getRutaHasta());
		if (f.getFechaBaja() != null) {
			btnEditarFurgonetas.setEnabled(false);
			btnEliminarFurgoneta.setEnabled(false);
			btnGestionarCarga.setEnabled(false);
		}
		String carga = "";
		for (CargaFurgonetas c : f.getCarga()) {
			carga = carga + c.toString() + "\n";
		}
		textAreaCargaEnvios.setText(carga);

	}
	
	private void rellenarFurgonetaBlaco() {
		txtFurgonetasFechaAlta.setText("");
		txtFurgonetasFechaBaja.setText("");
		txtFurgonetasRutaDesde.setText("");
		txtFurgonetasRutaHasta.setText("");
		textAreaCargaEnvios.setText("");

	}

	private JButton getBtnGestionarCarga() {
		if (btnGestionarCarga == null) {
			btnGestionarCarga = new JButton("Gestionar Carga");
			btnGestionarCarga.setEnabled(false);
			btnGestionarCarga.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnGestionarCarga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaGestionarCargaD va = new VentanaGestionarCargaD(txtEntradaFurgonetas.getText(),
							textAreaCargaEnvios, comboClasificarEnvios);
					va.setVisible(true);
				}
			});
			btnGestionarCarga.setBounds(450, 351, 138, 23);
		}
		return btnGestionarCarga;
	}

	private JButton getBtnEditarFurgonetas() {
		if (btnEditarFurgonetas == null) {
			btnEditarFurgonetas = new JButton("Editar");
			btnEditarFurgonetas.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEditarFurgonetas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtFurgonetasRutaDesde.setEditable(true);
					txtFurgonetasRutaHasta.setEditable(true);
					btnGuardarCambios.setEnabled(true);
					btnEliminarFurgoneta.setEnabled(false);
					btnGestionarCarga.setEnabled(false);
					btnAltaFurgonetas.setEnabled(false);
					btnBuscarFurgonetas.setEnabled(false);
				}
			});
			btnEditarFurgonetas.setEnabled(false);
			btnEditarFurgonetas.setBounds(130, 77, 89, 23);
		}
		return btnEditarFurgonetas;
	}

	private JButton getBtnGuardarCambios() {
		if (btnGuardarCambios == null) {
			btnGuardarCambios = new JButton("Guardar Cambios");
			btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (validarCambios().contains("OK")) {
						String salida = sp.ModificarFurgoneta(txtEntradaFurgonetas.getText(),
								txtFurgonetasRutaDesde.getText(), txtFurgonetasRutaHasta.getText());
						if (salida.contains("OK")) {
							respuestaFurgonetas.setText(salida);
							txtFurgonetasRutaDesde.setEditable(false);
							txtFurgonetasRutaHasta.setEditable(false);
							btnGuardarCambios.setEnabled(false);

							btnEliminarFurgoneta.setEnabled(true);
							btnGestionarCarga.setEnabled(true);
							btnAltaFurgonetas.setEnabled(true);
							btnBuscarFurgonetas.setEnabled(true);
						} else {
							respuestaFurgonetas.setText(salida);
						}
					} else {
						respuestaFurgonetas.setText(validarCambios());
					}

				}
			});
			btnGuardarCambios.setEnabled(false);
			btnGuardarCambios.setBounds(302, 351, 138, 23);
		}
		return btnGuardarCambios;
	}

	protected String validarCambios() {

		if (txtFurgonetasRutaDesde.getText().length() != 5 || txtFurgonetasRutaHasta.getText().length() != 5
				|| !isNumeric(txtFurgonetasRutaDesde.getText()) || !isNumeric(txtFurgonetasRutaHasta.getText())) {
			return "los CP tienen que tener 5 digitos y ser numericos";
		}

		int d = Integer.parseInt(txtFurgonetasRutaDesde.getText());
		int h = Integer.parseInt(txtFurgonetasRutaHasta.getText());

		if (d < 33000 || d > 33999) {
			return "Los rangos de CP tiene que ser de asturias (33000-33999)";
		}
		if (h < 33000 || h > 33999) {
			return "Los rangos de CP tiene que ser de asturias (33000-33999)";
		}
		if (d > h) {
			return ("desde no puede ser mayor que hasta");
		}

		return "OK";

	}

	private JPanel getClasificar() {
		if (Clasificar == null) {
			Clasificar = new JPanel();
			Clasificar.setLayout(null);
			Clasificar.add(getComboClasificarEnvios());
			Clasificar.add(getBtnClasificar());
			Clasificar.add(getBtnClasificarAgregar());
			Clasificar.add(getComboBoxFurgonetasPermitidas());
			Clasificar.add(getTxtClasificarRespuesta());
			Clasificar.add(getTxtTituloClasificacion());
			Clasificar.add(getLblNewLabel_5());
		}
		return Clasificar;
	}

	private JComboBox getComboClasificarEnvios() {
		sacarTodosEnvios = new ArrayList();
		sacarTodosEnvios = sp.buscarTodosEnvios();
		comboClasificarEnvios = new JComboBox();
		comboClasificarEnvios.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (sacarTodosEnvios != null) {

			for (int i = 0; i < sacarTodosEnvios.size(); i++) {
				comboClasificarEnvios.addItem(
						sacarTodosEnvios.get(i).getNenvio() + " CpDestino: " + sacarTodosEnvios.get(i).getCpDestino());
			}
		}

		comboClasificarEnvios.setBounds(46, 282, 270, 29);

		return comboClasificarEnvios;
	}

	private JButton getBtnClasificar() {
		if (btnClasificar == null) {

			btnClasificar = new JButton("Clasificar");
			btnClasificar.setBackground(new Color(255, 69, 0));
			btnClasificar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClasificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int seleccionado = comboClasificarEnvios.getSelectedIndex();
					furgonetasPermitidas = sp.clasificar(sacarTodosEnvios.get(seleccionado).getCpDestino());
					comboBoxFurgonetasPermitidas.removeAllItems();

					if (!furgonetasPermitidas.isEmpty()) {
						for (int i = 0; i < furgonetasPermitidas.size(); i++) {
							String meter = furgonetasPermitidas.get(i).getMatricula() + " Desde: "
									+ furgonetasPermitidas.get(i).getRutaDesde() + " Hasta: "
									+ furgonetasPermitidas.get(i).getRutaHasta();
							comboBoxFurgonetasPermitidas.addItem(meter);
						}

						comboBoxFurgonetasPermitidas.setEnabled(true);
						comboClasificarEnvios.setEnabled(false);
						btnClasificarAgregar.setEnabled(true);
					} else {
						txtClasificarRespuesta.setText("No hay furgonetas que repartan en esos CPs");
					}
					if (sacarTodosEnvios.isEmpty()) {
						btnClasificar.setEnabled(false);
					}

				}
			});
			btnClasificar.setBounds(326, 282, 128, 27);

		}
		return btnClasificar;
	}

	private JComboBox getComboBoxFurgonetasPermitidas() {
		if (comboBoxFurgonetasPermitidas == null) {

			comboBoxFurgonetasPermitidas = new JComboBox();
			comboBoxFurgonetasPermitidas.setFont(new Font("Tahoma", Font.BOLD, 13));
			comboBoxFurgonetasPermitidas.setEnabled(false);

			comboBoxFurgonetasPermitidas.setBounds(464, 283, 255, 27);

		}
		return comboBoxFurgonetasPermitidas;
	}

	private JButton getBtnClasificarAgregar() {
		if (btnClasificarAgregar == null) {
			btnClasificarAgregar = new JButton("A\u00F1adir Envio");
			btnClasificarAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnClasificarAgregar.setEnabled(false);
			btnClasificarAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String mensaje = sp.añadirCarga(
							sacarTodosEnvios.get(comboClasificarEnvios.getSelectedIndex()).getNenvio(),
							furgonetasPermitidas.get(comboBoxFurgonetasPermitidas.getSelectedIndex()).getId());
					txtClasificarRespuesta.setText(mensaje);

					comboClasificarEnvios.enable(true);
					sacarTodosEnvios = sp.buscarTodosEnvios();
					comboClasificarEnvios.removeAllItems();
					if (sacarTodosEnvios != null) {

						for (int i = 0; i < sacarTodosEnvios.size(); i++) {
							comboClasificarEnvios.addItem(sacarTodosEnvios.get(i).getNenvio() + " CpDestino: "
									+ sacarTodosEnvios.get(i).getCpDestino());
						}
					}
					comboBoxFurgonetasPermitidas.removeAllItems();
					comboBoxFurgonetasPermitidas.enable(false);
					btnClasificar.enable(true);

				}
			});
			btnClasificarAgregar.setBounds(581, 348, 128, 27);
		}
		return btnClasificarAgregar;
	}

	private JTextField getTxtClasificarRespuesta() {
		if (txtClasificarRespuesta == null) {
			txtClasificarRespuesta = new JTextField();
			txtClasificarRespuesta.setBorder(null);
			txtClasificarRespuesta.setEditable(false);
			txtClasificarRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtClasificarRespuesta.setBounds(46, 339, 475, 44);
			txtClasificarRespuesta.setColumns(10);
		}
		return txtClasificarRespuesta;
	}

	private JLabel getLblSeguimiento() {
		if (lblSeguimiento == null) {
			lblSeguimiento = new JLabel("Numero de envio:");
			lblSeguimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSeguimiento.setBounds(50, 113, 144, 26);
		}
		return lblSeguimiento;
	}

	private JLabel getLblSeguimientoEstados() {
		if (lblSeguimientoEstados == null) {
			lblSeguimientoEstados = new JLabel("Estados del envio:");
			lblSeguimientoEstados.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSeguimientoEstados.setBounds(44, 189, 174, 31);
		}
		return lblSeguimientoEstados;
	}

	private JTextField getTxtSeguimientoTitulo() {
		if (txtSeguimientoTitulo == null) {
			txtSeguimientoTitulo = new JTextField();
			txtSeguimientoTitulo.setBorder(null);
			txtSeguimientoTitulo.setDisabledTextColor(UIManager.getColor("Button.focus"));
			txtSeguimientoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			txtSeguimientoTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
			txtSeguimientoTitulo.setText("Seguimiento de envios");
			txtSeguimientoTitulo.setEditable(false);
			txtSeguimientoTitulo.setBounds(171, 26, 380, 47);
			txtSeguimientoTitulo.setColumns(10);
		}
		return txtSeguimientoTitulo;
	}

	private JTextField getTxtTituloClasificacion() {
		if (txtTituloClasificacion == null) {
			txtTituloClasificacion = new JTextField();
			txtTituloClasificacion.setEditable(false);
			txtTituloClasificacion.setBorder(null);
			txtTituloClasificacion.setBackground(UIManager.getColor("Button.background"));
			txtTituloClasificacion.setFont(new Font("Tahoma", Font.BOLD, 30));
			txtTituloClasificacion.setText("Bienvenido a la m\u00E1quina de clasificaci\u00F3n");
			txtTituloClasificacion.setBounds(65, 28, 644, 53);
			txtTituloClasificacion.setColumns(10);
		}
		return txtTituloClasificacion;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel();
			lblImagen.setBounds(453, 11, 264, 80);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/icono envio.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 1));
			lblImagen.setIcon(icono);

		}
		return lblImagen;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(210, 127, 155, 98);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/icono buscar.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), 1));
			lblNewLabel_3.setIcon(icono);

		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setBounds(210, 268, 155, 98);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/icono buscar.png"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(), 1));
			lblNewLabel_3_1.setIcon(icono);
		}
		return lblNewLabel_3_1;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(44, 11, 117, 80);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/seguimiento.jpg"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), 1));
			lblNewLabel_4.setIcon(icono);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("");
			lblNewLabel_4_1.setBounds(553, 11, 133, 80);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/seguimiento.jpg"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblNewLabel_4_1.getWidth(), lblNewLabel_4_1.getHeight(), 1));
			lblNewLabel_4_1.setIcon(icono);

		}
		return lblNewLabel_4_1;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setBounds(46, 105, 673, 140);

			ImageIcon imagen = new ImageIcon(VentanaLogin.class.getResource("/img/clasificador.jpg"));
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), 1));
			lblNewLabel_5.setIcon(icono);
		}
		return lblNewLabel_5;
	}
}
