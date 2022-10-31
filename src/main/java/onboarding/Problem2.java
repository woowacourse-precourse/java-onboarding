package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Cryptogram.validateValueCase(cryptogram);
        Cryptogram.validateValueRange(cryptogram);
        answer = Cryptogram.decodeValue(cryptogram);
        return answer;
    }

    public static void main(String[] args) {
        Program2.start();
        String inputCryptogram = Program2.input();
        Program2.validate(inputCryptogram);
        String result = Program2.decode(inputCryptogram);
        Program2.end("cryptogram", inputCryptogram, result);
    }
}

class Program2 {
    static void start() {
        OutView2.printStart();
    }

    static String input() {
        return Input2.inputCryptogram();
    }

    static void validate(String inputCryptogram) {
        Cryptogram.validateValueRange(inputCryptogram);
        Cryptogram.validateValueCase(inputCryptogram);
    }

    static String decode(String inputCryptogram) {
        return Cryptogram.decodeValue(inputCryptogram);
    }

    static void end(String program, String inputCryptogram, String result) {
        OutView2.printHead(program);
        OutView2.printResult(inputCryptogram, result);
    }
}

class Input2 {
    static String inputCryptogram() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}

class Cryptogram {

    static void validateValueRange(String stringValue) {
        if (stringValue.length() == 0 || 1000 < stringValue.length()) {
            throw new IllegalStateException("1이상 1000 이하인 문자열을 입력해 주세요!");
        }
    }

    static void validateValueCase(String stringValue) {
        char[] toCharArray = stringValue.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            if (!Character.isLowerCase(toCharArray[i])) {
                throw new IllegalStateException("영어 소문자만 입력가능합니다.");
            }
        }
    }

    static String decodeValue(String stringValue) {
        LinkedList<Character> characters = getCharacterArrayList(stringValue);
        int i = characters.size() - 1;
        while (i != 0) {
            if (removeSameChars(characters, i) && characters.size() != 0) {
                i = characters.size() - 1;
            } else {
                i--;
            }
        }
        return characters.toString()
                .replaceAll("\\[|\\]", "")
                .replaceAll(",", "")
                .replaceAll(" ", "");
    }

    private static boolean removeSameChars(LinkedList<Character> characters, int i) {
        if (characters.get(i) == characters.get(i - 1)) {
            characters.remove(i);
            characters.remove(i - 1);
            return true;
        }
        return false;
    }

    private static LinkedList<Character> getCharacterArrayList(String stringValue) {
        LinkedList<Character> characters = new LinkedList<>();
        for (int i = 0; i < stringValue.length(); i++) {
            characters.add(stringValue.charAt(i));
        }
        return characters;
    }

}

class OutView2 {
    static void printStart() {
        System.out.println("암호문을 입력해 주세요.");
    }
    static void printHead(String cryptoMethod ) {
        System.out.println(cryptoMethod + "\t" + "result");
    }

    static void printResult(String inputCryptogram, String result) {
        System.out.println(inputCryptogram + "\t" + result);
    }
}