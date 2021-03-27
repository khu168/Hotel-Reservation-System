/**
 * 
 */
package com.hrs.protect.service;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

import java.util.List;
import java.util.stream.Collectors;

import com.hrs.dao.HrsAppDAO;
import com.hrs.dao.IhrsAppDAO;
import com.hrs.dto.HotelDataDTO;
import com.hrs.dto.ReservationDTO;
import com.hrs.service.HRSAppCustomerService;
import com.hrs.service.IhrsAppCustomerService;

/**
 * @author kkumari
 *
 */
public class HRSAppHotelSelect implements IhrsAppHotelSelect {
	IhrsAppDAO hrsAppDAO = null;
	IhrsAppCustomerService hrsAppCustomerService = null;

	@Override
	public String selectbestHotelDeal(ReservationDTO reservationDTO) {
		hrsAppDAO = new HrsAppDAO();
		hrsAppCustomerService = new HRSAppCustomerService();
		
		List<HotelDataDTO> hotelDataDTOList = hrsAppDAO.loadHotelData();
		
		if(performNullAndSizeCheck(reservationDTO, hotelDataDTOList)) return "none";
		
		List<HotelDataDTO> hotelWithTarrif = hrsAppCustomerService.calculateRates(hotelDataDTOList, reservationDTO);
		return getHotelWithBestDeal(hotelWithTarrif);
	}

	private boolean performNullAndSizeCheck(ReservationDTO reservationDTO, List<HotelDataDTO> hotelDataDTOList) {
		return (reservationDTO == null && hotelDataDTOList.size()<0 );
			
	}

	public String getHotelWithBestDeal(List<HotelDataDTO> hotelWithTarrif) {
		if(hotelWithTarrif.size()==0)
			 return "none";
		hotelWithTarrif =	hotelWithTarrif.stream().sorted(comparing(HotelDataDTO ::getTotalTarrif)
			.thenComparing(reverseOrder(comparing(HotelDataDTO::getRating)))).collect(Collectors.toList());
	return hotelWithTarrif.get(0).getName();
	}

}
