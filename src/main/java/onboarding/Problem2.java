package onboarding;

public class Problem2 {
    static int depth = 0;
    public static String solution(String cryptogram){
        if (depth == 0) {
            try {
                constraint2(cryptogram);
            } catch (Exception e) {
                System.out.println("Problem2 exception : " + e.getMessage());
            }
            depth++;
        }

        String result = String.valueOf(isReduplicated(cryptogram));

        if (result.equals(cryptogram)) {
            depth = 0;
            return result;
        } else {
            return solution(result);
        }
    }
    //문자열을 배열로 만들어 검사
    static StringBuilder isReduplicated(String cryptogram){
        StringBuilder output = new StringBuilder();
        char [] chars = cryptogram.toCharArray();

        for(int i = 0 ; i <= cryptogram.length()-1; i++) {
            if(i == 0) {
                if (chars[i] != chars[i+1]) {
                    output.append(chars[i]);
                }
                continue;
            }
            if(i == cryptogram.length() - 1) {
                if (chars[i] != chars[i-1]) {
                    output.append(chars[i]);
                }
                continue;
            }
            if (chars[i-1] != chars[i] && chars[i+1] != chars[i]) {
                output.append(chars[i]);
            }
        }
        return output;
    }
    //제한사항을 검사하는 constraint
    static void constraint2(String str) throws Exception {
        //주어진 문자열의 길이가 1 이상 1000 이하인지 확인한다.
        if (str.length() > 1000 || str.length() < 1) {
            throw new Exception("문자열의 길이는 1 이상 1000 이하이어야 합니다.");
        }
        //문자열이 알파벳 소문자로만 이루어져 있는지 확인한다.
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 'a' || c > 'z') {
                throw new Exception("문자열은 알파벳 소문자로만 이루어져 있어야 합니다.");
            }
        }
    }

}
