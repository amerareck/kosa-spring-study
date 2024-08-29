package com.tobaki.tobaki.dto;

import java.util.ArrayList;
import java.util.List;

public class Ch06Cart {
	private List<Ch06Item> contents = new ArrayList<Ch06Item>();
	
	public List<Ch06Item> getContents() {
		return contents;
	}
	
	public void addItem(Ch06Item Ch06Item) {
		contents.add(Ch06Item);
	}
	
	public void removeItem(Ch06Item Ch06Item) {
		contents.remove(Ch06Item);
	}
}
