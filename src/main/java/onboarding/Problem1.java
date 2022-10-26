package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static int getBig(int x) {
        int add = 0;
        int mul = 1;
        int num = 0;
        while (x > 0) {
            num = x % 10;
            x /= 10;
            add += num;
            mul *= num;
        }
        return add > mul ? add : mul;
    }
//    public static void main(String[] args){
//        System.out.println(getBig(1));
//    }
}

