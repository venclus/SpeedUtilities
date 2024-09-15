package pl.speedplugins.utilities;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {

    public enum MessageType {
        TITLE,
        TITLE_SUBTITLE,
        SUBTITLE,
        ACTIONBAR,
        DO_NOT_SEND,
        CHAT;

        public static MessageType fromString(String type) {
            try {
                return MessageType.valueOf(type.toUpperCase());
            } catch (IllegalArgumentException e) {
                return CHAT;
            }
        }
    }

    public void message(CommandSender sender, String type, String message) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            MessageType messageType = MessageType.fromString(type);

            if (messageType == MessageType.TITLE) {
                ChatUtil.sendTitle(p, message, "");
            } else if (messageType == MessageType.TITLE_SUBTITLE) {
                String[] split = message.split("%NEWLINE%");
                if (split.length > 1) {
                    ChatUtil.sendTitle(p, split[0], split[1]);
                } else {
                    ChatUtil.sendTitle(p, split[0], "");
                }
            } else if (messageType == MessageType.SUBTITLE) {
                ChatUtil.sendTitle(p, "", message);
            } else if (messageType == MessageType.ACTIONBAR) {
                ChatUtil.sendActionbar(p, ChatUtil.fixColor(message));
            } else if (messageType == MessageType.DO_NOT_SEND) {
            } else {
                p.sendMessage(ChatUtil.fixColor(message));
            }
        } else {
            sender.sendMessage(ChatUtil.fixColor(message));
        }
    }
}