package gui_coins;

import java.awt.Label;

public class Timer extends Thread {

	private Label label;
	private int s, m;
	private boolean work;

	public Timer(Label label) {
		this.label = label;
	}

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				synchronized (this) {
					while (!work)
						wait();
				}
				label.setText(toString());
				label.revalidate();
				sleep(1000);
				s++;
				if (s % 60 == 0) {
					m++;
					s = 0;
				}
			}
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void go() {
		work = true;
	}
	
	public synchronized void pause() {
		work = false;
	}
	
	public synchronized void reset() {
		m = s = 0;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", m,s);
	}

}
