package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    // 유저가 펼친 페이지의 왼쪽, 오른쪽의 각 자리수의 합 중 큰 값을 찾는 메서드
    public static int sumNumber(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer num : list){
            int temp = 0;
            while (num > 0){
                temp += num % 10;
                num /= 10;
            }
            result.add(temp);
        }
        return result.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}