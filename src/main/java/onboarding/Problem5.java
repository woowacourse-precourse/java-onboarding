package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        /*
        기능 목록
        1. 값을 저장할 빈 배열 생성
        2. 금액 별 count 변수 생성 및 초기화
        3. 금액을 높은 단위(50000)부터 나눈 후 몫은 count 변수에, 나머지 값은 money에 전달
        4. 빈 배열에 금액 별 count 값 전달
         */
        List<Integer> answer = Collections.emptyList();

        //값을 저장할 빈 배열 생성
        ArrayList<Integer> List = new ArrayList<Integer>();

        //금액 단위 별 count 변수 생성
        int count50000 = 0;
        int count10000 = 0;
        int count5000 = 0;
        int count1000 = 0;
        int count500 = 0;
        int count100 = 0;
        int count50 = 0;
        int count10 = 0;
        int count1 = 0;

        //높은 금액 단위부터 낮은 금액 순으로 나눔
        count50000 = money / 50000;
        money -= count50000 * 50000;

        count10000 = money / 10000;
        money -= count10000 * 10000;

        count5000 = money / 5000;
        money -= count5000 * 5000;

        count1000 = money / 1000;
        money -= count1000 * 1000;

        count500 = money / 500;
        money -= count500 * 500;

        count100 = money / 100;
        money -= count100 * 100;

        count50 = money / 50;
        money -= count50 * 50;

        count10 = money / 10;
        money -= count10 * 10;

        count1 = money / 1;
        money -= count1 * 1;


        return answer;
    }
}