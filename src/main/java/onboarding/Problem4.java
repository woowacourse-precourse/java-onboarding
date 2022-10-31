package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int index = 0; index < word.length() ; index++){
            int ascii = (int)word.charAt(index);

            if (ascii>=65 && ascii<=90) ascii = convertCapitalLetter(ascii);
            else if (ascii>=97 && ascii<=122) ascii = convertSmallLetter(ascii);

            answer += (char)ascii;
        }

        return answer;
    }

    public static int convertCapitalLetter(int inputAscii){
        return outputAscii;
    }

    public static int convertSmallLetter(int inputAscii){
        return outputAscii;
    }
}
