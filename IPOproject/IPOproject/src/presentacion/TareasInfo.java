package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import data.Data;
import domain.Proyecto;
import domain.Tarea;
import domain.User;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class TareasInfo extends JPanel {
	private JLabel label;
	private static JTextField textFieldNombre;
	private JLabel label_1;
	private JLabel lblFechaDeFinalizacin;
	private static JComboBox comboBoxPrioridad;
	private JLabel lblPrioridad;
	private JLabel lblNewLabel;
	private static JComboBox comboBoxResponsable;
	private JLabel lblEstado;
	private static JComboBox comboBoxEstado;
	private JLabel lblComentarios;
	private static JTextArea textAreaComentarios;
	private JButton btnGestionMiembros;
	private JButton btnImagenes;
	private JButton btnAdd;
	private static JButton btnAddSubtarea;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	private static JDatePickerImpl datePicker;
	private static JDatePickerImpl datePicker2;
	private static JPanel panelparent;
	private Data data;
	Proyecto proyectoseleccionado;
	Tarea tareaseleccionada;

	/**
	 * Create the panel.
	 */
	public TareasInfo(Data data) {
		this.data = data;
		proyectoseleccionado = ProjectInfoLayer.getProyectoSeleccionado();
		tareaseleccionada = ProjectInfoLayer.getTareaSeleccionada();
		panelparent = this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 108, 0, 10, 60, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 10, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		label = new JLabel(Messages.getString("TareasInfo.label.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		add(label, gbc_label);

		lblPrioridad = new JLabel(Messages.getString("TareasInfo.lblPrioridad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.gridwidth = 2;
		gbc_lblPrioridad.anchor = GridBagConstraints.WEST;
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 4;
		gbc_lblPrioridad.gridy = 1;
		add(lblPrioridad, gbc_lblPrioridad);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 2;
		add(textFieldNombre, gbc_textFieldNombre);

		comboBoxPrioridad = new JComboBox();
		comboBoxPrioridad.setModel(new DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));
		GridBagConstraints gbc_comboBoxPrioridad = new GridBagConstraints();
		gbc_comboBoxPrioridad.gridwidth = 2;
		gbc_comboBoxPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPrioridad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPrioridad.gridx = 4;
		gbc_comboBoxPrioridad.gridy = 2;
		add(comboBoxPrioridad, gbc_comboBoxPrioridad);

		label_1 = new JLabel(Messages.getString("TareasInfo.label_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);

		lblNewLabel = new JLabel(Messages.getString("TareasInfo.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setBorder(new LineBorder(Color.DARK_GRAY));
		datePicker.getJFormattedTextField().setBackground(SystemColor.control);
		model.setSelected(true);

		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		datePicker2.getJFormattedTextField().setBorder(new LineBorder(Color.DARK_GRAY));
		datePicker2.getJFormattedTextField().setBackground(SystemColor.control);
		model2.setSelected(true);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(datePicker);

		comboBoxResponsable = new JComboBox();
		GridBagConstraints gbc_comboBoxResponsable = new GridBagConstraints();
		gbc_comboBoxResponsable.gridwidth = 2;
		gbc_comboBoxResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxResponsable.gridx = 4;
		gbc_comboBoxResponsable.gridy = 4;
		add(comboBoxResponsable, gbc_comboBoxResponsable);

		lblFechaDeFinalizacin = new JLabel(Messages.getString("TareasInfo.lblFechaDeFinalizacin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeFinalizacin = new GridBagConstraints();
		gbc_lblFechaDeFinalizacin.gridwidth = 2;
		gbc_lblFechaDeFinalizacin.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeFinalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizacin.gridx = 1;
		gbc_lblFechaDeFinalizacin.gridy = 5;
		add(lblFechaDeFinalizacin, gbc_lblFechaDeFinalizacin);

		lblEstado = new JLabel(Messages.getString("TareasInfo.lblEstado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.gridwidth = 2;
		gbc_lblEstado.anchor = GridBagConstraints.WEST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 4;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(datePicker2);

		comboBoxEstado = new JComboBox();
		comboBoxEstado
				.setModel(new DefaultComboBoxModel(new String[] { "Completada", "Activa", "Tardia", "Sin comenzar" }));
		GridBagConstraints gbc_comboBoxEstado = new GridBagConstraints();
		gbc_comboBoxEstado.gridwidth = 2;
		gbc_comboBoxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEstado.gridx = 4;
		gbc_comboBoxEstado.gridy = 6;
		add(comboBoxEstado, gbc_comboBoxEstado);

		lblComentarios = new JLabel(Messages.getString("TareasInfo.lblComentarios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.gridwidth = 2;
		gbc_lblComentarios.anchor = GridBagConstraints.WEST;
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 1;
		gbc_lblComentarios.gridy = 7;
		add(lblComentarios, gbc_lblComentarios);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		textAreaComentarios = new JTextArea();
		scrollPane.setViewportView(textAreaComentarios);

		btnGestionMiembros = new JButton(Messages.getString("TareasInfo.btnGestionMiembros.text")); //$NON-NLS-1$
		btnGestionMiembros.addActionListener(new BtnNewButtonActionListener());
		btnGestionMiembros
				.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/members.png"))
						.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnGestionMiembros = new GridBagConstraints();
		gbc_btnGestionMiembros.gridwidth = 2;
		gbc_btnGestionMiembros.fill = GridBagConstraints.BOTH;
		gbc_btnGestionMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_btnGestionMiembros.gridx = 4;
		gbc_btnGestionMiembros.gridy = 9;
		add(btnGestionMiembros, gbc_btnGestionMiembros);

		btnImagenes = new JButton(Messages.getString("TareasInfo.btnImagenes.text")); //$NON-NLS-1$
		btnImagenes.addActionListener(new BtnNewButton_1ActionListener());
		btnImagenes.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(getClass().getResource("/647719_camera_512x512.png")).getImage()
						.getScaledInstance(32, 32, Image.SCALE_SMOOTH)));

		GridBagConstraints gbc_btnImagenes = new GridBagConstraints();
		gbc_btnImagenes.fill = GridBagConstraints.BOTH;
		gbc_btnImagenes.gridwidth = 2;
		gbc_btnImagenes.insets = new Insets(0, 0, 5, 5);
		gbc_btnImagenes.gridx = 4;
		gbc_btnImagenes.gridy = 11;
		add(btnImagenes, gbc_btnImagenes);

		btnAdd = new JButton(Messages.getString("TareasInfo.btnAdd.text")); //$NON-NLS-1$
		btnAdd.addActionListener(new BtnAddActionListener());
		btnAdd.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/add-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 13;
		add(btnAdd, gbc_btnAdd);

		btnAddSubtarea = new JButton(Messages.getString("TareasInfo.btnAddSubtarea.text")); //$NON-NLS-1$
		btnAddSubtarea.addActionListener(new BtnAddSubtareaActionListener());
		btnAddSubtarea
				.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/addsubitem.png"))
						.getImage().getScaledInstance(35, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnAddSubtarea = new GridBagConstraints();
		gbc_btnAddSubtarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddSubtarea.gridx = 2;
		gbc_btnAddSubtarea.gridy = 13;
		add(btnAddSubtarea, gbc_btnAddSubtarea);
		btnAddSubtarea.setEnabled(false);

		btnEliminar = new JButton(Messages.getString("TareasInfo.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridwidth = 2;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 13;
		add(btnEliminar, gbc_btnEliminar);

		btnGuardar = new JButton(Messages.getString("TareasInfo.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/save-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 13;
		add(btnGuardar, gbc_btnGuardar);

	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ProjectInfoLayer.getTareaSeleccionada() != null) {
				MiembrosTareas miembros = new MiembrosTareas(data);
				miembros.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(TareasInfo.this,
						"Seleccione una tarea de la lista para poder gestionar sus miembros.", "Error.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ProjectInfoLayer.getTareaSeleccionada() != null) {
				ImagenesFrame imagenes = new ImagenesFrame(data);
				imagenes.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(TareasInfo.this,
						"Seleccione una tarea de la lista para poder gestionar sus imagenes.", "Error.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar cal = Calendar.getInstance();
			cal.setTime((Date) datePicker.getModel().getValue());
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime((Date) datePicker2.getModel().getValue());

			ArrayList<User> listamiembros = new ArrayList<User>();
			listamiembros.add((User) comboBoxResponsable.getSelectedItem());

			Tarea tareaacrear = new Tarea(textFieldNombre.getText(), cal, cal2,
					(User) comboBoxResponsable.getSelectedItem(), (String) comboBoxPrioridad.getSelectedItem(),
					(String) comboBoxEstado.getSelectedItem(), textAreaComentarios.getText(), listamiembros);

			tareaacrear.setIsSubtarea(false);

			data.listaTareas.add(tareaacrear);
			proyectoseleccionado = ProjectInfoLayer.getProyectoSeleccionado();
			if (proyectoseleccionado.getTareas() == null) {
				ArrayList<Tarea> listanuevatareas = new ArrayList<Tarea>();
				listanuevatareas.add(tareaacrear);
				proyectoseleccionado.setTareas(listanuevatareas);
			} else
				proyectoseleccionado.getTareas().add(tareaacrear);
			ProjectInfoLayer.reseleccionarproyecto();
			ProjectInfoLayer.gettable().repaint();

			JOptionPane.showMessageDialog(TareasInfo.this,
					"La tarea ha sido añadida correctamente al proyecto seleccinado.", "",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
							.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));

		}
	}

	private class BtnAddSubtareaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ProjectInfoLayer.getTareaSeleccionada() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePicker.getModel().getValue());
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime((Date) datePicker2.getModel().getValue());

				ArrayList<User> listamiembros = new ArrayList<User>();
				listamiembros.add((User) comboBoxResponsable.getSelectedItem());

				Tarea tareaacrear = new Tarea(textFieldNombre.getText(), cal, cal2,
						(User) comboBoxResponsable.getSelectedItem(), (String) comboBoxPrioridad.getSelectedItem(),
						(String) comboBoxEstado.getSelectedItem(), textAreaComentarios.getText(), listamiembros);
				tareaacrear.setIsSubtarea(true);
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) ProjectInfoLayer.getTree()
						.getLastSelectedPathComponent();

				Object nodeInfo = node.getUserObject();
				Tarea t = (Tarea) nodeInfo;
				if (t.getIsSubtarea() == false) {
					if (t.getSubtareas() != null) {
						t.getSubtareas().add(tareaacrear);
					} else {
						ArrayList<Tarea> subtareas = new ArrayList<Tarea>();
						subtareas.add(tareaacrear);
						t.setSubtareas(subtareas);
					}
					ProjectInfoLayer.getTree().repaint();
					ProjectInfoLayer.reseleccionarproyecto();
					JOptionPane.showMessageDialog(TareasInfo.this,
							"La subtarea ha sido añadida correctamente a la tarea seleccionada.", "",
							JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
									.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));

				} else {
					JOptionPane.showMessageDialog(TareasInfo.this,
							"Las subtareas no pueden tener subtareas. Seleccione una tarea en la vista arbol para poder añadirle una subtarea.",
							"Error en subtarea.", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(TareasInfo.this, "Seleccione una tarea para poder añadirle una subtarea",
						"Error en selección.", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (ProjectInfoLayer.getTareaSeleccionada() != null) {
				tareaseleccionada = ProjectInfoLayer.getTareaSeleccionada();
				if (tareaseleccionada.getIsSubtarea() == false) {// no es una subtarea
					if (ProjectInfoLayer.tabselected() == 0) { // borrar de vista detalle

						MiModeloTabla modeloTabla = (MiModeloTabla) ProjectInfoLayer.gettable().getModel();
						modeloTabla.eliminaFila((ProjectInfoLayer.gettable().getSelectedRow()));
					} else {// borrar de vista arbol

						DefaultMutableTreeNode node = (DefaultMutableTreeNode) ProjectInfoLayer.getTree()
								.getLastSelectedPathComponent();
						DefaultTreeModel model = (DefaultTreeModel) ProjectInfoLayer.getTree().getModel();
						model.removeNodeFromParent(node);
					}

					for (int i = 0; i < data.listaProyectos.size(); i++) {
						if (data.listaProyectos.get(i).getTareas().contains(tareaseleccionada))
							data.listaProyectos.get(i).getTareas().remove(tareaseleccionada);
					}
					ProjectInfoLayer.gettable().repaint();
					ProjectInfoLayer.getTree().repaint();
					ProjectInfoLayer.reseleccionarproyecto();

				} else {// es una subtarea
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) ProjectInfoLayer.getTree()
							.getLastSelectedPathComponent();
					DefaultMutableTreeNode nodepadre = (DefaultMutableTreeNode) node.getParent();
					Object nodeInfo = nodepadre.getUserObject();
					Tarea t = (Tarea) nodeInfo;
					for (int i = 0; i < t.getSubtareas().size(); i++) {
						if (t.getSubtareas().get(i) == tareaseleccionada) {
							t.getSubtareas().remove(i);
						}

					}

					DefaultTreeModel model = (DefaultTreeModel) ProjectInfoLayer.getTree().getModel();
					model.removeNodeFromParent(node);
					ProjectInfoLayer.getTree().repaint();
					ProjectInfoLayer.reseleccionarproyecto();
					JOptionPane.showMessageDialog(TareasInfo.this, "La subtarea ha sido actualizada correctamente.", "",
							JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
									.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));

				}
				JOptionPane.showMessageDialog(TareasInfo.this, "La tarea ha sido eliminada correctamente.", "",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
								.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
			} else {
				JOptionPane.showMessageDialog(TareasInfo.this,
						"Seleccione una tarea de la lista para poder eliminarla.", "Error al eliminar.",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (ProjectInfoLayer.getTareaSeleccionada() != null) {
				tareaseleccionada = ProjectInfoLayer.getTareaSeleccionada();
				tareaseleccionada.setNombre(textFieldNombre.getText());
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePicker.getModel().getValue());
				tareaseleccionada.setFechacreacion(cal);
				Calendar cal2 = Calendar.getInstance();
				cal.setTime((Date) datePicker2.getModel().getValue());
				tareaseleccionada.setFechacreacion(cal2);
				tareaseleccionada.setEstado((String) comboBoxEstado.getSelectedItem());
				tareaseleccionada.setResponsable((User) comboBoxResponsable.getSelectedItem());
				tareaseleccionada.setPrioridad((String) comboBoxPrioridad.getSelectedItem());
				tareaseleccionada.setComentarios(textAreaComentarios.getText());
				ProjectInfoLayer.gettable().repaint();
				ProjectInfoLayer.getTree().repaint();
				ProjectInfoLayer.reseleccionarproyecto();
				JOptionPane.showMessageDialog(TareasInfo.this, "La tarea ha sido actualizada correctamente.", "",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
								.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
			} else {
				JOptionPane.showMessageDialog(TareasInfo.this,
						"Seleccione una tarea de la lista para poder actualizar su información.", "Error al guardar.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void fillTareaValues(Tarea t) {

		textFieldNombre.setText(t.getNombre());
		Calendar fechacreacion = t.getFechacreacion();
		datePicker.getModel().setDate(fechacreacion.get(Calendar.YEAR), fechacreacion.get(Calendar.MONTH),
				fechacreacion.get(Calendar.DATE));
		Calendar fechafinal = t.getFechafinal();
		datePicker2.getModel().setDate(fechafinal.get(Calendar.YEAR), fechafinal.get(Calendar.MONTH),
				fechafinal.get(Calendar.DATE));
		comboBoxEstado.setSelectedItem(t.getEstado());
		comboBoxResponsable.removeAllItems();
		for (int i = 0; i < t.getMiembros().size(); i++)
			comboBoxResponsable.addItem(t.getMiembros().get(i));
		comboBoxResponsable.setSelectedItem(t.getResponsable());
		comboBoxPrioridad.setSelectedItem(t.getPrioridad());
		textAreaComentarios.setText(t.getComentarios());
	}

	public static void setComboBoxResponsable(ArrayList<User> miembrosdetarea) {
		comboBoxResponsable.removeAllItems();
		for (int i = 0; i < miembrosdetarea.size(); i++) {
			comboBoxResponsable.addItem(miembrosdetarea.get(i));
		}

	}

	public static void setAddSubButton(int selectedIndex) {
		if (selectedIndex == 0) {
			btnAddSubtarea.setEnabled(false);
		} else {
			btnAddSubtarea.setEnabled(true);
		}

	}
}
