package org.locusta.day03;

import java.util.Arrays;
import java.util.List;

public enum PointDirection {
	
	RIGHT(1,0), TOP(0,-1), LEFT(-1, 0), BOTTOM(0, 1);
	
	private Point offset;

	PointDirection(int offsetX, int offsetY) {
		this.offset = new Point(offsetX, offsetY);
	}

	public Point offset() {
		return offset;
	}

	public PointDirection next() {
		List<PointDirection> list = Arrays.asList(values());
		int nextIndex = (list.indexOf(this) + 1) % 4;
		return list.get(nextIndex);
	}

}
