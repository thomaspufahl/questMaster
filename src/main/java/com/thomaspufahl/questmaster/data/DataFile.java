package com.thomaspufahl.questmaster.data;

import com.google.gson.Gson;
import com.thomaspufahl.questmaster.Mission.MissionData;
import com.thomaspufahl.questmaster.QuestMaster;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataFile {
    private static final Gson gson = new Gson();

    private static File dataFolder;
    private static File missionsFile;
    public static final String MISSIONS_FILE_NAME = "missions.json";

    public static List<MissionData> MISSIONS_FROM_JSON = new ArrayList<>();


    public static void setup(@NotNull JavaPlugin plugin) {
        dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) dataFolder.mkdir();

        missionsFile = new File(dataFolder, MISSIONS_FILE_NAME);
        if (!missionsFile.exists()) createFile(missionsFile);

        setMissionsFromJSON();
    }

    private static void setMissionsFromJSON() {
        MISSIONS_FROM_JSON = getMissionsFromJSON();
    }

    private static List<MissionData> getMissionsFromJSON() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(missionsFile)){

            Object data = parser.parse(reader);
            reader.close();
            JSONArray dataArray = (JSONArray) data;

            MissionData[] missions = gson.fromJson(dataArray.toJSONString(), MissionData[].class);

            return Arrays.asList(missions);
        } catch (FileNotFoundException e) {
            QuestMaster.getPlugin(QuestMaster.class).getLogger().info("@ERROR FROM GET MISSIONS@ NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            QuestMaster.getPlugin(QuestMaster.class).getLogger().info("@ERROR FROM GET MISSIONS@ IOEXCEP");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            QuestMaster.getPlugin(QuestMaster.class).getLogger().info("@ERROR FROM GET MISSIONS@ PARSER");
            throw new RuntimeException(e);
        }

        return Collections.emptyList();
    }

    private static void createFile(@NotNull File file) {
        try {
            file.createNewFile();
            setDefaultData(file);
        } catch (IOException e) {
            QuestMaster.getPlugin(QuestMaster.class).getLogger().info("@ERROR FROM CREATE FILE@");
            throw new RuntimeException(e);
        }
    }

    private static void setDefaultData(@NotNull File file) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("[\n {\n }\n]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
