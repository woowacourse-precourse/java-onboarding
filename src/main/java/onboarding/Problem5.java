package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<Integer>();
        // 객체배열 9개를 만들어준다.
        int[] arr = new int[9];
        // a 배열에 50000원 부터 1원까지 9개를 순서대로 담아준다.
        int[] a = new int[]{50000, 10000, 5000, 1000, 500, 100, 50 , 10, 1};

        // for문을 이용해 index 0 부터 a.length까지 money를 화폐의 나눈몫을 arr에 담아준다.
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                arr[i] = (money / a[i]);

            } else {
                arr[i] = (money % a[i - 1]) / a[i];
            }
        }
        // arr에 담은 배열 값을 answer 이라는 list에 .add() 해준다.
        // list answer 값을 return 해준다.
        for (int b : arr) {
            answer.add(b);
        }
        return answer;
    }
}