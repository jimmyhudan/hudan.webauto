package com.t.webauto.pojo;

public class ExcelParam {
	private String filePath;
	private int startRow;
	private int endRow;
	private int startcellIndex;
	private int endcellIndex;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getStartRow() {
		return startRow;
	}
	public ExcelParam(String filePath, int startRow, int endRow, int startcellIndex, int endcellIndex) {
		//父类对象的引用
		super();
		this.filePath = filePath;
		this.startRow = startRow;
		this.endRow = endRow;
		this.startcellIndex = startcellIndex;
		this.endcellIndex = endcellIndex;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getStartcellIndex() {
		return startcellIndex;
	}
	public void setStartcellIndex(int startcellIndex) {
		this.startcellIndex = startcellIndex;
	}
	public int getEndcellIndex() {
		return endcellIndex;
	}
	public void setEndcellIndex(int endcellIndex) {
		this.endcellIndex = endcellIndex;
	}
	
}
