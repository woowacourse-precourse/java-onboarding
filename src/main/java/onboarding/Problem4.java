package onboarding;

import static java.lang.Math.*;

public class Problem4 {
    public static char upperReplaceWorld(char word){
        int replaceTarget = (char)word;

        int aTozAsciiCodeRange = 25;
        int upperAasciiCode = 65;
        int upperZasciiCode = upperAasciiCode + aTozAsciiCodeRange;

        int RangeOfChangeWorde = abs(upperAasciiCode - replaceTarget);
        int reverseOfword = upperZasciiCode - RangeOfChangeWorde;
        char reverseWord = (char)reverseOfword;

        return reverseWord;
    }

    public static char lowerReplaceWorld(char word){
        int replaceTarget = (char)word;
        int aTozAsciiCodeRange = 25;
        int lowerAasciiCode = 97;
        int lowerZasciiCode = lowerAasciiCode + aTozAsciiCodeRange;

        int RangeOfChangeWorde = abs(lowerAasciiCode - replaceTarget);
        int reverseOfword = lowerZasciiCode - RangeOfChangeWorde;
        char reverseWord = (char)reverseOfword;

        return reverseWord;
    }

    public static String solution(String word) {
        String answer = "";

        for(int i=0;i< word.length();i++){
            char replaceTarget = word.charAt(i);

            if(Character.isUpperCase(replaceTarget)) answer += upperReplaceWorld(replaceTarget);
            if(Character.isLowerCase(replaceTarget)) answer += lowerReplaceWorld(replaceTarget);
            if(replaceTarget == ' ') answer += ' ';
        }

        return answer;
    }
}
