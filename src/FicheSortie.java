import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class FicheSortie {
	private Document document = new Document();

	public FicheSortie(String path) {

		if (path == null)
			return;
		try {
			PdfWriter.getInstance(document,
                new FileOutputStream(path));
			document.open();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public Document getDocument() {
		return document;
	}
	
	public void closeDocument() {
		document.close();
	}
}