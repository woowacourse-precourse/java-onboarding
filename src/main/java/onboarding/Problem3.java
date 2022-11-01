package onboarding;


/*
 3,6,9가 포함된 숫자는 해당 숫자에서 3,6,9의 갯수만큼 손뼉을 친다.

 >> 제시된 숫자까지의 3,6,9 갯수를 모두 카운트

 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String str1;
        for (int i = 1; i < number + 1; i++) {
            str1 = Integer.toString(i);
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == '3' || str1.charAt(j) == '6' || str1.charAt(j) == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
