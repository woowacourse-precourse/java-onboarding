package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number;i++) {
            String Strnumber = Integer.toString(i); // 문자열로 교환
            for (int j=3;j<=9;j+=3) { // 3,6,9 진행
                char num = Character.forDigit(j , 10); // 3,6,9를 문자로 교환
                // 정규표현식 사용하기
                answer +=Strnumber.chars().filter(ch -> ch ==num).count(); 
            }
        }
        return answer;
    }
}
