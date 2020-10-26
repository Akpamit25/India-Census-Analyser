package com.Capgemini.IndiaCensus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import exception.CensusAnalyserException;
import exception.CensusAnalyserException.ExceptionType;
import service.CSVStateCensus;
import csvBuilder.CSVBuilderException;
import csvBuilder.CSVBuilderFactory;
import csvBuilder.ICSVBuilder;
import service.*;

public class StateCensusAnalyser {
	
	public int loadCSVData(String csvFilePath) throws CensusAnalyserException{
		if(!this.checkFileExtention(csvFilePath)) {
			throw new CensusAnalyserException("File type is not correct",CensusAnalyserException.ExceptionType.FILE_TYPE_INCORRECT); 
		}
		
		checkForWrongDelimiter(csvFilePath);
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String headerLine=br.readLine();
			String[] headerLineValues=headerLine.split(",");
			if(!(headerLineValues[0].equals("State") && headerLineValues[1].equals("Population") && headerLineValues[2].equals("AreaInSqKm") && headerLineValues[3].equals("DensityPerSqKm")))
				  throw new CensusAnalyserException("File headers are not correct",ExceptionType.HEADER_INCORRECT);  
		}
		catch(IOException e) {
			
		}
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder=CSVBuilderFactory.createCSVBuilder();
			Iterator<CSVStateCensus> csvIterator = csvBuilder.getCSVFileIterator(reader, CSVStateCensus.class);
			return this.getCount(csvIterator);
		}
		catch(IOException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		catch(CSVBuilderException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		
	}
	
	public int loadStateCodeData(String csvFilePath) throws CensusAnalyserException{
		
		if(!this.checkFileExtention(csvFilePath)) {
			throw new CensusAnalyserException("File type is not correct",ExceptionType.FILE_TYPE_INCORRECT);
		}
		
		checkForWrongDelimiter(csvFilePath);
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String headerLine=br.readLine();
			String[] headerLineValues=headerLine.split(",");
			if(!(headerLineValues[0].equals("State Code") && headerLineValues[1].equals("TIN") && headerLineValues[2].equals("Population") && headerLineValues[3].equals("State Code")))
				  throw new CensusAnalyserException("File headers are not correct",ExceptionType.HEADER_INCORRECT); 
		}catch(IOException e) {
			
		}
		try {
			Reader reader=Files.newBufferedReader(Paths.get(csvFilePath));
			ICSVBuilder csvBuilder=CSVBuilderFactory.createCSVBuilder();
			Iterator<CSVStateCode> csvIterator = csvBuilder.getCSVFileIterator(reader,CSVStateCode.class);
			return this.getCount(csvIterator);
		}
		catch(IOException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		catch(CSVBuilderException e) {
			throw new CensusAnalyserException("File path is not correct",ExceptionType.FILE_INCORRECT);
		}
		
	}
	
	private <E> int getCount(Iterator<E> iterator) {
		int numOfEntries=0;
		Iterable<E> csvIterable = () -> iterator;
		numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numOfEntries;
	}
		
	private boolean checkFileExtention(String csvFilePath) {
		String[] filePathComponents=csvFilePath.split("[.]");
		if(!filePathComponents[filePathComponents.length-1].equals("csv")) 
			return false;
		return true;
	}
	private void checkForWrongDelimiter(String csvFilePath) throws CensusAnalyserException{
		try {
			BufferedReader br=Files.newBufferedReader(Paths.get(csvFilePath));
			String line;
			while((line=br.readLine())!=null) {
				  String[] lineComponents=line.split(",");
				  if(lineComponents.length!=4)
					  throw new CensusAnalyserException("This file is having incorrect delimiter",ExceptionType.DELIMITER_INCORRECT);
			}
		}
		catch(IOException e) {
			throw new CensusAnalyserException("This file path is incorrect",ExceptionType.FILE_INCORRECT);
		}
	}
	
}/****/
