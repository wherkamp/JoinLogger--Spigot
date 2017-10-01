package net.KingTux.JoinLogger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

	@EventHandler
	public void Join(PlayerJoinEvent e) {
		JoinLogger.SaveFile("login", e.getPlayer());

	}

	@EventHandler
	public void Leave(PlayerQuitEvent e) {

		JoinLogger.SaveFile("exit", e.getPlayer());

	}
}
