package meujogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

	private Image fundo;
	private Player Player;
	private Player2 Player2;
	private Timer timer;
	private List<Bola> bola;
	private boolean emJogo;

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res\\blackground.jpeg");
		fundo = referencia.getImage();

		Player = new Player();
		Player.load();
		
		Player2 = new Player2();
		Player2.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		inicializabola();
		emJogo = true;

	}

	public void inicializabola() {
		int cordenadas[] = new int[2];
		bola = new ArrayList<Bola>();

		for (int i = 0; i < cordenadas.length; i++) {
			int x = 750;
			int y = 150;
			bola.add(new Bola(x, y));
		}

	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if(emJogo == true)
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(Player.getImagem(), Player.getX(), Player.getY(), this);
		List<Chute> Chutes = Player.getChutes();

		for (int i = 0; i < Chutes.size(); i++) {
			Chute m = Chutes.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}

		for (int o = 0; o < bola.size(); o++) {
			Bola in = bola.get(o);
			in.load();
			graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player.update();
		List<Chute> Chutes = Player.getChutes();

		for (int i = 0; i < Chutes.size(); i++) {
			Chute m = Chutes.get(i);
			if (m.isVisivel()) {
				m.update();
			} else {
				Chutes.remove(i);
			}
		}

		for (int o = 0; o < bola.size(); o++) {
			Bola in = bola.get(o);
			if (in.isVisivel()) {
				in.update();
				
			} else {
				bola.remove(o);
			}
			

		}

		repaint();

	}
	
	public void checarColisoes() {
		Rectangle formaNave = Player.getBounds();
		Rectangle formaBola;
		Rectangle formaChute;
		
		for(int i = 0; i < bola.size(); i++ ) {
			Bola tempBola = bola.get(i);
			formaBola = tempBola.getBounds();
			  if(formaNave.intersects(formaBola)) {
				  Player.setVisivel(false);
				  tempBola.setVisivel(false);
			  }
		}
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			Player.KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Player.KeyRelease(e);
		}
	}
}
