package com.hrs.dto;

import java.util.HashMap;
import java.util.Map;

public class HotelDataDTO {
	
	private String name;
	private Integer rating;
	private Map<String,Long> regularRates;
	private Map<String,Long> rewardsRates;
	 private long totalTarrif;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param i the rating to set
	 */
	public void setRating(int i) {
		this.rating = i;
	}
	/**
	 * @return the regularRates
	 */
	public Map<String, Long> getRegularRates() {
		if(regularRates ==null) {
			return new HashMap<String, Long>();
		}
		return regularRates;
	}
	/**
	 * @param regularRates the regularRates to set
	 */
	public void setRegularRates(Map<String, Long> regularRates) {
		this.regularRates = regularRates;
	}
	/**
	 * @return the rewardsRates
	 */
	public Map<String, Long> getRewardsRates() {
		if(rewardsRates ==null) {
			return new HashMap<String, Long>();
		}
		return rewardsRates;
	}
	/**
	 * @param rewardsRates the rewardsRates to set
	 */
	public void setRewardsRates(Map<String, Long> rewardsRates) {
		this.rewardsRates = rewardsRates;
	}
	/**
	 * @return the totalTarrif
	 */
	public long getTotalTarrif() {
		return totalTarrif;
	}
	/**
	 * @param totalTarrif the totalTarrif to set
	 */
	public void setTotalTarrif(long totalTarrif) {
		this.totalTarrif = totalTarrif;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((regularRates == null) ? 0 : regularRates.hashCode());
		result = prime * result + ((rewardsRates == null) ? 0 : rewardsRates.hashCode());
		result = prime * result + (int) (totalTarrif ^ (totalTarrif >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HotelDataDTO other = (HotelDataDTO) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		if (regularRates == null) {
			if (other.regularRates != null) {
				return false;
			}
		} else if (!regularRates.equals(other.regularRates)) {
			return false;
		}
		if (rewardsRates == null) {
			if (other.rewardsRates != null) {
				return false;
			}
		} else if (!rewardsRates.equals(other.rewardsRates)) {
			return false;
		}
		if (totalTarrif != other.totalTarrif) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "HotelDataDTO [name=" + name + ", rating=" + rating + ", regularRates=" + regularRates
				+ ", rewardsRates=" + rewardsRates + ", totalTarrif=" + totalTarrif + "]";
	}
	
	
	
}
