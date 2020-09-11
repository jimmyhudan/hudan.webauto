package com.t.webauto.pojo;

import java.util.List;

public class Page {

	public Page(String keyWord,List<Locator> locators)
	{
		super();
		this.keyWord=keyWord;
		this.locators=locators;
	}
	private String keyWord; 
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public List<Locator> getLocators() {
		return locators;
	}
	public void setLocators(List<Locator> locators) {
		this.locators = locators;
	}
	private List<Locator> locators;
}
