package com.hrs.dto;

public class DateDTO {
	private String date;

	private boolean isWeekEnd;

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the isWeekEnd
	 */
	public boolean isWeekEnd() {
		return isWeekEnd;
	}

	/**
	 * @param isWeekEnd the isWeekEnd to set
	 */
	public void setWeekEnd(boolean isWeekEnd) {
		this.isWeekEnd = isWeekEnd;
	}

	@Override
	public String toString() {
		return "DateDTO [date=" + date + ", isWeekEnd=" + isWeekEnd + "]";
	}

}
