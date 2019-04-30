package com.example.vtrans.dao;


import com.example.vtrans.pojo.Recording;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecordingDao {

    @Select("select * from b_recording where user_id = #{userId}")
    List<Recording> getRecordingList(int userId);

    @Delete("delete from b_recording where recording_id = #{recordingId}")
    int deleteRecording(int recordingId);

}
