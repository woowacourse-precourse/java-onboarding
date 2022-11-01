package onboarding.problem3;

public class LoopClapper implements Clapper{
    public int getNumOfClap(int n) {
        int answer = 0;
        answer += getTotalClap(n);
        return answer;
    }
    private int getTotalClap(int number) {
        int totalClap = 0;
        for(int i = 1; i <= number; i++) {
            totalClap += getClap(i);
        }
        return totalClap;
    }
    private int getClap(int n) {
        int count = 0;
        String strOfNum = String.valueOf(n);
        for(int i = 0; i < strOfNum.length(); i++) {
            count += multipleOfThree(strOfNum.charAt(i));
        }
        return count;
    }
}
