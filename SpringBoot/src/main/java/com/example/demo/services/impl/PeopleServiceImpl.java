package com.example.demo.services.impl;

import com.example.demo.entity.People;
import com.example.demo.mapper.PeopleMapper;
import com.example.demo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public List<People> findByPeopleListId(String peopleListId) {
        return peopleMapper.findByPeopleListId(peopleListId);
    }

    @Override
    @Transactional
    public boolean insertPeopleList(List<People> peopleList) {
        return peopleMapper.insertPeopleList(peopleList) > 0;
    }

    @Override
    @Transactional
    public boolean deletePeopleByListId(String peopleListId) {
        return peopleMapper.deletePeopleByListId(peopleListId) > 0;
    }

    @Override
    @Transactional
    public boolean deleteAllPeople() {
        return peopleMapper.deleteAllPeople() > 0;
    }

    @Override
    @Transactional
    public boolean updatePeople(People people) {
        return peopleMapper.updatePeople(people) > 0;
    }
}