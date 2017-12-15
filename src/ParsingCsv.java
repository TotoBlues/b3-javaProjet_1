public class ParsingCsv extends Csv{

	public static String[] returnCsv(String lineCsv) {
		String[] result = lineCsv.split(";");
		return result;
	}
}