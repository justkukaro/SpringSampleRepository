package net.theceres.util;

public class IdGenerator {
    public static String run() {
        int firstCount = (int) (Math.random() * 20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstCount; i++) {
            stringBuilder.append((char) ((Math.random() * 25) + 97));
        }
        return stringBuilder.toString();
    }
}
