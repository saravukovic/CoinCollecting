package gui_coins;

import java.awt.Graphics;
import java.awt.Paint;

public abstract class Figure {
	protected int x, y, width;
	
	

	public Figure(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Figure)) return false;
		Figure f = (Figure)obj;
		return this.x==f.x && this.y==f.y;
	}
	
	public abstract void paint(Graphics g);
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
