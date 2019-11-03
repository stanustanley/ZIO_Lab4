package pl.example.spring.Zad03Stanecki;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {
    final StudentService service=new StudentService();
    @Test
    public void getEmptyList(){

        List<Student> students = service.getStudents();
        students=service.getStudents();
        assertTrue(students.isEmpty());

    }


    @Test
    public void addStudent() {
        final Student created=service.addStudent(
                new NewStudent("Student1","1-2-3","IP")
        );
        assertNotNull(created);

    }

    @Test
    public void addStudentIsReturned(){
        final Student created=service.addStudent(
                new NewStudent("Student1","1-2-3","IP")
        );

        final List<Student> all = service.getStudents();
        assertEquals("Student1",all.get(0).name);
    }
    @Test
    public void addStudentHasNewId(){
        Student created=service.addStudent(
                new NewStudent("Student1","1-2-3","IP")
        );
        Student created2=service.addStudent(
                new NewStudent("Student1","1-2-3","IP")
        );

        assertNotEquals(created.id, created2.id);
        assertEquals(2,service.getStudents().size());
    }

}