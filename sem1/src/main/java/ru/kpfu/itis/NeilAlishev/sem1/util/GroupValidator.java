package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class GroupValidator implements Validator {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return GroupCreationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        GroupCreationForm groupForm = (GroupCreationForm) o;
        if (groupRepository.findOneByName(groupForm.getName()) != null) {
            errors.rejectValue("name", "", "Такая группа уже существует");
        }
    }
}
