package onboarding;

public class Problem3 {
    // 1. number -> String으로 변경후 3,6,9가 있으면 count로 세기
    public static int solution(int number) {
        String num = "";
        int count =0;
        for(int i = 1; i<number+1; i++) num +=i+"";//1234567891011121314
            for(int j =0; j<num.length();j++){
                if(num.charAt(j) == '3') count++;
                if(num.charAt(j) == '6') count++;
                if(num.charAt(j) == '9') count++;
            }
        return count;

    }
}
