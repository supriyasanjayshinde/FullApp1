package com.kgisl.springjson.controller;

import java.util.List;

import com.kgisl.springjson.dao.ContactDAO;
import com.kgisl.springjson.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ContactController
 */
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value = "/")
    public List<Contact> printHello() {
        List<Contact> listContact = contactDAO.list();
        // model.addAttribute("listContact", listContact);
        return listContact;
     }
    }
