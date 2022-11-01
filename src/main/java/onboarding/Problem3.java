package onboarding;

public class Problem3 {
    static int count_369(int n){ // 숫자 n에 존재하는 3, 6, 9의 개수를 반환하는 함수
        int answer = 0;
        String n_str = Integer.toString(n); // number을 문자열로 변환
        for (int i = 0; i < n_str.length(); i++) {
            if (n_str.charAt(i) == '3' || n_str.charAt(i) == '6' || n_str.charAt(i) == '9')
                answer++;
        }
        return answer;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer+=count_369(i);
        }
        return answer;
    }
}
