package com.example.service.impl;

import com.example.dao.PersonMapper;
import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Guo on 2017/2/17.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public Person getUserById(String userId) {
        return personMapper.selectByPrimaryKey(userId);
    }
}
