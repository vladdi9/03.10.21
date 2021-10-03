package org.itstep;

public class Main1 {

    public static void main(String[] args) {
        String s = "Посчитать количество повторяющихся символов в строке";
        //Создать строку с неповторяющимися символами на основе существующей
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if (sb.indexOf(Character.toString(c))==-1)
            sb.append(c);
        }
        System.out.println(sb);
        // Посчитать количество этих символов в строке
        int counts []=new int[sb.length()];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(Character.toString(c));
            if (index != -1) {
                counts[index]++;
            }
        }
        System.out.println();
        for (int i=0; i<sb.length(); i++)
            System.out.printf("%c,%d,%n", sb.charAt(i), counts[i]);
    }
}
