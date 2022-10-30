package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(validateCheck(number)){
            answer = findNumber(number);
        }
        else {
            answer = 0;
        }
        return answer;
    }
    private static boolean validateCheck(int number){
        if(number < 1 || number > 10000){
            return false;
        }
        else {
            return true;
        }
    }
    private static int findNumber(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            String tmp = String.valueOf(i);
            if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9")){
                count += countClap(tmp);
            }
        }
        return count;
    }
    private static int countClap(String num){
        int count = 0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9'){
                count++;
            }
        }
        return count;
    }
}
