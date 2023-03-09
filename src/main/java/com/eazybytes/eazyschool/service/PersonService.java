package com.eazybytes.eazyschool.service;


import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.PersonRepository;
import constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public boolean registerNewUser(Person person)
    {
        boolean isSaved=false;
        var isAccount= personRepository.findByEmail(person.getEmail());
        Person result= new Person();
        if (isAccount==null)
        result=personRepository.save(person);
        if(result!=null && person.getPersonId()>0)
            isSaved=true;
        return isSaved;
    }

}
