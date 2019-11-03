package pl.example.spring.Zad03Stanecki;


import io.vavr.collection.List;

public class StudentService {
    private List<Student> students = List.empty();


    List<Student> getStudents(){
        return students;
    }
    public Student addStudent(final NewStudent s){
        Student created = new Student(students.length()+1, s.name, s.numer, s.grupa);
        students=students.prepend(created);
        return created;
    }
}
