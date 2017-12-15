import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFfile {
	public static final String chemin = "/Users/pierregaly/Desktop/B°3/Java/Projet JAVA/pfdtest.pdf";

	public static void main(String[] args) throws DocumentException, IOException {
		
		Document ficheProduit = new Document();
		
		/*String code = "Code: "+resultat[0];
		String description = "Descritpion"+resultat[1];
		String catégories = "Catégorie: "+resultat[2];
		String titre = "Titre: "+resultat[3];
		*/
		
		try {
			PdfWriter.getInstance(ficheProduit, new FileOutputStream(chemin));
			ficheProduit.open();
			ficheProduit.add(new Paragraph("Code: "));
			ficheProduit.add(new Paragraph("Catégorie: "));
			ficheProduit.add(new Paragraph("Titre"));
			ficheProduit.add(new Paragraph("Description"));
			ficheProduit.add(premierTableau());
			ficheProduit.add(new Paragraph("Montant HT: "));
			ficheProduit.add(new Paragraph("TVA: "));
			ficheProduit.add(new Paragraph("Montant TTC: "));
			
		}catch (DocumentException de)
		{
			de.printStackTrace();
		}catch (IOException ioe)
		{
			ioe.printStackTrace();
		}finally {
			//fermeture de document
			ficheProduit.close();
		}

	}
	
	public static PdfPTable premierTableau()
	  {
	      //On créer un objet table dans lequel on intialise sa taille.
	      PdfPTable table = new PdfPTable(3);
	      
	      //On créer l'objet cellule.
	      PdfPCell cell;
	      table.setSpacingBefore(100f);
	      table.setSpacingAfter(10f);
	      
	      
	      cell = new PdfPCell(new Phrase("Description du produit"));
	      cell.setColspan(3);
	      cell.setPadding(55);
	      table.addCell(cell);
	 
	 
	      //contenu du tableau.
	      table.addCell("Colonne 1; Cellule 1");
	      
	      
	      return table;  
	  }

}
