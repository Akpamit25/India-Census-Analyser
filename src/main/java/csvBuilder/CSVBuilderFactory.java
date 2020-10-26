package csvBuilder;

public class CSVBuilderFactory {
	public static ICSVBuilder createCSVBuilder() {
		return (ICSVBuilder) new OpenCSVBuilder();
	}
}
