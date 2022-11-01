package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
//    public static void main(String[] args) {
//        List<Integer> pobi = new ArrayList<>(Arrays.asList(123,124));
//        solution()
//    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPage(pobi)||checkPage(crong)){
            return -1;
        }
        int result_pobi = valueCal(pobi);
        int result_crong = valueCal(crong);
        int answer = -1;
        if (result_crong==-1 || result_pobi==-1) {
            return answer;
        }
        if (result_pobi > result_crong){
            answer = 1;
        } else if (result_pobi<result_crong) {
            answer = 2;
        }else if (result_pobi==result_crong){
            answer = 0;
        }else{
            answer=-1;
        }
        return answer;
    }
    public static boolean checkPage(List<Integer> checkList){
        int page=-1;
        for (Integer num:checkList) {
            if(page+1==num){
                return false;
            }
            page=num;
        }
        return true;
    }
    public static int valueCal(List<Integer> checkList){
        List<Integer> addList = new ArrayList<Integer>();
        for (Integer num:checkList) {
            if (1<=num && num<=400) {
                int numAdd = 0;
                int numPro = 1;
                String strNum = String.valueOf(num);
                char[] charNum = strNum.toCharArray();
                for (int i = 0; i < charNum.length; i++) {
                    numAdd = numAdd + Character.getNumericValue(charNum[i]);
                    numPro = numPro * Character.getNumericValue(charNum[i]);
                }

                int numCheck = Math.max(numAdd, numPro);
                addList.add(numCheck);
            }else{
                return -1;
            }
        }

        return Collections.max(addList);
    }
}