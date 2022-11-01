package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        int index = 0, startIndex = -1, lastIndex = -1;
        while(index < answer.length() - 1) {
            if(answer == "") {
                break;
            }
            if(answer.charAt(index) == answer.charAt(index + 1)) {
                startIndex = index;
                lastIndex = getLastIndex(answer, startIndex);
                answer = removeRedundant(answer, startIndex, lastIndex);
                index = startIndex - 1;
            }
            else {
                index++;
            }
        }

        return answer;
    }

    public static int getLastIndex(String str, int sIndex) {
        int i = sIndex;
        while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
            i++;
        }
        return i;
    }

    public static String removeRedundant(String str, int sIndex, int lIndex) {
        return str.substring(0, sIndex) + str.substring(lIndex + 1);
    }
}
