package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }


    public static boolean validCheck(List<Integer> integerList){
// 리스트 체크
        if(integerList.isEmpty() || integerList ==null)  return false;

//요소 체크
        for (Integer i : integerList){      //오토언박싱
            if (i ==null) return false;                 //요소값 중 하나라도 null값이면, false

            int num = i.intValue();
            if (num == 1 || num == 400)  return false; //요소값 중 하나라도 첫페이지나 마지막페이지면, false
        }

// 페이지 연결 체크
        if (integerList.get(0).intValue()+1 != integerList.get(1).intValue()) return false;

        return true;
    }

}