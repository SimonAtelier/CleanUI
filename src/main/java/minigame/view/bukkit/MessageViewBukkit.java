package minigame.view.bukkit;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import minigame.view.MessageView;

public class MessageViewBukkit implements MessageView {

	private String prefix;
	
	@Override
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private String createTranslatedMessageWithPrefix(String message) {
		String translatedMessage = ChatColor.translateAlternateColorCodes('&', message);
		String translatedPrefix = ChatColor.translateAlternateColorCodes('&', prefix);
		return translatedPrefix + " " + translatedMessage;
	}
	
	@Override
	public void displayMessage(UUID uniquePlayerId, String message) {
		Player player = Bukkit.getPlayer(uniquePlayerId);
		player.sendMessage(createTranslatedMessageWithPrefix(message));
	}

	@Override
	public void displayConsoleMessage(String message) {
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage(createTranslatedMessageWithPrefix(message));
	}
	
}
