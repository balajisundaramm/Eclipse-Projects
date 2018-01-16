import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class FileInformation {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document d=new Document();
		//PdfWriter writer=new PdfWriter(new FileOutputStream("FileInfo.pdf"));
		PdfWriter writer=writer.getInstance(d, new FileOutputStream("FileInfo.pdf"));
		String fileName="/Java_workspace/SamplePdf";
		inspect(writer, fileName);
		
	}
	public static void inspect(PrintWriter writer, String fileName) throws IOException {
		PdfReader reader= new PdfReader(fileName);
		writer.println(fileName);
		writer.println("No of pages:"+reader.getNumberOfPages());
		Rectangle rec=reader.getPageSize(1);
		writer.println("size of the page is->"+rec.getTop()+","+rec.getBottom()+","+rec.getLeft()+","+rec.getRight());
		writer.flush();
		reader.close();
	
	}
}
