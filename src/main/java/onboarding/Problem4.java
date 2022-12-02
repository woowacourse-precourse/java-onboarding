package onboarding;

public class Problem4 {

    public static void main(String[] args){
        String word = "I love you";
        System.out.println(solution(word));
    }
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();

        for (char c : wordArray) {
            if (c == ' ') {answer += ' '; continue;}
            answer+= makeReversAlpha(c);
        }
        return answer;
    }

    public static char makeReversAlpha(char c){

        if (Character.isUpperCase(c)) {
            return reverse(c,155);
        }
        return reverse(c,219);
    }


    public static char reverse(char c, int total) {

        int ascii = c;

        return (char) (total - ascii);
    }



}
