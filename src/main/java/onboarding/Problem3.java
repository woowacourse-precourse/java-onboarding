package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (Integer i = 1; i <= number; i++){
            answer += get369Number(i.toString());
        }
        return answer;
    }
    private static int get369Number(String numberString){
        int numberOf369 = 0;
        for (int i = 0; i < numberString.length(); i++){
            int digit = numberString.charAt(i) - '0';
            if (digit != 0 && digit % 3 == 0) numberOf369++;
        }
        return numberOf369;
    }

}
