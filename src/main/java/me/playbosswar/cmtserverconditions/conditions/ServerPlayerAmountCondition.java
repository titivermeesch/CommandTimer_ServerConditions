package me.playbosswar.cmtserverconditions.conditions;

import me.playbosswar.com.api.ConditionRule;
import me.playbosswar.com.api.NeededValue;
import me.playbosswar.com.conditionsengine.ConditionCompare;
import me.playbosswar.com.conditionsengine.conditions.ConditionHelpers;
import org.bukkit.Bukkit;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ServerPlayerAmountCondition implements ConditionRule {
    @Override
    public String getName() {
        return "PLAYER_AMOUNT";
    }

    @Override
    public String getDescription() {
        return "Check amount of players online";
    }

    @Override
    public boolean evaluate(Facts facts) {
        ConditionCompare conditionCompare = facts.get("conditionCompare");
        Double playerAmount = facts.get("playerAmount");

        return ConditionHelpers.calculateConditionCompare(conditionCompare, Bukkit.getOnlinePlayers().size(), playerAmount);
    }

    @Override
    public ArrayList<NeededValue<?>> getNeededValues() {
        ArrayList<NeededValue<?>> values = new ArrayList<>();

        values.add(new NeededValue<>("playerAmount", "Player Amount", Double.class, 0.0));
        values.add(new NeededValue<>(
                "conditionCompare",
                "Compare Rule",
                ConditionCompare.class,
                ConditionCompare.EQUAL));

        return values;
    }

    @Override
    public void execute(Facts facts) { }

    @Override
    public int compareTo(@NotNull Rule o) {
        return 0;
    }
}
