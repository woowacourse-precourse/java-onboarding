package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = splitNumber(number);
        return answer;
    }
    static int splitNumber(int number){
        int result = 0;
        for(int i=1; i<=number; i++){
            String str = Integer.toString(i);
            String[] strarr = str.split("");
            if(clapCount(strarr) > 0) result += clapCount(strarr);
        }
        return result;
    }
    static int clapCount(String[] strarr){
        int count = 0;
        for(int i=0 ; i<strarr.length; i++){
            if(strarr[i].equals("3") || strarr[i].equals("6") || strarr[i].equals("9")) count++;
        }
        return count;
    }
}
