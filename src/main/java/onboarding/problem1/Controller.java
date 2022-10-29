package onboarding.problem1;

import java.util.List;

public class Controller {

    private final Service service;

    public List<Integer> pobi;
    public List<Integer> crong;

    public Controller(Service service) {
        this.service = service;
    }

    public Integer startGame(List<Integer> pobi, List<Integer> crong) {
        // User 생성
        User userA = service.createUser(pobi, "pobi");
        User userB = service.createUser(crong, "crong");

        // User 스코어 생성
        service.setScore(userA);
        service.setScore(userB);

        // 더 높은 값 비교
        // 1 : userA가 승리
        // 2 : userB가 승리
        // 0 : 무승부
        Integer value = service.getHigherUser(userA, userB);

        return value;

    }

    // 유저 정보를 생성한다


}
