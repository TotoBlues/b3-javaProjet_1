public class ParsingCsv {

	public static String[] returnCsv(String lineCsv) {
		System.out.println(lineCsv);
		String[] result = lineCsv.split(";");
		return result;
	}
}