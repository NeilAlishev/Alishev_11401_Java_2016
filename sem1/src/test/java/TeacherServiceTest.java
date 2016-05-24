import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
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
public class TeacherServiceTest {
    @Autowired
    TeacherService teacherService;

    @Autowired
    GroupService groupService;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    GroupRepository groupRepository;

    private static Teacher teacher = new Teacher();

    private static Group group = new Group();

    @BeforeClass
    public static void setup() {
        teacher.setId(1L);

        group.setId(1L);

    }

    @Test
    public void getTeacherByIDGetsTeacherById(long id) {
        when(teacherRepository.findOne(1L)).thenReturn(teacher);
        assertEquals(teacher, teacherService.getTeacherByID(1));
    }

    @Test
    public void findAllByGroupFindsAllByGroup(Group group) {
        when(groupRepository.findByTeachers_Id(1L)).thenReturn(new ArrayList<Group>());
        assertEquals(new ArrayList<Group>(), groupService.findAllByTeacher(teacher));
    }

}
