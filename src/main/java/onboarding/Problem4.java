package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] str2list = word.toCharArray();

        for (char ch : str2list)
            answer += changeChar2ReverseAlphabet(ch);

        return answer;
    }

    public static char changeChar2ReverseAlphabet(char ch){

        if ((int)ch >= 65 && (int)ch <= 90) // A(65) - Z(90)
            return (char)(90-(int)ch+65);

        else if ((int)ch >= 97 && (int)ch <= 122) // a(97) - z(122)
            return  (char)(122-(int)ch+97);

        else // another character
            return ch;
    }
}