package org.locusta.day03;

public class Point {
	
	private final int x;
	public int getX() { return x; }
	
	private final int y;
	public int getY() {	return y; }
	
	public static final Point ZERO = new Point(0,0);
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point on(PointDirection direction) {
		return new Point(x + direction.offset().getX(), y + direction.offset().getY());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%d,%d]", x, y);
	}	

}
