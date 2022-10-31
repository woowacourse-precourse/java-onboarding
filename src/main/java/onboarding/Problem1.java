package onboarding;

import java.util.List;

class Problem1 {

    public static int multiple(Integer num) {
        int sum=1;
        String stringNum = num.toString();
        for (int i=0; i<stringNum.length();i++) {
            sum*=Character.getNumericValue(stringNum.charAt(i));
        }
        return sum;
    }

    public static int add(Integer num) {
        int sum=0;
        String stringNum = num.toString();
        for (int i=0; i<stringNum.length();i++) {
            sum+=Character.getNumericValue(stringNum.charAt(i));
        }
        return sum;
    }
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE''

        int pobiMax=-1;
        int crongMax=-1;
        boolean error = false;

        if (error) {
            answer=-1;
        } else if (pobiMax>crongMax) {
            answer=1;
        } else if (pobiMax<crongMax) {
            answer=2;
        } else if (pobiMax==crongMax) {
            answer=0;
        }
        return answer;
    }
}

