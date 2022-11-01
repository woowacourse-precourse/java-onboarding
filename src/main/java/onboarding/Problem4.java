package onboarding;

public class Problem4 {
    public static Character reverse(char word)
    {
        int asciiword = word;
        if(word>='A' &&word <='Z')
        {
            asciiword = asciiword -'A';
            word = (char)((int)'Z'-asciiword);
        }
        else if(word >= 'a' && word <='z')
        {
            asciiword = asciiword -'a';
            word = (char)((int)'z'-asciiword);
        }
        return word;
    }
    public static String solution(String word) {
        String answer = "";
        for(int i = 0 ; i<word.length();i++)
        {
            answer +=reverse(word.charAt(i));
        }
        return answer;
    }
}
