package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.util.*;

import javax.validation.Valid;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class GroupsController {

    @Autowired
    GroupService groupService;

    @Autowired
    GroupValidator groupValidator;

    @RequestMapping(value = "/groups/new", method = RequestMethod.GET)
    public String newGroup(Model model) {
        model.addAttribute("group", new GroupCreationForm());
        return "groups/new";
    }

    @RequestMapping(value = "/groups/create", method = RequestMethod.POST)
    public String createGroup(Model model, @ModelAttribute("group") @Valid GroupCreationForm groupCreationForm,
                              BindingResult result) {
        groupValidator.validate(groupCreationForm, result);
        if (result.hasErrors()) {
            return "groups/new";
        }
        groupService.createOrUpdate(GroupCreationFormToGroupTransformer
                .transform(groupCreationForm));
        model.addAttribute("info", "Вы успешно добавили группу");
        return "groups/new";
    }
}
