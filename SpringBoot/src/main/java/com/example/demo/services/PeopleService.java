package com.example.demo.services;

import com.example.demo.entity.People;

import java.util.List;

public interface PeopleService {
    List<People> findByPeopleListId(String peopleListId);
    boolean insertPeopleList(List<People> peopleList);

    boolean deletePeopleByListId(String peopleListId);
    boolean deleteAllPeople();

    boolean updatePeople(People people);
}
