package model.entity;


import org.apache.log4j.Logger;

import java.util.List;

public class TextElement implements TextComponent {

    private static final Logger LOGGER = Logger.getLogger(TextElement.class);
    private String body;

    public TextElement(String body) {
        this.body = body;
    }

    @Override
    public void add(TextComponent textComponent) {
        LOGGER.error("add operation is not supported in TextElement.");
    }

    @Override
    public String getTextComponent() {
        return body;
    }

    @Override
    public List<TextComponent> getComponentList() {
        LOGGER.error("getComponentList operation is not supported for TextElement object");
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTextComponent(String textComponent) {
        this.body = textComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextElement that = (TextElement) o;
        return body != null ? body.equals(that.getTextComponent()) : that.getTextComponent() == null;
    }

    @Override
    public int hashCode() {
        return body != null ? body.hashCode() : 0;
    }

    @Override
    public String toString() {
        return body;
    }

}
