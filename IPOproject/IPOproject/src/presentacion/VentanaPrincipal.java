package presentacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import domain.Proyecto;
import domain.Tarea;
import domain.User;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.event.ListSelectionListener;

import data.Data;

import javax.swing.event.ListSelectionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel tabProyectos;
	private JPanel tabUsuarios;
	private JButton btnHome;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblUltimaConexin;
	private JLabel lblConexionX;
	private JPanel panel_2;
	private JPanel panel_5;
	private JPanel panel_6;
	DefaultListModel<Proyecto> modeloProyectos = new DefaultListModel<Proyecto>();
	public Data data;
	public User login;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Data data, User login) {
		this.data= data;
		this.login=login;
		initComponents();
	}
	public void initComponents() {
		setTitle(Messages.getString("VentanaPrincipal.this.title")); //$NON-NLS-1$ //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/taskmanagerlogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1750, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{29, 88, 92, 0, 0, 0, 110, 475, 0};
		gbl_panel.rowHeights = new int[]{16, 0, 0, 0, 15, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnHome = new JButton(); //$NON-NLS-1$
		btnHome.setText(Messages.getString("VentanaPrincipal.btnHome.text")); //$NON-NLS-1$
		btnHome.addActionListener(new BtnHomeActionListener());
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/home-icon-76240.png")).getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnHome = new GridBagConstraints();
		gbc_btnHome.gridheight = 3;
		gbc_btnHome.gridwidth = 5;
		gbc_btnHome.fill = GridBagConstraints.BOTH;
		gbc_btnHome.insets = new Insets(0, 0, 5, 5);
		gbc_btnHome.gridx = 1;
		gbc_btnHome.gridy = 1;
		panel.add(btnHome, gbc_btnHome);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 7;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 20, 110, 52, 20, 95, 64, 20, 0};
		gbl_panel_1.rowHeights = new int[]{10, 0, 16, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblNewLabel = new JLabel(Messages.getString("VentanaPrincipal.lblNewLabel.text")); //$NON-NLS-1$ //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel(login.toString());
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblUltimaConexin = new JLabel(); //$NON-NLS-1$
		lblUltimaConexin.setText(Messages.getString("VentanaPrincipal.lblUltimaConexin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUltimaConexin = new GridBagConstraints();
		gbc_lblUltimaConexin.anchor = GridBagConstraints.NORTH;
		gbc_lblUltimaConexin.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltimaConexin.gridx = 5;
		gbc_lblUltimaConexin.gridy = 1;
		panel_1.add(lblUltimaConexin, gbc_lblUltimaConexin);
		
		lblConexionX = new JLabel(login.getLastconnect());
		GridBagConstraints gbc_lblConexionX = new GridBagConstraints();
		gbc_lblConexionX.insets = new Insets(0, 0, 5, 5);
		gbc_lblConexionX.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblConexionX.gridx = 6;
		gbc_lblConexionX.gridy = 1;
		panel_1.add(lblConexionX, gbc_lblConexionX);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabProyectos = new JPanel();
		tabbedPane.addTab("Proyectos", null, tabProyectos, null);
		GridBagLayout gbl_tabProyectos = new GridBagLayout();
		gbl_tabProyectos.columnWidths = new int[]{0, 0, 0, 171, 5, 0, 0};
		gbl_tabProyectos.rowHeights = new int[]{5, 29, 0};
		gbl_tabProyectos.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabProyectos.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabProyectos.setLayout(gbl_tabProyectos);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(Messages.getString("VentanaPrincipal.panel_6.borderTitle"))); //$NON-NLS-2$ //$NON-NLS-1$
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 3;
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridheight = 2;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		tabProyectos.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{171, -47, 0, 611, 0};
		gbl_panel_6.rowHeights = new int[]{0, 29, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		panel_2 = new ProjectInfoLayer(data);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_6.add(panel_2, gbc_panel_2);
		panel_2.setBorder(null);
		
		panel_5 = new TareasInfo(data);
		panel_5.setBorder(new TitledBorder(Messages.getString("VentanaPrincipal.panel_5.borderTitle"))); //$NON-NLS-2$ //$NON-NLS-1$
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 1;
		tabProyectos.add(panel_5, gbc_panel_5);
		
		
		tabUsuarios = new UsuariosPanel(data);
		tabbedPane.addTab("Usuarios", null, tabUsuarios, null);
		
	}

	
	
	private class BtnHomeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginFrame ventana = new LoginFrame();
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
			VentanaPrincipal.this.setVisible(false);
			
		}
	}




}
