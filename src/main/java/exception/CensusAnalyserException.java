package exception;

public class CensusAnalyserException extends Exception {
	public enum ExceptionType {
		WRONG_FILE_PATH, WRONG_FILE_TYPE, WRONG_DELIMITER_TYPE, WRONG_HEADER;
	}

	ExceptionType type;

	public CensusAnalyserException(ExceptionType type) {

		this.type = type;
	}

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;

	}

	public ExceptionType getExceptionType() {
		return type;
	}

}
/*******/