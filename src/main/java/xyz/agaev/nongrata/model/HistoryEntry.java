package xyz.agaev.nongrata.model;

public class HistoryEntry {

    private final String action;
    private final String author;
    private final long timestamp;

    public HistoryEntry(String action, String author, long timestamp) {
        this.action = action;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public String getAuthor() {
        return author;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
