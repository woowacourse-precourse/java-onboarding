package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += clab(i);
        }
        return answer;
    }

    public static int clab(int ptr) { // 한자릿 수 별로 나눠서 박수 횟수를 계산하는 메소드
        String temp = Integer.toString(ptr);
        int[] num = new int[temp.length()];
        int pnt = 0;
        for (int i = 0; i < temp.length(); i++) {
            num[i] = temp.charAt(i) - '0';
        }
        for (int i = 0; i < temp.length(); i++) {
            if (num[i] != 0 && num[i] % 3 == 0) {
                pnt++;
            }
        }
        return pnt;

    }
}
