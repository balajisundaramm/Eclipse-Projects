import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;


public class FirstPdf {
	
	public static void main(String[] args) {
		Document d=new Document(null);
		try {
			PdfWriter.getInstance(d, new FileOutputStream("Sample.pdf"));
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
