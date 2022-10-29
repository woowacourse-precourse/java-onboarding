package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int countClap(int n){
        String temp = Integer.toString(n);
        int count = 0;
        for (int i = 0; i < temp.length(); i++){
            if ((temp.charAt(i) == '3') || (temp.charAt(i) == '6') ||(temp.charAt(i) == '9')){
                count += 1;
            }
        }
        return count;
    }
}
