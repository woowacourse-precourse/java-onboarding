package onboarding;

public class Problem2 {
    public static StringBuilder createNewCryptogram(String cryptogram) {
        StringBuilder new_cryptogram = new StringBuilder(); //문자열 성능 향상을 위한 StringBuilder 사용
        if (cryptogram.charAt(0)!=cryptogram.charAt(1))     //맨 앞글자 처리
            new_cryptogram.append(cryptogram.charAt(0));
        for (int i=1; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1) | cryptogram.charAt(i)==cryptogram.charAt(i-1)) continue;   //앞이나 뒤와 같은 문자라면 continue
            new_cryptogram.append(cryptogram.charAt(i));    //연속되지 않는다면 추가
        }
        if (cryptogram.charAt(cryptogram.length()-1)!=cryptogram.charAt(cryptogram.length()-2))    //맨 뒷글자 처리
            new_cryptogram.append(cryptogram.charAt(cryptogram.length()-1));
        return new_cryptogram;
    }
    public static String solution(String cryptogram) {

        while (true) {
            if (cryptogram.length()<2) break;   //길이가 2 미만이면 반복문 종료
            StringBuilder new_cryptogram = createNewCryptogram(cryptogram); //문자열 성능 향상을 위한 StringBuilder 사용

            if (cryptogram.equals(new_cryptogram.toString())) break;    //같은 문자라면 종료
            cryptogram=new_cryptogram.toString();   //cryptogram을 새로운 문자열로 치환
        }
        return cryptogram;
    }
}
