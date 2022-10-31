package onboarding.problem1;

import java.util.List;

import static onboarding.problem1.Calculator.getEachNumber;
import static onboarding.problem1.EachSide.pageLeft;
import static onboarding.problem1.EachSide.pageRight;

// 변수 줄이기
public class CollectionVariable {

    //최대값 구하기
    public static int getMax(List<Integer> player) {

        int leftMax = getEachNumber(pageLeft(player));
        int rightMax = getEachNumber(pageRight(player));

        int max = leftMax > rightMax ? leftMax : rightMax;

        return max;
    }
}
