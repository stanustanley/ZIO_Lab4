package pl.example.spring.Zad03Stanecki;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class HelloController {
    private StudentService service=new StudentService();
    @RequestMapping("/Hello")
    public String GetHello() {
        return "Hello " + new Date().toString();
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> GetUsers() {

       return this.service.getStudents().asJava();

    }
    @RequestMapping(value = "/students", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(NewStudent newStudent){
        return this.service.addStudent(newStudent);
    }

}
