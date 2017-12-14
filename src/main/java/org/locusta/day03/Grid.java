package org.locusta.day03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Grid {
	
	private final Map<Point, Long> points = new LinkedHashMap<>();
	private Point last;
	private PointDirection lastDirection;
	
	public Grid() {
		put(Point.ZERO, PointDirection.BOTTOM);
	}
	
	public Point nextPoint() {
		PointDirection nextDirection = points.containsKey(last.on(lastDirection.next())) ? lastDirection : lastDirection.next();
		Point nextPoint = last.on(nextDirection);
		put(nextPoint, nextDirection);
		return nextPoint;
	}
	
	public int stepsTo(int value) {
		Point accessPort = Point.ZERO;
		Point point = getPoint(value);
		return Math.abs(accessPort.getX() - point.getX()) + Math.abs(accessPort.getY() - point.getY());
	}
	
	public Point getPoint(int value) {
		extendGridIfNeeded(value);
		for (Entry<Point, Long> entry : points.entrySet()) {
			if (entry.getValue() == value) {
				return entry.getKey();
			}
		}
		throw new IllegalStateException("Could not find point with value:" + value);
	}
	
	public void clear() {
		for (Entry<Point, Long> entry : points.entrySet()) {
			points.put(entry.getKey(), 0l);
		}
		points.put(Point.ZERO, 1l);
	}
	
	public long sumAdjucent(long value) {
		long lastSum = 1;
		extendGridIfNeeded(value);
		clear();
		for (Entry<Point, Long> entry : points.entrySet()) {
			lastSum = entry.getKey().equals(Point.ZERO) ? 1 : getAdjacentSum(entry.getKey());
			points.put(entry.getKey(), lastSum);			
		}
		return lastSum;
	}
	
	
	public int getAdjacentSum(Point point) {
		int sum = 0;
		for (PointDirection direction : PointDirection.values()) {
			Long adjustcentPointValue = points.get(point.on(direction.nextWithDiagonals()));
			if (adjustcentPointValue != null) {
				sum += adjustcentPointValue;
			}
		}
		return sum;
	}
	
	public long findFirstValueLargerThan(long max) {
		long firstValue = 1;
		long i = 1;
		do {
			firstValue = sumAdjucent(i++);
		} while (firstValue < max);
		return firstValue;
	}
	
	private void extendGridIfNeeded(long value) {
		for (long i = points.size(); i < value; i++) {
			nextPoint();
		}
	}

	private void put(Point point, PointDirection direction) {
		points.put(point, last == null ? 1 : points.get(last) + 1);
		last = point;
		lastDirection = direction;
	}
	
}
