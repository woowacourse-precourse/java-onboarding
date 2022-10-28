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

class CalNumber{
    public int getAddValue(int value){
        int sum = 0;
        while(value != 0){
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }

    public int getMulValue(int value){
        int val = 1;
        while(value != 0){
            val *= value % 10;
            value /= 10;
        }
        return val;
    }
}

class WinLoseDecision{

    private final static Exception exception = new Exception();
    private final static CalNumber calNumber = new CalNumber();

    public Boolean isValidMatch(List<Integer> pobi, List<Integer> crong){
        if(!exception.isValidArea(pobi.get(0)) || !exception.isValidArea(crong.get(0))) return false;
        if(!exception.isValidValue(pobi) || !exception.isValidValue(crong)) return false;
        if(!exception.isValidSeqNumber(pobi) || !exception.isValidSeqNumber(crong)) return false;
        if(!exception.isValidPosition(pobi) || !exception.isValidPosition(crong)) return false;
        return true;
    }

    public int getResultMatch(List<Integer> pobi, List<Integer> crong) {
        if(!isValidMatch(pobi, crong)){
            return -1;
        }

        int getPobiScore = Math.max(Math.max(calNumber.getAddValue(pobi.get(0)), calNumber.getAddValue(pobi.get(1))),
                                         Math.max(calNumber.getMulValue(pobi.get(0)), calNumber.getMulValue(pobi.get(1))));

        int getCrongScore = Math.max(Math.max(calNumber.getAddValue(crong.get(0)), calNumber.getAddValue(crong.get(1))),
                                        Math.max(calNumber.getMulValue(crong.get(0)), calNumber.getMulValue(crong.get(1))));

        if(getPobiScore == getCrongScore) {
            return 0;
        } else{
            if(getPobiScore > getCrongScore){
                return 1;
            } else{
                return 2;
            }
        }
    }
}

class Problem1 {
    private final static WinLoseDecision winLoseDecision = new WinLoseDecision();
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = winLoseDecision.getResultMatch(pobi, crong);

        return answer;
    }
}