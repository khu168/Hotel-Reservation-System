/**
 * 
 */
package com.hrs.entrypoint;

import com.hrs.dto.ReservationDTO;
import com.hrs.exceptions.InputFormatException;
import com.hrs.protect.service.HRSAppHotelSelect;
import com.hrs.protect.service.IhrsAppHotelSelect;
import com.hrs.read.HRSAppInputProcessor;

/**
 * This Class is the Controller Class of the Application Acts as the entryPoint
 * For the HRS App.
 * 
 *
 */
public class HRSAppController {

	private static HRSAppInputProcessor hrsAppInputProcessor;
	private static IhrsAppHotelSelect hrsAppHotelSelect;
	
	public static void main(String[] args) {
		ReservationDTO reservationDTO= null;
		instantiateObjects();
		try{
			reservationDTO = hrsAppInputProcessor.doGetInput();
			String preferredHotel = hrsAppHotelSelect.selectbestHotelDeal(reservationDTO);
			System.out.println("The Best Deat For Your Choices is : "+preferredHotel);
		}catch(InputFormatException inputFormatException) {
			System.out.println(inputFormatException.getMessage());
		}catch (Exception exception) {
			exception.printStackTrace();
		}
		

	}
	private static void instantiateObjects() {
		hrsAppInputProcessor = new HRSAppInputProcessor();
		hrsAppHotelSelect = new HRSAppHotelSelect();
	}

}
