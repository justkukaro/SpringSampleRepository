package net.theceres.dto;

import org.springframework.stereotype.Component;

@Component("soccer")
public class Soccer implements Game {
    private boolean ball;
    private int peopleCount;

    {
        ball = true;
        peopleCount = 11;
    }

    public Soccer() {
    }

    public Soccer(boolean ball, int peopleCount) {
        this.ball = ball;
        this.peopleCount = peopleCount;
    }

    public void info() {
        System.out.println("축구는 " + peopleCount + "명이서 공을" + (ball ? "사용하는 " : "사용하지 않는 ") + "게임입니다.");
    }

    public boolean isBall() {
        return ball;
    }

    public void setBall(boolean ball) {
        this.ball = ball;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    @Override
    public String toString() {
        return "Soccer{" +
                "ball=" + ball +
                ", peopleCount=" + peopleCount +
                '}';
    }
}
