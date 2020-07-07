package de.staticco.coral.commands.util;

import net.dv8tion.jda.api.entities.TextChannel;

import javax.annotation.Nullable;

public abstract class Command {

    private String name;
    private String prefix;
    private String[] aliases;

    public Command(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public Command(String name, String prefix, String... aliases) {
        this.name = name;
        this.prefix = prefix;
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String[] getAliases() {
        return aliases;
    }


    public abstract void execute(CommandSender commandSender, @Nullable TextChannel textChannel, String command, String[] args);

}
