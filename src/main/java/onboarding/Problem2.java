package onboarding;

public class Problem2 {
    public static String removeSpace(char[] chars) {
        String result = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                continue;
            }
            result += Character.toString(chars[i]);
        }
        return result;
    }

    public static String deleteDuplication(String cryptogram, String indexes) {
        char[] chars = cryptogram.toCharArray();
        String tmp = "";
        for(int i = 0; i < indexes.length(); i++) {
            if(indexes.charAt(i) != ' ') {
                tmp += Character.toString(indexes.charAt(i));
                continue;
            }
            chars[Integer.parseInt(tmp)] = ' ';
            tmp = "";
        }
        cryptogram = removeSpace(chars);
        return cryptogram;
    }

    public static String findDuplication(String cryptogram) {
        char prevChar = cryptogram.charAt(0);
        String indexes;
        while(true) {
            indexes = "";
            for(int i = 1; i < cryptogram.length(); i++) {
                if(prevChar == cryptogram.charAt(i)) {
                    indexes += Integer.toString(i - 1) + " ";
                    indexes += Integer.toString(i) + " ";
                }
                prevChar = cryptogram.charAt(i);
            }
            if(indexes.length() == 0) {
                break;
            }
            cryptogram = deleteDuplication(cryptogram, indexes);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = findDuplication(cryptogram);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("abaaa");
    }
}
