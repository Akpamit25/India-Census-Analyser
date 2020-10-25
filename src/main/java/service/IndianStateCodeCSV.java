package service;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCSV {
	@CsvBindByName(column = "State")
	public String state;

	@CsvBindByName(column = "StateCode")
	public String stateCode;

	@Override
	public String toString() {
		return "IndiaCensusCSV{" + "State='" + state + ", StateCode='" + stateCode + '}';
	}

}
