package csvBuilder;

public class CSVBuilderException extends Exception{
	public enum ExceptionType{
		UNABLE_TO_PARSE,CSV_ERROR};
	
	ExceptionType type;
	
	CSVBuilderException(String message,ExceptionType type){
		super(message);
		this.type=type;
	}
	
	public ExceptionType getExceptionType() {
		return this.type;
	}
}