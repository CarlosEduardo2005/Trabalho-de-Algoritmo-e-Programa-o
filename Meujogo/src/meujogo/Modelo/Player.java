package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {


	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Chute> Chutes;
	private boolean isVisivel;

	public Player() {
		this.x = 60;
		this.y = 480;
		isVisivel = true;

		Chutes = new ArrayList<Chute>();
	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\PlayerP.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void Chutes() {
		this.Chutes.add(new Chute(x + largura, y + (altura / 2)));
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,largura, altura);
	}
	
	
	public void KeyPressed(KeyEvent tecla) {
		int codigo = tecla.getExtendedKeyCode();
		
		if (codigo == KeyEvent.VK_SPACE) {
			Chutes();
		}

		if (codigo == KeyEvent.VK_UP) {
			
			dy = -30;
			
		}

		if (codigo == KeyEvent.VK_DOWN) {
			dy = 5;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {
			dx = -15;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 15;
		}

	}

	public void KeyRelease(KeyEvent tecla) {
		int codigo = tecla.getExtendedKeyCode();


		if (codigo == codigo) {
			dy = 5;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
	}
	
	
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Chute> getChutes() {
		return Chutes;
	}

}
