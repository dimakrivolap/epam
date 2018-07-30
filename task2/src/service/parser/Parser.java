package service.parser;

import model.entity.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}
