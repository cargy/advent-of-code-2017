package org.locusta.day05;

import java.util.List;

public class IncreasableOffsetList {

	private final List<Integer> list;
	private int index = 0;

	public IncreasableOffsetList(List<Integer> list) {
		this.list = list;
	}
	
	public Integer getCurrent() {
		return list.get(index);
	}
	
	public boolean jump() {
		return jump(getCurrent().intValue());		
	}
	
	public int jumpAround() {
		int count = 0;
		do {
			count++;
		} while (jump()); 
		return count;
	}

	public boolean jump(int offset) {
		if (index + offset < list.size() && index + offset >= 0) {
			onJump(index, 1);
			index += offset;
			return true;
		} else {
			return false;
		}
	}
	
	protected void onJump(int index, int add) {
		list.set(index, list.get(index).intValue() + add);
	}

}
