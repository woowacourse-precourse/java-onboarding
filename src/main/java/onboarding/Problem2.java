package onboarding;

public class Problem2 {
    public static String solution(String cryptogram){
        /*
        * 중복 문자 삭제하기
        * param : string
        * output : string (중복 제거된)
        * substring 함수 - (i, j) -> 인덱스 i ~ j-1 까지 string을 return
        * */
        String answer = "answer";
        String tmpString;
        String tmpAnswer = cryptogram;

        // 짧아졌는지 확인
        boolean isShorten = true;
        while (isShorten) {
            // 짧아진 문자열과 비교하기 위해 tmp_answer 선언
            tmpString = tmpAnswer;
            // 비교를 위해 초기화
            tmpAnswer = "";
            isShorten = false;
            // String concatnation을 위한 index 선언, cryptogram 길이는 1000 이하이므로 범위 밖의 값으로 선언.
            int shortenIndex = 1001;

            for ( int i = 0; i < ( tmpString.length() - 1 ); i++){
                // 앞,뒤 문자가 같은 경우 Substring을 그대로 두고 tmpAnswer를 새로 선언한다.
                if (tmpString.charAt(i) == tmpString.charAt(i + 1)) {
                    // 중복 문자를 제거했으므로, 예상 결과가 줄어들었다는 flag를 true로 한다.
                    isShorten = true;
                    // tmpAnswer가 빈 문자열이 아니면(2개 이상 중복 시), 다시 시작한 곳부터 겹치기 전까지 문자열 붙이기.
                    if (!(tmpAnswer.equals(""))) {
                        tmpAnswer += tmpString.substring(shortenIndex + 2, i);
                        // 겹치는 부분 : i ~ i + 1이므로 String의 substring 함수 인자표현을 위해 i + 2로 선언
                        shortenIndex = i;
                    }
                    // tmpAnswer가 빈 문자열이면, 이전까지 문자열 저장하기
                    if ( tmpAnswer.equals("") ) {
                        // 인덱스 : 0 ~ i-1
                        tmpAnswer = tmpString.substring(0, i);
                        // 겹치는 부분 : i ~ i + 1이므로 String의 substring 함수 인자표현을 위해 i + 2로 선언
                        shortenIndex = i;
                    }
                    // 다음 인덱스는 이미 중복문자이므로 다음 인덱스는 생략한다.
                    i = shortenIndex + 1;
                }
            }

            // for 문에서 줄어들었는지 확인하여 index + 2에서 끝까지 더한다.
            if (isShorten){
                tmpAnswer += tmpString.substring(shortenIndex + 2, tmpString.length());
            }

            // 비교 후에 아무 중복문자가 없는 경우, tmpString은 줄지 않았으므로 정답이다.
            if (!isShorten){
                answer = tmpString;
                break;
            }
        }

        return answer;
    }
}
