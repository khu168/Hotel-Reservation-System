package com.hrs.read;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hrs.dto.DateDTO;
import com.hrs.dto.ReservationDTO;
import com.hrs.exceptions.InputFormatException;

public class HRSAppInputProcessorTest {

	HRSAppInputProcessor hrsAppInputProcessor = null;
	ReservationDTO reservationDTO = null;
	private List<DateDTO> dateList = null;

	@Before
	public void setUp() throws Exception {
		dateList = new ArrayList<>();
		getReservationDataPrepare();
		hrsAppInputProcessor = new HRSAppInputProcessor();
	}

	@Test
	public void testDoProcessInputNormal() throws InputFormatException {
		ReservationDTO reservationDTOOut = hrsAppInputProcessor
				.doProcessInput("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		assertEquals(reservationDTO.getIsRewarded(), reservationDTOOut.getIsRewarded());
		assertEquals(reservationDTO.getDateList().get(0).getDate(), reservationDTOOut.getDateList().get(0).getDate());
		assertEquals(reservationDTO.getDateList().get(1).getDate(), reservationDTOOut.getDateList().get(1).getDate());
		assertEquals(reservationDTO.getDateList().get(2).getDate(), reservationDTOOut.getDateList().get(2).getDate());
	}

	@Test(expected = InputFormatException.class)
	public void testDoProcessInputNormalException() throws InputFormatException {
		hrsAppInputProcessor.doProcessInput("");
	}

	@Test(expected = InputFormatException.class)
	public void testDoProcessInputNormalExceptioninNull() throws InputFormatException {
		hrsAppInputProcessor.doProcessInput(null);
	}

	@Test
	public void testIsWeekendTrue() {
		assertTrue(hrsAppInputProcessor.isWeekEnd("16Mar2009(sun)"));
	}

	@Test
	public void testIsWeekendFalse() {
		assertFalse(hrsAppInputProcessor.isWeekEnd("15Mar2009(mon)"));
	}

	private void getReservationDataPrepare() {

		reservationDTO = new ReservationDTO();
		reservationDTO.setIsRewarded(false);
		dateList.add(getDateDTO("16Mar2009(mon)", false));
		dateList.add(getDateDTO("17Mar2009(tues)", false));
		dateList.add(getDateDTO("18Mar2009(wed)", false));
		reservationDTO.setDateList(dateList);

	}

	private DateDTO getDateDTO(String string, boolean b) {
		DateDTO dateDTO = new DateDTO();
		dateDTO.setDate(string);
		dateDTO.setWeekEnd(b);
		return dateDTO;
	}
}
