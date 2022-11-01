package onboarding;

public class Problem3 {
    public static int getClappingCount(int i) { //369 갯수만큼 박수 Count
        return Integer.toString(i).length() - Integer.toString(i).replaceAll("[369]","").length();
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i=3; i<=number; i++) { //3 이전은, 박수를 치지 않으므로 3부터 시작
            answer+=getClappingCount(i);
        }
        return answer;
    }
}
