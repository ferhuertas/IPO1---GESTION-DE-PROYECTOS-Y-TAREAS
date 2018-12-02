package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import data.Data;
import domain.Proyecto;
import domain.Tarea;
import domain.User;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ProjectInfoLayer extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JScrollPane scrollPane;
	private JLabel label_3;
	private JTextArea textAreaDescription;
	private JLabel label_4;
	private static JComboBox comboBoxResponsable;
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JButton buttonSave;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JDatePickerImpl datePickerCreacion;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private Properties p;
	private JButton btnAadirMiembros;
	private JList listamiembros;
	static DefaultListModel<User> modeloUsers = new DefaultListModel<User>();
	private JTextField textFieldNombre;
	private JScrollPane scrollPane_2;
	private static JList listProyectos;
	private JLabel lblProyectos;
	private static JTabbedPane tabbedPanelVistas;
	private JPanel panelDetalle;
	private JPanel panelArbol;
	private static JTable table;
	private static JTree tree;
	private JScrollPane scrollPane_3;
	private JPanel panel;
	private Data data;
	DefaultListModel<Proyecto> modeloProyectos;
	static DefaultTableModel modelonlyheader;

	/**
	 * Create the panel.
	 */
	public ProjectInfoLayer(Data data) {

		this.data = data;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 0, 0, 0, 5, 162, 5, 122, 100, 5, 0, 88, 88, 96, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 5, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setToolTipText("");
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.gridheight = 11;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		add(scrollPane_2, gbc_scrollPane_2);

		listProyectos = new JList();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProyectos.addListSelectionListener(new ListProyectosListSelectionListener());
		scrollPane_2.setViewportView(listProyectos);
		modeloProyectos = new DefaultListModel<Proyecto>();

		Iterator<Proyecto> it = data.listaProyectos.iterator();

		while (it.hasNext()) {
			Proyecto proyectoLeido = it.next();
			modeloProyectos.addElement(proyectoLeido);
		}
		listProyectos.setModel(modeloProyectos);

		lblProyectos = new JLabel(Messages.getString("ProjectInfoLayer.lblProyectos.text")); //$NON-NLS-1$
		scrollPane_2.setColumnHeaderView(lblProyectos);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("ProjectInfoLayer.panel.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 11;
		gbc_panel.gridx = 10;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 93, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		tabbedPanelVistas = new JTabbedPane(JTabbedPane.TOP);

		GridBagConstraints gbc_tabbedPanelVistas = new GridBagConstraints();
		gbc_tabbedPanelVistas.fill = GridBagConstraints.BOTH;
		gbc_tabbedPanelVistas.gridheight = 10;
		gbc_tabbedPanelVistas.gridwidth = 4;
		gbc_tabbedPanelVistas.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPanelVistas.gridx = 0;
		gbc_tabbedPanelVistas.gridy = 0;
		panel.add(tabbedPanelVistas, gbc_tabbedPanelVistas);

		panelDetalle = new JPanel();
		tabbedPanelVistas.addTab("Vista Detalle (Principales)", null, panelDetalle, null);
		panelDetalle.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane_3 = new JScrollPane();
		panelDetalle.add(scrollPane_3);

		String[] nombreColumnas = { "Tarea", "Fecha Creación", "Fecha finalización", "Responsable", "Prioridad",
				"Estado" };
		modelonlyheader = new DefaultTableModel(null, nombreColumnas);
		table = new JTable();
		scrollPane_3.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.getSelectionModel().addListSelectionListener(new ListTareasListSelectionListener());
		table.setModel(modelonlyheader);

		panelArbol = new JPanel();
		tabbedPanelVistas.addTab("Vista Arbol (Con Subtareas)", null, panelArbol, null);
		panelArbol.setLayout(new GridLayout(0, 1, 0, 0));

		tree = new JTree();
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		scrollPane = new JScrollPane();
		panelArbol.add(scrollPane);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		scrollPane.setViewportView(tree);

		label = new JLabel(Messages.getString("ProjectInfoLayer.label.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 5;
		gbc_label.gridy = 2;
		add(label, gbc_label);

		label_2 = new JLabel(Messages.getString("ProjectInfoLayer.label_2.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.gridwidth = 2;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 7;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 5;
		gbc_textFieldNombre.gridy = 3;
		add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 7;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);

		btnAadirMiembros = new JButton(Messages.getString("ProjectInfoLayer.btnAadirMiembros.text")); //$NON-NLS-1$
		btnAadirMiembros
				.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/members.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		btnAadirMiembros.addActionListener(new BtnAadirMiembrosActionListener());
		scrollPane.setColumnHeaderView(btnAadirMiembros);

		listamiembros = new JList<>(modeloUsers);
		scrollPane.setViewportView(listamiembros);

		label_1 = new JLabel(Messages.getString("ProjectInfoLayer.label_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 4;
		add(label_1, gbc_label_1);

		model = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		datePickerCreacion = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerCreacion.getJFormattedTextField().setBorder(new LineBorder(Color.DARK_GRAY));
		datePickerCreacion.getJFormattedTextField().setBackground(SystemColor.control);
		model.setSelected(true);

		panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 5;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(datePickerCreacion);

		label_3 = new JLabel(Messages.getString("ProjectInfoLayer.label_3.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 6;
		add(label_3, gbc_label_3);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 5;
		gbc_scrollPane_1.gridy = 7;
		add(scrollPane_1, gbc_scrollPane_1);

		textAreaDescription = new JTextArea();
		scrollPane_1.setViewportView(textAreaDescription);

		label_4 = new JLabel(Messages.getString("ProjectInfoLayer.label_4.text")); //$NON-NLS-1$
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridwidth = 2;
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 7;
		gbc_label_4.gridy = 8;
		add(label_4, gbc_label_4);

		comboBoxResponsable = new JComboBox();
		GridBagConstraints gbc_comboBoxResponsable = new GridBagConstraints();
		gbc_comboBoxResponsable.gridwidth = 2;
		gbc_comboBoxResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxResponsable.gridx = 7;
		gbc_comboBoxResponsable.gridy = 9;
		add(comboBoxResponsable, gbc_comboBoxResponsable);

		buttonAdd = new JButton(Messages.getString("ProjectInfoLayer.buttonAdd.text")); //$NON-NLS-1$
		buttonAdd.setToolTipText(Messages.getString("ProjectInfoLayer.buttonAdd.toolTipText")); //$NON-NLS-1$
		buttonAdd.addActionListener(new ButtonAddActionListener());
		buttonAdd.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/add-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
		gbc_buttonAdd.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAdd.gridx = 5;
		gbc_buttonAdd.gridy = 11;
		add(buttonAdd, gbc_buttonAdd);

		buttonDelete = new JButton(Messages.getString("ProjectInfoLayer.buttonDelete.text")); //$NON-NLS-1$
		buttonDelete.addActionListener(new ButtonDeleteActionListener());
		buttonDelete.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_buttonDelete = new GridBagConstraints();
		gbc_buttonDelete.gridwidth = 2;
		gbc_buttonDelete.insets = new Insets(0, 0, 5, 5);
		gbc_buttonDelete.gridx = 6;
		gbc_buttonDelete.gridy = 11;
		add(buttonDelete, gbc_buttonDelete);

		buttonSave = new JButton(Messages.getString("ProjectInfoLayer.buttonSave.text")); //$NON-NLS-1$
		buttonSave.addActionListener(new ButtonSaveActionListener());
		buttonSave.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/save-icon-76240.png"))
						.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_buttonSave = new GridBagConstraints();
		gbc_buttonSave.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSave.gridx = 8;
		gbc_buttonSave.gridy = 11;
		add(buttonSave, gbc_buttonSave);

		tabbedPanelVistas.addChangeListener(new TabbedPanelVistasChangeListener());

	}

	private class BtnAadirMiembrosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiembrosProyecto miembros = new MiembrosProyecto(data, modeloUsers);
			miembros.setVisible(true);
		}
	}

	private class ListProyectosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			table.clearSelection();
			if (!arg0.getValueIsAdjusting()) {
				if (!listProyectos.isSelectionEmpty()) {

					Proyecto proyectoseleccionado = (Proyecto) listProyectos.getSelectedValue();
					textFieldNombre.setText(proyectoseleccionado.getNombre());
					Calendar date = proyectoseleccionado.getFechacreación();
					datePickerCreacion.getModel().setDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
							date.get(Calendar.DATE));
					textAreaDescription.setText(proyectoseleccionado.getDescripción());
					modeloUsers.removeAllElements();
					comboBoxResponsable.removeAllItems();
					for (int i = 0; i < proyectoseleccionado.getMiembros().size(); i++) {
						modeloUsers.addElement(proyectoseleccionado.getMiembros().get(i));
						comboBoxResponsable.addItem(proyectoseleccionado.getMiembros().get(i));
					}
					comboBoxResponsable.setSelectedItem(proyectoseleccionado.getResponsable());
					table.removeAll();
					MiModeloTabla modeloTabla = new MiModeloTabla();
					if (proyectoseleccionado.getTareas() != null) {
						for (int i = 0; i < proyectoseleccionado.getTareas().size(); i++) {
							Tarea tareaLeido = proyectoseleccionado.getTareas().get(i);
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

							Object[] fila = { tareaLeido, format1.format(tareaLeido.getFechacreacion().getTime()),
									format1.format(tareaLeido.getFechafinal().getTime()), tareaLeido.getResponsable(),
									tareaLeido.getPrioridad(), tareaLeido.getEstado() };
							modeloTabla.aniadeFila(fila);

							tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Tareas") {
								{
									DefaultMutableTreeNode node_1;
									for (int i = 0; i < proyectoseleccionado.getTareas().size(); i++) {
										node_1 = new DefaultMutableTreeNode(proyectoseleccionado.getTareas().get(i));
										if (proyectoseleccionado.getTareas().get(i).getSubtareas() != null) {
											for (int j = 0; j < proyectoseleccionado.getTareas().get(i).getSubtareas()
													.size(); j++)
												node_1.add(new DefaultMutableTreeNode(
														proyectoseleccionado.getTareas().get(i).getSubtareas().get(j)));
										}
										add(node_1);
									}

								}
							}));

						}
						table.setModel(modeloTabla);
					} else {
						table.setModel(modelonlyheader);
						tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Tareas")));
					}
				}
			}
		}
	}

	private class ListTareasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (!event.getValueIsAdjusting()) {
				if (!(table.getSelectionModel().isSelectionEmpty())) {
					Tarea t = (Tarea) table.getModel().getValueAt(table.getSelectedRow(), 0);
					TareasInfo.fillTareaValues(t);
				}

			}
		}
	}

	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			if (!(tree.getSelectionModel().isSelectionEmpty())) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				Object nodeInfo = node.getUserObject();
				if (!node.isRoot()) {
					Tarea t = (Tarea) nodeInfo;
					TareasInfo.fillTareaValues(t);
				}

			}
		}
	}

	private class ButtonSaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listProyectos.isSelectionEmpty()) {
				Proyecto proyectoseleccionado = (Proyecto) listProyectos.getSelectedValue();
				proyectoseleccionado.setNombre(textFieldNombre.getText());
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePickerCreacion.getModel().getValue());
				proyectoseleccionado.setFechacreación(cal);
				proyectoseleccionado.setDescripción(textAreaDescription.getText());
				proyectoseleccionado.setResponsable((User) comboBoxResponsable.getSelectedItem());
				ArrayList<User> listamiembros = new ArrayList<User>();
				for (int i = 0; i < modeloUsers.size(); i++) {
					listamiembros.add(modeloUsers.get(i));
				}
				proyectoseleccionado.setMiembros(listamiembros);
				listProyectos.repaint();
				JOptionPane.showMessageDialog(ProjectInfoLayer.this, "El proyecto ha sido actualizado correctamente.",
						"", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
								.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
			} else {
				JOptionPane.showMessageDialog(ProjectInfoLayer.this,
						"Seleccione un proyecto de la lista para poder actualizarlo.", "Error al actualizar.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class ButtonDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listProyectos.isSelectionEmpty()) {
				Proyecto proyectoseleccionado = (Proyecto) listProyectos.getSelectedValue();
				modeloProyectos.removeElement(proyectoseleccionado);
				data.listaProyectos.remove(proyectoseleccionado);
				JOptionPane.showMessageDialog(ProjectInfoLayer.this, "El proyecto ha sido eliminado correctamente.", "",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
								.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
			} else {
				JOptionPane.showMessageDialog(ProjectInfoLayer.this,
						"Seleccione un proyecto de la lista para poder eliminarlo.", "Error al eliminar.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class ButtonAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar cal = Calendar.getInstance();
			cal.setTime((Date) datePickerCreacion.getModel().getValue());
			ArrayList<User> listamiembros = new ArrayList<User>();
			for (int i = 0; i < modeloUsers.size(); i++) {
				listamiembros.add(modeloUsers.get(i));
			}
			Proyecto proyectoacrear = new Proyecto(textFieldNombre.getText(), cal, textAreaDescription.getText(),
					(User) comboBoxResponsable.getSelectedItem(), listamiembros, null);
			modeloProyectos.addElement(proyectoacrear);
			data.listaProyectos.add(proyectoacrear);
			listProyectos.setSelectedValue(proyectoacrear, true);
			listProyectos.repaint();
			JOptionPane.showMessageDialog(ProjectInfoLayer.this, "El proyecto ha sido añadido correctamente.", "",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
							.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));
		}
	}

	private class TabbedPanelVistasChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			TareasInfo.setAddSubButton(tabbedPanelVistas.getSelectedIndex());
		}
	}

	public static void addcomboBoxResponsable(User userseleccionado) {
		comboBoxResponsable.addItem(userseleccionado);
	}

	public static void quitcomboBoxResponsable(User userseleccionado) {
		comboBoxResponsable.removeItem(userseleccionado);
	}

	public static Proyecto getProyectoSeleccionado() {
		if (!listProyectos.isSelectionEmpty()) {
			Proyecto proyectoseleccionado = (Proyecto) listProyectos.getSelectedValue();
			return proyectoseleccionado;
		}
		return null;
	}

	public static Tarea getTareaSeleccionada() {
		Tarea tareaseleccionada = null;
		if (tabbedPanelVistas.getSelectedIndex() == 0) {
			if (table.getModel() != modelonlyheader) {
				if (!(table.getSelectionModel().isSelectionEmpty())) {
					tareaseleccionada = (Tarea) (Tarea) table.getModel().getValueAt(table.getSelectedRow(), 0);

				}

			}
		} else {
			if (!(tree.getSelectionModel().isSelectionEmpty())) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				Object nodeInfo = node.getUserObject();
				if (!node.isRoot()) {
					tareaseleccionada = (Tarea) nodeInfo;
				}

			}

		}
		return tareaseleccionada;

	}

	public static JTable gettable() {
		return table;
	}

	public static int tabselected() {
		return tabbedPanelVistas.getSelectedIndex();
	}

	public static void reseleccionarproyecto() {
		Proyecto proyectoseleccionado = (Proyecto) listProyectos.getSelectedValue();
		listProyectos.clearSelection();
		listProyectos.setSelectedValue(proyectoseleccionado, true);
		listProyectos.repaint();
	}

	public static JTree getTree() {
		return tree;

	}

}
