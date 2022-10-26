package onboarding;

import java.util.List;

class Problem1 {
    private static boolean check(List<Integer> list){
        int first = list.get(0);
        int second = list.get(1);
        if(second != first+1){
            return true;
        }
        return false;
    }
    // 각 자리 수의 합을 구하는 함수
    private static int getSumOfEachNumber(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    // 각 자리 수의 곱을 구하는 함수
    private  static int getMultipleOfEachNumber(int num){
        int mul = 1;
        while(num != 0){
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(check(pobi) || check(crong)){
            return -1;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println("안녕하세요");
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        System.out.println(solution(pobi, crong));
    }
}