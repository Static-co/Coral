package de.staticco.coral.commands.util;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class DiscordSender extends CommandSender {

    private Member member;
    private TextChannel textChannel;

    public DiscordSender(String name, Member member, TextChannel textChannel) {
        super(name);
        this.textChannel = textChannel;
        this.member = member;
    }

    @Override
    public void sendMessage(String message) {
        textChannel.sendMessage(message).queue();
    }

    @Override
    public void sendMessage(MessageEmbed embed) {
        textChannel.sendMessage(embed).queue();
    }

    @Override
    public void sendDirectMessage(final String message) {
        member.getUser().openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(message).queue();
        });
    }

    @Override
    public void sendDirectMessage(MessageEmbed embed) {
        member.getUser().openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(embed).queue();
        });
    }

    public Member getMember() {return member;}
}
