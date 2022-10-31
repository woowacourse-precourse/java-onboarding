package onboarding;

public class Problem3 {
    public static int solution(int number) {
        //제한조건
        if(number<1||number>10000) return -1;
        int sum=0;
        for(int j=1;j<=number;j++)
        {
            String n = Integer.toString(j);
            for(int i=0;i<n.length();i++){
                int sol1 = Integer.parseInt(n.substring(i, i + 1));
                if(sol1 %3==0 && sol1!=0) sum++;
            }
        }

        int answer = sum;
        return answer;
    }
}
