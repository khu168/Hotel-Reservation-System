/**
 * 
 */
package com.hrs.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class Contains the Expected Reservation Data
 * 
 * @author kkumari
 *
 */
public class ReservationDTO {

	private Boolean isRewarded;

	private List<DateDTO> dateList;

	

	/**
	 * @return the isRewarded
	 */
	public Boolean getIsRewarded() {
		return isRewarded;
	}

	/**
	 * @param isRewarded the isRewarded to set
	 */
	public void setIsRewarded(Boolean isRewarded) {
		this.isRewarded = isRewarded;
	}

	/**
	 * @return the dateList
	 */
	public List<DateDTO> getDateList() {
		if (dateList == null) {
			new ArrayList<DateDTO>();
		}
		return dateList;
	}

	/**
	 * @param dateList the dateList to set
	 */
	public void setDateList(List<DateDTO> dateList) {
		this.dateList = dateList;
	}

	@Override
	public String toString() {
		return "ReservationDTO [isRewarded=" + isRewarded + ", dateList=" + dateList + "]";
	}
	

}
