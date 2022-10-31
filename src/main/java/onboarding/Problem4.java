package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] dividedChars;
        char addChar;

        dividedChars = word.toCharArray();

        for (int i =0; i<dividedChars.length;i++)
        {
            if (dividedChars[i]>=65 && dividedChars[i]<=90)
            {
                addChar = (char) (65 + (90 - dividedChars[i]));
                answer += addChar;
                continue;
            }
            if(dividedChars[i]>=97 && dividedChars[i]<=122)
            {
                addChar = (char) (97 + (122 - dividedChars[i]));
                answer += addChar;
                continue;
            }
            answer += dividedChars[i];
        }

        return answer;
    }
}
