package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = Count369(number);
        return answer;
    }
    public static int Count369(int num){

        if(exceptionCheck(num)) return -1;

        StringBuffer str369 = new StringBuffer();
        int cnt = 0;

        //문자열을 만들고 각 숫자를 문자열에 이어붙인다.
        for(int i = 1 ; i <= num; i++){
            str369.append(i);
        }
        //문자열 str369에 3, 6, 9가 몇개 있는지 세본다.
        for(int i = 0 ; i < str369.length(); i++){
            //str369의 i번째 문자가 3, 6, 9인지 확인
            //3, 6, 9 중 하나라면 cnt 값을 증가시킨다.
            int tmp =str369.charAt(i);
            if (tmp == '3') cnt++;
            else if (tmp == '6') cnt++;
            else if (tmp == '9') cnt++;
        }

        return cnt;
    }
    public static boolean exceptionCheck(int number){
        //number는 1이상 10,000 이하인 자연수이다.
        if(number < 0 || number > 10000) return true;
        return false;
    }
}
