package onboarding.problem3;

public class ThreeSixNineGame {
    private int number;
    private long clapCount;
    private int totalClapCount;

    public ThreeSixNineGame(int number){
        this.number = number;
    }

    public int calculateClapCount(){
        for(int num = 0; num <= number; num++){
            String strNumber = Integer.toString(num);
            clapCount = strNumber.chars().filter(n -> n == '3' || n == '6' || n == '9').count();
            totalClapCount += clapCount;
        }
        return totalClapCount;
    }
}
