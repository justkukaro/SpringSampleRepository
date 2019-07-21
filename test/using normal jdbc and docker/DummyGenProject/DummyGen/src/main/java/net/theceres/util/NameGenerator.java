package net.theceres.util;

public class NameGenerator {
    public static String run() {
        int firstCount = (int) (Math.random() * 10) + 1;
        int lastCount = (int) (Math.random() * 10) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstCount; i++) {
            if(i==0){
                stringBuilder.append((char) ((Math.random() * 25) + 65));
            }else{
                stringBuilder.append((char) ((Math.random() * 25) + 97));
            }
        }
        stringBuilder.append(' ');
        for (int i = 0; i < lastCount; i++) {
            if(i==0){
                stringBuilder.append((char) ((Math.random() * 25) + 65));
            }else{
                stringBuilder.append((char) ((Math.random() * 25) + 97));
            }
        }
        return stringBuilder.toString();
    }
}
