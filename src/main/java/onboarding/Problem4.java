package onboarding;

public class Problem4 {
    public static String convert(String word){
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < word.length();i++){
            int ascii = word.charAt(i);

            if ('A' <= ascii && ascii <= 'Z') {
                int idx = ascii-'A';
                res.append((char) ('Z' - idx));
            }
            else if ('a' <= ascii && ascii<= 'z') {
                int idx = ascii-'a';
                res.append((char) ('z' - idx));
            }
            else res.append((char) ascii);
        }
        return res.toString();
    }
    public static String solution(String word) {
        return convert(word);
    }
}
