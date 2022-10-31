package onboarding;

//-----기능-----
//1. 청개구리 사전 만들기
//2. 대소문자 판별

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String upperDict = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowwerDict = "zyxwvutsrqponmlkjihgfedcba";

        for (int i = 0 ; i < word.length(); i++)
        {
            answer = getAnswer(word, answer, upperDict, lowwerDict, i);
        }
        return answer;
    }

    private static String getAnswer(String word, String answer, String upperDict, String lowwerDict, int i) {
        char c = word.charAt(i);
        if (Character.isUpperCase(c))
            answer += upperDict.charAt((int)c - 'A');
        else if(Character.isLowerCase(c))
            answer += lowwerDict.charAt((int)c - 'a');
        else //대소문자가 아니라면 그대로 concat 한다.
            answer += c;
        return answer;
    }
}
