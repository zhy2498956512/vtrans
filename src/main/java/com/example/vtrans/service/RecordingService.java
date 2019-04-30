package com.example.vtrans.service;

import com.example.vtrans.pojo.Recording;
import java.util.List;

public interface RecordingService {

    List<Recording> getRecordingList(int userId);

    int deleteRecording(int recordingId);

}
