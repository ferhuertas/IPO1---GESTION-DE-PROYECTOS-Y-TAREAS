package presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;

import data.Data;
import domain.Proyecto;
import domain.Tarea;
import domain.User;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class UsuariosPanel extends JPanel {
	private JFrame frame;

	private JList listUsers;
	private JList listTareas;
	private JList listProyectos;
	private JLabel lblUsuarios;
	private JLabel lblNewLabel;
	private JLabel lblTareasAsignadas;
	private JLabel lblAvatar;
	private JButton btnCambiarImagen;
	private JLabel lblNickname;
	private JTextField textFieldNick;
	private JLabel lblDni;
	private JTextField textFieldDni;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblFormacionBasica;
	private JComboBox comboBoxFormacion;
	private JLabel lblApellido;
	private JTextField textFieldApellido;
	private JLabel lblTtulo;
	private JTextField textFieldTitulo;
	private JLabel lblTelfono;
	private JLabel lblDireccin;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JPanel panel;
	private JLabel lblAsunto;
	private JTextField textAsunto;
	private JLabel lblMensaje;
	private JButton btnEnviarMensajeA;
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	private JButton btnAadirUsuario;
	private JTextArea textAreaMensaje;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private Data data;
	private JScrollPane scrollPane_1;
	DefaultListModel<User> modeloUsuarios;
	DefaultListModel<Proyecto> modeloProyectos;
	DefaultListModel<Tarea> modeloTareas;
	private ImageIcon imagen;

	/**
	 * Create the panel.
	 */
	public UsuariosPanel(Data data) {
		this.data = data;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 86, 146, 5, 5, 5, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 31, 18, 0, 5, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 2.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblUsuarios = new JLabel(Messages.getString("UsuariosPanel.lblUsuarios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 1;
		add(lblUsuarios, gbc_lblUsuarios);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("UsuariosPanel.panel_1.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 146, 6, 0, 0, 5, 0, 0, 5, 0, 5, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 5, 18, 30, 0, 0, 0, 26, 16, 18, 6, 6, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblAvatar = new JLabel(); //$NON-NLS-1$
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.gridheight = 6;
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridx = 0;
		gbc_lblAvatar.gridy = 1;
		panel_1.add(lblAvatar, gbc_lblAvatar);
		lblAvatar.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/0_200.png"))
				.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));

		lblNickname = new JLabel(Messages.getString("UsuariosPanel.lblNickname.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 2;
		gbc_lblNickname.gridy = 1;
		panel_1.add(lblNickname, gbc_lblNickname);

		lblDni = new JLabel(Messages.getString("UsuariosPanel.lblDni.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.gridwidth = 2;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 5;
		gbc_lblDni.gridy = 1;
		panel_1.add(lblDni, gbc_lblDni);

		lblNewLabel = new JLabel(Messages.getString("UsuariosPanel.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 8;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		lblTareasAsignadas = new JLabel(Messages.getString("UsuariosPanel.lblTareasAsignadas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTareasAsignadas = new GridBagConstraints();
		gbc_lblTareasAsignadas.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTareasAsignadas.insets = new Insets(0, 0, 5, 0);
		gbc_lblTareasAsignadas.gridx = 10;
		gbc_lblTareasAsignadas.gridy = 1;
		panel_1.add(lblTareasAsignadas, gbc_lblTareasAsignadas);

		listProyectos = new JList();
		GridBagConstraints gbc_listProyectos = new GridBagConstraints();
		gbc_listProyectos.fill = GridBagConstraints.BOTH;
		gbc_listProyectos.gridheight = 13;
		gbc_listProyectos.insets = new Insets(0, 0, 0, 5);
		gbc_listProyectos.gridx = 8;
		gbc_listProyectos.gridy = 2;
		panel_1.add(listProyectos, gbc_listProyectos);

		listProyectos.setBorder(new LineBorder(Color.LIGHT_GRAY));

		listTareas = new JList();
		GridBagConstraints gbc_listTareas = new GridBagConstraints();
		gbc_listTareas.fill = GridBagConstraints.BOTH;
		gbc_listTareas.gridheight = 13;
		gbc_listTareas.gridx = 10;
		gbc_listTareas.gridy = 2;
		panel_1.add(listTareas, gbc_listTareas);
		listTareas.setBorder(new LineBorder(Color.LIGHT_GRAY));

		textFieldNick = new JTextField();
		GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
		gbc_textFieldNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNick.gridwidth = 2;
		gbc_textFieldNick.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNick.gridx = 2;
		gbc_textFieldNick.gridy = 2;
		panel_1.add(textFieldNick, gbc_textFieldNick);
		textFieldNick.setColumns(10);

		textFieldDni = new JTextField();
		GridBagConstraints gbc_textFieldDni = new GridBagConstraints();
		gbc_textFieldDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDni.gridwidth = 2;
		gbc_textFieldDni.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDni.gridx = 5;
		gbc_textFieldDni.gridy = 2;
		panel_1.add(textFieldDni, gbc_textFieldDni);
		textFieldDni.setColumns(10);

		lblNombre = new JLabel(Messages.getString("UsuariosPanel.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 3;
		panel_1.add(lblNombre, gbc_lblNombre);

		lblFormacionBasica = new JLabel(Messages.getString("UsuariosPanel.lblFormacionBasica.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFormacionBasica = new GridBagConstraints();
		gbc_lblFormacionBasica.anchor = GridBagConstraints.WEST;
		gbc_lblFormacionBasica.gridwidth = 2;
		gbc_lblFormacionBasica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacionBasica.gridx = 5;
		gbc_lblFormacionBasica.gridy = 3;
		panel_1.add(lblFormacionBasica, gbc_lblFormacionBasica);

		textFieldName = new JTextField();
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridwidth = 2;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.gridx = 2;
		gbc_textFieldName.gridy = 4;
		panel_1.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);

		comboBoxFormacion = new JComboBox();
		GridBagConstraints gbc_comboBoxFormacion = new GridBagConstraints();
		gbc_comboBoxFormacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFormacion.gridwidth = 2;
		gbc_comboBoxFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxFormacion.gridx = 5;
		gbc_comboBoxFormacion.gridy = 4;
		panel_1.add(comboBoxFormacion, gbc_comboBoxFormacion);
		comboBoxFormacion.setModel(new DefaultComboBoxModel(new String[] { "Sin Formación", "Primaria", "Secundaria",
				"Bachillerato", "Grado Medio", "Grado Superior", "Universitaria" }));

		lblApellido = new JLabel(Messages.getString("UsuariosPanel.lblApellido.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.gridwidth = 2;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 2;
		gbc_lblApellido.gridy = 5;
		panel_1.add(lblApellido, gbc_lblApellido);

		lblTtulo = new JLabel(Messages.getString("UsuariosPanel.lblTtulo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.anchor = GridBagConstraints.WEST;
		gbc_lblTtulo.gridwidth = 2;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 5;
		gbc_lblTtulo.gridy = 5;
		panel_1.add(lblTtulo, gbc_lblTtulo);

		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridwidth = 2;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 6;
		panel_1.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);

		textFieldTitulo = new JTextField();
		GridBagConstraints gbc_textFieldTitulo = new GridBagConstraints();
		gbc_textFieldTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitulo.gridwidth = 2;
		gbc_textFieldTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitulo.gridx = 5;
		gbc_textFieldTitulo.gridy = 6;
		panel_1.add(textFieldTitulo, gbc_textFieldTitulo);
		textFieldTitulo.setColumns(10);

		btnCambiarImagen = new JButton(Messages.getString("UsuariosPanel.btnCambiarImagen.text")); //$NON-NLS-1$
		btnCambiarImagen.addActionListener(new BtnCambiarImagenActionListener());
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.fill = GridBagConstraints.BOTH;
		gbc_btnCambiarImagen.gridheight = 2;
		gbc_btnCambiarImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarImagen.gridx = 0;
		gbc_btnCambiarImagen.gridy = 7;
		panel_1.add(btnCambiarImagen, gbc_btnCambiarImagen);
		btnCambiarImagen.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/camera-switch-512.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));

		lblTelfono = new JLabel(Messages.getString("UsuariosPanel.lblTelfono.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.WEST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 2;
		gbc_lblTelfono.gridy = 7;
		panel_1.add(lblTelfono, gbc_lblTelfono);

		lblDireccin = new JLabel(Messages.getString("UsuariosPanel.lblDireccin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 5;
		gbc_lblDireccin.gridy = 7;
		panel_1.add(lblDireccin, gbc_lblDireccin);

		textFieldTelefono = new JTextField();
		GridBagConstraints gbc_textFieldTelefono = new GridBagConstraints();
		gbc_textFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono.gridwidth = 2;
		gbc_textFieldTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono.gridx = 2;
		gbc_textFieldTelefono.gridy = 8;
		panel_1.add(textFieldTelefono, gbc_textFieldTelefono);
		textFieldTelefono.setColumns(10);

		textFieldDireccion = new JTextField();
		GridBagConstraints gbc_textFieldDireccion = new GridBagConstraints();
		gbc_textFieldDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion.gridwidth = 2;
		gbc_textFieldDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion.gridx = 5;
		gbc_textFieldDireccion.gridy = 8;
		panel_1.add(textFieldDireccion, gbc_textFieldDireccion);
		textFieldDireccion.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 5;
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 10;
		panel_1.add(panel, gbc_panel);
		panel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), Messages.getString("UsuariosPanel.panel.borderTitle"), TitledBorder.LEADING, //$NON-NLS-1$
				TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 5, 222, 0, 0, 5, 0 };
		gbl_panel.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 5, 0, 5, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblAsunto = new JLabel(Messages.getString("UsuariosPanel.lblAsunto.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
		gbc_lblAsunto.gridwidth = 2;
		gbc_lblAsunto.anchor = GridBagConstraints.WEST;
		gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsunto.gridx = 1;
		gbc_lblAsunto.gridy = 1;
		panel.add(lblAsunto, gbc_lblAsunto);

		textAsunto = new JTextField();
		GridBagConstraints gbc_textAsunto = new GridBagConstraints();
		gbc_textAsunto.gridwidth = 3;
		gbc_textAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_textAsunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAsunto.gridx = 1;
		gbc_textAsunto.gridy = 2;
		panel.add(textAsunto, gbc_textAsunto);
		textAsunto.setColumns(10);

		lblMensaje = new JLabel(Messages.getString("UsuariosPanel.lblMensaje.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.gridwidth = 3;
		gbc_lblMensaje.anchor = GridBagConstraints.WEST;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 3;
		panel.add(lblMensaje, gbc_lblMensaje);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		panel.add(scrollPane, gbc_scrollPane);

		textAreaMensaje = new JTextArea();
		scrollPane.setViewportView(textAreaMensaje);
		textAreaMensaje.setBorder(new LineBorder(Color.LIGHT_GRAY));

		btnEnviarMensajeA = new JButton(Messages.getString("UsuariosPanel.btnEnviarMensajeA.text")); //$NON-NLS-1$
		btnEnviarMensajeA.addActionListener(new BtnEnviarMensajeAActionListener());
		btnEnviarMensajeA
				.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/sendmail.png"))
						.getImage().getScaledInstance(58, 30, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnEnviarMensajeA = new GridBagConstraints();
		gbc_btnEnviarMensajeA.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnviarMensajeA.gridx = 2;
		gbc_btnEnviarMensajeA.gridy = 7;
		panel.add(btnEnviarMensajeA, gbc_btnEnviarMensajeA);

		btnNewButton = new JButton(Messages.getString("UsuariosPanel.btnNewButton.text")); //$NON-NLS-1$
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(getClass().getResource("/attach_file_black_192x192.png"))
						.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		panel.add(btnNewButton, gbc_btnNewButton);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);

		listUsers = new JList();
		listUsers.addListSelectionListener(new ListUsersListSelectionListener());
		scrollPane_1.setViewportView(listUsers);
		modeloUsuarios = new DefaultListModel<User>();

		Iterator<User> it = data.listaUsuarios.iterator();

		while (it.hasNext()) {
			User userLeido = it.next();
			modeloUsuarios.addElement(userLeido);
		}
		listUsers.setModel(modeloUsuarios);
		listUsers.setBorder(new LineBorder(Color.LIGHT_GRAY));
		listUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnAadirUsuario = new JButton(Messages.getString("UsuariosPanel.btnAadirUsuario.text")); //$NON-NLS-1$
		btnAadirUsuario.addActionListener(new BtnAadirUsuarioActionListener());
		btnAadirUsuario.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/add-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnAadirUsuario = new GridBagConstraints();
		gbc_btnAadirUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirUsuario.gridx = 3;
		gbc_btnAadirUsuario.gridy = 5;
		add(btnAadirUsuario, gbc_btnAadirUsuario);

		btnEliminar = new JButton(Messages.getString("UsuariosPanel.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 4;
		gbc_btnEliminar.gridy = 5;
		add(btnEliminar, gbc_btnEliminar);

		btnGuardarCambios = new JButton(Messages.getString("UsuariosPanel.btnGuardarCambios.text")); //$NON-NLS-1$
		btnGuardarCambios.addActionListener(new BtnGuardarCambiosActionListener());
		btnGuardarCambios.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/save-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnGuardarCambios = new GridBagConstraints();
		gbc_btnGuardarCambios.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarCambios.gridx = 5;
		gbc_btnGuardarCambios.gridy = 5;
		add(btnGuardarCambios, gbc_btnGuardarCambios);

	}

	private class ListUsersListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			if (!arg0.getValueIsAdjusting()) {
				if (!listUsers.isSelectionEmpty()) {

					User userseleccionado = (User) listUsers.getSelectedValue();
					textFieldName.setText(userseleccionado.getNombre());
					textFieldNick.setText(userseleccionado.getNickname());
					textFieldDni.setText(userseleccionado.getDni());
					textFieldApellido.setText(userseleccionado.getApellido());
					textFieldDireccion.setText(userseleccionado.getDirección());
					textFieldTelefono.setText(userseleccionado.getTelefono());
					textFieldTitulo.setText(userseleccionado.getTitulo());
					comboBoxFormacion.setSelectedItem(userseleccionado.getFormacion());
					if (userseleccionado.getImage() != null) {
						imagen = new ImageIcon(new ImageIcon(userseleccionado.getImage()).getImage()
								.getScaledInstance(140, 140, Image.SCALE_SMOOTH));
						lblAvatar.setIcon(imagen);
					} else {
						lblAvatar.setIcon(new ImageIcon(
								new javax.swing.ImageIcon(getClass().getResource("/0_200.png")).getImage()
										.getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
					}

					modeloProyectos = new DefaultListModel<Proyecto>();
					for (int i = 0; i < data.listaProyectos.size(); i++) {
						if (data.listaProyectos.get(i).getMiembros().contains(userseleccionado)) {
							modeloProyectos.addElement(data.listaProyectos.get(i));
						}
					}
					listProyectos.setModel(modeloProyectos);
					modeloTareas = new DefaultListModel<Tarea>();
					for (int i = 0; i < data.listaTareas.size(); i++) {
						if (data.listaTareas.get(i).getMiembros().contains(userseleccionado)) {
							modeloTareas.addElement(data.listaTareas.get(i));
							if (data.listaTareas.get(i).getSubtareas() != null) {
								for (int j = 0; j < data.listaTareas.get(i).getSubtareas().size(); j++) {
									if (data.listaTareas.get(i).getSubtareas().get(j).getMiembros()
											.contains(userseleccionado))
										modeloTareas.addElement(data.listaTareas.get(i).getSubtareas().get(j));
								}

							}
						}
						listTareas.setModel(modeloTareas);
					}
				}
			}
		}
	}

	private class BtnAadirUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			User newUser = new User(textFieldNick.getText(), textFieldName.getText(), textFieldDni.getText(),
					textFieldApellido.getText(), (String) comboBoxFormacion.getSelectedItem(),
					textFieldTitulo.getText(), textFieldTelefono.getText(), textFieldDireccion.getText());
			data.listaUsuarios.add(newUser);
			modeloUsuarios.addElement(newUser);
			listUsers.setSelectedValue(newUser, true);
			listUsers.repaint();
		}
	}

	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listUsers.isSelectionEmpty()) {
				User userseleccionado = (User) listUsers.getSelectedValue();
				modeloUsuarios.removeElement(userseleccionado);
				data.listaUsuarios.remove(userseleccionado);
			}
		}
	}

	private class BtnGuardarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listUsers.isSelectionEmpty()) {
				User userseleccionado = (User) listUsers.getSelectedValue();
				userseleccionado.setNombre(textFieldName.getText());
				userseleccionado.setNickname(textFieldNick.getText());
				userseleccionado.setApellido(textFieldApellido.getText());
				userseleccionado.setDni(textFieldDni.getText());
				userseleccionado.setFormacion((String) comboBoxFormacion.getSelectedItem());
				userseleccionado.setTitulo(textFieldTitulo.getText());
				userseleccionado.setTelefono(textFieldTelefono.getText());
				userseleccionado.setDirección(textFieldDireccion.getText());
				listUsers.repaint();
			} else {
				JOptionPane.showMessageDialog(UsuariosPanel.this, "Seleccione un usuario para guardar su información.",
						"Error al guardar.", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private class BtnEnviarMensajeAActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listUsers.isSelectionEmpty()) {
				if (textAsunto.getText().equals("")) {
					JOptionPane.showMessageDialog(UsuariosPanel.this, "Escriba un asunto para poder enviar un mensaje.",
							"Error al enviar.", JOptionPane.ERROR_MESSAGE);
				} else {
					User userseleccionado = (User) listUsers.getSelectedValue();
					JOptionPane.showMessageDialog(UsuariosPanel.this,
							"El mensaje: \"" + textAsunto.getText() + "\" ha sido enviado al usuario: \""
									+ userseleccionado + "\".",
							"", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
									.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
				}
			} else {
				JOptionPane.showMessageDialog(UsuariosPanel.this,
						"Seleccione un usuario para poder enviarle un mensaje.", "Error al enviar.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class BtnCambiarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listUsers.isSelectionEmpty()) {
				JFileChooser fcAbrir = new JFileChooser();
				int valorDevuelto = fcAbrir.showOpenDialog(frame);
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					File file = fcAbrir.getSelectedFile();
					imagen = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(140, 140,
							Image.SCALE_SMOOTH));
					lblAvatar.setIcon(imagen);
					User userseleccionado = (User) listUsers.getSelectedValue();
					userseleccionado.setImage(file.getAbsolutePath());
				}

			} else {
				JOptionPane.showMessageDialog(UsuariosPanel.this,
						"Seleccione un usuario para poder añadirle un avatar.", "Error.", JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) { 
				File file2 = fcAbrir.getSelectedFile();
				String filepath= file2.getAbsolutePath();
			}
		}
	}
}
