package service;

import com.opencsv.bean.CsvBindByName;

public class IndianCensusCSV {
	@CsvBindByName(column = "State")
	public String state;

	@CsvBindByName(column = "Population")
	public int population;

	@CsvBindByName(column = "AreaInSqKm")
	public int areaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm")
	public int densityPerSqKm;

	@Override
	public String toString() {
		return "IndiaCensusCSV{" + "State='" + state + ", Population='" + population + ", AreaInSqKm='" + areaInSqKm
				+ ", DensityPerSqKm='" + densityPerSqKm + '}';
	}

}
/*******/