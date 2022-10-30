package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <=number; i++){
            answer += clapCount(i);
        }
        return answer;
    }
    public static int clapCount(int number){
        String [] num = Integer.toString(number).split("");
        int answer = 0;
        for(int i = 0; i <num.length; i++){
            if(num[i].equals("3")||num[i].equals("6")||num[i].equals("9")){
                answer++;
            }
        }


        return answer;
    }
}
