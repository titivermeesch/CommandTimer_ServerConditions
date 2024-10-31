package me.playbosswar.cmtserverconditions;

import me.playbosswar.cmtserverconditions.conditions.ServerPlayerAmountCondition;
import me.playbosswar.cmtserverconditions.conditions.ServerRandomValueCondition;
import me.playbosswar.cmtserverconditions.events.TimeSkipEventExtension;
import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import me.playbosswar.com.api.events.EventExtension;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandTimerServerConditions extends ConditionExtension {
    ConditionRules rules = new ConditionRules();

    public CommandTimerServerConditions() {
        rules.register(new ServerPlayerAmountCondition(), new ServerRandomValueCondition());
    }

    @Override
    public @NotNull String getConditionGroupName() {
        return "SERVER";
    }

    @Override
    public @NotNull
    String[] getDescription() {
        return new String[]{"§7Use server data to fulfill conditions"};
    }

    @Override
    public @NotNull String getAuthor() {
        return "PlayBossWar";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.2.0";
    }

    @Override
    public @NotNull ConditionRules getRules() {
        return rules;
    }

    @Override
    public ArrayList<EventExtension> getEvents() {
        ArrayList<EventExtension> events = new ArrayList<>();
        events.add(new TimeSkipEventExtension(this));
        return events;
    }
}
