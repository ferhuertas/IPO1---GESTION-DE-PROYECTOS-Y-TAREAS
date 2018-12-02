package presentacion;

import java.awt.Color;
import java.io.Serializable;

public class TextoGrafico extends ObjetoGrafico implements Serializable{

	private Color color;
	private String texto;

	public TextoGrafico(int x, int y, String texto, Color color) {
		super(x, y);
		this.color = color;
		this.texto = texto;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
