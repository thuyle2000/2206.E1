/*
mo ta cau truc lop truu tuong Shape, bao gom :
- cac phuong thuc truu tuong: tinh dien tich va tinh chu vi
- override phuong thuc toString()
 */

package data;

public abstract class Shape {
    public abstract double area();
    public abstract double peripheral();
    public abstract void input();

    @Override
    public String toString() {
        return String.format("dien tich: %.2f, chu vi: %.2f", area(), peripheral());
    }

}
