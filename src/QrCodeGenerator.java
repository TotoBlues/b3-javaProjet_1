import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodeGenerator {
	public static void createQrCode(String code) throws IOException, WriterException {
		String content = code;
		String filename = "qrcode.png";
		BufferedImage image = generate(content, 150);
		ImageIO.write(image, "PNG", new File(filename));
	}

private static BufferedImage generate(String content, int sizeInPixels) throws WriterException {
	QRCodeWriter qrWriter = new QRCodeWriter();
	Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, sizeInPixels, sizeInPixels);
	return MatrixToImageWriter.toBufferedImage((BitMatrix) matrix);
	}
}