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
import domain.User;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Window.Type;

public class MiembrosProyecto extends JDialog {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JList listSysUser;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JList listProyUser;
	private JScrollPane scrollPane_1;
	private JButton btnQuit;
	private JLabel lblAvatar;
	private JLabel lblNombre;
	private JLabel lblMemberX;
	private Data data;
	private DefaultListModel<User> modeloUsers;
	private DefaultListModel<User> modeloUsersSistema;
	private JButton btnAceptar;
	private DefaultListModel<User> modeloUsersaux;
	private ImageIcon imagen;

	/**
	 * Launch the application.
	 */
	public MiembrosProyecto(Data data, DefaultListModel<User> modeloUsers) {
		setResizable(false);
		setModal(true);
		this.data = data;
		this.modeloUsers = modeloUsers;
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MiembrosProyecto.class.getResource("/taskmanagerlogo.png")));
		setTitle(Messages.getString("MiembrosProyecto.this.title")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 432);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Label.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 123, 330);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("MiembrosProyecto.panel.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 99, 289);
		panel.add(scrollPane);

		listSysUser = new JList();
		modeloUsersSistema = new DefaultListModel<User>();
		for (int i = 0; i < data.listaUsuarios.size(); i++) {
			if (!(modeloUsers.contains(data.listaUsuarios.get(i))))
				modeloUsersSistema.addElement(data.listaUsuarios.get(i));
		}
		listSysUser.setModel(modeloUsersSistema);

		scrollPane.setViewportView(listSysUser);
		listSysUser.setToolTipText("Member 1\r\nMember 2");
		listSysUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel_1 = new JPanel();
		panel_1.setBounds(296, 13, 305, 330);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("MiembrosProyecto.panel_1.borderTitle"), //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 28, 99, 289);
		panel_1.add(scrollPane_1);

		modeloUsersaux = new DefaultListModel<User>();

		for (int i = 0; i < modeloUsers.size(); i++)
			modeloUsersaux.addElement(modeloUsers.get(i));

		listProyUser = new JList();
		scrollPane_1.setViewportView(listProyUser);
		listProyUser.addListSelectionListener(new ListProyUserListSelectionListener());
		listProyUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProyUser.setModel(modeloUsersaux);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(138, 99, 138, 131);
		lblAvatar.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAvatar.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/0_200.png"))
				.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		panel_1.add(lblAvatar);

		lblNombre = new JLabel(Messages.getString("MiembrosProyecto.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setBounds(123, 243, 50, 16);
		panel_1.add(lblNombre);

		lblMemberX = new JLabel("");
		lblMemberX.setBounds(177, 223, 129, 56);
		panel_1.add(lblMemberX);

		btnAdd = new JButton(Messages.getString("MiembrosProyecto.btnAdd.text")); //$NON-NLS-1$
		btnAdd.setBounds(147, 107, 137, 51);
		btnAdd.addActionListener(new BtnAddActionListener());
		btnAdd.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaderecha.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		contentPane.add(btnAdd);

		btnQuit = new JButton(Messages.getString("MiembrosProyecto.btnQuit.text")); //$NON-NLS-1$
		btnQuit.setBounds(147, 179, 137, 51);
		btnQuit.addActionListener(new BtnQuitActionListener());
		btnQuit.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaizquierda.png"))
						.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		contentPane.add(btnQuit);

		btnAceptar = new JButton(Messages.getString("MiembrosProyecto.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(453, 346, 149, 44);
		contentPane.add(btnAceptar);
	}

	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!listSysUser.isSelectionEmpty()) {
				User userseleccionado = (User) listSysUser.getSelectedValue();
				modeloUsersSistema.removeElement(userseleccionado);
				modeloUsersaux.addElement(userseleccionado);
				ProjectInfoLayer.addcomboBoxResponsable(userseleccionado);
			}
		}
	}

	private class BtnQuitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listProyUser.isSelectionEmpty()) {
				User userseleccionado = (User) listProyUser.getSelectedValue();
				modeloUsersaux.removeElement(userseleccionado);
				modeloUsersSistema.addElement(userseleccionado);
				ProjectInfoLayer.quitcomboBoxResponsable(userseleccionado);
			}

		}
	}

	private class ListProyUserListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			if (!listProyUser.isSelectionEmpty()) {
				User userseleccionado = (User) listProyUser.getSelectedValue();
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
			modeloUsers.removeAllElements();
			for (int i = 0; i < modeloUsersaux.size(); i++) {
				modeloUsers.addElement(modeloUsersaux.get(i));
			}
			dispose();
		}
	}
}
