
package demo;
import data.*;
public class TestStudent {
    public static void main(String[] args) {
        
        Student<String, String, String> sv1 = new Student<>("sv1","Nhat Minh","male","pass");
        
        Student<Integer, Boolean, Float> sv2 = new Student<>(100, "Viet Dong", Boolean.TRUE, 99.9F);
        
        Student<String, String, Integer> sv3 = new Student<>("sv2", "Huy", "male", 66);
        
        sv1.output();
        sv2.output();
        sv3.output();
        
        
    }
    
}
