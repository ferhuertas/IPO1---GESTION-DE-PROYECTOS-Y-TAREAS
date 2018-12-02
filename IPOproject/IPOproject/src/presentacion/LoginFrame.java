package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import data.Data;
import domain.User;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField textFieldUsuario;
	private JLabel lblContrasea;
	private JButton btnEntrar;
	private JLabel lblhasOlvidadoLa;
	private JLabel lblPulseAqu;
	private JComboBox comboBox;
	private JLabel lblIdioma;
	private JPasswordField passwordField;
	private JLabel lblLogo;
	private String password = "ipo1";
	private Data data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setLocationRelativeTo(null);
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
	public LoginFrame() {
		this.data = new Data();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginFrame.class.getResource("/taskmanagerlogo.png")));
		setTitle(Messages.getString("LoginFrame.this.title")); //$NON-NLS-1$ //$NON-NLS-1$
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 289, 317);
		contentPane.add(panel);
		panel.setLayout(null);

		lblUsuario = new JLabel(); //$NON-NLS-1$
		lblUsuario.setText(Messages.getString("LoginFrame.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(30, 155, 116, 16);
		panel.add(lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.addActionListener(new TextFieldActionListener());
		textFieldUsuario.setBounds(30, 174, 227, 22);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		lblContrasea = new JLabel(); //$NON-NLS-1$
		lblContrasea.setText(Messages.getString("LoginFrame.lblContrasea.text")); //$NON-NLS-1$
		lblContrasea.setEnabled(false);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(30, 209, 116, 16);
		panel.add(lblContrasea);

		btnEntrar = new JButton(); //$NON-NLS-1$
		btnEntrar.setText(Messages.getString("LoginFrame.btnEntrar.text")); //$NON-NLS-1$
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean entrar;
				User login = null;
				entrar = false;
				for (int i = 0; i < data.listaUsuarios.size(); i++) {
					if (String.valueOf(passwordField.getPassword()).toString().equals(password)
							&& data.listaUsuarios.get(i).getNickname().equals(textFieldUsuario.getText())) {
						login = data.listaUsuarios.get(i);
						Calendar calendario = new GregorianCalendar();
						login.setLastconnect(calendario.getTime().toString());
						entrar = true;
					}
				}
				if (entrar == true) {
					JOptionPane.showMessageDialog(LoginFrame.this, "Contraseña correcta. Puede entrar.",
							"Login correcto.", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))
									.getImage().getScaledInstance(39, 51, Image.SCALE_SMOOTH)));

					new VentanaPrincipal(data, login).setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(LoginFrame.this, "Contraseña incorrecta. ", "Login incorrecto.",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnEntrar.setEnabled(false);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(83, 261, 118, 43);
		panel.add(btnEntrar);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ComboBoxActionListener());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Español", "English" }));
		comboBox.setBounds(174, 9, 103, 22);
		panel.add(comboBox);

		lblIdioma = new JLabel(); //$NON-NLS-1$
		lblIdioma.setText(Messages.getString("LoginFrame.lblIdioma.text")); //$NON-NLS-1$
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdioma.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/languajeicon.png"))
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		lblIdioma.setBounds(68, 1, 96, 39);
		panel.add(lblIdioma);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEntrar.requestFocus();
			}
		});
		passwordField.setEnabled(false);
		passwordField.setBounds(30, 226, 227, 22);
		panel.add(passwordField);

		lblLogo = new JLabel(Messages.getString("LoginFrame.lblLogo.text")); //$NON-NLS-1$
		lblLogo.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/taskmanagerlogo.png"))
						.getImage().getScaledInstance(106, 106, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(85, 48, 116, 113);
		panel.add(lblLogo);

		lblhasOlvidadoLa = new JLabel(); //$NON-NLS-1$
		lblhasOlvidadoLa.setText(Messages.getString("LoginFrame.lblhasOlvidadoLa.text")); //$NON-NLS-1$
		lblhasOlvidadoLa.setHorizontalTextPosition(SwingConstants.LEFT);
		lblhasOlvidadoLa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblhasOlvidadoLa.setBounds(10, 324, 189, 33);
		contentPane.add(lblhasOlvidadoLa);

		lblPulseAqu = new JLabel(); //$NON-NLS-1$
		lblPulseAqu.setText(Messages.getString("LoginFrame.lblPulseAqu.text")); //$NON-NLS-1$
		lblPulseAqu.addMouseListener(new LblPulseAquMouseListener());
		lblPulseAqu.setForeground(SystemColor.textHighlight);
		lblPulseAqu.setBounds(204, 324, 79, 33);
		contentPane.add(lblPulseAqu);

	}

	private class TextFieldActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblContrasea.setEnabled(true);
			passwordField.setEnabled(true);
			btnEntrar.setEnabled(true);
			// Pasamos el foco (el cursor) al campo de la contrase�a
			passwordField.requestFocus();

		}
	}
	private class LblPulseAquMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			JOptionPane.showMessageDialog(null, "Usuario= admin, Contraseña= ipo1", "Ayudante de login", JOptionPane.WARNING_MESSAGE);
		}
	}

	private class ComboBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedIndex()==1) {
				Messages.setIdioma("inglés");
			}
			if(comboBox.getSelectedIndex()==0) {
				Messages.setIdioma("español");
			}
			LoginFrame ventana = new LoginFrame();
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
			dispose();
		}
		
	}

}
