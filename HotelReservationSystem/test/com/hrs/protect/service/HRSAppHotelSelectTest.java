package com.hrs.protect.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hrs.dto.HotelDataDTO;

public class HRSAppHotelSelectTest {
	List<HotelDataDTO> hotelWithTarrif = null;
	HotelDataDTO hotelDataDTO = null;
	HRSAppHotelSelect hRSAppHotelSelect = null;

	@Before
	public void setUp() throws Exception {
		hotelWithTarrif = new ArrayList<HotelDataDTO>();
		hRSAppHotelSelect = new HRSAppHotelSelect();

	}

	private void prepareData() {
		hotelDataDTO = new HotelDataDTO();
		hotelDataDTO.setName("Bridgewood");
		hotelDataDTO.setRating(3);
		hotelDataDTO.setTotalTarrif(330);
		hotelWithTarrif.add(hotelDataDTO);
		hotelDataDTO = new HotelDataDTO();
		hotelDataDTO.setName("Lakewood");
		hotelDataDTO.setRating(4);
		hotelDataDTO.setTotalTarrif(330);
		hotelWithTarrif.add(hotelDataDTO);
	}

	@Test
	public void testGetHotelWithBestDeal() {
		prepareData();
		String hotelName = hRSAppHotelSelect.getHotelWithBestDeal(hotelWithTarrif);
		assertEquals( "Lakewood",hotelName);
	}

	@Test
	public void testGetHotelWithBestDealSizeCheck() {
		hotelWithTarrif = new ArrayList<HotelDataDTO>();
		String hotelName = hRSAppHotelSelect.getHotelWithBestDeal(hotelWithTarrif);
		assertEquals("none",hotelName);
	}

	@Test
	public void testGetHotelWithBestDealWithMinimumPrice() {
		prepareData();
		hotelDataDTO = new HotelDataDTO();
		hotelDataDTO.setName("Ridgewood");
		hotelDataDTO.setRating(4);
		hotelDataDTO.setTotalTarrif(220);
		hotelWithTarrif.add(hotelDataDTO);
		String hotelName = hRSAppHotelSelect.getHotelWithBestDeal(hotelWithTarrif);
		assertEquals( "Ridgewood",hotelName);
	}
}
