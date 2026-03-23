package experiment2;
import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + marks;
    }
}


public class studentrecord {
	public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Rutuja", 90));
        students.add(new Student(101, "Sakshi", 85));
        students.add(new Student(102, "Snehal", 78));
        students.add(new Student(104, "Shreya", 88));

        System.out.println("Original List:");
        for(Student s : students) {
            System.out.println(s);
        }

        // Sorting by ID
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.id - s2.id;
            }
        });

        System.out.println("\nSorted by ID:");
        for(Student s : students) {
            System.out.println(s);
        }

        // Sorting by Marks
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks;
            }
        });

        System.out.println("\nSorted by Marks (Descending):");
        for(Student s : students) {
            System.out.println(s);
        }
    }
}



