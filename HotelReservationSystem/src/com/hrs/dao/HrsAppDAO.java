/**
 * 
 */
package com.hrs.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hrs.dto.HotelDataDTO;

/**
 * @author kkumari
 *
 */
public class HrsAppDAO implements IhrsAppDAO {
	@Override
	public List<HotelDataDTO> loadHotelData() {
		List<HotelDataDTO> hotelDataDTOList = new ArrayList<>();
		try {
			Object hrsDataObj = new JSONParser().parse(new FileReader("resources/com/hotels/rates/hrs.json"));
			JSONArray hrsDataArray = (JSONArray) hrsDataObj;

			for (int i = 0; i < hrsDataArray.size(); i++) {

				HotelDataDTO hotelDataDTO = setJSONData((JSONObject) hrsDataArray.get(i));
				hotelDataDTOList.add(hotelDataDTO);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return hotelDataDTOList;
	}

	public HotelDataDTO setJSONData(JSONObject jsonObj) {
		if(jsonObj == null) 
			return null;

		HotelDataDTO hotelDataDTO = new HotelDataDTO();
		Map<String, Long> regularRates = new HashMap<>();
		Map<String, Long> rewardsRates = new HashMap<>();

		JSONObject regularJsonObj = (JSONObject) jsonObj.get("regularRates");
		JSONObject rewardsRatesObj = (JSONObject) jsonObj.get("rewardsRates");
		
		hotelDataDTO.setName((String) jsonObj.get("name"));
		rewardsRates.put("weekend", (Long) rewardsRatesObj.get("weekend"));
		rewardsRates.put("weekday", (Long) rewardsRatesObj.get("weekday"));
		regularRates.put("weekend", (Long) regularJsonObj.get("weekend"));
		regularRates.put("weekday", (Long) regularJsonObj.get("weekday"));
		hotelDataDTO.setRating(((Long) jsonObj.get("rating")).intValue());
		hotelDataDTO.setRegularRates(regularRates);
		hotelDataDTO.setRewardsRates(rewardsRates);

		return hotelDataDTO;
	}

}
