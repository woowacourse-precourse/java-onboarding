package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int[] makeChange(int money){
        int[] cashArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] changeArray = new int[9];
        int index = 0;
        int count = 0;

        for(int i:cashArray){
            count = money/i;
            changeArray[index] = count;
            money -= (count*i);
            count = 0;
            index++;
        }

        return changeArray;
    }

}
