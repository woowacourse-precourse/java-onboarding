package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //예외 확인
        if(checkException(pobi) || checkException(crong))
            return -1;

        return answer;
    }
    private static boolean checkException(List<Integer> list){
        //페이지가 1 미만 400 초과일 때
        for(int i=0; i< list.size(); i++){
            if(1 > list.get(i) || 400 < list.get(i))
                return true;
        }
        //오른쪽 페이지가 왼쪽페이지+1가 아닐 때
        if(list.get(0)+1 != list.get(1))
            return true;
        return false;
    }

}