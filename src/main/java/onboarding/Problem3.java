package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String s = Integer.toString(i);
            String[] splits = s.split("");
            for(String split : splits){
                answer+=isContain369(split);
            }
        }
        return answer;
    }

    public static int isContain369(String s){
        Integer k = Integer.parseInt(s);
        if(k!=0&&k%3==0) return 1;
        return 0;
    }
}
