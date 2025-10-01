package DP;

import java.util.Objects;

public class PlainText implements Text {
    private final String content;

    public PlainText(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Text content cannot be null or blank.");
        }
        this.content = content;
    }

    @Override
    public String render() {
        return content;
    }
}