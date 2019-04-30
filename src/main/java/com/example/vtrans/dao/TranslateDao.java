package com.example.vtrans.dao;

import com.example.vtrans.pojo.Translate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TranslateDao {

    @Select("select * from b_translate where user_id = #{userId}")
    List<Translate> getTranslateList(int userId);

    @Delete("delete from b_translate where translate_id = #{translateId}")
    int deleteTranslate(int translateId);

}
