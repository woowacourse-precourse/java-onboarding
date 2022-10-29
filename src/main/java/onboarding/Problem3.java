package onboarding;


/*
- 기능 구현사항 목록 -
1. 1부터 입력값까지 for 문 실행
2. 해당 숫자를 문자열이 담긴 배열로 변환
3. 해당 배열에서 3/6/9 count -> answer += count
 */
public class Problem3 {

    private static int count369(int[] counter){
        int cnt = 0;
        for(int m = 1; m < 4; m++){
            cnt += counter[3*m];
        }
        return cnt;
    }
    private static int[] IntegerToList(int n){
        String temp = Integer.toString(n);
        int l = temp.length();
        int[] digits = new int[l];
        for (int i = 0; i < l; i++) digits[i] = temp.charAt(i) - '0';
        return digits;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number+1; i++) {
            int[] digits = IntegerToList(i);
            int[] counter = new int[10];
            for (int digit : digits) counter[digit]++;
            answer += count369(counter);
        }
        return answer;
    }
}
