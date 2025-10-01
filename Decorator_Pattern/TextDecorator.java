package DP;

public abstract class TextDecorator implements Text {
    protected final Text decoratedText;

    public TextDecorator(Text decoratedText) {
        if (decoratedText == null) {
            throw new IllegalArgumentException("Decorated text cannot be null.");
        }
        this.decoratedText = decoratedText;
    }

    @Override
    public abstract String render();
}