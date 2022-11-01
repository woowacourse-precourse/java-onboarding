package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i<=number; i++){
            Problem3 P = new Problem3();
            answer += P.count(i);
        }
        return answer;
    }

    // 하나의 숫자 안에 3,6,9가 몇 개 있는지 카운트하는 메서드 구현
    public int count(int number){
        String numToStr = Integer.toString(number);
        int cnt = numToStr.length();
        numToStr = numToStr.replace("3","");
        numToStr = numToStr.replace("6","");
        numToStr = numToStr.replace("9","");
        cnt -= numToStr.length();
        return cnt;
    }
}
