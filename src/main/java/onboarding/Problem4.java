package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();

        for (char c : wordArray) {
            System.out.println("c = " + c);
            System.out.println(isUpperOrLower(c));
        }
        return answer;
    }

    public static int isUpperOrLower(char c) {
        if(Character.isUpperCase(c)){
            return 1;
        } else {
            return 2;
        }
    }




    public static void main(String[] args) {

        String word = "I love you";

        solution(word);
    }
}
