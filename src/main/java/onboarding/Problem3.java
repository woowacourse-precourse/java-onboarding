package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countAllClaps(number);
        return answer;
    }

    private static int countAllClaps(int number){
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    private static int countClap(int n){
        String temp = Integer.toString(n);
        int count = 0;
        for (int i = 0; i < temp.length(); i++){
            if (isClap(temp.charAt(i))){
                count += 1;
            }
        }
        return count;
    }

    private static Boolean isClap(char c){
        return (c == '3') || (c == '6') ||(c == '9');
    }
}
