package com.example.basemybatis.controller;

import com.example.basemybatis.model.Friend;
import com.example.basemybatis.service.FriendService;
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
        return friendService.getList();
    }

    @RequestMapping("/save")
    public Object save() {
        return friendService.save();
    }

}
