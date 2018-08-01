package model.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private List<TextComponent> components = new ArrayList<>();

    public List<TextComponent> getComponentList() {
        return components;
    }

    public void setComponents(List<TextComponent> components) {
        this.components = components;
    }

    public void add(TextComponent component){
        this.components.add(component);
    }

    @Override
    public void print() {
        System.out.println(components);
    }
}
