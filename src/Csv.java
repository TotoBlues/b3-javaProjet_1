import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Csv {
	private String csvPath = "../";
	private String categorieFilter = "../";
	private String etiquetteName = "../";
	private String fichesName = "../";
	private float price;
	private float tva = 20;
	
	public void readCsv(String file) {
		Path fichierCsv = Paths.get(file); // file descriptor
		try (Stream<String> linesFile = Files.lines(fichierCsv)) {
			linesFile.forEach(item -> ParsingCsv.returnCsv(item));
		}
		catch (IOException e)
		{
			System.out.println(e);
		}	
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	public String getCategorieFilter() {
		return categorieFilter;
	}

	public void setCategorieFilter(String categorieFilter) {
		this.categorieFilter = categorieFilter;
	}

	public String getEtiquetteName() {
		return etiquetteName;
	}

	public void setEtiquetteName(String etiquetteName) {
		this.etiquetteName = etiquetteName;
	}

	public String getFichesName() {
		return fichesName;
	}

	public void setFichesName(String fichesName) {
		this.fichesName = fichesName;
	}

	public float getTva() {
		return tva;
	}

	public void setTva(String tva) {		
		this.tva = Float.parseFloat(tva);
		setPrice();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice() {
		this.price = price + (price * tva / 100);
	}

	// Main fonction
	public static void main(String [] args) {
		Param param = new Param(args);
		
		param.parserCmd();
	}
}
