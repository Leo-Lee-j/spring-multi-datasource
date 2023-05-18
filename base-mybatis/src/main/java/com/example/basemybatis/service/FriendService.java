package com.example.basemybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.basemybatis.mapper.FriendMapper;
import com.example.basemybatis.model.Friend;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leo
 */
@Service
public class FriendService extends ServiceImpl<FriendMapper, Friend> {

    public List<Friend> getList() {
        return this.list();
    }

    public Object save() {
        Friend friend = new Friend();
        friend.setUsername("张三");
        return this.save(friend);
    }

}
