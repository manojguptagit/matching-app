package com.barclays.nebula.matcher.vo;

import com.poiji.annotation.ExcelCellName;

public class ExcelModelVO {

	@ExcelCellName("SDS Address")
	private String sdsAddress;

	@ExcelCellName("FISS Address")
	private String fissAddress;

	@ExcelCellName("Score")
	private Float matchingScore;

	/**
	 * @return the fissAddress
	 */
	public String getFissAddress() {
		return this.fissAddress;
	}

	/**
	 * @return the matchingScore
	 */
	public Float getMatchingScore() {
		return this.matchingScore;
	}

	/**
	 * @return the sdsAddress
	 */
	public String getSdsAddress() {
		return this.sdsAddress;
	}

	/**
	 * @param fissAddress
	 *            the fissAddress to set
	 */
	public void setFissAddress(String fissAddress) {
		this.fissAddress = fissAddress;
	}

	/**
	 * @param matchingScore
	 *            the matchingScore to set
	 */
	public void setMatchingScore(Float matchingScore) {
		this.matchingScore = matchingScore;
	}

	/**
	 * @param sdsAddress
	 *            the sdsAddress to set
	 */
	public void setSdsAddress(String sdsAddress) {
		this.sdsAddress = sdsAddress;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcelModelVO [sdsAddress=" + this.sdsAddress + ", fissAddress=" + this.fissAddress + ", matchingScore="
				+ this.matchingScore + "]";
	}
}
