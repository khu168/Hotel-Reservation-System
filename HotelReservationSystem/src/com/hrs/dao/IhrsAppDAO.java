package com.hrs.dao;

import java.util.List;

import com.hrs.dto.HotelDataDTO;

public interface IhrsAppDAO {
	
	public List<HotelDataDTO> loadHotelData();

}
