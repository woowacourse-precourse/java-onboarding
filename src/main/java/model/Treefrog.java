package model;


import java.util.HashMap;

public class Treefrog {
    private String word;
    private HashMap<Character, Character> dictionary;

    public Treefrog(String word, HashMap<Character, Character> dictionary) {
        this.word = word;
        this.dictionary = dictionary;
    }

    public String frogTalking() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.word.length(); i++) {
            char ch = this.word.charAt(i);
            result.append(flogThinking(ch));
        }
        return result.toString();
    }

    char flogThinking(char ch) {
        if (ch == ' ')
            return ch;
        else if (Character.isLowerCase(ch))
            return compareLowerCase(ch);
        else
            return compareUpperCase(ch);
    }

    // 단어가 만약 소문자인 경우에는 사전에 들어있는 값들이 전부 대문자이기 때문에 단어를 대문자로 변환후 청개구리 사전에서 검색하고 소문자로 다시 변환하여 반환합니다.
    char compareLowerCase(char lowerCh) {
        char changedUpperCase = Character.toUpperCase(lowerCh);
        return Character.toLowerCase(this.dictionary.get(changedUpperCase));
    }

    char compareUpperCase(char upperCh) {
        return this.dictionary.get(upperCh);
    }

}
