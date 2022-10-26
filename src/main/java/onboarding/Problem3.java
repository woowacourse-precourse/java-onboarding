package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        char[] tsn = {'3', '6', '9'};
        for(int i=1; i<number+1; i++){
            char[] numChar = String.valueOf(i).toCharArray();
            for(int j=0; j<tsn.length; j++){
                answer += containChar(numChar, tsn[j]);
            }
        }

        return answer;
    }

    private static int containChar(char[] num, char tsn){
        int cnt = 0;
        for(int i=0; i<num.length; i++){
            if(num[i] == tsn) cnt++;
        }
        return cnt;
    }
}
