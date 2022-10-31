package onboarding;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Encode.validateInput(word);
        answer = Encode.encode(word);
        return answer;
    }

    public static void main(String[] args) {
        Program4.start();
        String inputWord = Program4.inputWord();
        String result = Program4.encode(inputWord);
        Program4.end(inputWord, result);
    }
}

class Program4 {

    static void start() {
        OutView4.printStart();
    }

    static String inputWord() {
        return Input4.inputWord();
    }

    static String encode(String inputWord) {
        Encode.validateInput(inputWord);
        return Encode.encode(inputWord);
    }

    static void end(String inputWord, String result) {
        OutView4.printHead();
        OutView4.printResult(inputWord, result);
    }
}

class Input4 {
    static String inputWord() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}

class Encode {

    private static final int SKIP = 0;
    private static final int UPPERCASE = 1;
    private static final int LOWERCASE = 2;

    private static ArrayList<Character> UPPERTABLE = new ArrayList<>();
    private static ArrayList<Character> UPPERREVERSTABLE = new ArrayList<>();

    private static ArrayList<Character> LOWERTABLE = new ArrayList<>();
    private static ArrayList<Character> LOWERREVERSTABLE = new ArrayList<>();


    private static void loadTable() {
        for (int i = 65; i < 91; i++) {
            UPPERTABLE.add((char) i);
        }
        for (int i = 90; i > 64; i--) {
            UPPERREVERSTABLE.add((char)i);
        }
        for (int i = 97; i < 122; i++) {
            LOWERTABLE.add((char) i);
        }
        for (int i = 122; i > 96; i--) {
            LOWERREVERSTABLE.add((char)i);
        }
    }


    static void validateInput(String word) {
        if (word.length() < 1 || 1000 < word.length()) {
            throw new IllegalStateException("길이가 1이상 1000이하로 입력해 주세요!");
        }
    }

    static String encode(String word) {
        loadTable();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int encodeType = encodeType(charArray[i]);
            if (encodeType == UPPERCASE) {
                charArray[i] = encodeUpperCase2(charArray[i]);
            }
            if (encodeType == LOWERCASE) {
                charArray[i] = encodeLowerCase2(charArray[i]);
            }
        }
        StringBuffer encodeResult = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            encodeResult.append(charArray[i]);
        }
        return encodeResult.toString();
    }

    private static int encodeType(char c) {
        if (c < 65) {
            return SKIP;
        }
        if (c < 90) {
            return UPPERCASE;
        }
        if (c < 97) {
            return SKIP;
        }
        if (c < 123) {
            return LOWERCASE;
        }
        return SKIP;
    }

    private static char encodeUpperCase2(char c) {
        return UPPERREVERSTABLE.get(UPPERTABLE.indexOf(c));
    }

    private static char encodeLowerCase2(char c) {
        return LOWERREVERSTABLE.get(LOWERTABLE.indexOf(c));
    }

    private static char encodeLowerCase(char c) {
        int standard = ('a' + 'z') / 2;
        if (c <= standard) {
            standard += (standard - c + 1);
        }
        if (c >= standard) {
            standard -= (c - standard - 1);
        }
        return (char) standard;
    }
    private static char encodeUpperCase(char c) {
        int standard = ('A' + 'Z') / 2;
        if (c <= standard) {
            standard += (standard - c + 1);
        }
        if (c >= standard) {
            standard -= (c - standard - 1);
        }
        return (char) standard;
    }
}

class OutView4 {
    static void printStart() {
        System.out.println("길이가 1이상 1000이하인 문장을 입력해 주세요");
    }
    static void printHead() {
        System.out.println("word" + "\t" + "result");
    }

    static void printResult(String inputWord, String result) {
        System.out.println(inputWord + "\t" + result);
    }
}