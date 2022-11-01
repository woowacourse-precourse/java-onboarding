package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = splitNumber(number);
        return answer;
    }
    public static int splitNumber(int number){
        int result = 0;
        for(int i=1; i<=number; i++){
            String str = String.valueOf(i);
            String[] stringarr = str.split("");
            if(clapCount(stringarr) > 0) result += clapCount(stringarr);
        }
        return result;
    }
    private static int clapCount(String[] stringarr){
        int count = 0;
        for(int i=0 ; i<stringarr.length; i++){
            if(stringarr[i].equals("3") || stringarr[i].equals("6") || stringarr[i].equals("9")) count++;
        }
        return count;
    }
}