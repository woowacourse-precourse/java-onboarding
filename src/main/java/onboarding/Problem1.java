package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int maxPobi = 0;
        int maxCrong = 0;


        if (!(checkError(crong) && checkError(pobi))){
            return -1;
        }

        maxPobi = compareNumber(maxPobi,pobi);
        maxCrong = compareNumber(maxCrong,crong);

        if (maxPobi > maxCrong){
            return 1;
        }else if(maxPobi < maxCrong){
            return 2;
        }else{
            return 0;
        }
    }

    // 입력받은 수를 곱셈과 덧셈으로 나누어 큰 수를 리턴하는 메소드
    static int compareNumber(int maxNum,List<Integer> list) {
        for (int i = 0; i < list.toArray().length; i++) {
            ArrayList<Integer> tmp = splitNumber(list.get(i));
            int addNum = 0;
            int mulNum = 1;

            for (int j = 0; j < tmp.toArray().length; j++) {
                addNum += tmp.get(j);
                mulNum *= tmp.get(j);
            }
            maxNum = Math.max(addNum,mulNum);
        }
        return maxNum;
    }
    // 자릿수를 분리하는 메소드
    static ArrayList<Integer> splitNumber(int number){
        ArrayList<Integer> array = new ArrayList<>();

        while(number>0){
            array.add(number%10);
            number /= 10;
        }
        return array;
    }

    static boolean checkError(List<Integer>list){
        if (list.get(1) - list.get(0) == 1){
            return true;
        }else{
            return false;
        }
    }
}
