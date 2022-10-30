package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] str2list = word.toCharArray();
        for (char ch : str2list){
            if ((int)ch >= 65 && (int)ch <= 90)
                answer += (char)(90-(int)ch+65);
            else if ((int)ch >= 97 && (int)ch <= 122)
                answer += (char)(122-(int)ch+97);
            else
                answer += ch;

        }

        return answer;
    }
}
/*
* 65: A
* 90: Z
* 97: a
* 122: z
* */