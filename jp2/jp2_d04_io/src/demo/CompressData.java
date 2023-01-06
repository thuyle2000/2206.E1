/*  Demo nen du lieu  */
package demo;

import java.util.zip.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompressData {

    public static void main(String[] args) {
        String s = "The Java Path interface is part of the Java NIO 2 update which Java NIO received in Java 6 and Java 7. The Java Path interface was added to Java NIO in Java 7. The Path interface is located in the java.nio.file package, so the fully qualified name of the Java Path interface is java.nio.file.Path.";

        Deflater d = new Deflater();
        Inflater f = new Inflater();

        try {
            d.setInput(s.getBytes("UTF-8"));
            d.finish();

            byte[] buffer = new byte[1024];
            int size = d.deflate(buffer);

            System.out.println("Original String: ");
            System.out.println(s);
            System.out.println("Original size: " + s.length());
            System.out.println("===========================\n");
            System.out.println("Compressed String: ");
            System.out.println(new String(buffer));
            System.out.println("Compressed size: " + size);

            f.setInput(buffer, 0, size);
            f.finished();
            byte[] output = new byte[1024];
            int out_size = f.inflate(output);
            
            System.out.println("===========================\n");
            System.out.println("Depressed String: ");
            System.out.println(new String(output, "UTF-8"));
            System.out.println("Depressed size: " + out_size);

        } catch (UnsupportedEncodingException | DataFormatException ex) {
            Logger.getLogger(CompressData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
