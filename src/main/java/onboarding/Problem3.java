package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1;i<=number;i++){
            answer += getClap(i);
        }
        return answer;
    }
    static int getClap(int num){
        String s = Integer.toString(num);
        int count = 0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9'){
                count ++;
            }
        }
        return count;
    }
}
