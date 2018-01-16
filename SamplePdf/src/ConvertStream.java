import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

import javax.sound.midi.Synthesizer;

import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;

public class ConvertStream {
	public static final String SRC = "Test.pdf";
	public static final String DEST = "results/parse/stream%s";

	public static void main(String[] args) throws IOException {
		System.out.println("main starts");
	    File file = new File(DEST);
	    file.getParentFile().mkdirs();
	    new ConvertStream().parse(SRC, DEST);
		System.out.println("main ends");

	}

	public void parse(String src, String dest) throws IOException {
		System.out.println("in parse");
	    PdfReader reader = new PdfReader(src);
	    PdfObject obj;
	    for (int i = 1; i <= reader.getXrefSize(); i++) {
	        obj = reader.getPdfObject(i);
	        if (obj != null && obj.isStream()) {
	        	System.out.println("in if block");
	            PRStream stream = (PRStream)obj;
	            System.err.println(stream);
	            byte[] b;
	            try {
	                b = PdfReader.getStreamBytes(stream);
	            }
	            catch(UnsupportedPdfException e) {
	            	e.printStackTrace();
	                b = PdfReader.getStreamBytesRaw(stream);
	            }
	            FileOutputStream fos = new FileOutputStream(String.format(dest, i));
	            fos.write(b);
	            fos.flush();
	            fos.close();
	        }
	    }
	    System.out.println("parse ends");
	}
}
