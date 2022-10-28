package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=3; i<=number; i++) { //3 이전은, 박수를 치지 않으므로 3부터 시작
            for (String p : new String[]{"3","6","9"}) {    //3,6,9가 포함된 만큼 박수
                answer+=Integer.toString(i).length() - Integer.toString(i).replace(p,"").length();
            }
        }
        return answer;
    }
}
