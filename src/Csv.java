import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

public class Csv {
	private String csvPath = "./";
	private String categorieFilter = "./";
	private String etiquetteName = null;
	private String ficheName = null;
	private float tva = 20;
	private PdfFile pdfList;
	private Produit productList;

	public void readCsv(String file) throws IOException {
		pdfList = new PdfFile(etiquetteName);
		productList  = new Produit(ficheName);
		Path fichierCsv = Paths.get(file);
		try (Stream<String> linesFile = Files.lines(fichierCsv)) {
			linesFile.forEach(item -> {
				try {
					if (etiquetteName != null) {
						pdfList.fillFiche(ParsingCsv.returnCsv(item, categorieFilter), tva);
					}
					if (ficheName != null) {
						productList.fillFiche(ParsingCsv.returnCsv(item, categorieFilter), tva);
					}
				} catch (DocumentException e) {
					e.printStackTrace();
					System.exit(2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			pdfList.closeDocument();
			productList.closeDocument();
		}
		catch (IOException errIo) {
			System.out.println(errIo);
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

	public String getFicheName() {
		return ficheName;
	}
	
	public void setFicheName(String fichesName) {
		this.ficheName = fichesName;
	}

	public float getTva() {
		return tva;
	}

	public void setTva(String tva) {		
		this.tva = Float.parseFloat(tva);
	}

	// Main fonction
	public static void main(String [] args) {
		/* Csv fileCsv; */
		Param param = new Param(args);
		
		try {
			param.parserCmd();
			// fileCsv = param.getFileCsv();
		}
		catch(IOException e) {
			System.exit(2);
		}
		System.exit(0);
	}
}
