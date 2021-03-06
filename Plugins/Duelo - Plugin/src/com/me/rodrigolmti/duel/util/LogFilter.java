package com.me.rodrigolmti.duel.util;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

import com.me.rodrigolmti.duel.Duel;

public class LogFilter implements Filter {
    private final boolean debug;

    public LogFilter(Duel plugin) {
        // Doing a config loading lite here, because we can't depend on the config loader to have loaded before any debug messages are sent
        debug = plugin.getConfig().getBoolean("General.Verbose_Logging");
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return !(record.getMessage().contains("[Debug]") && !debug);
    }
}
