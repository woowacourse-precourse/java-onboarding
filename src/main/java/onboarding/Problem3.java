package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer += countThreeSixNine(i);
        }
        return answer;
    }
    private static int countThreeSixNine(int n){
        int sum = 0;
        String s = Integer.toString(n);
        String[] strArray = s.split("");
        for(String digit : strArray){
            if(digit.equals("3") || digit.equals("6") || digit.equals("9")){
                sum += 1;
            }
        }
        return sum;
    }
}
