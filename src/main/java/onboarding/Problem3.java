package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<number+1;i++){
            answer+=countClap(i);
        }
        return answer;
    }
    private static int countClap(int number){
        String numStr = Integer.toString(number);
        int count=0;
        for (int i=0; i<numStr.length();i++){
            char digit = numStr.charAt(i);
            if (digit=='3' || digit=='6' || digit=='9'){
                count+=1;
            }
        }
        return count;
    }
}
