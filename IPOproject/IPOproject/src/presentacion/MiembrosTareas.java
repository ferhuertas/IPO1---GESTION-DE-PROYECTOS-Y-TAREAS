package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import data.Data;
import domain.Proyecto;
import domain.Tarea;
import domain.User;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Window.Type;

public class MiembrosTareas extends JDialog {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JList listUserProy;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JList listUserTarea;
	private JScrollPane scrollPane_1;
	private JButton btnQuit;
	private JLabel lblAvatar;
	private JLabel lblNombre;
	private JLabel lblMemberX;
	private Data data;
	private DefaultListModel<User> modeloUsersTarea;
	private DefaultListModel<User> modeloUsersProyecto;
	private JButton btnAceptar;
	private DefaultListModel<User> modeloUsersaux;
	private Tarea tareaseleccionada;
	private ImageIcon imagen;

	/**
	 * Launch the application.
	 */
	public MiembrosTareas(Data data) {
		setResizable(false);
		setModal(true);
		this.data = data;
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MiembrosTareas.class.getResource("/taskmanagerlogo.png")));
		setTitle(Messages.getString("MiembrosTareas.this.title")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 432);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Label.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 133, 330);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("MiembrosTareas.panel.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 109, 289);
		panel.add(scrollPane);

		listUserProy = new JList();
		Proyecto proyectoseleccionado = ProjectInfoLayer.getProyectoSeleccionado();
		tareaseleccionada = ProjectInfoLayer.getTareaSeleccionada();
		modeloUsersProyecto = new DefaultListModel<User>();
		for (int i = 0; i < data.listaUsuarios.size(); i++) {
			if (proyectoseleccionado.getMiembros().contains(data.listaUsuarios.get(i))
					&& !(tareaseleccionada.getMiembros().contains(data.listaUsuarios.get(i)))) {
				modeloUsersProyecto.addElement(data.listaUsuarios.get(i));
			}
		}
		listUserProy.setModel(modeloUsersProyecto);

		scrollPane.setViewportView(listUserProy);
		listUserProy.setToolTipText("Member 1\r\nMember 2");
		listUserProy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel_1 = new JPanel();
		panel_1.setBounds(296, 13, 320, 330);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("MiembrosTareas.panel_1.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 28, 113, 289);
		panel_1.add(scrollPane_1);

		modeloUsersTarea = new DefaultListModel<User>();

		for (int j = 0; j < tareaseleccionada.getMiembros().size(); j++) {
			modeloUsersTarea.addElement(tareaseleccionada.getMiembros().get(j));
		}
		listUserTarea = new JList();
		scrollPane_1.setViewportView(listUserTarea);
		listUserTarea.addListSelectionListener(new ListProyUserListSelectionListener());
		listUserTarea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUserTarea.setModel(modeloUsersTarea);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(152, 99, 138, 131);
		lblAvatar.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAvatar.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/0_200.png"))
				.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		panel_1.add(lblAvatar);

		lblNombre = new JLabel(Messages.getString("MiembrosTareas.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setBounds(137, 243, 50, 16);
		panel_1.add(lblNombre);

		lblMemberX = new JLabel("");
		lblMemberX.setBounds(191, 223, 129, 56);
		panel_1.add(lblMemberX);

		btnAdd = new JButton(Messages.getString("MiembrosTareas.btnAdd.text")); //$NON-NLS-1$
		btnAdd.setBounds(153, 107, 137, 51);
		btnAdd.addActionListener(new BtnAddActionListener());
		btnAdd.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaderecha.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		contentPane.add(btnAdd);

		btnQuit = new JButton(Messages.getString("MiembrosTareas.btnQuit.text")); //$NON-NLS-1$
		btnQuit.setBounds(153, 187, 137, 51);
		btnQuit.addActionListener(new BtnQuitActionListener());
		btnQuit.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaizquierda.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		contentPane.add(btnQuit);

		btnAceptar = new JButton(Messages.getString("MiembrosTareas.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(467, 348, 149, 44);
		contentPane.add(btnAceptar);
	}

	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!listUserProy.isSelectionEmpty()) {
				User userseleccionado = (User) listUserProy.getSelectedValue();
				modeloUsersProyecto.removeElement(userseleccionado);
				modeloUsersTarea.addElement(userseleccionado);

			}
		}
	}

	private class BtnQuitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listUserTarea.isSelectionEmpty()) {
				User userseleccionado = (User) listUserTarea.getSelectedValue();
				modeloUsersTarea.removeElement(userseleccionado);
				modeloUsersProyecto.addElement(userseleccionado);

			}

		}
	}

	private class ListProyUserListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			if (!listUserTarea.isSelectionEmpty()) {
				User userseleccionado = (User) listUserTarea.getSelectedValue();
				lblMemberX.setText(userseleccionado.getNombre() + " " + userseleccionado.getApellido());
				if (userseleccionado.getImage() != null) {
					imagen = new ImageIcon(new ImageIcon(userseleccionado.getImage()).getImage().getScaledInstance(140,
							140, Image.SCALE_SMOOTH));
					lblAvatar.setIcon(imagen);
				} else {
					lblAvatar.setIcon(
							new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/0_200.png"))
									.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
				}
			}
		}
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<User> miembrosdetarea = new ArrayList<User>();
			for (int i = 0; i < modeloUsersTarea.size(); i++) {
				miembrosdetarea.add(modeloUsersTarea.get(i));
			}
			tareaseleccionada.setMiembros(miembrosdetarea);
			TareasInfo.setComboBoxResponsable(miembrosdetarea);
			dispose();
		}
	}
}
