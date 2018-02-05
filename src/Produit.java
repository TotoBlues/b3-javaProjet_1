import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class Produit extends FicheSortie {
	public Produit(String path) {
		super(path);
	}
	
	public void fillFiche(String[] infos, float tva) throws DocumentException {
		try {
			this.getDocument().add(new Paragraph(infos[0]));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
	}
}
