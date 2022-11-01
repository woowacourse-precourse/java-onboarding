package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
public class Problem5 {

    /* 계좌에 있는 돈을 나타내는 인스턴스 변수 */
    int money;
    /* 최종 결과값이 담기는 인스턴스 변 */
    List<Integer> answer =new ArrayList<>();
    /*
     * Problem 5의 메인 메소드
     * @param money 계좌에 담긴 돈
     * @return 각각의 돈의 단위로 변환되는 결과값 배열
     */
    public static List<Integer> solution(int money) {
        Problem5 p5 = new Problem5();
        p5.money = money;
        p5.iterate();
        return p5.answer;
    }
    /*
     * 각각의 50000, 10000단위로 돈을 차감하며 반복적으로 결과값 배열에 값을 채우는 메소드
     */
    private void iterate() {
        int fiveUnit = 50000;
        int oneUnit = 10000;
        for(int i =0; i < 9; i++){
            if(fiveUnit >= 50) divideWithUnit(fiveUnit);
            if(oneUnit >= 1) divideWithUnit(oneUnit);
            oneUnit /= 10;
            fiveUnit /= 10;
        }
    }
    /*
     * 각각의 돈의 단위가 주어졌을때 해당 돈의 단위로 변환이 가능한지 여부를 판단하고 돈을 차감시키는 메소드
     * @param unit 돈의 단위(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
     */
    private void divideWithUnit(int unit){
        if(money < unit){
            answer.add(0);
            return;
        }
        int count = 0;
        count += money/unit;
        money -= unit * count;
        answer.add(count);
    }
}
