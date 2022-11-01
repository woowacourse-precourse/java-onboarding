package onboarding;


public class Problem3 {
    public static int solution(int number) {
        int answer=0;
        for(int i=1;i<=number;i++){
            answer=answer+convert(i);
        }
        return answer;
    }
    public static int convert(int num){
        String row=Integer.toString(num);
        int cnt=0;
        for(int i=0;i<row.length();i++){
            if(row.charAt(i)=='3'||row.charAt(i)=='6'||row.charAt(i)=='9')
                cnt++;
        }
        return cnt;
    }

}
