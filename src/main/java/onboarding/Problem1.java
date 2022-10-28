package onboarding;

import java.util.List;

class Exception{

    public boolean isValidArea(int value){
        return !(value == 1 || value == 2 || value == 399 || value == 400);
    }
    public boolean isValidValue(List<Integer> values){
        return (1 <= values.get(0) && values.get(0) <= 400 && 1 <= values.get(1) && values.get(1) <= 400);
    }

    public boolean isValidPosition(List<Integer> values){
        return !(values.get(0) % 2 == 0 || values.get(1) % 2 == 1);
    }

    public boolean isValidSeqNumber(List<Integer> values){
        return (values.get(1) == values.get(0)+1);
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}