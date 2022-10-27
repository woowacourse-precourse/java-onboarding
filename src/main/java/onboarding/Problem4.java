package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Problem4 problem = new Problem4();
        String answer = "";

        char[] stringarray = word.toCharArray();

        for(int i=0; i<stringarray.length; i++) {
            stringarray[i] = problem.reserveAlphabet(stringarray[i]);
            answer = answer.concat(String.valueOf(stringarray[i]));
        }

        return answer;
    }

    public char reserveAlphabet(char alphabet) {
        char result = 32;

        if(alphabet == 32) {
            return result;
        } else if(alphabet > 64 && alphabet < 91) {
            int copynumber = 155 - (int)alphabet;
            result = (char)copynumber;
        } else if(alphabet > 96 && alphabet < 123) {
            int copynumber = 219 - (int)alphabet;
            result = (char)copynumber;
        }

        return result;
    }
}
