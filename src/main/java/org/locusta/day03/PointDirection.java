package org.locusta.day03;

import java.util.Arrays;
import java.util.List;

public enum PointDirection {
	
	RIGHT(1,0), TOP(0,-1), LEFT(-1, 0), BOTTOM(0, 1),
	TOP_RIGHT(1, -1), TOP_LEFT(-1, -1), BOTTOM_LEFT(-1,1), BOTTOM_RIGHT(1,1);
	
	private Point offset;

	PointDirection(int offsetX, int offsetY) {
		this.offset = new Point(offsetX, offsetY);
	}

	public Point offset() {
		return offset;
	}

	public PointDirection next() {
		List<PointDirection> list = Arrays.asList(RIGHT, TOP, LEFT, BOTTOM);
		int nextIndex = (list.indexOf(this) + 1) % list.size();
		return list.get(nextIndex);
	}

	public PointDirection nextWithDiagonals() {
		List<PointDirection> list = Arrays.asList(values());
		int nextIndex = (list.indexOf(this) + 1) % list.size();
		return list.get(nextIndex);
	}
}
