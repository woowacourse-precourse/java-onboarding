package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 의미있는 카운드는 3부터 시작이므로 시작 인덱스 3
        for (int i = 3; i <=number ; i++) {
            String temp = String.valueOf(i);
            answer += count(temp);
        }

        return answer;
    }

    static int count(String num) {
        int answer = 0;
        // int number 를 String num 으로 변환하여 매개변수로 받은후
        // for 반복문을 이용하여 charAt() 메서드로 각 자리의 숫자가 3 ,6 ,9 인지 체크
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                answer++;
            }
        }
        return answer;
    }
}
