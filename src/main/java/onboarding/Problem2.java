package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] answers = cryptogram.split(""); // 각 문자를 비교, 확인하기 위해 쪼개어 배열에 담아준다.

        //인접한 문자열이 서로 같다면 빈 값을 넣어주고, 다르다면 앞의 글자를 넣어준다.
        for (int i = 1; i < cryptogram.length(); i++) {
            if (answers[i-1].equals(answers[i])) {
                answers[i-1] = "";
                answers[i] = "";
                answer += "";
            }
            if (!answers[i-1].equals(answers[i])) {
                answer += answers[i-1];
            }
            //적어준 조건상, 맨 마지막 글자는 잘리기 때문에 이를 붙여준다.
            if (i == cryptogram.length()-1) {
                answer += answers[i];
            }
        }

        // 위 과정을 걸쳐 나온 문자를 재귀적으로 함수를 호출해 반복하여 확인해본다.
        String[] results = answer.split("");
        if (answer.length() == 2 && results[0].equals(results[1])) {
            answer = "";
        }
        for (int i = 1; i < answer.length()-1; i++) {
            if (results[i-1].equals(results[i])) {
                answer = solution(answer);
            }
        }
        return answer;
    }
}