import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PageInfoWeb {
	public static final String RESULT = "6.pdf";

	
	public static void main(String[] args) throws Exception {
		System.out.println("in main of web");
		new PageInfoWeb().editPdf();
		/*Sample.main(args);
		// Use old examples to create PDFs
		
		 * HelloWorldLandscape1.main(args); HelloWorldLandscape2.main(args);
		 * MovieTemplates.main(args); Hero1.main(args);
		 
		// Inspecting PDFs
		PrintWriter writer = new PrintWriter(new FileOutputStream(RESULT));*/
		/*
		 * inspect(writer, HelloWorldLandscape1.RESULT); inspect(writer,
		 * HelloWorldLandscape2.RESULT); inspect(writer, MovieTemplates.RESULT);
		 */
		//inspect(writer, Sample.RESULT);
		// inspect(writer,RESULT);
		/*writer.close();*/
		System.out.println("main ended...");
	}

	/**
	 * Inspect a PDF file and write the info to a txt file
	 * 
	 * @param writer
	 *            Writer to a text file
	 * @param filename
	 *            Path to the PDF file
	 * @throws IOException
	 */
	public static void inspect(PrintWriter writer, String filename) throws IOException {
		System.out.println("in inspect of web");
		PdfReader reader = new PdfReader(filename);
		writer.println(filename);
		writer.print("Number of pages: ");
		writer.println(reader.getNumberOfPages());
		Rectangle mediabox = reader.getPageSize(1);
		writer.print("Size of page 1: [");
		writer.print(mediabox.getLeft());
		writer.print(',');
		writer.print(mediabox.getBottom());
		writer.print(',');
		writer.print(mediabox.getRight());
		writer.print(',');
		writer.print(mediabox.getTop());
		writer.println("]");
		writer.print("Rotation of page 1: ");
		writer.println(reader.getPageRotation(1));
		writer.print("Page size with rotation of page 1: ");
		writer.println(reader.getPageSizeWithRotation(1));
		writer.print("Is rebuilt? ");
		writer.println(reader.isRebuilt());
		writer.print("Is encrypted? ");
		writer.println(reader.isEncrypted());
		writer.println();
		writer.flush();
		reader.close();
	}

	public void editPdf() throws Exception {
		System.out.println("df");
		PdfReader reader = new PdfReader(RESULT); // input PDF
		//BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

		// loop on pages (1-based)
		/* for (int i=1; i<=reader.getNumberOfPages(); i++){ */

		// get object for writing over the existing content;
		// you can also use getUnderContent for writing in the bottom layer
		/* PdfContentByte over = stamper.getOverContent(i); */

		/*
		 * // write text over.beginText(); over.setFontAndSize(bf, 10); // set font and
		 * size over.setTextMatrix(107, 740); // set x,y position (0,0 is at the bottom
		 * left) over.showText("I can write at page " + i); // set text over.endText();
		 * 
		 * // draw a red circle over.setRGBColorStroke(0xFF, 0x00, 0x00);
		 * over.setLineWidth(5f); over.ellipse(250, 450, 350, 550); over.stroke();
		 */
		PdfDictionary dict = reader.getPageN(1);
		PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
		System.out.println("object-->"+object);
		if (object instanceof PRStream) {
			
			PRStream stream = (PRStream) object;
			System.out.println("Stream-->"+stream);
			byte[] data = PdfReader.getStreamBytes(stream);
			//System.out.println("fghj");
			String eredeti = "XXXXXXXX";
			final String s = new String(eredeti.getBytes());
			//System.out.println(new String(data));
			//System.out.println(s);
			stream.setData(new String(data).replace("Adjustment", s).getBytes("ISO-8859-2"));
			//stream.setData(new String(data).replace("Job Title", s).getBytes());
			//stream.setData(new String(data).replace("George", new String("gokul".getBytes())).getBytes());
			Document d=new Document();
			d.open();
			Paragraph paragraph=new Paragraph();
			paragraph.add("Welcome to the Pdf file.");
			d.add(paragraph);
			d.close();
		}
		else {
			System.out.println("the given file is not PRStream");
		}
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("modified_" + RESULT)); // output PDF
	    stamper.close();

	   Paragraph preface = new Paragraph();
	    preface.setAlignment(Element.ALIGN_CENTER);

	    reader.close();
	}
}
