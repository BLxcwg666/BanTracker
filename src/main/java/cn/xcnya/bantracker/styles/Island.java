package cn.xcnya.bantracker.styles;

import cn.xcnya.bantracker.data.PunishmentData;
import today.opai.api.OpenAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import today.opai.api.enums.EnumNotificationType;

public class Island implements TrackerStyle {

    private final OpenAPI openAPI;

    public Island(OpenAPI openAPI) {
        this.openAPI = openAPI;
    }

    @Override
    public void print(int wdDiff, int stDiff, int lastWD, int lastST, PunishmentData data) {
        if (wdDiff <= 0 && stDiff <= 0) return;
        if (openAPI.isNull()) return;

        List<String> messages = new ArrayList<>();
        if (wdDiff > 0) messages.add("§eWatchdog§r banned " + wdDiff + " Player(s).");
        if (stDiff > 0) messages.add("§6Staff§r banned " + stDiff + " Player(s).");

        openAPI.popNotification(EnumNotificationType.WARNING, "Ban Tracker", String.join("\n", messages), 3000);
    }
}