package Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Events implements ActionListener {
	private Editor frame;
	private static boolean estaReproduciendo;

	public Events(Editor frame) {
		this.frame = frame;
		frame.getCancion().cargarArchivo();
		estaReproduciendo = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btnStop":
			System.out.println("STOP");
			frame.getCancion().stop();
			frame.changeIcon("icon-play");
			frame.setPlay(true);
			estaReproduciendo = false;
			break;
		case "btnPlay":
			if (frame.isPlay() && estaReproduciendo == false) {
				System.out.println("First Play");
				frame.getCancion().play();
				frame.changeIcon("icon-pause");
				frame.setPlay(false);
				estaReproduciendo = true;
			} else if (frame.isPlay() && estaReproduciendo == true) {
				System.out.println("Second play");
				frame.getCancion().resume();
				frame.changeIcon("icon-pause");
				frame.setPlay(false);
			} else if (!frame.isPlay()) {
				System.out.println("Pause");
				frame.setPlay(true);
				frame.getCancion().pause();
				frame.changeIcon("icon-play");
			}
			break;
		case "btnNext":
			System.out.println("NEXT");
			break;
		case "btnOptions":
			JOptionPane.showMessageDialog(frame, frame.getCancion(), "Informaci�n del audio",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	public boolean isNumber(String s) {
		boolean number = false;
		try {
			Integer.parseInt(s);
			number = true;
		} catch (Exception e) {
		}
		return number;
	}
}
