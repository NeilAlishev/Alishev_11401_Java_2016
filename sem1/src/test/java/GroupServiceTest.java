import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Autowired
    private static GroupRepository groupRepository;

    private static List<Group> groups;

    private static Group group = new Group();

    private static Teacher teacher = new Teacher();

    @BeforeClass
    public static void setup() {
        Student student = new Student();
        student.setId(1L);

        teacher.setId(1L);

        group.setId(1L);

        groups = groupRepository.findAll();
    }

    @Test
    public void getAllShouldReturnAllGroups() {
        when(groupRepository.findAll()).thenReturn(groups);
        assertEquals(groups, groupService.findAll());
    }

    @Test
    public void findByNameShouldFindByName() {
        when(groupRepository.findOneByName("test")).thenReturn(group);
        assertEquals(group, groupService.findByName("test"));
    }

    @Test
    public void findAllByTeacherShouldFindAllByTeacher() {
        when(groupRepository.findOneByName("test")).thenReturn(group);
        assertEquals(group, groupService.findAllByTeacher(teacher));
    }

}
