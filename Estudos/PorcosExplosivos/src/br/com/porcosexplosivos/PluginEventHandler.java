package br.com.porcosexplosivos;

import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PluginEventHandler implements Listener {

	@EventHandler
	void interactEventPlayer (PlayerInteractEntityEvent event) {
	
		if (event.getRightClicked() instanceof Pig) {
			
			Pig pig = (Pig) event.getRightClicked();
			pig.getWorld().createExplosion(pig.getLocation(), 20f, true);
					
		}
		return;
		
	}
	
}
