package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String s = Integer.toString(i) ;
            int num = i;
            for(int j=0;j<s.length();j++){
                if(num%10==3||num%10==6||num%10==9){
                    answer++;
                }
                num = num/10;
            }
        }
        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(solution(33));
//    }
}
