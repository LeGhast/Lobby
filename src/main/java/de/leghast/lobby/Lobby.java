package de.leghast.lobby;

import de.leghast.lobby.command.FlyCommand;
import de.leghast.lobby.command.SpawnCommand;
import de.leghast.lobby.listener.PlayerDeathListener;
import de.leghast.lobby.listener.PlayerInteractListener;
import de.leghast.lobby.listener.PlayerJoinListener;
import de.leghast.lobby.listener.PlayerMoveListener;
import de.leghast.servercore.ServerCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    private ServerCore serverCore;

    @Override
    public void onEnable() {
        serverCore = (ServerCore) Bukkit.getPluginManager().getPlugin("ServerCore");
        registerCommands();
        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    private void registerCommands(){
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

    public ServerCore getServerCore(){
        return serverCore;
    }
}
