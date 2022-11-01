package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Problem1 {
    static int getMax(List<Integer> input) {
        int leftSum = 0,leftMulti = 1,rightSum = 0,rightMulti = 1;
        int leftPage = input.get(0);
        int rightPage = input.get(1);
        ArrayList <Integer> list = new ArrayList<Integer>();

        while (leftPage > 0) {
            int rest = leftPage % 10;
            leftSum += rest;
            leftMulti *= rest;
            leftPage /= 10;
        }
        while (rightPage > 0) {
            int rest = rightPage % 10;
            rightSum += rest;
            rightMulti *= rest;
            rightPage /= 10;
        }
        list.add(leftSum);
        list.add(leftMulti);
        list.add(rightSum);
        list.add(rightMulti);

        return Collections.max(list);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobipoint, crongpoint;

        if (abs(pobi.get(0) - pobi.get(1)) > 1 || abs(crong.get(0) - crong.get(1)) > 1)
            return -1;

        pobipoint = getMax(pobi);
        crongpoint = getMax(crong);

        if (pobipoint == crongpoint)
            answer = 0;
        else if (pobipoint > crongpoint)
            answer = 1;
        else
            answer = 2;

        return answer;
    }
}