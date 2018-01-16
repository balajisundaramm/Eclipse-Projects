import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBorderArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDashPattern;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class SampleBroucher {
		public static final String DEST = "SampleBro.pdf";
		 
	    public static void main(String[] args) throws IOException, DocumentException {
	        File file = new File(DEST);
	        //file.getParentFile().mkdirs();
	        new SampleBroucher().createPdf(DEST);
	    }
	    public void createPdf(String dest) throws IOException, DocumentException {
	        Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
	        //PdfCanvas object = new PdfCanvas(pdfPage);  

	        document.open();
	        Paragraph paragraph=new Paragraph();
			paragraph.add("name");
			document.add(paragraph);	        PdfContentByte canvas = writer.getDirectContent();
	        //Graphics2D graphics2D = canvas.createGraphicsShapes(55, 87);
	        //Rectangle rect = new Rectangle(PageSize.A4);


	        //Graphics2D graphics2D = canvas.createGraphics(36, 54);
	        /*graphics2D.drawString("Hello World", 36, 54);
	        graphics2D.dispose(); */
	        canvas.rectangle(110, 710, 10, 40);
	        //canvas.Stroke();
	        Rectangle rec = new Rectangle(100,25);
	        Color color = Color.GREEN; 
	        canvas.circle(100, 720, 10);
	        canvas.circle(250, 720, 10);
	        canvas.circle(400, 720, 10);

	        	        
	        ColumnText ct = new ColumnText(canvas);
	        ct.setSimpleColumn(rec);
	        ct.addElement(new Paragraph("This is the text added in the rectangle"));
	        ct.go();
	 
	        rec.setBorder(Rectangle.BOX);
	        rec.setBorderWidth(1);
	        canvas.rectangle(rec);
	        document.close();
	}
}
