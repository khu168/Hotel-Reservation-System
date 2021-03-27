package com.hrs.service;

import java.util.List;

import com.hrs.dto.HotelDataDTO;
import com.hrs.dto.ReservationDTO;

public interface IhrsAppCustomerService {
	
	public List<HotelDataDTO> calculateRates(List<HotelDataDTO> hotelDataDTOList, ReservationDTO reservationDTO);

}
