/*
demo liet ke danh sach cac tap tin co ten mo rong (ext) theo yeu cau
 */
package demo;

import java.io.*;
import java.util.*;

public class ListFile {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("nhap ten thu muc: ");
        String path = sc.nextLine().trim();
        
        //tao doi tuong File, lien ket voi ten thu muc moi nhap
        File f = new File(path);
        
        //lay ds ten cua cac tap tin, co ten mo rong la [jpg]
        String[] fnames = f.list(new FileFilter("jpg"));
        
        //in ra so luong tap tin 
        System.out.printf(">> tim thay %d tap tin \n", fnames.length);
        
        //in ra ds cac tap tin co ten mo rong [jpg]
        for (String item : fnames) {
            System.out.println("\t"+ item );
        }
    }
}

class FileFilter implements FilenameFilter{
    public String ext;
    public FileFilter(String ext) {
        this.ext = "."+ext;
    }
    
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}


