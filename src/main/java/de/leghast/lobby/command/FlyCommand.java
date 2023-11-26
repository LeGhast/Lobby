package de.leghast.lobby.command;

import de.leghast.lobby.Lobby;
import de.leghast.servercore.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    private Lobby main;

    public FlyCommand(Lobby main){
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player player){
            boolean hasPermission = main.getServerCore().getRankSystem().getRankManager().hasRank(player.getUniqueId(), Rank.ADMINISTRATOR) || main.getServerCore().getRankSystem().getRankManager().hasRank(player.getUniqueId(), Rank.STAFF) || main.getServerCore().getRankSystem().getRankManager().hasRank(player.getUniqueId(), Rank.VIP);
            if(hasPermission){
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("§cFlight mode disabled");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("§aFlight mode enabled");
                }
            }else{
                player.sendMessage("§cYou need the " + Rank.VIP.getDisplay() + " §crank to use this feature");
            }
        }

        return false;
    }
}
