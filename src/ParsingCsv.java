public class ParsingCsv {

	public static String[] returnCsv(String lineCsv) {
		String[] result = lineCsv.split(";");
		for (int i = 0; i < 5; i++) {
			System.out.println(result[i]);
		}
		return result;
	}
}