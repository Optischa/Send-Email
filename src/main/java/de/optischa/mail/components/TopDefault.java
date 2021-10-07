package de.optischa.mail.components;

import java.util.Map;

public class TopDefault implements Component {

    @Override
    public String body() {
        return null;
    }

    @Override
    public String file() {
        return "default/top.html";
    }
}