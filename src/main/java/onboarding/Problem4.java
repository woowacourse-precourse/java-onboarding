package onboarding;

public class Problem4 {
//    1. 한글자씩 떼어서 대문자 vs 소문자 아스키코드로 비교 -> 해당하는 글자로 출력
    public static String solution(String word) {
        String newWord ="";
        char a = ' ';
        for (int i =0; i<word.length(); i++){
            int num = Integer.valueOf(word.charAt(i));
            if(word.charAt(i)==' ') newWord +=" ";
            if(num >64 && num <91) { // 대문자 아스키 코드 A ~Z : 65~91
                a = (char) Math.abs(155-num);
                newWord += String.valueOf(a);}
            if(num >97 && num <122) { // 소문자 아스키 코드 a ~z : 98 ~122
                a = (char) Math.abs(219-num);
                newWord += String.valueOf(a);}
        }
        return newWord;
    }
}
