package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int[] claps = new int[number + 1];                  /*목표한 숫자+1만큼의 크기로 배열을 할당*/
        for (int i = 0; i < claps.length; i++) {                /*배열의 인덱스를 가지고 연산*/
            count369(claps, i);
        }
        return Arrays.stream(claps).sum();
    }

    /**
     * 1부터 숫자를 문자열로 변환하여 각 숫자의 손뼉수를 저장
     **/
    private static void count369(int[] claps, int i) {
        String curr = String.valueOf(i);
        int cnt = 0;
        for (int j = 0; j < curr.length(); j++) {
            cnt = getCnt(curr, cnt, j);
        }
        claps[i] = cnt;
    }

    /**
     * 손뼉을 쳐야하면 cnt를 증가
     **/
    private static int getCnt(String curr, int cnt, int j) {
        if (isThree(curr, j)) {
            cnt += 1;
        } else if (isSix(curr, j)) {
            cnt += 1;
        } else if (isNine(curr, j)) {
            cnt += 1;
        }
        return cnt;
    }

    /**
     * 문자가 3이면 참, 아니면 거짓을 반환
     **/
    private static boolean isThree(String curr, int j) {
        return curr.charAt(j) == '3';
    }

    /**
     * 문자가 6이면 참, 아니면 거짓을 반환
     **/
    private static boolean isSix(String curr, int j) {
        return curr.charAt(j) == '6';
    }

    /**
     * 문자가 9이면 참, 아니면 거짓을 반환
     **/
    private static boolean isNine(String curr, int j) {
        return curr.charAt(j) == '9';
    }

}
