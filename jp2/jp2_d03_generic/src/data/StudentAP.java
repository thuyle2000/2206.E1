/*
    dinh nghia cau truc generic cho doi tuong sinh vien AP (ke thua Student), bo sung them thuoc tinh project 
 */
package data;

public class StudentAP<X,Y,Z,V> extends Student<X, Y, Z>{
    public V project;

    public StudentAP() {
    }

    public StudentAP(V project, X id, String name, Y gender, Z mark) {
        super(id, name, gender, mark);
        this.project = project;
    }

    @Override
    public void output() {
        super.output(); 
        System.out.println("project: " + project);
    }
    
    
    
}
