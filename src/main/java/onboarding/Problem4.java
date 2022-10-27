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

// word의 단어 한개를 검사한다 .
// 대문자일 경우 대문자 호출 --> 치환메서드 호출
// 소문자일 경우 소문자 호출 --> 치환메서드 호출
// 대문자, 소문자 치환에서 중복되는 부분 메서드 구현.
//반환...
///왜 자동 연결이 안되나요..... .ㅠㅠㅠ 제발 올라가주세요 .... ㅠㅠㅠ
//git push --set-upstream origin Jihoon9809 이거 안쓰면 안 올라가져요 ㅜㅜ....
//안쓰고 됨? ,, 젭바루ㅜㅜ,, 이제 된건가 ....,d연동 성공?,,,, 제벌르ㅡㅡㅡㅡㅡㅡㅡ,,,,, 하ㅏ...

