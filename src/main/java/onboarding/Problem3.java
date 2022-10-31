package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<number+1;i++){
            String [] tmp = String.valueOf(i).split("");
            for(int j=0;j<tmp.length;j++){
                if(tmp[j].equals("3")||tmp[j].equals("6")||tmp[j].equals("9")) answer++;
            }
        }
        return answer;
    }
}