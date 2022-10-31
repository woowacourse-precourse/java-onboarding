package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += get369(Integer.toString(i)).length();
        }
        return answer;
    }

    //문자열에서 3, 6, 9가 아닌 숫자를 제거하는 함수
    private static String get369(String number){
        return number.replaceAll("[1245780]","");
    }
}
