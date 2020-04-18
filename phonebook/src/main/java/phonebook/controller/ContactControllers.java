package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactControllers {
    private List<Contact> contacts;

    public ContactControllers() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", this.contacts);

        return modelAndView;
    }

    @PostMapping("/")
    public String storeContact(Contact contact) {
        System.out.println(contact.getName());

        this.contacts.add(contact);

        return "redirect:/";
    }
}
