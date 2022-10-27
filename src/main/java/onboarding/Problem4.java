package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 65 66 67 68 69 70 71 72 73 74 75 ..
        // 90 89 88
        // 155, 대문자

        // 97 98 99 100 101 102 103
        // 122 121 120
        // 219, 소문자

        // 1 2 3 4 5 6 7 8 9 10
        // 10 9 8 7 6 5 4 3 2 1

        // 대문자 인가 소문자인가
        // 맞는 숫자 출력해주기
        String newWord ="";
        for (int i =0; i<word.length(); i++){
            int num = Integer.valueOf(word.charAt(i));
            if(word.charAt(i)==' ') newWord +=" ";
            if(num >64 && num <91) newWord += String.valueOf(Math.abs(155-num));
            if(num >97 && num <122) newWord += String.valueOf(Math.abs(219-num));

        }

        return newWord;
    }
}
