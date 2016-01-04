package com.daniel.picture;

public class AdBean {
	private int iconResId;
	private String desc;

	public int getIconResId() {
		return iconResId;
	}

	public AdBean(int iconResId, String desc) {
		this.iconResId = iconResId;
		this.desc = desc;
	}

	public void setIconResId(int iconResId) {
		this.iconResId = iconResId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
