public class ParsingCsv {

	public static String[] returnCsv(String lineCsv) {
		String[] result = lineCsv.split(";");
		return result;
	}

	public static void main(String args[]) {
		String[] resultLine = returnCsv(new String(
				"VT66556555;The Witcher 3;Incarnez un tueur de monstres et vivez son épopée !;jeu video;32,12"));

		String codeCsv = resultLine[0];
		String nomCsv = resultLine[1];
		String descriptionCsv = resultLine[2];
		String categorieCsv = resultLine[3];
		String prixCsv = resultLine[4] + "€";

	}
}