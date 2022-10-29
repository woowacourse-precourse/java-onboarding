package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

class Encoder {
    String deleteDuplicate(String str) {
        String new_str = "";
        int l = str.length();
        int i = 0;
        while (i < l-1) {
            if (str.charAt(i) == str.charAt(i+1)) {
                int dup_cnt = 1;
                while ( i + dup_cnt < l) {
                    if (str.charAt(i) == str.charAt(i + dup_cnt + 1)) {
                        dup_cnt += 1;
                    } else {break;}
                }
                i += dup_cnt + 1;
            }
            else {
                new_str += str.charAt(i);
                i += 1;
            }
        }
        if (str.charAt(l-1) == str.charAt(l-2)) {
            return new_str;
        } else {return new_str + str.charAt(l-1);}
    }
}