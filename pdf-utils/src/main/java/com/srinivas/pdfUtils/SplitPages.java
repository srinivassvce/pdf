package com.srinivas.pdfUtils;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

public class SplitPages {
  public static void splitPages(String filePath, String destinationDir) throws IOException {

    //Loading an existing PDF document
    // Input the directory

    // Iterate over the files

    // create a folder with file name

    // Split the pdfs and save
    File file = new File(filePath);
    PDDocument document = PDDocument.load(file);

    //Instantiating Splitter class
    Splitter splitter = new Splitter();

    //splitting the pages of a PDF document
    List<PDDocument> Pages = splitter.split(document);

    //Creating an iterator
    Iterator<PDDocument> iterator = Pages.listIterator();

    //Saving each page as an individual document
    int i = 1;
    while(iterator.hasNext()) {
      PDDocument pd = iterator.next();
      pd.save(destinationDir + "/" + file.getName() + "-0"+i++ + ".pdf");
    }
    System.out.println("Multiple PDF’s created");
    document.close();
  }
}