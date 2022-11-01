package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) { // 들어온 int를 범위로 생각하고 배열로 생성한 후, split으로 자른 후에 3, 6, 9가 매치될 때마다 횟수를 증가시키도록
        int[] arr = new int[number];
        int answer = 0;

        Arrays.setAll(arr, num -> (num + 1)); // scan받은 범위만큼 int형 배열 생성
        String[] some = Arrays.toString(arr).split(""); //받은 int형 배열을 split으로 하나씩 나눠서 저장
        return answer;
    }
}
