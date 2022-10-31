package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();

        for (char c : wordArray) {
            System.out.println("c = " + c);
        }
        return answer;
    }


    public static void main(String[] args) {

        String word = "I love you";

        solution(word);
    }
}
