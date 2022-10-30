package onboarding;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = overlappedEmailList(overlappedList(forms), forms);
        Collections.sort(answer);
        return answer;
    }

    // 한글 추출 메서드
    // input : 문자열 sIndex : 추출 시작 인덱스  byteSize : 추출 바이트 길이 byteLenKor : 한글 한글자 바이트수
    public static String substrb(String input, int sIndex, int byteSize, int byteLenKor) {
        if (input == null) return null;
        if (input.length() == 0) return input;
        if (sIndex < 0 || byteSize < 0 || byteLenKor > 3) return input;
        int iLen = 0;
        int iPrevSumBytes = 0;
        int iOneWordBytes = 0;

        do {
            iPrevSumBytes += iOneWordBytes;
            iOneWordBytes = (Character.getType(input.charAt(sIndex + iLen)) == Character.OTHER_LETTER) ? byteLenKor : 1;

            if (iPrevSumBytes + iOneWordBytes <= byteSize) {
                ++iLen;
            } else {
                break;
            }
        } while (sIndex + iLen < input.length());

        String strFmt = null;
        try {
            int iOutBytes = (input.substring(sIndex, sIndex + iLen)).getBytes("UTF-8").length;
            strFmt = (byteSize - iOutBytes > 0) ? "%-" + (byteSize - iOutBytes) + "s" : "%s";
        } catch (UnsupportedEncodingException e) {
            return null;
        }

        return input.substring(sIndex, sIndex + iLen) + String.format(strFmt, "");
    }

    // 어떤 글자가 중복되었는지 확인 후 포함된 index를 포함한 List 반환
    public static List<Integer> isOverlapped(List<List<String>> forms, String name) {

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).contains(name)) {        // 글자가 포함되어있다면
                indexList.add(i);
            }
        }
        return indexList;
    }

    // 중복된 리스트 isOverlapped를 통하여 이름들과 비교해서 최종 List계산
    public static List<Integer> overlappedList(List<List<String>> forms) {
        int startIndex = 0;
        int byteSize = 6;
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = substrb(forms.get(i).get(1), startIndex, byteSize, 3);
            // 1이 아니면 중복이 된걸 찾은 것 !
            answerList = isOverlapped(forms, name);
            if (answerList.size() != 1) {
                byteSize += 3;
                name = substrb(forms.get(i).get(1), startIndex, byteSize, 3);
                List<Integer> answerListNext = isOverlapped(forms, name);
                if (answerListNext.size() == 1) break;

            }
        }
        return answerList;
    }

    // 중복된 이메일 리스트 출력
    public static List<String> overlappedEmailList(List<Integer> answerList, List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < answerList.size(); i++) {
            answer.add(forms.get(answerList.get(i)).get(0)); //이메일 추가
        }
        return answer;
    }
}

