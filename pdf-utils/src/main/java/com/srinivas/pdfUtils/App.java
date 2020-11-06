package com.srinivas.pdfUtils;

import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public
class App {
  public static
  void main(String[] args)
  throws IOException {
    final String pdfsPath = "D:\\user personal\\Hospital\\all scans";
    File file = new File(pdfsPath);
    System.out.println("is directory?" + file.isDirectory());
    File[] files = file.listFiles();
    for (File file1 : files) {
      String fileName = file1.getAbsolutePath();
      String fileNameWithExtension = file1.getName();
      String fileNameWithoutExtension = fileNameWithExtension.replaceFirst("[.][^.]+$", "");
      String destinationPath = pdfsPath + "/" + fileNameWithoutExtension;
      File destinationFolder = new File(destinationPath);
      if(!destinationFolder.exists()) {
        System.out.println("Creating folder");
        destinationFolder.mkdir();
      }
      System.out.println("Path is " + fileName);
      System.out.println("splitting PDFs for " + file1.getName() + " in folder " + destinationFolder.getName());
      SplitPages.splitPages(fileName, destinationPath);
    }
  }
}
