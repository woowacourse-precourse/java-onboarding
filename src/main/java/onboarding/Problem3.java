package onboarding;

public class Problem3 {

    static int[] Dy;
    static int answer;

    static void preProcess() {
        Dy[1] = 0;
        Dy[2] = 0;
        Dy[3] = 1;
        Dy[4] = 1;
        Dy[5] = 1;
        Dy[6] = 2;
        Dy[7] = 2;
        Dy[8] = 2;
        Dy[9] = 3;
    }

    public static int solution(int number) {
        Dy = new int[number + 1];
        return answer;
    }
}
