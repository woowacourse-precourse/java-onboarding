package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        solution(5);
        solution(53);
        solution(297);
        solution(4444);
    }
    public static int solution(int number) {
        int answer = 0;
        int numLength = (int) Math.log10(number)+1;
        System.out.println(numLength);

        return answer;
    }
}
