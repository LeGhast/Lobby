package de.leghast.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getPlayer();
        player.teleport(new Location(player.getWorld(), -54.5, 62, -18.5, -45, 0));
        player.setInvulnerable(true);
        player.setGameMode(GameMode.ADVENTURE);
    }

}
