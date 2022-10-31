package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 손뼉을 친 횟수
        int count = 0;

        // 1. 숫자를 number 까지 센다
        for (int i = 1; i <= number ; i++) {
            String tmp = String.valueOf(number);

            if(tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
                for (int j = 0; j < tmp.length(); j++) {
                    // 2. 뽑아낸 숫자가 3, 6, 9 존재하는 지 확인하는 함수
                    if(isThreeSixNine(tmp.charAt(j))) count++;
                }
            }

        }

        return answer;
    }

    /**
     * 해당 숫자가 3, 6, 9에 해당되는지 판별하는 함수
     * @param {Character} c
     * @return {boolean}
     */
    public static boolean isThreeSixNine(Character c) {
        if(c == '3' || c == '6' || c == '9') return true;
        else return false;
    }
}