package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            char[] numChar = String.valueOf(i).toCharArray();
            for(char ch : numChar){
                if(ch == '3')
                    answer++;
                else if(ch == '6')
                    answer++;
                else if(ch == '9')
                    answer++;
            }
        }

        return answer;
    }
}
