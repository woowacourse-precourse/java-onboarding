package onboarding;

/*
    기능 목록
    1. 중복 구간을 "*"로 바꾸고 나중엔 ""으로 바꿔준다.
    2. 문자열의 크기가 바뀌는 것을 이용해 while 탈출 조건을 만든다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int before = 0, after = cryptogram.length();
        // Step 1. 탈출 조건 -> 문자열의 크기가 계속 변하기 때문에 그것을 이용하여 탈출 조건을 만든다.
        // before -> 이전 문자열 크기 값
        // after -> 이후 문자열 크기 값
        while(before != after){
            before = after;
            cryptogram = filter(cryptogram);
            after = cryptogram.length();
        }

        answer = cryptogram;

        return answer;
    }

    // Step 2. 필터 함수 -> 문자열을 입력받아 중복되는 문자를 제거 후 문자열로 반환한다.
    public static String filter(String cryptogram){
        // 문자열을 char형 배열로 바꿔준다.
        char[] crypt = cryptogram.toCharArray();
        // check -> 중복 값 중 "*"로 하나라도 찍혀있는 경우 확인 하기 위해서 선언
        boolean check = false;
        // 문자열로 만들기 위해서 StringBuilder 선언
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i < cryptogram.length()-1; i++){
            // 이전 문자 값이 "*"로 바뀌고, 다음 문자는 같지 않은 경우
            // mmo -> **o로 만듬
            if(check && crypt[i] != crypt[i+1]){
                crypt[i] = '*';
                check = false;
            }
            // 중복되는 문자가 시작되는 경우 실행
            else if(crypt[i] == crypt[i+1]){
                // 중복되는 문자의 크기가 1인 경우 마지막 값을 "*"로 바꿔준다.
                // cryptogram.length()-1 로 기준을 잡았기 때문에 고려 해줘야한다.
                if(cryptogram.length()-1 == 1){
                    crypt[i+1] = '*';
                }
                crypt[i] = '*';
                check = true;
            }
        }

        // StringBuilder를 통해 char를 문자열로 만드는 과정
        for(char value : crypt){
            tmp.append(value);
        }

        // "*"로 만들어진 문자구간을 ""으로 만들어 문자열 반환
        return tmp.toString().replace("*", "");
    }
}
