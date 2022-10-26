package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        //1. 중복체크 기능
        //2. 지워야 할 문자열
        //3. 루프내에서 중복 문자열을 삭제할때마다 체크
        //4. 더이상 지울 문자열이 없으면 리턴

        int hasRm = 1; // 0이 아니면 지워야할 문자열이 있음, 루프 진입을 위해 1로 초기화.
        String str = ""; // 중복 문자열을 담을 변수

        while(hasRm != 0) {
            hasRm = 0; // 루프 진입 후 1 -> 0

            for(int i = 0; i < cryptogram.length(); i++) {
                char ch = cryptogram.charAt(i);
                str = ch + "";

                for(int j = i + 1; j < cryptogram.length() && ch == cryptogram.charAt(j); j++) { // i 번째 인덱스와 다음 오는 문자들이 중복되는 경우, 중복아니면 패스
                    str += cryptogram.charAt(j);
                }

                if(str.length() > 1) { // str 길이가 1 보다 크면 중복되는게 있음
                    hasRm = 1; // hasRM이 0이 아니므로 기능 수행 후 루프 재진입 예정
                    cryptogram = cryptogram.replaceFirst(str, ""); // 지워야 할 문자열 하나만 지우기. 다른것도 지워버리면 문제 발생. ex) axxbxxxc -> abxc
                    i = 0; // n번째 중복문자열 삭제 후 다시 0번 인덱스부터 다시 체크하기 위해 i = 0
                }
            }
        }

        return cryptogram;
    }
}
