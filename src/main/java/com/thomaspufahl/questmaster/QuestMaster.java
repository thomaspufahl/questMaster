package com.thomaspufahl.questmaster;

import com.thomaspufahl.questmaster.command.MissionCommand;
import com.thomaspufahl.questmaster.data.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("@ QUEST MASTER @");
        DataManager.setup(this);
        registerCommands();
    }

    public void registerCommands() {
        getCommand("missions").setExecutor(new MissionCommand());
    }

}
