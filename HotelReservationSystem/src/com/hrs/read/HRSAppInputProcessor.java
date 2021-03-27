/**
 * 
 */
package com.hrs.read;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hrs.dto.DateDTO;
import com.hrs.dto.ReservationDTO;
import com.hrs.exceptions.InputFormatException;

/**
 * This Class Reads the User Input and Set the variable Values.
 *
 */
public class HRSAppInputProcessor {

	public ReservationDTO doGetInput() throws InputFormatException {
		System.out.println("Please Enter The Data For The Hotel Booking");
		String input = null;
		try (Scanner scannerObj = new Scanner(System.in)) {
			input = scannerObj.nextLine();

		}
		return doProcessInput(input);
	}

	public ReservationDTO doProcessInput(String input) throws InputFormatException {
		ReservationDTO reservationDTO=null;
		List<DateDTO> dateList = new ArrayList<>();
		if (input != null && input != "") {
			reservationDTO = new ReservationDTO();
			try {
				String[] arrOfInput = input.split(":");
				reservationDTO.setIsRewarded(arrOfInput[0].equalsIgnoreCase("Rewards") ? true : false);
				String[] arrOfInputDates = arrOfInput[1].split(",");
				for (int i = 0; i < arrOfInputDates.length; i++) {
					processDate(dateList, arrOfInputDates, i);
				}
				reservationDTO.setDateList(dateList);

			} catch (Exception e) {
				throw new InputFormatException("Please enter Reservation Details in Accepted Format");
			}
		} else {
			throw new InputFormatException("Please enter Reservation Details For the Booking");
		}
		return reservationDTO;

	}

	public void processDate(List<DateDTO> dateList, String[] arrOfInputDates, int i) {
		DateDTO dateDTO = new DateDTO();
		dateDTO.setDate(arrOfInputDates[i].trim());
		String date = arrOfInputDates[i].toLowerCase();
		dateDTO.setWeekEnd(isWeekEnd(date));
		dateList.add(dateDTO);
	}

	public boolean isWeekEnd(String date) {
		return date.contains("sat") || date.contains("satuarday") || date.contains("sun") || date.contains("sunday");
	}

}
