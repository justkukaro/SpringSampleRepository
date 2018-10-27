package net.theceres.util;

import net.theceres.dto.Game;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        Game g1 = (Game) factory.getBean("soccer");
        g1.info();

        Game g2 = (Game) factory.getBean("track");
        g2.info();
    }
}
