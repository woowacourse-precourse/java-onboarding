package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //1부터 number까지 순회하며 숫자에 3,6,9가 포함돼있으면 answer++한다.
        for (int i = 1; i <= number; i++) {
            String numToS = Integer.toString(i); // 숫자를 문자열로 변환한다.
            for (int j = 0; j < numToS.length(); j++) { //변환한 숫자를 앞에서부터 순회한다.
                if (numToS.charAt(j) == '3' || numToS.charAt(j) == '6' || numToS.charAt(j) == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
