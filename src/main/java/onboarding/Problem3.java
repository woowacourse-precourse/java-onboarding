package onboarding;


public class Problem3 {
    public static int solution(int number) {
        int answer = 0; // 박수를 몇 번 쳐야할까?
        int thousand, hundred, ten, one = 0;

        for (int i = 0; i <= number; i++) {
            thousand = i / 1000;
            hundred = (i % 1000) / 100;
            ten = (i % 100) / 10;
            one = i % 10;

            if (thousand == 3 || thousand == 6 || thousand == 9) { answer++; }
            if (hundred == 3 || hundred == 6 || hundred == 9) { answer++; }
            if (ten == 3 || ten == 6 || ten == 9) { answer++; }
            if (one == 3 || one == 6 || one == 9) { answer++; }
        }

        return answer;
    }
}
