package service;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {
	@CsvBindByName(column="State Name")
	public String state;
	@CsvBindByName(column="TIN")
	public int tin;
	@CsvBindByName(column="Population")
	public int population;
	@CsvBindByName(column="State Code")
	public int stateCode;
	
	@Override
	public String toString() {
		return "IndiaCensusCSV{" + "State='" + state + ", Tin='" + tin + ",Population='" + population + 
				", State Code='" + stateCode + '}';
	}
}
