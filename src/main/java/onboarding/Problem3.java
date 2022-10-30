package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 손뼉을 친 횟수
        int count = 0;

        // 1. 숫자를 number 까지 센다
        for (int i = 1; i <= number ; i++) {
            String tmp = String.valueOf(number);

            if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
                for (int j = 0; j < tmp.length(); j++) {
                    if(tmp.charAt(i) == '3' || tmp.charAt(i) == '6' || tmp.charAt(i) == '9') {
                        count++;
                    }
                }
            }

        }

        return answer;
    }
}
