import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class PdfFile extends FicheSortie {

	public PdfFile(String path) {
		super(path);
	}

	public void createField(String[] tabInfos) {
		
	}

	public void fillFiche(String[] tabInfos) throws DocumentException {
		try {
			this.getDocument().add(new Paragraph(tabInfos[0]));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
	}
}
