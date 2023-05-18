package com.example.simpledemo.controller;

import com.example.simpledemo.config.DynamicDatasource;
import com.example.simpledemo.model.Friend;
import com.example.simpledemo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Leo
 */
@RequestMapping("/friend")
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping("/list")
    public List<Friend> getList() {
//        DynamicDatasource.sqlType.set("R");
        return friendService.getList();
    }

    @RequestMapping("/save")
    public Object save() {
//        DynamicDatasource.sqlType.set("W");
        return friendService.save();
    }

}
