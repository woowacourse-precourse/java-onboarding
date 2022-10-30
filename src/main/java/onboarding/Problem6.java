package onboarding;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        System.out.println(substrb(forms.get(0).get(1),1,6,3));
        
//        }
        return answer;
    }

    /**
     * substrb 원하는 바이트 추출. 마지막 글자가 한글이고 추출 시 한글이 깨지는 경우 그 글자는 제외시킴
     * @param input 입력문자열
     * @param sIndex 추출 시작 인덱스. 바이트단위가 아님
     * @param byteSize 추출 바이트 길이. 추출 바이트 길이 보다 클 경우 차분은 스페이스로 패딩
     * @param byteLenKor 한글 한글자 바이트수
     * @return 추출 문자열
     */
    public static String substrb(String input, int sIndex, int byteSize, int byteLenKor) {
        if (input == null) return null;
        if (input.length() == 0 ) return input;
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
        } while(sIndex + iLen < input.length());

        String strFmt = null;
        try {
            int iOutBytes = (input.substring(sIndex, sIndex + iLen)).getBytes("UTF-8").length;
            strFmt = (byteSize - iOutBytes > 0) ? "%-"+(byteSize - iOutBytes)+"s":"%s";
        } catch(UnsupportedEncodingException e) {
            return null;
        }

        return input.substring(sIndex, sIndex + iLen) + String.format(strFmt,"");
    }
}

