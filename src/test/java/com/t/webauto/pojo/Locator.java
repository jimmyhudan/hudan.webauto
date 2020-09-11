package com.t.webauto.pojo;

public class Locator {

	/**
	 * 元素关键字 
	 */
	public Locator()
	{
		super();
	}
	
	public Locator(String keyword,String by,String value)
	{
		super();
		this.keyword=keyword;
		this.by=by;
		this.value=value;
	}
	
	private String keyword;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String by;
	private String value;
	
	
	@Override
	public String toString() {
		return "元素关键字 keyword：" + keyword + ", 定位方式by：" + by + ", 选择器的值value：" + value + "]";
	}
}
