public class ParsingCsv extends Csv{

	public static String[] returnCsv(String lineCsv, String categorieFilter) {
		String[] result = lineCsv.split(";");
		if (categorieFilter.equals("./") == false) {
			if (categorieFilter.equals(result[3])) {
				return result;
			}
		}
		else {
			return result;
		}
		return null;
	}
}