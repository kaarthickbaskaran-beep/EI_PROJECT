package DP;

public class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String render() {
        return "_" + decoratedText.render() + "_"; 
    }
}