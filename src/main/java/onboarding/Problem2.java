
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int i = 0;
        while(i < 30) {
            String markedWord = isRepeat(answer);

            if (markedWord.contains("*")){
                answer = removeDummyMark(markedWord);
                i += 1;
            } else {
                break;
            }
        }
        return answer;
    }

    private static String isRepeat(String word) {
        StringBuffer sb = new StringBuffer();
        sb.append(word);

        int index = 0;
        char tmp = ' ';
        while (index < sb.length()) {
            if (tmp != sb.charAt(index)) {
                tmp = sb.charAt(index);
                index += 1;
            } else if (tmp == sb.charAt(index)) {
                DummyWord dummyMarkedWord = changeToDummyMark(new DummyWord(tmp, index-1, sb));
                sb = dummyMarkedWord.getWord();
                index = dummyMarkedWord.getIndex();
            }
        }

        return sb.toString();
    }

}
