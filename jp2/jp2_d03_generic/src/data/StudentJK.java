/*
dinh nghia cau truc non-generic cho doi tuong sinh vien JK (ke thua Student), bo sung them thuoc tinh project 
 */
package data;
public class StudentJK extends Student<String, Boolean, Integer>{
    public String project;

    public StudentJK() {
    }

    public StudentJK(String project, String id, String name, Boolean gender, Integer mark) {
        super(id, name, gender, mark);
        this.project = project;
    }

    @Override
    public void output() {
        super.output(); 
        System.out.println("project: " + project);
    }
}
