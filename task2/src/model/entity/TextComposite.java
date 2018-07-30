package model.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> list = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        list.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        list.remove(component);
    }

    @Override
    public List<String> getComponent() {
        return list;
    }

    @Override
    public void setComponent(List<String> list){
        this.list = list;
    }
}
