package org.itstep;

public class Ew {
    public static void main(String[] args) {
        //Инвертировать все слова в предложении
        String sentence = "Инвертировать все слова в предложении";
        String word = "word";
        StringBuilder sb = new StringBuilder(word);
        System.out.println(sb.reverse());
        System.out.println(reversevord(sentence));
        System.out.println(reversFrase(sentence));
    }
    static String reversevord (String s){
        return new StringBuilder(s).reverse().toString();
    }
    static String reversFrase (String s){
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word: words)
            sb.append(reversevord(word)).append(" ");
        return sb.toString();
    }
}
