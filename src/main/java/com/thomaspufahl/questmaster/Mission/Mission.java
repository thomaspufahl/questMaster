package com.thomaspufahl.questmaster.Mission;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public class Mission {
    private final MissionData missionData;
    public Mission(MissionData missionDataFromJson) {
        missionData = missionDataFromJson;
    }

    private boolean isComplete;

    public boolean isComplete() {return isComplete;}

    public void complete() {isComplete = true;}

    public String getName() {return missionData.name;}
    public String getDescription() {return missionData.description;}

    public void show(CommandSender sender) {
        sender.sendMessage(Component.text("---------------------------------"));
        sender.sendMessage(Component.text("name: " + missionData.name));
        sender.sendMessage(Component.text("description: " + missionData.description));
    }
}
