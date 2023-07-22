package com.thomaspufahl.questmaster.command;

import com.thomaspufahl.questmaster.Mission.MissionService;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MissionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        sender.sendMessage(Component.text("Welcome to QUEST MASTER"));
        sender.sendMessage(Component.text("@ Missions @ -> "));
        MissionService.MISSIONS.forEach(mission -> mission.show(sender));

        return true;
    }
}
