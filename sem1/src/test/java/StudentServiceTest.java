import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class StudentServiceTest {
    @Autowired
    GroupService groupService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    GroupRepository groupRepository;

    private static Student student = new Student();

    private static List<Student> students = new ArrayList<>();

    private static Teacher teacher = new Teacher();

    private static Group group = new Group();

    @BeforeClass
    public static void setup() {
        teacher.setId(1L);
        student.setId(1L);
        group.setId(1L);

    }

    @Test
    public void getOneGetsOneStudent() {
        when(studentRepository.findOne(1L)).thenReturn(student);
        assertEquals(student, studentService.getOne(1L));
    }

    @Test
    public void findAllFindsAllStudents() {
        when(studentRepository.findAll()).thenReturn(students);
        assertEquals(students, studentService.getAll());
    }

}
