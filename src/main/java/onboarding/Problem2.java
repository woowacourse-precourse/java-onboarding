package onboarding;

import java.util.Stack;

public class Problem2 {
    static void isCheck(String cryptogram) {
        if(cryptogram.length()<1 || cryptogram.length()>1000) {
            System.out.println("암호문의 길이가 잘못되었습니다.");
        }
        for(char c : cryptogram.toCharArray()) {
            if(!(c>=97 && c<=122)) {
                System.out.println("암호문은 알파벳 소문자로만 입력이 가능합니다.");
            }
        }
    }

    static StringBuilder removeDupliLetter(StringBuilder sb, String cryptogram, String answer) {
        Stack<Character> removeDupliLetter = new Stack<>();

        for (char c : cryptogram.toCharArray()) {
            if (!removeDupliLetter.isEmpty() && removeDupliLetter.peek()==c) {
                removeDupliLetter.pop();
            } else {
                removeDupliLetter.push(c);
            }
        }
        for (char c : removeDupliLetter) {
            sb.append(c);
        }
        return sb;
    }

    public static String solution(String cryptogram) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        isCheck(cryptogram);
        removeDupliLetter(sb, cryptogram, answer);

        answer = sb.toString();
        return answer;
    }
}