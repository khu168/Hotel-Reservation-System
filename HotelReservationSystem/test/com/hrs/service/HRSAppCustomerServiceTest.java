package com.hrs.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hrs.dto.DateDTO;
import com.hrs.dto.HotelDataDTO;
import com.hrs.dto.ReservationDTO;

public class HRSAppCustomerServiceTest {
	List<HotelDataDTO> hotelDataDTOList = null;
	HotelDataDTO hotelDataDTO = null;
	ReservationDTO reservationDTO = null;
	private List<DateDTO> dateList = null;

	HRSAppCustomerService hrsAppCustomerService = new HRSAppCustomerService();

	@Before
	public void setUp() throws Exception {
		hotelDataDTOList = new ArrayList<>();
		dateList = new ArrayList<>();
		getReservationDataPrepare();

	}

	@Test
	public void testOrganizeDataForTarrifRewarded() {
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		hrsAppCustomerService.organizeDataForTarrif(true, hotelswithTotalAmount, getDateDTO("16Mar2009(mon)", false),
				getHotelDTO(90L, 80L, 80L, 70L, "Bridgewood", 3));

		assertEquals("Bridgewood", hotelswithTotalAmount.get("Bridgewood").getName());
		assertEquals(70, hotelswithTotalAmount.get("Bridgewood").getTotalTarrif());
	}

	@Test
	public void testOrganizeDataForTarrifRegular() {
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		hrsAppCustomerService.organizeDataForTarrif(false, hotelswithTotalAmount, getDateDTO("16Mar2009(mon)", false),
				getHotelDTO(90L, 80L, 80L, 70L, "Lakewood", 3));

		assertEquals("Lakewood", hotelswithTotalAmount.get("Lakewood").getName());
		assertEquals(80, hotelswithTotalAmount.get("Lakewood").getTotalTarrif());
	}

	@Test
	public void testcalculateTotalTarrifWeekDay() {
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		long tarrif = hrsAppCustomerService.calculateTotalTarrif(hotelswithTotalAmount, "weekday",
				getRegularCustomerRates(90, 80), "Lakewood");

		assertEquals(80, tarrif);
	}

	@Test
	public void testcalculateTotalTarrifWeekEnd() {
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		long tarrif = hrsAppCustomerService.calculateTotalTarrif(hotelswithTotalAmount, "weekend",
				getRegularCustomerRates(90, 80), "Lakewood");

		assertEquals(90, tarrif);
	}

	@Test
	public void testcalculateTotalTarrifWeekEndaleadyHaveOne() {
		Map<String, HotelDataDTO> hotelswithTotalAmount = new HashMap<>();
		HotelDataDTO hotelDataDTO1 = getHotelDTO(90L, 80L, 80L, 70L, "Lakewood", 3);
		hotelDataDTO1.setTotalTarrif(90);
		hotelswithTotalAmount.put("Lakewood", hotelDataDTO1);
		long tarrif = hrsAppCustomerService.calculateTotalTarrif(hotelswithTotalAmount, "weekend",
				getRegularCustomerRates(90, 80), "Lakewood");

		assertEquals(180, tarrif);
	}

	@Test
	public void testCalculateRates() {
		hotelDataDTOList.add(getHotelDTO(90L, 80L, 80L, 70L, "Bridgewood", 4));
		List<HotelDataDTO> hotelWithTotalTarrif = hrsAppCustomerService.calculateRates(hotelDataDTOList,
				reservationDTO);
		assertEquals(140L, hotelWithTotalTarrif.get(0).getTotalTarrif());
	}

	@Test
	public void testCalculateRatesMultipleHotel() {
		hotelDataDTOList.add(getHotelDTO(90L, 80L, 80L, 70L, "Bridgewood", 3));
		hotelDataDTOList.add(getHotelDTO(100L, 90L, 70L, 60L, "Lakewood", 4));
		List<HotelDataDTO> hotelWithTotalTarrif = hrsAppCustomerService.calculateRates(hotelDataDTOList,
				reservationDTO);
		assertEquals(2, hotelWithTotalTarrif.size());
	}

	private HotelDataDTO getHotelDTO(long l, long m, long n, long o, String string, int i) {

		Map<String, Long> customerTypeRegularRates = getRegularCustomerRates(l, m);
		Map<String, Long> customerTypeRegewardRates = getRewardedCustomerRates(n, o);
		hotelDataDTO = new HotelDataDTO();
		hotelDataDTO.setName(string);
		hotelDataDTO.setRating(i);
		hotelDataDTO.setRegularRates(customerTypeRegularRates);
		hotelDataDTO.setRewardsRates(customerTypeRegewardRates);
		return hotelDataDTO;

	}

	private Map<String, Long> getRewardedCustomerRates(long n, long o) {
		Map<String, Long> customerTypeRegewardRates = new HashMap<String, Long>();
		customerTypeRegewardRates.put("weekend", n);
		customerTypeRegewardRates.put("weekday", o);
		return customerTypeRegewardRates;
	}

	private Map<String, Long> getRegularCustomerRates(long l, long m) {
		Map<String, Long> customerTypeRegularRates = new HashMap<String, Long>();
		customerTypeRegularRates.put("weekend", l);
		customerTypeRegularRates.put("weekday", m);
		return customerTypeRegularRates;
	}

	private void getReservationDataPrepare() {

		reservationDTO = new ReservationDTO();
		reservationDTO.setIsRewarded(true);
		dateList.add(getDateDTO("16Mar2009(mon)", false));
		dateList.add(getDateDTO("17Mar2009(tue)", false));
		reservationDTO.setDateList(dateList);

	}

	private DateDTO getDateDTO(String string, boolean b) {
		DateDTO dateDTO = new DateDTO();
		dateDTO.setDate(string);
		dateDTO.setWeekEnd(b);
		return dateDTO;
	}
}
