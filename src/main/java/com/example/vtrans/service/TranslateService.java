package com.example.vtrans.service;

import com.example.vtrans.pojo.Translate;
import java.util.List;

public interface TranslateService {

    List<Translate> getTranslateList(int userId);

    int deleteTranslate(int translateId);

}
