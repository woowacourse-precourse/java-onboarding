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
}
