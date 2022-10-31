package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String[] split = getSplitStrings(i);
            for(int j=0;j<split.length;j++){
                int parseInt = Integer.parseInt(split[j]);
                if(!isZero(parseInt) && isThreeMul(parseInt)){
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean isThreeMul(int number) {
        return number % 3 == 0;
    }

    private static boolean isZero(int number) {
        return number == 0;
    }

    private static String[] getSplitStrings(int number) {
        String s = String.valueOf(number);
        String[] split = s.split("");
        return split;
    }
}
