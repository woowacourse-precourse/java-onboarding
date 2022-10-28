package onboarding;

public class Problem3 {
    static int answer = 0;

    public static int solution(int number) {
        answer = pro(number);

        return answer;
    }

    static int pro(int number) {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            String s = String.valueOf(i);
            count += count(s);
        }

        return count;
    }

    // 해당 숫자에 3, 6, 9가 총 몇 개 들어 있는지 카운트하는 함수
    static int count(String number) {
        int count = 0;

        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c == '3' || c == '6' || c == '9') count++;
        }

        return count;
    }
}
