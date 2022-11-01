package onboarding;

import java.util.*;

class Node{
    Map<Character, Node> childNode = new HashMap<Character, Node>();
    boolean endOfWord;
}

class Trie{
    Node rootNode = new Node();

    public void insert(String str){
        Node node = this.rootNode;

        for(int i=0;i<str.length();i++){
            node = node.childNode.computeIfAbsent(str.charAt(i), key-> new Node());
        }
        node.endOfWord = true;
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
