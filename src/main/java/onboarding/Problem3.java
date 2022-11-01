package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        StringBuilder sb;

        for(int i=1;i<=number;i++){
            sb = new StringBuilder(String.valueOf(i));
            for(int j=0;j<sb.length();j++){
                if(sb.toString().charAt(j) == '3' || sb.toString().charAt(j) == '6' || sb.toString().charAt(j) == '9'){
                    answer++;

                }
            }
        }


        return answer;
    }
}
