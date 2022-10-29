package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 현재상태에서의 중복 문자열 리스트를 만든다
        // 없다면 루프 탈출 후 그대로 리턴, 있다면 중복된 문자열을 순서대로 공백문자로 변환한다
        // 현재상태에서의 공백문자들을 한꺼번에 삭제한다
        // 다시 루프의 처음으로 돌아가 위 기능들을 반복한다
        // refactor
        boolean hasRm = true;

        while(hasRm) {
            hasRm = false;

            List<String> rmList = findRm(cryptogram); // 현재 매개변수에서 중복 문자열이 있는지, 있다면 리스트를 반환해주는 메서드

            hasRm = rmList.size() > 0 ? true : false; // 리스트에 하나라도 들어가 있다면 삭제하는 기능 수행

            if(hasRm) {
                cryptogram = rmStr(rmList, cryptogram); // 중복 문자열 삭제 메서드, 중복 문자열 리스트에 해당하는 인덱스들을 공백 문자로 변환 후 한꺼번에 삭제
            }

        }

        return cryptogram;
    }
    private static List<String> findRm(String cryptogram) {
        List<String> rmList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cryptogram.length(); i++) {
            char ch = cryptogram.charAt(i);
            sb.append(ch);

            for(int j = i + 1; j < cryptogram.length() && ch == cryptogram.charAt(j); j++) {
                sb.append(cryptogram.charAt(j));
            }

            if(sb.length() > 1) {
                rmList.add(sb.toString());
            }

            sb.setLength(0);
        }

        return rmList;
    }
    private static String rmStr(List<String> rmList, String cryptogram) {
        for(String str : rmList) {
            cryptogram = cryptogram.replaceFirst(str, " ");
        }

        cryptogram = cryptogram.replaceAll(" ", "");

        return cryptogram;
    }
}
