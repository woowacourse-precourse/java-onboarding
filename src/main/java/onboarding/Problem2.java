package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = deduplication(cryptogram);

        return answer;
    }

    /**
     * DESCRIPTION
     *   중복 문자를 제거하며, 완성된 최종 문자열을 반환
     *
     * Params
     *   cryptogram - 중복 문자가 포함된 원본 문자열
     *
     * RETURN
     *   중복 문자가 제거된 문자열
     */
    public static String deduplication(String cryptogram){

        // 한 번의 문자열 검사마다 사용
        String decoding = ""; //중복 문자열이 제거된 문자열을 저장
        boolean globalChange = true; // 중복 문자열이 1번이라도 제거됐는지 확인

        // 문자열 검사 과정 중 사용
        boolean localChange = false; // 현재 조사 중인 문자와 바로 뒤에 오는 문자가 같은지 확인

        while(globalChange){ // 저번 문자열 검사 과정에서, 중복 문자열이 발견되지 않았으면 더 이상 조사할 필요가 없으므로 반목문 종료
            globalChange = false;
            decoding = "";

            for(int idx = 0; idx < cryptogram.length(); idx ++){ // 한 번의 문자열 검사 과정

                // 조건 1. 조건 2에서 바로 뒤 문자와의 일치를 확인하므로 마지막 문자에 대한 예외처리
                // 조건 2. 바로 뒤에있는 문자와 현재 조사 중인 문자가 같지 않을 시
                if(idx == cryptogram.length() - 1 || cryptogram.charAt(idx) != cryptogram.charAt(idx + 1)){
                    if(!localChange) // 연속 중복 문자인지 확인(e.g. bbbc이면 b->c여도 3개의 b를 모두 포함시키지 않아야 함)
                        decoding += cryptogram.charAt(idx);

                    localChange = false;
                }
                else { // 바로 뒤에있는 문자와 현재 조사 중인 문자가 같을시
                    localChange = true;
                    globalChange = true;
                }
            }

            cryptogram = decoding; // 다음 문자열 중복 검사 시도를 위해 cryptogram을 초기화
        }

        return decoding;
    }
}
