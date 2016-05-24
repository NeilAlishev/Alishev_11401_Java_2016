import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.HomeworkService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class HomeworkServiceTest {
    @Autowired
    private HomeworkService homeworkService;
}
