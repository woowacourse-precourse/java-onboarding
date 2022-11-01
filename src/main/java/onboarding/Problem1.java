package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // pobiScore : 포비의 페이지의 곱과 합 중 가장 큰 수
        // crongScore : 크롱의 페이지의 곱과 합 중 가장 큰 수
        int pobiScore = 0;
        int crongScore = 0;

        // 왼쪽, 오른쪽 페이지의 합과 곱중 큰값을 찾는 과정
        pobiScore = calculator(pobi);
        crongScore = calculator(crong);

        // 만약 pobiNum이나 crongNum이 -1이라면 페이지 숫자가 잘못된 것!
        if (pobiScore != -1 && crongScore != -1){
            if (pobiScore > crongScore){
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            }else {
                answer = 0;
            }
        }else{
            answer = -1;
        }

        return answer;
    }

    private static Integer calculator(List<Integer> person) {

        // 페이지끼리 1페이지만 차이나는지 확인
        if (person.get(1) - person.get(0) != 1){
            return -1;
        }

        // 각 페이지의 합과 곱중 큰값이 담길 List
        List<Integer> numList = new ArrayList<>();

        for(int i = 0 ; i < 2; i ++){
            // 각 리스트에 담긴 페이지 번호를 하나씩 잘라 tmp 배열에 담아준다
            int[] tmp = Stream.of(String.valueOf(person.get(i)).split("")).mapToInt(Integer::parseInt).toArray();

            int sum = 0;
            int multi = 1;

            for (int j = 0; j < tmp.length; j++) {
                sum += tmp[j];
                multi *= tmp[j];
            }

            // 각 페이지별 숫자들의 합과 곱중 큰 값을 numList에 담는다
            numList.add(Math.max(sum, multi));
        }

        return Collections.max(numList);
    }
}