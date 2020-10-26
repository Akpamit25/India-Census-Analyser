package com.Capgemini.IndiaCensus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import exception.CensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import service.IndianCensusCSV;
import service.IndianStateCodeCSV;
import csvBuilder.*;

public class CSVStateCensus {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException, IOException {
		String[] csvFile = csvFilePath.split("[.]");
		if (!csvFile[1].equals("csv")) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		}

		checkDelimiter(csvFilePath);
		checkHeader(csvFilePath);
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<IndianCensusCSV> censusCsvIterator = csvBuilder.getCSVFileIterator(reader, IndianCensusCSV.class);
			return this.getCount(censusCsvIterator);

		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
		} catch (IllegalStateException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		}
	}

	public void checkDelimiter(String csvFilePath) throws CensusAnalyserException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			while (true) {
				String line = br.readLine();
				String[] Linecolumns = line.split(",");
				if (Linecolumns.length < 4) {
					throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
				}
			}
		} catch (NullPointerException | IOException e) {
		}

	}

	public void checkHeader(String csvFilePath) throws CensusAnalyserException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			String FirstLine = br.readLine();
			String[] columns = FirstLine.split(",");
			boolean isCorrect = columns[0].equals("State") && columns[1].equals("Population")
					&& columns[2].equals("AreaInSqKm") && columns[3].equals("DensityPerSqKm");
			if (!isCorrect) {
				throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_HEADER);
			}

		} catch (NullPointerException | IOException e) {
		}

	}

	public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException, IOException {
		String[] csvFile = csvFilePath.split("[.]");
		if (!csvFile[1].equals("csv")) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
		}

		checkDelimiterStateCode(csvFilePath);
		checkHeaderStateCode(csvFilePath);
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<IndianStateCodeCSV> censusCsvIterator = csvBuilder.getCSVFileIterator(reader,
					IndianStateCodeCSV.class);
			return this.getCount(censusCsvIterator);
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_PATH);
		}
	}

	public void checkDelimiterStateCode(String csvFilePath) throws CensusAnalyserException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			while (true) {
				String line = br.readLine();
				String[] Linecolumns = line.split(",");
				if (Linecolumns.length < 2) {
					throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER_TYPE);
				}
			}
		} catch (NullPointerException | IOException e) {
		}

	}

	public void checkHeaderStateCode(String csvFilePath) throws CensusAnalyserException {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(csvFilePath));
			String FirstLine = br.readLine();
			String[] columns = FirstLine.split(",");
			boolean isCorrect = columns[0].equals("State") && columns[1].equals("StateCode");
			if (!isCorrect) {
				throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_HEADER);
			}

		} catch (NullPointerException | IOException e) {
		}

	}

	private <E> int getCount(Iterator<E> iterator) {
		int numOfEntries = 0;
		Iterable<E> csvIterable = () -> iterator;
		numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numOfEntries;
	}

}