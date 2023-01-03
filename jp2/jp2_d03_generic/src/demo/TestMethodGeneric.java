
package demo;

public class TestMethodGeneric {

    public static void main(String[] args) {
        String[] x1 = {"Xuan", "Ha", "Thu", "Dong"};
        Integer[] x2 = {2,3,5,7,11,13,17};
        
        TestMethodGeneric p = new TestMethodGeneric();
        p.display(x1, "4 mua");
        p.display(x2, "so nguyen to");
        
        System.out.println("\n ===========\n");
        p.print(x1, "4 mua trong nam");
        p.print(x2, "cac so nguyen to");
        
    }
    
    private void display(String[] s, String title){
        System.out.printf("== danh sach %s == \n", title);
        for (String item : s) {
            System.out.println(item);
        }
    }
    
    private void display(Integer[] a, String title){
        System.out.printf("== danh sach %s == \n", title);
        for (var item : a) {
            System.out.println(item);
        }        
    }
    
    private<T> void print(T[] a, String title){
        System.out.printf("== danh sach %s == \n", title);
        for (T item : a) {
            System.out.println(item);
        } 
    }
}
