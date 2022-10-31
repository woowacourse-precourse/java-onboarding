package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobisNumber;
        int crongsNumber;
        try {
            pobisNumber = findMaxValue(pobi);
            crongsNumber = findMaxValue(crong);
        } catch (Exception e) {
            return -1;
        }
        return pobisNumber>crongsNumber?1:(pobisNumber==crongsNumber?0:2);
    }

    public static int findMaxValue(List<Integer>list)throws Exception{
        if((list.get(1)-list.get(0))>1){
            throw new Exception();
        }
        List<Integer> left =Arrays.stream(String.valueOf(list.get(0)).split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> right =Arrays.stream(String.valueOf(list.get(1)).split("")).map(Integer::parseInt).collect(Collectors.toList());

        int leftMult = 1;
        int leftPlus = 0;
        int rightMult = 1;
        int rightPlus = 0;

        for (Integer i : left){
            leftMult = leftMult * i;
            leftPlus = leftPlus + i;
        }
        for (Integer i : right){
            rightMult = rightMult * i;
            rightPlus = rightPlus + i;
        }

        return Math.max(Math.max(leftMult,leftPlus),Math.max(rightMult,rightPlus));
    }

//    public static int recursive(List<Integer> list,String simpol,int result){
//
//        result = Integer.parseInt( simpol+list.get(0));
//        list.remove(0);
//        //최종 값까지 추출한 다음 list가 비었을 경우 누적된 결과값을 가져간다.
//        if(list.isEmpty()) return result;
//
//        return Math.max(recursive(list, "+",result), recursive(list, "*",result));
//    }
}

