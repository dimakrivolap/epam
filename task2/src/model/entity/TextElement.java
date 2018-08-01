package model.entity;


public class TextElement implements TextComponent {
    private String body;
    private String type;

    public TextElement(String body, String type) {
        this.body = body;
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void print() {

    }

    @Override
    public String toString() {
        return "TextElement{" +
                "body='" + body + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
