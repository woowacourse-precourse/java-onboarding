package onboarding;

public class Problem3 {
    public static int solution(int number) {
        /*
        기능 목록
        1. 1부터 숫자 number 까지 for문 생성
        2. 각각의 number에 3, 6, 9가 포함되어 있는 경우 해당 숫자 저장
        3. 저장된 숫자중 3, 6, 9 개수 계산
        */
        int answer = 0;

        // 3, 6, 9가 포함된 숫자 저장할 변수
        String include369 = "";

        for(int i=1; i<=number; i++) {
            // 30, 62와 같은 경우도 포함하기 위해 String 변환
            String str = Integer.toString(i);

            //3, 6, 9가 문자 내에 포함되어 있는 경우 해당 숫자 저장
            if (str.contains("3") || str.contains("6") || str.contains("9")) {
                include369 += str;
            }
        }

        //3, 6, 9 등장 횟수 count
        for(int j=0; j<include369.length(); j++) {
            if (include369.charAt(j) == '3' || include369.charAt(j) == '6' || include369.charAt(j) == '9') {
                answer += 1;
            }
        }

        return answer;
    }
}
