package onboarding;

import java.util.List;

class Problem1 {

    private static int maxElement(int value){
        int plus = 0;
        int multiple = 1;
        while(value != 0){
            plus = plus + value % 10;
            multiple = multiple * (value%10);
            value /= 10;
        }
        return Math.max(plus,multiple);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return answer;
        }
        int Pobi = Math.max(maxElement(pobi.get(0)), maxElement(pobi.get(1)));
        int Crong = Math.max(maxElement(crong.get(0)), maxElement(crong.get(1)));

        answer = Pobi - Crong;
        if(answer == 0)return answer;
        return answer / Math.abs(answer);
    }
}