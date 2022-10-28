package onboarding.problem1;

import java.util.List;

// 각 페이지 번호 단순하게 구하기
public class EachSide {
    public static int pageLeft(List<Integer> player){return player.get(0);}
    public static int pageRight(List<Integer> player){return player.get(1);}
}
