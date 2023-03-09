package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Controller
public class ContactController{

    private final ContactService contactService;
    @Autowired
    ContactController(ContactService contactService)
    {
        this.contactService=contactService;
    }
    @RequestMapping("/contact")
    public String displayContactPage(Model model)
    {  model.addAttribute("contact",new Contact());
        return"contact.html";
    }
    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors error){
        if(error.hasErrors())
        {
            log.error("Contact from validation failed due to: "+error.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model)
    {
        List<Contact> contactMsgs=contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView=new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }
    @RequestMapping(value = "/closeMsg",method=GET)
    public String closeMsg(@RequestParam int id)
    {
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }
}
