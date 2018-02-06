import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.encoder.QRCode;

public class PdfFile extends FicheSortie {
	private String prix;
	private PdfPTable table;
	private int labelId = 0;
	private String code;
	private String name;

	public PdfFile(String path) {
		super(path);
	}

	public void createField(String[] tabInfos) {

	}
	
	public void fillFiche(String[] tabInfos, float tva) throws DocumentException, IOException, WriterException {
		this.prix = tabInfos[4];
		this.code = tabInfos[0].toString();
		this.name = tabInfos[1];
		QrCodeGenerator qrcode = new QrCodeGenerator();
		qrcode.createQrCode(code);
		BarcodeQRCode barcode = new BarcodeQRCode(code, 10, 1, null);
		Image codeQrImage = barcode.getImage();
        codeQrImage.scaleAbsolute(50, 5);
        
		if (this.labelId % 16 == 0) {
			this.getDocument().newPage();
			this.table = new PdfPTable(2);
		}
		try {
			
			PdfPCell cellQrCode = new PdfPCell();
			
			Paragraph priceProduct = new Paragraph(this.prix);
			Paragraph codeProduct = new Paragraph(this.code);
			Paragraph nameProduct = new Paragraph(this.name);
			
			PdfPCell cell = new PdfPCell();
			
			PdfPTable ttable = new PdfPTable(2);
			PdfPCell cellInfos = new PdfPCell();
			cellInfos.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellInfos.addElement(priceProduct);
			cellInfos.addElement(codeProduct);
			cellInfos.addElement(nameProduct);
			cellQrCode.addElement(codeQrImage);
			/*tcell1.addElement(qrcode);*/
			
			cellQrCode.setBorder(Rectangle.NO_BORDER);
			cellInfos.setBorder(Rectangle.NO_BORDER);
			
			float[] columnWidths = {0.5f, 2f};
			ttable.setWidths(columnWidths);
			ttable.addCell(cellQrCode);
			ttable.addCell(cellInfos);
			cell.addElement(ttable);
			this.table.addCell(cell);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		this.labelId++;
		if (this.labelId % 16 == 0) {
			this.getDocument().add(this.table);
		}
	}
}
