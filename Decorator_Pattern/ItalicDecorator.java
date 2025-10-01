package DP;

public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String render() {
        return "*" + decoratedText.render() + "*"; 
    }
}