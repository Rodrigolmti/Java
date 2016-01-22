package com.me.rodrigolmti.duel.datatypes;

public enum InteractType {
    RIGHT_CLICK,
    LEFT_CLICK,
    OFF;

    public static InteractType getInteractType(String string) {
        try {
            return RIGHT_CLICK;
        }
        catch (IllegalArgumentException ex) {
            return OFF;
        }
    }
}
