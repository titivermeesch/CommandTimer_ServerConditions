package me.playbosswar.cmtserverconditions;

import me.playbosswar.cmtserverconditions.conditions.ServerPlayerAmountCondition;
import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import org.jetbrains.annotations.NotNull;

public class CommandTimerServerConditions extends ConditionExtension {
    ConditionRules rules = new ConditionRules();

    public CommandTimerServerConditions() {
        rules.register(new ServerPlayerAmountCondition());
    }

    @Override
    public @NotNull String getConditionGroupName() {
        return "SERVER";
    }

    @Override
    public @NotNull
    String[] getDescription() {
        return new String[]{ "§7Use server data to fulfill conditions" };
    }

    @Override
    public @NotNull String getAuthor() {
        return "PlayBossWar";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    public @NotNull ConditionRules getRules() {
        return rules;
    }
}
