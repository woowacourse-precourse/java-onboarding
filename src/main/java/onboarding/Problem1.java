package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int left;
        int right;
        // exception check
        // Q1. 예외가 어떤 케이스를 제공하는지 모르겠다..
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return -1;

        // find max value
        // Q1. 따로 함수를 만들어서 하는게 깔끔한가?
        // Q2. Math.max 가 아닌 리스트에 넣어서 sort 해서 max 값을 찾는게 더 빠른가?
        left = Math.max(plusBookNum(pobi.get(0)), multiBookNum(pobi.get(0)));
        right = Math.max(plusBookNum(pobi.get(1)), multiBookNum(pobi.get(1)));
        int pobi_max = Math.max(left, right);
        left = Math.max(plusBookNum(crong.get(0)), multiBookNum(crong.get(0)));
        right = Math.max(plusBookNum(crong.get(1)), multiBookNum(crong.get(1)));
        int crong_max = Math.max(left, right);

        if(pobi_max > crong_max) answer = 1;
        else if(pobi_max < crong_max) answer = 2;
        else if(pobi_max == crong_max) answer = 0;
        return answer;
    }

    public static int plusBookNum(int num){
        int sum=0;
        while(num > 0) {
            sum+= num %10;
            num /= 10;
        }
        return sum;
    }

    public static int multiBookNum(int num){
        int sum=1;
        while(num > 0) {
            sum*= num %10;
            num /= 10;
        }
        return sum;
    }
}