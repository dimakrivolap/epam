package model.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);
    String getTextComponent();
    List<TextComponent> getComponentList();
    void setTextComponent(String textComponent);
}
