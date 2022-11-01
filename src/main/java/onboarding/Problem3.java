package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = getClapCount(number);
        return answer;
    }

    public static int getClapCount(int number) {
        int clapCount = 0;
        for(int i = 1; i <= number; i++) {
            String numString = Integer.toString(i);
            clapCount += getNumberCount(numString);
        }
        return clapCount;
    }

    public static int getNumberCount(String numString) {
        int numberCount = 0;
        for(int i = 0; i < numString.length(); i++) {
            if(numString.charAt(i) == '3' || numString.charAt(i) == '6' || numString.charAt(i) == '9') {
                numberCount++;
            }
        }

        return numberCount;
    }
}
