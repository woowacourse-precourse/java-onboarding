package onboarding;

import java.util.List;

class Problem1 {
    public static int add(List<Integer> arr) {
        int length = arr.size();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            System.out.println(i);
            sum += arr.get(i);
        }
        return sum;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong){
        int result = add(pobi);
        System.out.println(result);
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void main(String[] args) {
        solution(List.of(97, 98), List.of(197, 198));
    }
}