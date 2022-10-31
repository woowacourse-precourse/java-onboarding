package onboarding.problem1;

import java.util.List;

// refactor : 각 페이지 번호 구하기 기능 추출
public class EachSide {
    public static int pageLeft(List<Integer> player){return player.get(0);}
    public static int pageRight(List<Integer> player){return player.get(1);}
}
