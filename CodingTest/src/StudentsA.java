import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class StudentsA {
    public static void printStudentData(HashSet<Student> mStudents){
        for(Student s: mStudents)
            System.out.println(s.id + ", " + s.name + ", " + s.mark);
    }
    public static void main(String[] args) {
        try {
            HashSet<Student> students = new HashSet<>();
            FileReader fr = new FileReader("studentsA.csv");
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double mark = Double.parseDouble(parts[2]);
                Student student = new Student(name, id, mark);
                //TODO: (1) Add the student in the students hashset declared above
                students.add(student);

            }
            System.out.println("-----All The Students of A Section-----");
            printStudentData(students);

            //TODO: (2) Take another hashset, populate it in such a way that it can calculate
            // the total number of unique marks all the students have got and print it
                HashSet<Double> students2 = new HashSet<>();
                for (Student s:students){
                    students2.add(s.mark);
                }
                for (Double d:students2){
                    System.out.println(students2+" ");
                }




            System.out.println("-------Unique Marks All the Students Got-------");






            //TODO: (3) Print the total number of unique marks all the students have got using the new hashset
            System.out.println("------Total number of unique marks-------");



            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
