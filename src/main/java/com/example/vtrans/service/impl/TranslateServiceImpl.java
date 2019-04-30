package com.example.vtrans.service.impl;

import com.example.vtrans.dao.TranslateDao;
import com.example.vtrans.pojo.Translate;
import com.example.vtrans.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TranslateServiceImpl implements TranslateService {

    @Autowired
    private TranslateDao translateDao;

    public List<Translate> getTranslateList(int userId){
        return translateDao.getTranslateList(userId);
    }

    public int deleteTranslate(int translateId){
        return translateDao.deleteTranslate(translateId);
    }
}
