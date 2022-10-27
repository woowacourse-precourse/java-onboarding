package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 아스키 코드를 이용한 방법을 채택.
        // A (65) ~ Z (90) 77 78
        // a (97) ~ z (122) 109 110

        // String word 를 char 배열에 담는다.
        char[] chars = word.toCharArray();

        // for 반복문을 돌면서 revers() 메서드 실행.
        for (char aChar : chars) {
            answer += (char)reverse(aChar);
        }

        return answer;
    }

    static int reverse(int c) {
        // 각 아스키 코드의 범위에 따라 if 문으로 reverse()메서드 구현.
        if (c >= 77 && c <=90) {
            return (char) (90 - (c - 65));
        }
        if (c >= 65 && c <= 78 ) {
            return (char) (65 + (90 - c));
        }
        if (c >= 109 && c <=122) {
            return (char) (122-(c-97));
        }
        if (c >= 97 && c <= 110 ) {
            return (char) (97 + (122-c));
        }
    // 위 if 문에 해당하지 않는 공백, 띄어쓰기 는 그대로 리턴.
        return c;
    }
}
