package com.SpringRest.model;

public class Properties {
	private String filePath;
	
	private StringBuffer fileData;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the fileData
	 */
	public StringBuffer getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(StringBuffer fileData) {
		this.fileData = fileData;
	}
	
	

}
