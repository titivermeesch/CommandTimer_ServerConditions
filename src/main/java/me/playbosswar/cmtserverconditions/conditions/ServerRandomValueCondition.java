package me.playbosswar.cmtserverconditions.conditions;

import me.playbosswar.com.api.ConditionRule;
import me.playbosswar.com.api.NeededValue;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ServerRandomValueCondition implements ConditionRule {
    @Override
    public String getName() {
        return "RANDOM_VALUE";
    }

    @Override
    public String getDescription() {
        return "Apply randomness to any condition rule";
    }

    @Override
    public boolean evaluate(Facts facts) {
        final double random = facts.get("random");
        final double chance = Math.random() * 100;

        return chance <= random;
    }

    @Override
    public ArrayList<NeededValue<?>> getNeededValues() {
        ArrayList<NeededValue<?>> values = new ArrayList<>();

        values.add(new NeededValue<>("random", "Random value between 0 and 100%", Double.class, 0.0));

        return values;
    }

    @Override
    public void execute(Facts facts) {
        // Not implemented
    }

    @Override
    public int compareTo(@NotNull Rule o) {
        return 0;
    }
}
