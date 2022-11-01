package onboarding.problem1.domain;

public class Score {
    private int [][] score;
    public Score(int [][] score){
        this.score = score;
    }

    public int getMaxScore(){
        int maxSumValue = getMaxSumValue();
        int maxMulValue = getMaxMulValue();

        if(maxMulValue > maxSumValue){
            return maxMulValue;
        }
        return maxSumValue;
    }
    private int getMaxSumValue(){
        int maxSumValue = 0;
        for(int index = 0; index <score[0].length; index++){
            maxSumValue = compareMaxValue(maxSumValue, score[0][index]);
        }
        return maxSumValue;
    }
    private int getMaxMulValue(){
        int maxMulValue = 0;
        for(int index = 0; index <score[1].length; index++){
            maxMulValue = compareMaxValue(maxMulValue, score[1][index]);
        }
        return maxMulValue;
    }
    private int compareMaxValue(int value1, int value2){
        if(value1 > value2){
            return value1;
        }
        return value2;
    }
}
