package DP;

public class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String render() {
        return "**" + decoratedText.render() + "**"; 
    }
}