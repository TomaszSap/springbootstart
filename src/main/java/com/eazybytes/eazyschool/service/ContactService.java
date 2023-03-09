package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import constants.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
//@requestScope
//@SessionScope
//@ApplicationScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    public ContactService()
    {
        System.out.println("Contact Service Bean initialized");
    }
    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved=false;
        contact.setStatus(AppConstants.OPEN);
        Contact result=contactRepository.save(contact);
        if(result!=null && contact.getContactId()>0)
            isSaved=true;
        return isSaved;
    }

    public List<Contact>  findMsgsWithOpenStatus() {

        List<Contact> contactMsgs = contactRepository.findByStatus(AppConstants.OPEN);
        return contactMsgs;

    }

    public boolean updateMsgStatus(int id) {
        boolean isUpdated=false;
        Optional<Contact> contact=contactRepository.findById(id);
        contact.ifPresent(contact1 ->
        {
            contact1.setStatus(AppConstants.CLOSE);
        });
        Contact updatedContact=contactRepository.save(contact.get());
    if(updatedContact!=null && updatedContact.getUpdatedBy()!=null)
            isUpdated=true;
        return isUpdated;
    }
}
