package de.staticco.coral.commands.util;

import net.dv8tion.jda.api.entities.MessageEmbed;

public abstract class CommandSender {

    public CommandSender(String name) {
    }

    //those method will be used to send a message over of the textchannel the command got send to
    public abstract void sendMessage(String message);
    public abstract void sendMessage(MessageEmbed embed);

    //those method will be used to send a direct message to the commandsender
    public abstract void sendDirectMessage(String message);
    public abstract void sendDirectMessage(MessageEmbed embed);

}
