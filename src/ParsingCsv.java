public class ParsingCsv {

	public static String[] returnCsv(String lineCsv) {
		String[] result = lineCsv.split(";");
		return result;
	}
}