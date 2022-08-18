class Student implements Comparable<Student>{
    String name;
    int id;
    double mark;
    public Student(String name, int id, double mark) {
        this.name = name;
        this.id = id;
        this.mark = mark;
    }
    public Student(double mark){
        this.mark=mark;
    }
    @Override
    public int compareTo(Student o) {
        //You can write your code here

        return 0;
    }
}
