package com.example.vtrans.service.impl;

import com.example.vtrans.dao.RecordingDao;
import com.example.vtrans.pojo.Recording;
import com.example.vtrans.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordingServiceImpl implements RecordingService {

    @Autowired
    private RecordingDao recordingDao;

    public List<Recording> getRecordingList(int userId){
        return recordingDao.getRecordingList(userId);
    }

    public int deleteRecording(int recordingId){
        return recordingDao.deleteRecording(recordingId);
    }

}
