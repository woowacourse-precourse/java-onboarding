package onboarding.problem1.service;

import java.util.ArrayList;
import java.util.List;

public class ScoreService {
    //해당 함수는 Integer 받아 한 개씩 잘라서 ArrayList 에 쌓은 후 반환
    public static ArrayList<Integer> integerToArrayList(Integer value){
        ArrayList<Integer> slicedIntList = new ArrayList<Integer>();
        int number = value.intValue();

        while (number > 0){
            slicedIntList.add(number % 10);
            number /= 10;
        }
        /*
         * number = 123 -> slicedList = [3,2,1]
         * */
        return slicedIntList;
    }
    // ArrayList에 쌓인 값들에 대한 누적합 진행
    public static int cumulativeSum(ArrayList<Integer> list){
        int result = 0;

        for(int index = 0; index<list.size(); index++){
            result += list.get(index);
        }

        return result;
    }
    // ArrayList에 쌓인 값들에 대한 누적곱 진행
    public static int cumulativeMul(ArrayList<Integer> list){
        int result = 1;

        for(int index = 0; index<list.size(); index++){
            result *= list.get(index);
        }

        return result;
    }
}