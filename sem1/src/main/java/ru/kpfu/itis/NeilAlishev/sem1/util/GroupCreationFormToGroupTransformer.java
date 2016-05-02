package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class GroupCreationFormToGroupTransformer {
    public static Group transform(GroupCreationForm groupCreationForm) {
        Group group = new Group();
        group.setName(groupCreationForm.getName());
        return group;
    }
}
