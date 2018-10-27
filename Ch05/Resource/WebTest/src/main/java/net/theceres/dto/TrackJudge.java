package net.theceres.dto;

import org.springframework.stereotype.Component;

@Component("track-judge")
public class TrackJudge implements Judge {
    public void alert() {
        System.out.println("부정 출발 ㄴㄴ");
    }
}

