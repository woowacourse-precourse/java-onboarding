package onboarding;

//-----기능-----
//1. 청개구리 사전 만들기
//2. 대소문자 판별

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String dict = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        for (int i = 0 ; i < word.length(); i++)
        {
            char c = word.charAt(i);
            System.out.println((int)c);
            if (Character.isUpperCase(c))
                answer += dict.charAt((int)c - 'A');
            else if(Character.isLowerCase(c))
                answer += dict.charAt((int)c - 'a');
            else
                answer += c;
        }
        return answer;
    }
}
