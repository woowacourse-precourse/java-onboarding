package onboarding;

import onboarding.pkgProblem1.DTO.User;

import java.util.List;

/**
 * 매개변수로 주어진 User의 연속된 페이지 번호의 List를 받아
 * 각 자리수 덧셈, 곱셈의 최대값이 pobi가 높다면 1, crong이 높다면 2 무승부면 0을 반환하는 프로그램
 * @date ~ 2022-11-01
 * @author 유지웅
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        User pobiInfo = new User(1, pobi);
        User crongInfo = new User(2, crong);

        if(pobiInfo.getMaxScore() == crongInfo.getMaxScore()) return 0;

        return pobiInfo.getMaxScore() > crongInfo.getMaxScore() ? 1 : 2;
    }
}