import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

public class Produit extends FicheSortie {
	public Produit(String path) {
		super(path);
	}
	
	public void fillFiche(String[] infos) throws DocumentException {
		this.getDocument().add(new Paragraph());
		getDocument().add(new Paragraph("Code: "));
		getDocument().add(new Paragraph("Catégorie: "));
		getDocument().add(new Paragraph("Titre"));
		getDocument().add(new Paragraph("Description"));
		getDocument().add(new Paragraph("Montant HT: "));
		getDocument().add(new Paragraph("TVA: "));
		getDocument().add(new Paragraph("Montant TTC: "));
		super.closeDocument();
	}
}
