package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";


        char ch;
        char p='Z';
        char q='z';

        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>='a'&&word.charAt(i)<='z')
            {
                ch=(char) ('a'+('z'-word.charAt(i)));
                answer+=ch;
            }
            else if(word.charAt(i)>='A'&&word.charAt(i)<='Z')
            {
                ch=(char) ('A'+('Z'-word.charAt(i)));
                answer+=ch;
            }
            else
                answer+=word.charAt(i);

        }

        return answer;
    }
}
