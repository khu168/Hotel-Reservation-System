package com.hrs.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.hrs.dto.HotelDataDTO;

public class HrsAppDAOTest {

	List<HotelDataDTO> hotelDataDTOList = null;
	HrsAppDAO hrsAppDAO = new HrsAppDAO();

	@Test
	public void testLoadHotelData() {
		hotelDataDTOList = hrsAppDAO.loadHotelData();
		assertEquals(3, hotelDataDTOList.size());
	}

	
	@Test
	public void testReadUpdateData() {
		JSONObject jsonObj = new JSONObject();
		prepareData(jsonObj);
		HotelDataDTO hotelDataDTO = hrsAppDAO.setJSONData(jsonObj);
		assertEquals("Bridgewood", hotelDataDTO.getName());
		assertEquals(3, hotelDataDTO.getRating());
		
	}

	@Test
	public void testReadUpdateDataNullCheck() {
		JSONObject jsonObj =null;
		HotelDataDTO hotelDataDTO = hrsAppDAO.setJSONData(jsonObj);
		assertEquals(null, hotelDataDTO);
		
	}
	@SuppressWarnings("unchecked")
	private void prepareData(JSONObject jsonObj) {
		jsonObj.put("name", "Bridgewood");
		jsonObj.put("rating", 3L);
		JSONObject regularJsonObj = new JSONObject();
		regularJsonObj.put("weekday", 80L);
		regularJsonObj.put("weekend", 90L);
		jsonObj.put("regularRates", regularJsonObj);
		JSONObject rewardsRatesObj = new JSONObject();
		rewardsRatesObj.put("weekday", 70L);
		rewardsRatesObj.put("weekend", 80L);
		jsonObj.put("rewardsRates", regularJsonObj);
	}
}
