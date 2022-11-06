package onboarding;

/**
 * 숫자 number가 매개변수로 주어질 때,
 * 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 * */
public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        String numToString;

        // 숫자에 대해서 모두 순회
        for (int i = 1; i <= number; i++) {
            numToString = i + "";

            // 숫자 하나에 대해서 문자별로 순회
            for (int j = 0; j < numToString.length(); j++) {
                if (numToString.charAt(j) == '3' || numToString.charAt(j) == '6' || numToString.charAt(j) == '9') {
                    clapCount++;
                }
            }
        }
        return clapCount;
    }
}

