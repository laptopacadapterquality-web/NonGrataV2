package xyz.agaev.nongrata.model;

public enum Category {

    CHEATS("Читы"),
    GRIEF("Гриферство"),
    SCAM("Мошенничество"),
    TOXIC("Токсичность"),
    SPY("Шпионаж"),
    OTHER("Другое");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
