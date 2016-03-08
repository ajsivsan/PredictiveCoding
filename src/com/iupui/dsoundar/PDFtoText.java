package com.iupui.dsoundar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFtoText {
	static String path = "C:/Users/ajsiv/Documents/Predictive/PDFfiles";
	static String outpath = "C:/Users/ajsiv/Documents/Predictive/TextFiles";
	static BufferedWriter bw;
	static PDFTextStripper pdftext;
	static PDDocument pdf;
	static String data;
	
	public static String getfilename(String filename){
		
		return filename.substring(0,filename.lastIndexOf("."));
		
	}
	public static void main(String[] args) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for(File f : listOfFiles){
			String outfile = getfilename(f.getName());
			System.out.println("Converting the file " + outfile + ".pdf");
			try {
				bw = new BufferedWriter(new FileWriter(outpath + "/" + outfile + ".txt"));
				pdf = PDDocument.load(f);
				pdftext = new PDFTextStripper();
				data = pdftext.getText(pdf);
				bw.write(data);
			} catch (IOException e) {
				System.out.println("Unable to access the file " + f);;
			} finally{
					try {
						pdf.close();
					} catch (IOException e) {
						System.out.println("Failed to close the PDF document " + f);
					}
					try {
						bw.close();
					} catch (IOException e) {
						System.out.println("Failed to close the output file " + outfile);
					}
			}
		}
		System.out.println("Processing Completed!!!!");
	}

}
