package me.playbosswar.cmtserverconditions.events;

import me.playbosswar.com.CommandTimerPlugin;
import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.NeededValue;
import me.playbosswar.com.api.events.EventExtension;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.TimeSkipEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TimeSkipEventExtension extends EventExtension implements Listener {
    private final ConditionExtension extension;

    public TimeSkipEventExtension(ConditionExtension extension) {
        this.extension = extension;
    }

    @Override
    public @NotNull String getEventName() {
        return "TIME_SKIP";
    }

    @Override
    public @NotNull String[] getEventDescription() {
        return new String[]{"Triggered when server time gets skipped, like when all players sleep"};
    }

    @Override
    public ArrayList<NeededValue<?>> getReturnedValues() {
        ArrayList<NeededValue<?>> values = new ArrayList<>();
        values.add(new NeededValue<>("WORLD_NAME", "Name of the world where the time gets skipped", String.class, ""));
        values.add(new NeededValue<>("SKIP_REASON", "Reason for the time skip, can be COMMAND, CUSTOM or NIGHT_SKIP", String.class, TimeSkipEvent.SkipReason.NIGHT_SKIP.toString()));

        return values;
    }

    @EventHandler
    public void onSkip(TimeSkipEvent e) {
        World w = e.getWorld();
        TimeSkipEvent.SkipReason reason = e.getSkipReason();

        ArrayList<NeededValue<?>> values = new ArrayList<>();
        values.add(new NeededValue<>("WORLD_NAME", "Name of the world where the time gets skipped", String.class, w.getName()));
        values.add(new NeededValue<>("SKIP_REASON", "Reason for the time skip, can be COMMAND, CUSTOM or NIGHT_SKIP", String.class, reason.toString()));
        CommandTimerPlugin.getInstance().getEventsManager().handleTriggeredEvent(extension, this, values);
    }
}
