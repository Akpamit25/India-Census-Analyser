package com.Capgemini.IndiaCensus;

import static org.junit.Assert.*;
import exception.CensusAnalyserException;
import exception.CensusAnalyserException.ExceptionType;
import org.junit.Test;

public class StateCensusAnalyserTester {

	@Test
	public void loadDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusData.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			int numOfEntries = stateCensusAnalyser.loadCSVData(csvFilePath);
			assertEquals(36, numOfEntries);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void ForIncorrectFileShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateData.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForIncorrectFileTypeShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusData.txt";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_TYPE_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForFileWithIncorrectDelimiterShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusWrongDelimiter.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.DELIMITER_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForFileWithIncorrectHeaderShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusWrongHeader.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadCSVData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void loadStateCodeDataFromCsvShouldReturnCorrectNumberOfEntries() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCode.txt";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			int numOfEntries = stateCensusAnalyser.loadStateCodeData(csvFilePath);
			assertEquals(36, numOfEntries);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void ForIncorrectStateCodeFileShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeNoData";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForIncorrectStateCodeFileTypeShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCode.txt";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.FILE_TYPE_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForStateCodeFileWithIncorrectDelimiterShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeWrongDelimiter.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.DELIMITER_INCORRECT, e.getExceptionType());
		}
		
	}

	@Test
	public void ForStateCodeFileWithIncorrectHeaderShouldThrowException() {
		try {
			String csvFilePath = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeWrongHeader.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.loadStateCodeData(csvFilePath);
		} catch (CensusAnalyserException e) {
			assertEquals(ExceptionType.HEADER_INCORRECT, e.getExceptionType());
		}
		
	}

}
