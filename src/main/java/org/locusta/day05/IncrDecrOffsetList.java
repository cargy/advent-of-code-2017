package org.locusta.day05;

import java.util.List;

public class IncrDecrOffsetList extends IncreasableOffsetList {

	public IncrDecrOffsetList(List<Integer> list) {
		super(list);
	}
	
	@Override
	protected void onJump(int index, int add) {
		if (getCurrent() >= 3) {
			super.onJump(index,	-1);
		} else {
			super.onJump(index, 1);
		}
	}

}
