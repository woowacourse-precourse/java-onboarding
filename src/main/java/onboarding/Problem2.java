package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicate(cryptogram);
    }

    private static String removeDuplicate(String cryptogram){
        if(cryptogram.equals("")) // 수행할 문자가 비어있다면 빈 문자열을 리턴함
            return cryptogram;

        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram.charAt(0));

        char temp = cryptogram.charAt(0); // 비교되는 문자
        for (int i = 1; i < cryptogram.length(); i++) {
            if(temp == cryptogram.charAt(i)){
                // 비교하는 문자(cryptogram.charAt(i))를 다음 수행의 비교되는 문자(temp)로 정함
                temp = cryptogram.charAt(i);
                // sb에서 비교하는 문자와 같은 마지막 문자를 제거
                sb.setLength(sb.length() - 1);
            }
            else{
                temp = cryptogram.charAt(i);
                sb.append(cryptogram.charAt(i));
            }
        }
//        System.out.println(sb.toString());

        // 수행할 문자열(cryptogram)과 처리한 문자열(sb.toString())이 같으면 최종 문자열을 반환
        if(cryptogram.equals(sb.toString()))
            return sb.toString();
        // 아직 처리 할 중복 문자가 남아서 재귀함수 실행
        else
            return removeDuplicate(sb.toString());
    }
}