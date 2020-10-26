package csvBuilder;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder<E> {
	public Iterator<E> getCSVFileIterator(Reader reader,Class<E> csvClass) throws CSVBuilderException{
		CsvToBean<E> csvToBean=new CsvToBeanBuilder(reader).withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
		return csvToBean.iterator();
	}
}
