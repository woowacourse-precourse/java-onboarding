package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1 부터 number 까지 확인
        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);

            answer += checkClap(str);
        }

        return answer;
    }

    // 3 6 9 의 개수만큼 더해주는 메소드
    private static int checkClap(String str) {
        int count = 0;

        for (int j = 0; j < str.length(); j++) {
            int clap = str.charAt(j) - '0';

            // 3 6 9가 포함될 시 answer+1
            if(clap != 0 && clap%3 == 0) count++;
        }
        
        return count;
    }
}
