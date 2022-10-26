package onboarding;

import java.util.List;
//Clear
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
        answer = valueGetMax(pobi);
        tmpanswer = valueGetMax(crong);
        if(answer>tmpanswer)
            return 1;
        else if (answer<tmpanswer) {
            return 2;
        }else{
            return 0;
        }
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
    public static  int valueGetMax(List<Integer> value)
    {
        int left =  value.get(0);
        int  right = value.get(1);
        // Calculate sum
        int l_sum = getSum(left);
        int l_multi = getMulti(left);
        if (l_sum > l_multi) {
            left = l_sum;
        }else {
            left = l_multi;
        }
        int r_sum = getSum(right);
        int r_multi = getMulti(right);
        if (r_sum > r_multi) {
            right = r_sum;
        }else {
            right = r_multi;
        }

        if (left > right) {
            return left;
        }else {
            return right;}
        // Calculate multiple
    }

    public static int getSum(int number)
    {
        int total = 0 ;
        while(number > 0) {
            total += number % 10;
            number /= 10;
        }
        return total;
    }
    public static int getMulti(int number)
    {
        int total = 1 ;
        while(number > 0) {
            total *= number % 10;
            number /= 10;
        }
        return total;
    }
}
