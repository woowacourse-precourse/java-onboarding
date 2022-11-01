package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        String temp;
        int count=0;

        for(int i=1;i<=number;i++) {
            temp=i+"";
            for (int j=0;j<temp.length();j++) {
                if (temp.charAt(j)=='3' || temp.charAt(j)=='6' || temp.charAt(j)=='9') {
                    count++;
                }
            }
        }

        answer = count;
        return answer;
    }
}
