package onboarding;

public class Problem3 {
    public static int check369(String number){
        int answer=0;
        for(int i=0;i<number.length();i++){
            String current=Character.toString(number.charAt(i));
            if(current.equals("3") ||current.equals("6") ||current.equals("9")){
                answer+=1;
            }
        }
        return answer;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int n=1;n<=number;n++){
            answer+=check369(Integer.toString(n));
        }
        return answer;
    }
}
