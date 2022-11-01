package onboarding;

import onboarding.problem1.RandomPageGamer;
import onboarding.problem1.WrongInputException;

import java.util.List;

/**
 * Problem 01 기능 목록
 * 1. pobi, crong 의 입력값이 올바른 값인지 검사한다. 올바르지 않다면 -1을 반환한다.
 * 2. pobi, crong 이 펼친 페이지를 바탕으로 최댓값을 계산한다.
 * 3. pobi, cront 의 최댓값을 비교하여 pobi 가 크면 1 crong 이 크면 2 동일하면 0으로 반환한다.
 */
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            RandomPageGamer gamer = new RandomPageGamer(pobi, crong, 400);
            return gamer.play();
        } catch (WrongInputException e) {
            return -1;
        }
    }
}