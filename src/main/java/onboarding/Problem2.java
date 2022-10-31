package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = Decoder.decoding(cryptogram);
        return answer;
    }
}

class Decoder {
    static String decoding(String str) {
        String n_str = deleteDuplicate(str);
        if (str.equals(n_str)) {
            return str;
        }
        return decoding(n_str);
    }

    private static String deleteDuplicate(String str) {
        String new_str = "";
        // 빈 String 그대로 반환
        if (str.equals("")) {
            return "";
        }
        int l = str.length();
        // 길이가 1인 String 그대로 반환
        if (l == 1) {
            return str;
        }
        int i = 0;
        while (i < l-1) {
            if (str.charAt(i) == str.charAt(i+1)) {
                int dup_cnt = 1;
                while (dup_cnt < l - 1 - i) {
                    if (str.charAt(i) == str.charAt(i + 1 + dup_cnt)) {
                        dup_cnt += 1;
                    } else {
                        break;
                    }
                }
                i += dup_cnt + 1;
            } else {
                new_str += str.charAt(i);
                i += 1;
            } if (i == l-1) {
                new_str += str.charAt(i);
            }
        }
        return new_str;
    }
}