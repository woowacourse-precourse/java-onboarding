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
    //List 를 받고, 최종 페이지넘버게임 점수를 계산하는 함수
    public static int[][] calculateScore(List<Integer> list){
        ArrayList<Integer>[] slicedNumberList = new ArrayList[2];
        int [][] score = {{0,0},{0,0}};

        for(int index =0; index < list.size(); index++){
            slicedNumberList[index] = integerToArrayList(list.get(index));
        }
        /*
         * [[9, 7],[9, 8]]
         * */
        for(int index = 0; index<slicedNumberList.length; index++){
            score[index][0] = cumulativeSum(slicedNumberList[index]);
            score[index][1] = cumulativeMul(slicedNumberList[index]);
        }
        return score;
    }
}