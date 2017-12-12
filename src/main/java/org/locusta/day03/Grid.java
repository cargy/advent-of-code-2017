package org.locusta.day03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Grid {
	
	private final Map<Point, Integer> points = new LinkedHashMap<>();
	private Point last;
	private PointDirection lastDirection;
	
	public Grid() {
		addPoint(new Point(0,0), PointDirection.BOTTOM);
	}
	
	public Point nextPoint() {
		PointDirection nextDirection = points.containsKey(last.on(lastDirection.next())) ? lastDirection : lastDirection.next();
		Point nextPoint = last.on(nextDirection);
		addPoint(nextPoint, nextDirection);
		return nextPoint;
	}
	
	public int stepsTo(int value) {
		Point accessPort = new Point(0,0);
		Point point = getPoint(value);
		return Math.abs(accessPort.getX() - point.getX()) + Math.abs(accessPort.getY() - point.getY());
	}
	
	public Point getPoint(int value) {
		extendGridIfNeeded(value);
		for (Entry<Point, Integer> entry : points.entrySet()) {
			if (entry.getValue() == value) {
				return entry.getKey();
			}
		}
		throw new IllegalStateException("Could not find point with value:" + value);
	}
	
	private void extendGridIfNeeded(int value) {
		for (int i = points.size(); i < value; i++) {
			nextPoint();
		}
	}
	
	private void addPoint(Point point, PointDirection direction) {
		points.put(point, last == null ? 1 : points.get(last) + 1);
		last = point;
		lastDirection = direction;
	}

}
