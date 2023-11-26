package de.leghast.lobby.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;


public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();
        if (clickedBlock != null && clickedBlock.getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE && e.getAction().equals(Action.PHYSICAL)) {
            e.setCancelled(true);
            Vector direction = player.getLocation().getDirection().normalize();
            direction.setY(0.3);
            player.setVelocity(direction.multiply(2.5));
        }
    }

}
