package com.thomaspufahl.questmaster.Mission;

import com.thomaspufahl.questmaster.data.DataManager;

import java.util.ArrayList;
import java.util.List;

public class MissionService {

    public static List<Mission> MISSIONS = getMissions();

    private static List<Mission> getMissions() {
        List<MissionData> missionDataList = DataManager.MISSIONS_FROM_JSON;
        List<Mission> missions = new ArrayList<>();

        for (MissionData missionData : missionDataList) missions.add(new Mission(missionData));

        return missions;
    }
}
