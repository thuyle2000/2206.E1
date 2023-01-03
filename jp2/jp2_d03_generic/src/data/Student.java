/*
 xay dung cau truc generic cho doi tuong sinh vien, bao gom cac cot:
    id, name, gender va mark
 */
package data;
public class Student< A, B, C> {
    public A id;
    public String name;
    public B gender;
    public C mark;

    public Student() {
    }

    public Student(A id, String name, B gender, C mark) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mark = mark;
    }
    
    public void output(){
        System.out.println("\n Thong tin sinh vien ");
        System.out.println(" id: "+ id);
        System.out.println(" ho ten: " + name);
        System.out.println(" gioi tinh: " + gender);
        System.out.println(" diem ket qua: " + mark);
    }
}
