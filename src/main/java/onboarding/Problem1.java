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

    public static int findMax (int num1, int num2, int num3, int num4) {
        int maxCandidate1 = 0;
        int maxCandidate2 = 0;
        maxCandidate1 = Math.max(num1, num2);
        maxCandidate2 = Math.max(num3, num4);
        return Math.max(maxCandidate1, maxCandidate2);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = 0;
        int crongMax = 0;
        boolean error = false;

        if (pobi.get(0)%2==0||pobi.get(1)%2==1||crong.get(0)%2==0||crong.get(1)%2==1) {
            error=true;
        }
        if (pobi.get(0)+1!=pobi.get(1)||crong.get(0)+1!=crong.get(1)) {
            error=true;
        }
        if (pobi.get(0)<1||pobi.get(0)>400||pobi.get(1)<0||pobi.get(1)>400||crong.get(0)<1||crong.get(0)>400||crong.get(1)<1||crong.get(1)>400) {
            error = true;
        }

        pobiMax = findMax(add(pobi.get(0)),add(pobi.get(1)),multiple(pobi.get(0)),multiple(pobi.get(1)));
        crongMax = findMax(add(crong.get(0)),add(crong.get(1)),multiple(crong.get(0)),multiple(crong.get(1)));


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

