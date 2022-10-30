package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++)
            answer += clappedNumber(i);

        return answer;
    }

    public static int clappedNumber(int now) {

        int clappingCnt = 0;

        String numberToStr = String.valueOf(now);
        for(int j=0; j<numberToStr.length(); j++) {
            if (numberToStr.charAt(j) == '3') clappingCnt += 1;
            if (numberToStr.charAt(j) == '6') clappingCnt += 1;
            if (numberToStr.charAt(j) == '9') clappingCnt += 1;
        }

        return clappingCnt;
    }
}
