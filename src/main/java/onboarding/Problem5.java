package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 1 이상 1,000,000 이하인 자연수를 받는다.
// 받은 자연수를 오만, 만, 오천, 천, 오백, 백, 오십, 십, 일의 단위로 나눈 후,
// 각 단위의 숫자가 몇개인지 리스트에 금액이 큰 순서대로 담은 후 값을 반환

// todo
// 1. 리스트에 넣은 수가 크기에 상관없이 순서대로 들어가는지 확인
// 2. 받은 자연수를 각 단위로 나누어준다.
// 3. 나눈 몫을 차례대로 리스트에 담은 후 반환한다.

// more
// 1. 함수화 하는 방법 생각해보기
// 2. 단위를 리스트화해서 반복문으로 함수를 돌리는 방법 생각해보기

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> unitList = new ArrayList(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        answer = new ArrayList<>();

        for (int unit : unitList) {
            money = changeDivider(unit, money, answer);
        }

        System.out.println(answer);
        return answer;
    }

    public static int changeDivider(int unit, int money, List<Integer> answerList){
        answerList.add(money / unit);
        money = (money % unit);
        return money;
    }

}
