package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 1. 1부터 number 까지의 숫자 확인
        // 2. 각각의 숫자가 3또는 6또는 9를 포함하는 지 확인
        // 3. 2번의 조건이 참인 숫자에 3또는 6또는 9의개수만큼 count++
        // 4. count의 합 반환
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String NUMBER = Integer.toString(i);
            if (NUMBER.contains("3") || NUMBER.contains("6") || NUMBER.contains("9")) {
                int count = 0;
                for (int j = 0; j < NUMBER.length(); j++) {
                    if (NUMBER.charAt(j) == '3' || NUMBER.charAt(j) == '6' || NUMBER.charAt(j) == '9') {
                        count++;
                    }
                }
                answer += count;
            }
        }
        return answer;
    }
}
