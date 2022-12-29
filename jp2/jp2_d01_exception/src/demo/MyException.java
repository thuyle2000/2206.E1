/*  user-defined exception  */
package demo;

public class MyException extends Exception{

    public MyException() {
        super("Loi sai : du lieu ko hop le !!!");
    }
    
    public MyException(String s){
        super(s);
    }
    
}
