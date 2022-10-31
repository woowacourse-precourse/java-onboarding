package onboarding;

import java.util.List;

class Problem1 {

    //왼쪽 페이지가 홀수가 아닐 때, = 짝수일 때,
    //왼쪽 페이지 + 1 = 오른쪽 페이지 일 대,
    //왼쪽 페이지 오른쪽 페이지가 모두 1 =< a <= 399  2=< b <=400
    public static boolean isItRight(List<Integer> arr) {
        if(arr.get(0) % 2 == 0 || arr.get(1) % 2 == 1 ){
            return false;
        } else if(arr.get(1) != arr.get(0) + 1){
            return false;
        } else if(1 > arr.get(0) || arr.get(0) > 399 || 2 > arr.get(1) || arr.get(1) > 400) {
            return false;
        }else return true;
    }
    public static int calculateMax(List<Integer> arr) {
        int max = 0;
        for(int i = 0; i < arr.size(); i++) {
            int max_sum = 0;
            int max_mul = 1;
            String str = String.valueOf(arr.get(i));
            for(int j = 0; j < str.length(); j++){
                Integer num =  Integer.parseInt(str.substring(j, j + 1));
                max_sum = max_sum + num;
                max_mul = max_mul * num;
            }
            if(max_sum < max_mul) {
                max = max_mul;
            } else {
                max = max_sum;
            };
        }

        return max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!isItRight(pobi) || !isItRight(crong)) {
            return -1;
        };

        if(calculateMax(pobi) > calculateMax(crong)) {
            answer = 1;
        } else if (calculateMax(pobi) < calculateMax(crong)) {
            answer = 2;
        } else if (calculateMax(pobi) == calculateMax(crong)) {
            answer = 0;
        }


        return answer;
    }
}

