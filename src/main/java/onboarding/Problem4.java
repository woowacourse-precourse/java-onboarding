package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = compute(word);
        return answer;
    }
    public static String compute(String str)
    {

        String reverseAlphabet1 = "zyxwvutsrqponmlkjihgfedcba";
        String reverseAlphabet2 = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        String ans = "";
        for (int i = 0; i < str.length(); i++){
            if(65<=str.charAt(i)&&str.charAt(i)<=90){//대문자면

                ans = ans + reverseAlphabet2.charAt(str.charAt(i) - 'A');
            }
            else if (97<=str.charAt(i)&&str.charAt(i)<=122) {//소문자일경우

                ans = ans + reverseAlphabet1.charAt(str.charAt(i) - 'a');
            }
            else {

                ans = ans + str.charAt(i);

            }
        }

        return ans;
    }
}
