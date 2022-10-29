package onboarding;

public class Problem3 {

    public static int solution(int number) {
        if(!NumberCheck(number)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }


        return check(number);
    }

    public static boolean NumberCheck(int number){
        if(1 <= number || number >= 10000){
            return true;
        }else{
            return false;
        }
    }

    public static int check(int num){

        int sum = 0;

        for(int i=1; i<=num; i++){
            String s = Integer.toString(i);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                    sum+=1;
                }
            }
        }
        return sum;
    }
}
