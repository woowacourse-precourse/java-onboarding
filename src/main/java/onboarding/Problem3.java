package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            String num = Integer.toString(i);
            answer += counter(num);
        }
        return answer;
    }

    public static int counter(String num){
        int answer = 0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i)=='3'||num.charAt(i)=='6'||num.charAt(i)=='9')
                answer++;
        }
        return answer;
    }
}
