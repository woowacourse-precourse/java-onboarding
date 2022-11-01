package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer; // 최종 결과
        boolean isOverlap; // 문자열 내 중복문자 유무 여부 플래그
        int start; // 중복문자 시작 인덱스
        int cnt; // 중복문자 개수
        StringBuilder sb = new StringBuilder(); // 문자열 조작
        String tmp = cryptogram; // 중복삭제된 문자열을 저장하여 비교

        sb.append(cryptogram); // StringBuilder 초기화
        while(true) {
            isOverlap = false;
            for(int i=0; i<tmp.length()-1; i++) {
                cnt = 0;
                if(tmp.charAt(i) == tmp.charAt(i+1)) {
                    // 문자가 중복되는 경우
                    isOverlap = true;
                    cnt++;

                    // 몇개 중복인지 확인
                    start = i;
                    while(start+cnt+1 < tmp.length()) {
                        if(tmp.charAt(start) == tmp.charAt(start+cnt+1)) {
                            //중복 문자가 더 있는 경우
                            cnt++;
                        }
                        else break;
                    }

                    sb.delete(start, start+cnt+1); // 중복 문자 삭제
                    tmp = sb.toString(); // 삭제 결과 갱신
                    i -= (cnt+1); // 중복문자가 삭제되어 다음문자의 인덱스가 당겨지게되므로 중복문자 개수만큼 i 조절
                }
            }
            if(!isOverlap) {
                // 문자열에 중복문자가 없을 경우 while문 탈출
                answer = sb.toString();
                break;
            }
        }
        return answer;
    }
}
