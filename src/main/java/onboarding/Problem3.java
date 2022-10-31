package onboarding;

public class Problem3 {
    public static int clapNum(int num){
        String str = ""+num;
        int ret = 0;
        for(int i = 0; i<str.length(); i++){
            char tmp = str.charAt(i);
            if(tmp == '3' || tmp == '6' || tmp == '9') ret++;
        }
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        while(number != 0){
            answer += clapNum(number);
            number--;
        }
        return answer;
    }
}
