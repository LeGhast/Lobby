package de.leghast.lobby.listener;

import de.leghast.lobby.Lobby;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private Lobby main;

    public PlayerMoveListener(Lobby main){
        this.main = main;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();

        if(player.getLocation().getY() <= 0){
            player.teleport(new Location(player.getWorld(), -54.5, 62, -18.5, -45, 0));
        }

    }

}

