package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = eliminateDuplicateChars(cryptogram,0,Character.MIN_VALUE, false);

        return answer;
    }

    /**
     * 재귀적으로 돌며 연속된 문자열 삭제<br/><br/>
     * - 오른쪽 방향으로 읽어가며 문자열 처음부터 끝까지 탐색 <br/>
     * - 해당 절차에서 연속된 문자열이 생겼다면 해당 글자를 자르고 그 위치부터 다시 탐색 <br/>
     * - 위 절차들을 진행하며 문자열 끝에 도달하는 것을 하나의 sequence라고 표현 <br/>
     * - 해당 sequence에서 문자열 수정이 있었다면 다시 처음부터 위 절차들을 진행 <br/>
     * - 아니라면 종료
     * @param cryptogram 검사할 암호문
     * @param index 검사해야 할 string index
     * @param before 이전에 검사했던 character
     * @param duplicateFoundInSequence 이번 sequence에서 중복이 발생했는지
     * @return 재귀호출 또는 해독된 암호문
     */
    private static String eliminateDuplicateChars(String cryptogram, int index, char before, boolean duplicateFoundInSequence){
        if(index + 1 > cryptogram.length()){
            if(duplicateFoundInSequence==true) {
                // Back to initial sequence
                return eliminateDuplicateChars(cryptogram,0, Character.MIN_VALUE, false);
            }
            else return cryptogram;
        }
        else{
            char current = cryptogram.charAt(index);

            if(before == current){
                String part1 = cryptogram.substring(0, index-1);
                String part2 = cryptogram.substring(index+1);
                return eliminateDuplicateChars(part1+part2, index-1, current, true);
            }
            else
                return eliminateDuplicateChars(cryptogram, index+1, current, duplicateFoundInSequence);
        }
    }
}
