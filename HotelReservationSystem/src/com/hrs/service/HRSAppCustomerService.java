/**
 * 
 */
package com.hrs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrs.dto.DateDTO;
import com.hrs.dto.HotelDataDTO;
import com.hrs.dto.ReservationDTO;

/**
 * This class does the actual processing and calculates the cheap rate hotel
 *
 */
public class HRSAppCustomerService implements IhrsAppCustomerService {

	@Override
	public List<HotelDataDTO> calculateRates(List<HotelDataDTO> hotelDataDTOList, ReservationDTO reservationDTO) {
		List<DateDTO> dateList = reservationDTO.getDateList();
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		List<HotelDataDTO> hotelWithTotalTarrif = null;
		dateList.forEach(obj -> {
			hotelDataDTOList.forEach(objHotel -> {
				organizeDataForTarrif( reservationDTO.getIsRewarded(), hotelswithTotalAmount, obj, objHotel);
			});
		});
		hotelWithTotalTarrif = new ArrayList<HotelDataDTO> (hotelswithTotalAmount.values());
		return hotelWithTotalTarrif ;
	}

	public void organizeDataForTarrif(Boolean isRewarded, Map<String, HotelDataDTO> hotelswithTotalAmount,
			DateDTO obj, HotelDataDTO objHotel) {
		
		if(objHotel == null)
			return;
		
		String dayType = obj.isWeekEnd() ? "weekend" : "weekday";
		Map<String, Long> customerTypeRates =isRewarded ? objHotel.getRewardsRates()
				: objHotel.getRegularRates();
		String hotelName = objHotel.getName();
		objHotel.setTotalTarrif(calculateTotalTarrif(hotelswithTotalAmount, dayType, customerTypeRates, hotelName));
		hotelswithTotalAmount.put(objHotel.getName(), objHotel);
	}

	public long calculateTotalTarrif(Map<String, HotelDataDTO> hotelswithTotalAmount, String dayType,
			Map<String, Long> customerTypeRates, String hotelName) {
		long tarrif;
		if (hotelswithTotalAmount.containsKey(hotelName)) {
			tarrif = hotelswithTotalAmount.get(hotelName).getTotalTarrif() + customerTypeRates.get(dayType);
		} else {
			tarrif = customerTypeRates.get(dayType);
		}
		return tarrif;
	}

}
