package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String str;
        int answer = 0;

        if(number<1 || 10000<number) //잘못된 범위 일떄 -1
            return -1;

        for(int i=1; i<=number; i++){
            str = String.valueOf(i); //i를 문자열로 변환
            answer += str.chars().filter(c->c=='3' || c=='6' || c=='9').count(); //stream과 필터를 활용
        }

        return answer;
    }

}
