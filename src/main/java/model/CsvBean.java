package model;

public class CsvBean {

	/** 
	 * ID
	 */
	private int ID;

	/**
	 * 氏名
	 */
	private String name;

	/**
	 * 社員ID取得
	 * @return id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * ID設定
	 * @param id セットする 社員id
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * 社員名取得
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 社員名設定
	 * @param name セットする社員名
	 */
	public void setName(String name) {
		this.name = name;
	}
}
