package net.theceres.dto;

public class Track implements Game {
    private boolean ball;
    private int peopleCount;

    public Track() {
    }

    public Track(boolean ball, int peopleCount) {
        this.ball = ball;
        this.peopleCount = peopleCount;
    }

    public void info() {
        System.out.println("육상은 " + peopleCount + "명이서 공을" + (ball ? "사용하는" : "사용하지 않는 ") + "게임입니다.");
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
        return "Track{" +
                "ball=" + ball +
                ", peopleCount=" + peopleCount +
                '}';
    }
}
