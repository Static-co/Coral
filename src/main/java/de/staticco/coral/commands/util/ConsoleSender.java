package de.staticco.coral.commands.util;

import net.dv8tion.jda.api.entities.MessageEmbed;

public class ConsoleSender extends CommandSender {

    public ConsoleSender(String name) {
        super(name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void sendMessage(MessageEmbed embed) {
        System.out.println(embed.getDescription());
    }

    @Override
    public void sendDirectMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void sendDirectMessage(MessageEmbed embed) {
        System.out.println(embed.getDescription());
    }
}
