package org.phish.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	/*private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
*/
			
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				
				
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
			
				File dir = new File(rootPath + File.separator + "tmpFiles");
				/*
				if (!dir.exists())*/
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				
				
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				
				stream.close();

			/*	logger.info("Server File Location="
						+ serverFile.getAbsolutePath());*/
				
				//make pdf into txt file
				PDFToTXT(name,serverFile,bytes);
				
				//take txt file and create a new one with only learning outcomes
				
				//TXTToTXT( name, serverFile);				 				
				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
		
		
		
		
	}

	
	public void PDFtoDOCX(String name,File dir,byte[] bytes) throws IOException {
		
		XWPFDocument doc = new XWPFDocument();
		
		PdfReader reader = new PdfReader(bytes);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		    TextExtractionStrategy strategy = null;
			try {
				strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String text = strategy.getResultantText();
		    XWPFParagraph p = doc.createParagraph();
		    XWPFRun run = p.createRun();
		    run.setText(text);
		    run.addBreak(BreakType.PAGE);
		}
		FileOutputStream out = new FileOutputStream(dir
				+ ".docx");
		//FileOutputStream out = new FileOutputStream(serverFile+".docx");
		doc.write(out);
		// Close all open files
		
	}
	
public void PDFToTXT(String name,File file,byte[] bytes) throws IOException {
		
	File f = new File(file.getAbsolutePath());
	String parsedText;
	PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
	parser.parse();
		
	COSDocument cosDoc = parser.getDocument();
	PDFTextStripper pdfStripper = new PDFTextStripper();
	//pdfStripper.setLineSeparator(" ");//removes spaces
	PDDocument pdDoc = new PDDocument(cosDoc);
	parsedText = pdfStripper.getText(pdDoc);
		
	
	Scanner s = null;
	String output="";
	try {
        Scanner scanner = new Scanner(parsedText);
       
        boolean tokenFound = false;
        while (scanner.hasNext()) {
            String line = scanner.next();
            //line, not scanner.
            if (line.equals("LO1")) //tag in the txt to locate position
            {
                tokenFound = true;
            } else if (line.equals("TEACHING")) {
                tokenFound = false;
            }

            if ((tokenFound) && (!line.equals("LO1 "))) {
                output+=line+" ";
              
            }
            
            
        }
      
    } catch (Exception e) {
        return;
    }
	
	
	PrintWriter pw = new PrintWriter(file +".txt");
	pw.print(output);
	pw.close();
	
	}


public void TXTToTXT(String name,File file) throws IOException {
	String all="";
/*	try (Scanner scanner = new Scanner(new File( file.getAbsolutePath()+".txt"));) {
	    while(scanner.hasNextLine())
	     all = scanner.nextLine();
	}*/
	
	BufferedReader br = new BufferedReader (
			new FileReader(file.getAbsolutePath()+".txt"));
	
	
	
 
	

	
	
	 String start ="LEARNING";
	 String end = "teaching";
	 String newTxt="";
	
	//newTxt.substring(all.indexOf(start));
	
	PrintWriter pw = new PrintWriter(file+"new"+".txt");
	pw.print(all);
	pw.close();
	
	
	
	}







}
