import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class Produit extends FicheSortie {
	public Produit(String path) {
		super(path);
	}
	
	public void fillFiche(String[] infos) throws DocumentException {
		this.getDocument().add(new Paragraph());
	}
}
