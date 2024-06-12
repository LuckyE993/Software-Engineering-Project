package com.example.demo.controller;


import com.example.demo.entity.People;
import com.example.demo.services.PeopleService;
import com.example.demo.utils.ExcelUtil;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/allPeople/{peopleListId}")
    public Results getPeopleByListId(@PathVariable String peopleListId) {
        List<People> people = peopleService.findByPeopleListId(peopleListId);
        if (people.isEmpty()) {
            return Results.error().message("未找到人员");
        } else {
            return Results.ok().data("people", people);
        }
    }

    @PostMapping("/upload/{ruleId}")
    public Results uploadPeople(@PathVariable String ruleId, @RequestParam("file") MultipartFile file) {
        try {
            List<People> peopleList = ExcelUtil.parseExcel(file, ruleId);
            boolean success = peopleService.insertPeopleList(peopleList);
            if (success) {
                return Results.ok().message("人员导入成功");
            } else {
                return Results.error().message("人员导入失败");
            }
        } catch (Exception e) {
            return Results.error().message("文件处理失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteByListId/{peopleListId}")
    public Results deletePeopleByListId(@PathVariable String peopleListId) {
        boolean success = peopleService.deletePeopleByListId(peopleListId);
        if (success) {
            return Results.ok().message("人员删除成功");
        } else {
            return Results.error().message("人员删除失败");
        }
    }

    @DeleteMapping("/deleteAll")
    public Results deleteAllPeople() {
        boolean success = peopleService.deleteAllPeople();
        if (success) {
            return Results.ok().message("所有人员删除成功");
        } else {
            return Results.error().message("所有人员删除失败");
        }
    }

    @PutMapping("/update")
    public Results updatePeople(@RequestBody People people) {
        boolean success = peopleService.updatePeople(people);
        if (success) {
            return Results.ok().message("人员信息更新成功");
        } else {
            return Results.error().message("人员信息更新失败");
        }
    }
}