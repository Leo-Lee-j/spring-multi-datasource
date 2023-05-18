package com.example.simpledemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.simpledemo.config.DB;
import com.example.simpledemo.mapper.FriendMapper;
import com.example.simpledemo.model.Friend;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leo
 */
@Service
public class FriendService extends ServiceImpl<FriendMapper, Friend> {

    @DB("R")
    public List<Friend> getList() {
        return this.list();
    }

    @DB
    public Object save() {
        Friend friend = new Friend();
        friend.setUsername("张三");
        return this.save(friend);
    }

}
