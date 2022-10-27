package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Problem4 problem = new Problem4();
        String answer = "";

        char[] stringarray = word.toCharArray();

        for(int i=0; i<stringarray.length; i++) {
            stringarray[i] = problem.reserveAlphabet(stringarray[i]);
        }

        return answer;
    }

    public char reserveAlphabet(char alphabet) {
        char result = 32;
        return result;
    }
}
