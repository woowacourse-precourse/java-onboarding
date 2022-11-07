package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            answer += getClapInNumber(String.valueOf(i));
        }

        return answer;
    }

    public static int getClapInNumber(String value){
        int clapCount = 0;

        for(int i=0; i<value.length(); i++){ // n이 value의 길이인, O(n) 시간복잡도
            if(value.charAt(i) == '3') clapCount++;
            if(value.charAt(i) == '6') clapCount++;
            if(value.charAt(i) == '9') clapCount++;
        }

        return clapCount;
    }
}
