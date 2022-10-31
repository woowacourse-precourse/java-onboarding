package onboarding;

public class Problem3 {

    int count = 0;
    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        p3.iterate(number);
        return answer;
    }

    private void iterate(int number) {
        for(int i =1; i <= number; i++){
            count++;
        }
    }
}
