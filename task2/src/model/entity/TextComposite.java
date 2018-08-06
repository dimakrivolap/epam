package model.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private static final Logger LOGGER = Logger.getLogger(TextComposite.class);
    private List<TextComponent> textComponents = new ArrayList<>();

    public TextComposite() {

    }

    @Override
    public void add(TextComponent textComponent) {
        this.textComponents.add(textComponent);
    }

    @Override
    public String getTextComponent() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent c : textComponents) {
            sb.append(c.toString());
        }
        return sb.toString();
    }

    @Override
    public List<TextComponent> getComponentList() {
        return textComponents;
    }

    @Override
    public void setTextComponent(String textComponent) {
        LOGGER.error("setTextComponent is unsupported operation ");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent content : textComponents)
            stringBuilder.append(content.toString());
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return (textComponents != null ? textComponents.equals(that.textComponents) : that.textComponents == null);
    }

    @Override
    public int hashCode() {
        return textComponents != null ? 31 * textComponents.hashCode() : 0;
    }
}
