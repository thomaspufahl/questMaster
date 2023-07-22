package com.thomaspufahl.questmaster;


import com.thomaspufahl.questmaster.data.DataFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("@ QUEST MASTER @");
        DataFile.setup(this);
    }
}
