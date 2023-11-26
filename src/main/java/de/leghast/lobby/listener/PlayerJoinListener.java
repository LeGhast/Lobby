package de.leghast.lobby.listener;

import de.leghast.lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private Lobby main;

    public PlayerJoinListener(Lobby main){
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        player.teleport(new Location(player.getWorld(), -54.5, 62, -18.5, -45, 0));
        player.setInvulnerable(true);
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
    }

}
