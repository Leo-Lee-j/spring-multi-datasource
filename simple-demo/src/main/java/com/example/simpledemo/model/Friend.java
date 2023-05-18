package com.example.simpledemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Leo
 */
@Data
public class Friend {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

}
