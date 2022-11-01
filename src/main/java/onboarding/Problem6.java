package onboarding;

import org.mockito.internal.matchers.Find;

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


class FindDuplicateWord{
    private final static Trie trie = new Trie();
    private final static List<String> result = new ArrayList<>();
    private final static HashSet<String> isExist = new HashSet<>();

    public void findDuplicateWord(StringBuilder stringBuilder){
        isExist.add(stringBuilder.toString());
        result.add(stringBuilder.toString());
    }

    public void search(String str){
        int cnt = 0;
        Node node = trie.rootNode;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
            node = node.childNode.getOrDefault(str.charAt(i), null);
            if(node == null){
                cnt = 0;
                stringBuilder.delete(0, stringBuilder.length());
                node = trie.rootNode;
                continue;
            }

            cnt++;
            if(cnt == 2) {
                if(!isExist.contains(stringBuilder.toString())){
                    findDuplicateWord(stringBuilder);
                }

                cnt = 0;
                node = trie.rootNode;
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
    }

    public List<String> getResult(List<List<String>> forms){
        List<String> answer = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            search(forms.get(i).get(1));
            trie.insert(forms.get(i).get(1));
        }

        for(int i=0;i<result.size();i++){
            for(int j=0;j<forms.size();j++){
                if(forms.get(j).get(1).contains(result.get(i))){
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}

public class Problem6 {

    private final static FindDuplicateWord findDuplicateWord = new FindDuplicateWord();
    public static List<String> solution(List<List<String>> forms) {
        return findDuplicateWord.getResult(forms);
    }
}
