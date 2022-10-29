package onboarding;

public class Problem3 {
    /*
    * 기능 구현 목록
    * 매개변수 숫자 -> 문자열로 바꾸는 기능
    * 바꾼 문자열의 문자들을 탐색해서, 3,6,9가 있는지 확인하는 기능
    * 시간복잡도는 O(5*N) = O(N)
    * */
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++){
            String s = Integer.toString(i);

            for (int j =0; j<s.length();j++){
                if (s.charAt(j)=='3' || s.charAt(j)=='6' || s.charAt(j)=='9'){
                    answer+=1;
                }
            }
        }

        return answer;
    }
}
