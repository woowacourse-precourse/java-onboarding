package onboarding;

class DummyWord {
    private char tmp;
    private int index;
    private StringBuffer word;

    public DummyWord(char tmp, int index, StringBuffer word) {
        this.tmp = tmp;
        this.index = index;
        this.word = word;
    }

    public char getTmp() {
        return tmp;
    }

    public int getIndex() {
        return index;
    }

    public StringBuffer getWord() {
        return word;
    }

}

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(true) {
            String markedWord = isRepeat(answer);

            if (markedWord.contains("*")){
                answer = removeDummyMark(markedWord);
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

    private static DummyWord changeToDummyMark(DummyWord dummyWord) {
        int i = 0;
        char tmp = dummyWord.getTmp();
        int index = dummyWord.getIndex();
        StringBuffer word = dummyWord.getWord();

        while (index+i < word.length() && tmp == word.charAt(index+i)) {
            word.setCharAt(index+i, '*');
            i += 1;
        }

        return new DummyWord(' ', index+i, word);
    }

    private static String removeDummyMark(String markedWord) {
        String newWord = markedWord.replaceAll("[^a-z]", "");
        return newWord;
    }
}
