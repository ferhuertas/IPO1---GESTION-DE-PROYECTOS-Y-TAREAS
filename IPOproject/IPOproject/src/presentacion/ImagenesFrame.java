package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;

import data.Data;
import domain.Tarea;
import domain.User;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ImagenesFrame extends JDialog {
	
	private JFrame frame;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnCargarImagen;
	private JPanel panel;
	private JList listImagesSyst;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JList listImagesTarea;
	private JScrollPane scrollPane_1;
	private JButton btnAdd;
	private JButton btnDelete;
	private JLabel lblMiareadibujo;
	// Area de dibujo personalizada (creada extendiendo de JLabel)
	private MiAreaDibujo miAreaDibujo;
	// Imagen en la que se cargar� el fichero seleccionado por el
	// usuario
	private ImageIcon imagen;
	// Variables para almacenar las
	// coordenadas actuales
	private int x, y;

	// Componente de entrada de texto que permitir�
	// a�adir anotaciones (dibujar texto) sobre la imagen
	private JTextField txtTexto = new JTextField();
	/**
	 * Launch the application.
	 */
	
	
	int modo = -1;
	private final int RECTANGULO = 3;
	private final int TEXTO = 4;

	// Cursores e imagenes
	private Toolkit toolkit;
	private Image imagRectangulo;
	private Image imagTexto;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;
	private JButton btnRectangulo;
	private JButton btnTexto;
	private JScrollPane scrollPane_2;
	private Data data;
	private DefaultListModel<String> modeloImgSyst;
	private DefaultListModel<String> modeloImgTarea;
	private Tarea tareaseleccionada;
	
	
    public ImagenesFrame(Data data) {
    	setModal(true);
    	this.data=data;
        initComponents();
    }

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImagenesFrame.class.getResource("/taskmanagerlogo.png")));
		
		// Creaci�n de im�genes y cursores
		toolkit = Toolkit.getDefaultToolkit();

		imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("rectangulo.png"));
		imagTexto = toolkit.getImage(getClass().getClassLoader().getResource("aniadirAnotacion.png"));


		// Creaci�n de los cursores
		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo, new Point(0, 0), "CURSOR_RECTANGULO");
		cursorTexto = toolkit.createCustomCursor(imagTexto, new Point(0, 0), "CURSOR_TEXTO");

		tareaseleccionada = ProjectInfoLayer.getTareaSeleccionada();
		
		setTitle(Messages.getString("ImagenesFrame.this.title")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1272, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{5, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0};
		gbl_contentPane.rowHeights = new int[]{5, 0, 5, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnCargarImagen = new JButton(Messages.getString("ImagenesFrame.btnCargarImagen.text")); //$NON-NLS-1$
		btnCargarImagen.addActionListener(new BtnCargarImagenActionListener());
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.anchor = GridBagConstraints.WEST;
		gbc_btnCargarImagen.fill = GridBagConstraints.VERTICAL;
		gbc_btnCargarImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarImagen.gridx = 1;
		gbc_btnCargarImagen.gridy = 1;
		contentPane.add(btnCargarImagen, gbc_btnCargarImagen);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 23;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, Messages.getString("ImagenesFrame.panel.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 10;
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{5, 0, 5, 0};
		gbl_panel.rowHeights = new int[]{5, 0, 0, 5, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		listImagesSyst = new JList();
		scrollPane.setViewportView(listImagesSyst);
		modeloImgSyst = new DefaultListModel<String>();
		for(int i= 0; i<data.listaImagenes.size(); i++)
			modeloImgSyst.addElement(data.listaImagenes.get(i));
		listImagesSyst.setModel(modeloImgSyst);
		
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, Messages.getString("ImagenesFrame.panel_1.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 10;
		gbc_panel_1.gridwidth = 10;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 12;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, 2.0, 2.0, 2.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		

		btnRectangulo = new JButton(Messages.getString("ImagenesFrame.btnRectangulo.text")); //$NON-NLS-1$
		btnRectangulo.addActionListener(new BtnRectanguloActionListener());
		btnRectangulo.setIcon(new ImageIcon(ImagenesFrame.class.getResource("/rectangulo.png")));
		GridBagConstraints gbc_btnRectangulo = new GridBagConstraints();
		gbc_btnRectangulo.gridwidth = 2;
		gbc_btnRectangulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRectangulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangulo.gridx = 2;
		gbc_btnRectangulo.gridy = 0;
		panel_1.add(btnRectangulo, gbc_btnRectangulo);
		
		btnTexto = new JButton(Messages.getString("ImagenesFrame.btnTexto.text")); //$NON-NLS-1$
		btnTexto.addActionListener(new BtnAnotacionActionListener());
		btnTexto.setIcon(new ImageIcon(ImagenesFrame.class.getResource("/aniadirAnotacion.png")));
		GridBagConstraints gbc_btnTexto = new GridBagConstraints();
		gbc_btnTexto.gridwidth = 2;
		gbc_btnTexto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTexto.insets = new Insets(0, 0, 5, 0);
		gbc_btnTexto.gridx = 4;
		gbc_btnTexto.gridy = 0;
		panel_1.add(btnTexto, gbc_btnTexto);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		listImagesTarea = new JList();
		listImagesTarea.addListSelectionListener(new ListImagesTareaListSelectionListener());
		scrollPane_1.setViewportView(listImagesTarea);
		modeloImgTarea = new DefaultListModel<String>();
		if(tareaseleccionada.getListaimagenes()!= null) {
		for (int i= 0 ; i< tareaseleccionada.getListaimagenes().size(); i++)
			modeloImgTarea.addElement(tareaseleccionada.getListaimagenes().get(i));
		}
		listImagesTarea.setModel(modeloImgTarea);
		
		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 5;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);
		

		miAreaDibujo = new MiAreaDibujo();
		scrollPane_2.setViewportView(miAreaDibujo);
		miAreaDibujo.setBorder(new LineBorder(new Color(0, 0, 0)));
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		
		btnAdd = new JButton(Messages.getString("ImagenesFrame.btnAdd.text")); //$NON-NLS-1$
		btnAdd.addActionListener(new BtnAddActionListener());
		btnAdd.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaderecha.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 9;
		gbc_btnAdd.gridy = 6;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		btnDelete = new JButton(Messages.getString("ImagenesFrame.btnDelete.text")); //$NON-NLS-1$
		btnDelete.addActionListener(new BtnDeleteActionListener());
		btnDelete.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon-76240.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.gridwidth = 2;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 9;
		gbc_btnDelete.gridy = 8;
		contentPane.add(btnDelete, gbc_btnDelete);
	}
	

	
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			setCursor(cursorRectangulo);

		}
	}

	private class BtnAnotacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = TEXTO;
			setCursor(cursorTexto);

		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if (imagen != null) {
				switch (modo) {
				case RECTANGULO:
					miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x, y, x, y, Color.RED));
					break;
				case TEXTO:
					txtTexto.setBounds(x, y, 200, 30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg) {
							if (!txtTexto.getText().equals(""))
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y + 17, txtTexto.getText(), Color.BLUE));
							txtTexto.setText("");
							txtTexto.setVisible(false);
							miAreaDibujo.repaint();
						}
					});
					miAreaDibujo.add(txtTexto);
				}
			}

		}
	}

	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && imagen != null) {
				((RectanguloGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico) miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}

		}
	}
	private class BtnCargarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				String imagencargada = file.getAbsolutePath();
				modeloImgSyst.addElement(imagencargada);
				
			
			}
		}
	}
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listImagesSyst.isSelectionEmpty()) {				
				String imagenseleccionada = (String) listImagesSyst.getSelectedValue();
				modeloImgTarea.addElement(imagenseleccionada);
				if(tareaseleccionada.getListaimagenes()!= null) {
				tareaseleccionada.getListaimagenes().add(imagenseleccionada);
				} else {
					ArrayList<String> listaimagenes = new ArrayList<String>();
					tareaseleccionada.setListaimagenes(listaimagenes);
					tareaseleccionada.getListaimagenes().add(imagenseleccionada);
				}
			}
		}
	}
	private class ListImagesTareaListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (!listImagesTarea.isSelectionEmpty()) {	
				String imagenseleccionada = (String) listImagesTarea.getSelectedValue();
				if(getClass().getResource(imagenseleccionada)!=null) {
					imagen = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(imagenseleccionada)).getImage());
				}else {
					imagen = new ImageIcon(new ImageIcon(imagenseleccionada).getImage());
				}
				miAreaDibujo.setIcon(imagen);
			}
		}
	}
	private class BtnDeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!listImagesTarea.isSelectionEmpty()) {				
				String imagenseleccionada = (String) listImagesTarea.getSelectedValue();
				modeloImgTarea.removeElement(imagenseleccionada);
		}
	}
	}
}
