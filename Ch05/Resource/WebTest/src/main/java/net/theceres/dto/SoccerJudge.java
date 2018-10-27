package net.theceres.dto;

import org.springframework.stereotype.Component;

@Component("soccer-judge")
public class SoccerJudge implements Judge {
    public void alert() {
        System.out.println("카드 잘줌");
    }
}

