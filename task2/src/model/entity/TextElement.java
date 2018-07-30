package model.entity;

import java.util.Arrays;
import java.util.List;

public class TextElement extends TextComposite {
    protected String body;

    @Override
    public void setComponent(String text) {
        body = text;
    }

    @Override
    public List<String> getComponent() {
        return Arrays.asList(body);
    }
}
