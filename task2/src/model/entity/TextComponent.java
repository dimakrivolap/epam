package model.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    List<String> getComponent();
    void setComponent(List<String> list);
}
