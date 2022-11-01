package onboarding;

public class Problem3 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 1부터 주어진 수까지 의 숫자 중 3, 6, 9가 몇번 사용 되는지 확인하고, 해당 횟수 리턴
        - Stream을 활용하여 3, 6, 9의 빈도수를 구함
     */
    long count_Char(String str) {
        // Stream을 활용하여 특정 문자 빈도수 리턴
        return str.chars()
                .filter(c -> c == '3' || c == '6' || c =='9')   // lambda를 활용하여 값이 3이나 6, 9일 경우 걸러냄
                .count();   //값 중 3이나 6, 9가 있을 때 count
    }

    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        for (int i = 1; i < number + 1; i++) {
            String temp = Integer.toString(i);  // 자리수 별로 나눠 해결하기 위해 문자열로 바꿈
            answer += p3.count_Char(temp);  // 해당 문자열을 stream을 활용하여 문자열의 각각의 문자가 3이나 6, 9일 때 빈도수를 count함

        }
        return answer;
    }
}
