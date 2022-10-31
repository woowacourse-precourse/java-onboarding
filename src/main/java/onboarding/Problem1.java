package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (hasException(pobi, crong) == true)
            return -1;
        return answer;
    }

    public static int getNumByPage(List<Integer> user, String page) {
        int index = (page=="left")?0:1;
        int resultAdd = Arrays.stream(user.get(index).toString().split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        int resultMul = Arrays.stream(user.get(index).toString().split(""))
                .map(Integer::parseInt)
                .reduce(1, (a,b) -> a*b);
        return (resultAdd>resultMul)?resultAdd:resultMul;
    }


    private static boolean hasException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)
            return true;
        else if (pobi.get(0) % 2 != 1 || (pobi.get(0) + 1) != pobi.get(1))
            return true;
        else if (crong.get(0) % 2 != 1 || (crong.get(0) + 1) != crong.get(1))
            return true;
        return false;
    }

}