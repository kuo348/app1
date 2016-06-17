package com.winway.wwapp2;
import java.io.Serializable;

public class TreeElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1463219226909552195L;
	/** 文字内容 */
	private String contentText;
	/** 在tree中的層級 */
	private int level;
	/** 元素的id */
	private String id;
	/** 父元素的id */
	private String parendId;
	/** 是否有子元素 */
	private boolean hasChildren;
	/** item是否展開 */
	private boolean isExpanded;
	private String udrLevel;
	/** 表示該節點没有父元素，也就是level为0的節點 */
	public static final int NO_PARENT = -1;
	/** 表示該元素位于最頂層的層級 */
	public static final int TOP_LEVEL = 0;

	public TreeElement(String contentText, int level, String udrLevel,
			String id, String parendId, boolean hasChildren, boolean isExpanded) {
		super();
		this.contentText = contentText;
		this.level = level;
		this.udrLevel = udrLevel;
		this.id = id;
		this.parendId = parendId;
		this.hasChildren = hasChildren;
		this.isExpanded = isExpanded;
	}

	public boolean isExpanded() {
		return isExpanded;
	}

	public void setExpanded(boolean isExpanded) {
		this.isExpanded = isExpanded;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUdrLevel() {
		return udrLevel;
	}

	public void setUdrLevel(String udrLevel) {
		this.udrLevel = udrLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParendId() {
		return parendId;
	}

	public void setParendId(String parendId) {
		this.parendId = parendId;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
}
