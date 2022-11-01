package onboarding.Problem1Package;

import java.util.ArrayList;
import java.util.List;

public interface Calc {
    // 1. 한 숫자씩 나눠서 하나의 배열로 만들기
    default List<Integer> getListByInteger(Integer num) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(num > 0) {
            arrNum.add(num % 10);
            num /= 10;
        }
        return arrNum;
    }
}
