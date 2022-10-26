package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int tmpanswer = Integer.MAX_VALUE;
        //1 value check
        boolean result1 = valueCheck(pobi);
        boolean result2 = valueCheck(crong);
        // handle excpetion
        if (!(result1 & result2)){
            answer = -1;
        return  answer;
        }
        answer = valueCalculate(pobi);
        tmpanswer = valueCalculate(crong) ;
        return answer;
    }
    public static boolean  valueCheck(List<Integer> value)
    {

        int left = value.get(0);
        int right = value.get(1);
        if(left < 1 || left >399|| right < 1 || right > 399) return false ;
        if(left > right) return false ;
        if((right-left)>1) return false ;
        if(left%2 == 0 & right%2 == 1) return false ; // 좌측 우측 홀짝 구분

        else return true;
    }

    /**
     *
     * @param value // calcuate value
     * @return most Biggest vlaue
     */
    public static  int valueCalculate(List<Integer> value)
    {




        return 1 ;
    }


}
