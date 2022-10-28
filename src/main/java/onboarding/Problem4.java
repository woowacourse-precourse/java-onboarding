package onboarding;

/**
 * 구현 기능 목록
 * 1. 문자열을 받아 역순으로 바꿔주는 기능
 * 2. result에 치환한 문자열을 담고 반환
 */
public class Problem4 {
    static final int lowera = 'a';
    static final int lowerz = 'z';
    static final int upperA = 'A';
    static final int upperZ = 'Z';

    public static String solution(String word) {
        return ReverseWord(word).toString();
    }

    public static StringBuilder ReverseWord(String words) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<words.length(); i++) {
            int charcasting = words.charAt(i);
            if (charcasting>lowera && charcasting<lowerz) {
                charcasting = lowerz-(charcasting-lowera);
            } else if (charcasting>upperA&&charcasting<upperZ) {
                charcasting = upperZ-(charcasting-upperA);
            }
            result.append((char) charcasting);
        }
        return result;
    }
}

