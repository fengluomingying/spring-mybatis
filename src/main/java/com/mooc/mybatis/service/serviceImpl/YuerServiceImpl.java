package com.mooc.mybatis.service.serviceImpl;

import com.mooc.mybatis.bean.Yuer;
import com.mooc.mybatis.dao.YuerMapper;
import com.mooc.mybatis.service.YuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("yuerService")
public class YuerServiceImpl implements YuerService {

    @Autowired
    private YuerMapper yuerMapper;

    @Override
    public Yuer getFromYuerById(Integer id) {
        Yuer yuer = yuerMapper.selectFromYuerById(id);
        return yuer;
    }
}
