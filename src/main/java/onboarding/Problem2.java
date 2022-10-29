package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // crytogram와 길이, 값이 일치한 StringBuffer 생성
        StringBuffer sb = getStringBuffer(cryptogram);
        // sb를 디코딩
        decodeCryptogram(sb);
        // 중복 제거된 cryptogramStringBuffer을 String으로 변환
        answer = sb.toString();
        return answer;
    }

    /** String 매개변수와 길이, 값이 일치한 StringBuffer 반환 */
    private static StringBuffer getStringBuffer(String cryptogarm) {
        StringBuffer sb = new StringBuffer(cryptogram.length());
        sb.append(cryptogram);
        return sb;
    }

    /** StringBuffer를 디코딩하는 메서드 */
    private static void decodeCryptogram(StringBuffer cryptogarm) {
        // 중복이 없을 때까지 중복을 찾아 제거하는 함수 실행
        do {
            // 특정 인덱스의 char와 연속된 중복을 찾아 제거
            boolean isRemoved = removeDuplication(cryptogarm);
        } while(isRemoved == true) // 더이상 중복이 제거되지 않으면 while문 종료
        return;
    }

    /** 연속된 중복을 찾아 1번 제거 */
    private static boolean removeDuplication(StringBuffer cryptogarm) {
        int start = -1; // 삭제할 범위의 시작 인덱스
        int end = -1;   // 삭제할 범위의 마지막 인덱스
        boolean isRemoved = false;
        // 삭제할 범위의 시작 인덱스가 암호문의 마지막 인덱스이거나, 중복이 검색되어 end가 start보다 커지면 while문 종료
        while (start < cryptogarm.length() - 1 && start >= end) {
            start++; // start를 1씩 증가하여 해당 인덱스의 알파벳 중복을 검사
            end = searchDuplicateIndex(start, cryptogarm.charAt(start), cryptogarm);
            // 중복이 검색되면 연속된 중복의 마지막 인덱스가, 검색안되면 start 반환
        }
        if (start < end && start > -1 && end < cryptogarm.length()) { // start와 end가 유효하다면,
            cryptogarm.delete(start, end + 1);  // start<= x <= end 범위의 문자 삭제
            isRemoved = true;
        }
        return isRemoved;
    }

    /** 특정 위치의 문자가 중복됐는지 확인하여 마지막 중복된 인덱스 반환 */
    private static int searchDuplicateIndex(int start, char c, StringBuffer cryptogarm) {
        int end;
        // break가 발생하지 않으면 최종적인 end의 값은 cryptogarm.length()-1
        for (end = start; end < cryptogarm.length()-1; end++) {
            if (cyptogarm.charAt(end + 1) != 'c') {
                break;
            }
        }
        return end;
    }

}









































