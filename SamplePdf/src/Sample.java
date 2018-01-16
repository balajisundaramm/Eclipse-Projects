import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.Rectangle;


public class Sample {
	public static final String RESULT = "modified_testing.pdf";

	public static void main(String[] args) {
		System.out.println("Main");
		Document d=new Document();
		Rectangle rectangle=new Rectangle(100,200);
		/*rectangle=new Rectangle(Utilities.inchesToMillimeters(100),
				Utilities.inchesToMillimeters(100));
		rectangle =new Rectangle(PageSize.A4);*/
		d.setPageSize(rectangle);
		Font[] font= {
			new Font(Font.FontFamily.TIMES_ROMAN,15, Font.BOLD, 
					new BaseColor(240, 0, 0)),
			new Font(Font.FontFamily.COURIER,25, Font.BOLDITALIC, 
					new BaseColor(0, 0, 0)),
			new Font(Font.FontFamily.ZAPFDINGBATS,10, Font.ITALIC, 
					new BaseColor(0, 0, 240)),
			new Font(Font.FontFamily.HELVETICA,35, Font.UNDERLINE, 
					new BaseColor(0, 0, 0))

		};
		try {
			PdfWriter.getInstance(d, new FileOutputStream("Fiest.pdf"));
			d.open();
			Paragraph paragraph=new Paragraph();
			paragraph.add("Welcome to the Pdf file.");
			d.add(paragraph);
			for (int i = 0; i < font.length; i++) {
				Paragraph p=new Paragraph("hi",font[i]);
				d.add(p);
			}
			d.add(new Paragraph("Hello World", FontFactory.getFont(FontFactory.COURIER_BOLD,12,Font.BOLD,BaseColor.CYAN)));
			d.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main ended");
	}
}
