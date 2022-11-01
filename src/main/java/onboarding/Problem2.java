package onboarding;

public class Problem2 {
    //연속된 스펠링 제거
    public static String removeDuplicateSpelling(String cryptogram) {
        int pre, cur;
        int newIndex = 0;
        boolean isDuplication = false;
        char[] text = cryptogram.toCharArray();

        if(text.length == 1) { //종료 조건: 길이가 1인 경우
            return cryptogram;
        }

        for(cur = 1, pre = 0; cur < text.length; cur++, pre++) { //중복을 제거한 문자를 앞부터 덮어씌움 -> 유효한 문자만 슬라이스
            if(text[pre] == text[cur]) { //앞뒤 문자가 같을 때, 중복 표시
                isDuplication = true;
                continue;
            }
            if(!isDuplication) { //앞뒤 문자가 다를 때, pre가 중복이 아니면 pre 추가
                text[newIndex++] = text[pre];
            }
            isDuplication = false; //앞뒤 문자가 다를 때, 중복 표시 초기화
        }

        if(!isDuplication) { //앞뒤 문자가 다를 때, pre가 중복이 아니면 pre 추가
            text[newIndex++] = text[pre];
        }

        if(newIndex == 0) { //종료 조건: 모든 문자가 중복일 때
            return "";
        }
        return new String(text).substring(0, newIndex); //유효한 텍스트만 슬라이스
    }

    //솔루션 메소드
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isStop = false;

        while(!isStop) {
            answer = cryptogram;
            cryptogram = removeDuplicateSpelling(cryptogram); //연속된 스펠링 제거

            if(cryptogram.length() <= 1 || cryptogram.equals(answer)) { //텍스트가 1개 이하이거나, 줄어든 문자가 없을 때 멈춤
                isStop = true;
            }
        }
        answer = cryptogram;
        return answer;
    }
}
