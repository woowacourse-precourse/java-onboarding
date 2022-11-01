package onboarding.Problem1Package;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // 2. 두 배열(왼쪽/오른쪽 페이지 배열)을 하나의 배열로 합치기
    default List<Integer> mergeTwoArray(List<Integer> list) {
        List<Integer> first = getListByInteger(list.get(0));
        List<Integer> second = getListByInteger(list.get(1));

        List<Integer> result = Stream.concat(first.stream(), second.stream()).collect(Collectors.toList());

        return result;
    }
}
