package com.springexperiment.entities;

public class Student {

	String sno, sname, sdept;

	public Student() {

	}

	/**
	 * @param sno
	 * @param sname
	 * @param sdept
	 */
	public Student(String sno, String sname, String sdept) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sdept = sdept;
	}

	/**
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * @param sno
	 *            the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname
	 *            the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the sdept
	 */
	public String getSdept() {
		return sdept;
	}

	/**
	 * @param sdept
	 *            the sdept to set
	 */
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}

}
