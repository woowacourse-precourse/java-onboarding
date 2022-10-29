package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = Decoder.runDecoder(cryptogram);
        return answer;
    }
}


class Decoder {

    static String runDecoder(String str) {
        String n_str = deleteDuplicate(str);
//        System.out.println("_____변경전_____");
//        System.out.println(str);
//        System.out.println("_____변경후_____");
//        System.out.println(n_str);
//        System.out.println();
        if (str.equals(n_str)) return str;
        return runDecoder(n_str);
    }

    private static String deleteDuplicate(String str) {
        String new_str = "";
        if (str.equals("")) {
            return "";
        }
        int l = str.length();
        int i = 0;
        while (i < l-1) {
            if (str.charAt(i) == str.charAt(i+1)) {
                int dup_cnt = 1;
                while ( i + dup_cnt < l - 1) {
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