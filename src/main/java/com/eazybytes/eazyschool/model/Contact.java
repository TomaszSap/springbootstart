package com.eazybytes.eazyschool.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;

import javax.validation.constraints.*;
@Entity
@Table(name = "contact_msg")
@Data
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    private int contactId;
    @NotBlank(message="Number cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{9})",message = "Moblie number must be 9 digits")
    @Column(name = "mobile_num")
    private String mobileNum;
    @NotBlank(message="Name must not be blank")
    @Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
            "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\" +
            "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?" +
            ":[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "Please write a title of your message")
    @Size(min=3,max = 255,message = "Title is to short")
    private String subject;
    @NotBlank(message = "Please write your message")
    private String message;
    @NotNull
    @NotBlank(message="Name must not be blank")
    @Size(min=3,max=255,message = "Name must be at least 3 characters long")
    private String name;
    private String status;
}
