package com.Capgemini.IndiaCensus;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import exception.CensusAnalyserException;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusData.csv";
	private static final String WRONG_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensus.csv";
	private static final String WRONG_TYPE_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusData.txt";
	private static final String WRONG_DELIMITER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusWrongDelimiter.csv";
	private static final String WRONG_HEADER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCensusWrongHeader.csv";

	private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCode.csv";
	private static final String STATE_CODE_WRONG_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeData.csv";
	private static final String STATE_CODE_WRONG_TYPE_FILE_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCode.txt";
	private static final String STATE_CODE_WRONG_DELIMITER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeWrongDelimiter.csv";
	private static final String STATE_CODE_WRONG_HEADER_PATH = "D:\\Capg_Bridgelabz\\IndiaCensus\\StateCodeWrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			int numOfRecords = csvStateCensus.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);

		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongFileTypeShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongDelimiterShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_DELIMITER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWithWrongHeaderShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaCensusData(WRONG_HEADER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_HEADER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeCSVFileReturnsCorrectRecords() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			int numOfRecords = csvStateCensus.loadIndiaStateCodeData(INDIA_STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(36, numOfRecords);

		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeWithWrongFileShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaStateCodeData(STATE_CODE_WRONG_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongFileTypeShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaStateCodeData(STATE_CODE_WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongDelimiterShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaStateCodeData(STATE_CODE_WRONG_DELIMITER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianStateCodeDataWithWrongHeaderShouldThrowException() {
		try {
			CSVStateCensus csvStateCensus = new CSVStateCensus();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			csvStateCensus.loadIndiaStateCodeData(STATE_CODE_WRONG_HEADER_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(e.getExceptionType(), CensusAnalyserException.ExceptionType.WRONG_HEADER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}