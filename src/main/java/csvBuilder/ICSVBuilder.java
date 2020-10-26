package csvBuilder;

import java.io.Reader;
import java.util.Iterator;
import exception.CensusAnalyserException;

public interface ICSVBuilder<E> {
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CensusAnalyserException;
}
