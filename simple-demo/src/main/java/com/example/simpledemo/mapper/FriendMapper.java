package com.example.simpledemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.simpledemo.model.Friend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Leo
 */
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {


}
