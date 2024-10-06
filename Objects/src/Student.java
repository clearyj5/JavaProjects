
// this: to refer to the current class instance variable

// Each argument to the constructor shadows one of the object's
// fields — inside the constructor id is a local copy of the
// constructor's first argument. To refer to the Student field id,
// the constructor must use this.id

public class Student
{
    int id;
    String name;

    Student(int id, String name)
    {
	this.id = id;
	this.name = name;
    }

    public void display()
    {
	System.out.println(id + " " + name);
    }

    public static void main(String[] args)
    {
        Student s = new Student(123, "Joe");
        s.display();
    }
}