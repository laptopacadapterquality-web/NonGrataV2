package xyz.agaev.nongrata.model;

public enum DangerLevel {

    LOW(1, "★☆☆☆☆"),
    MEDIUM(2, "★★☆☆☆"),
    HIGH(3, "★★★☆☆"),
    VERY_HIGH(4, "★★★★☆"),
    CRITICAL(5, "★★★★★");

    private final int level;
    private final String stars;

    DangerLevel(int level, String stars) {
        this.level = level;
        this.stars = stars;
    }

    public int getLevel() {
        return level;
    }

    public String getStars() {
        return stars;
    }

}
