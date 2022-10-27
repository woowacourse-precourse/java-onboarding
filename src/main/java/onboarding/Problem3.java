package onboarding;

public class Problem3 {
    public static int solution(int number) {

        String num = "";
        int count =0;
        for(int i = 0; i<number; i++) num +=i+"";//1234567891011121314

        for(int j =0; j<num.length();j++){
            if(num.charAt(j) == '3') count++;
            if(num.charAt(j) == '6') count++;
            if(num.charAt(j) == '9') count++;

        }

        return count;
        // 개수 만큼 손뼉을 쳐야한다
        // 3 6 9 13 16 19 23 26 29 33 36 39
        // 제시된 숫자를 String에 붙여넣어
        // charAt함수로 3,6,9있는지 확인하고 세기


    }
}
