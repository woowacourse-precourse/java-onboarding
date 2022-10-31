package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String,Boolean> twice_word = new HashMap<>(); //단어, 중복여부의 쌍
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] dontCheck = new boolean[forms.size()]; //check 필요 여부 //이미 check한 닉네임을 중복 체크하지 않는다.

        for (int i = 0; i < forms.size(); i++) {//forms의 모든 닉네임 순회
            String nick = forms.get(i).get(1);
            boolean flag = addDic(nick);//닉네임으로 단어리스트를 만들고 원래 있던 단어가 나왔다면 true를 반환한다.
            if(flag){//중복이 있었다면
                dontCheck[i] = true;
                answer.add(forms.get(i).get(0)); //중복된 닉
            }
        }

        for (Iterator<String> iterator = twice_word.keySet().iterator(); iterator.hasNext();) {
            String item = iterator.next(); //중복으로 나온 단어가 아니라면 리스트에서 삭제
            if (!twice_word.get(item)) {
                iterator.remove();
            }
        }
        //닉네임을 순회하며 중복 사전의 단어를 포함하고 있으면 중복된 닉네임, answer에 추가
        for (int i = 0; i < forms.size(); i++) {
            if(dontCheck[i] == true) continue;

            String nick = forms.get(i).get(1);
            Iterator<String> twice_keys = twice_word.keySet().iterator();
            while(twice_keys.hasNext()){
                String key = twice_keys.next();
                if(nick.contains(key)){
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        Collections.sort(answer); //정렬한다.
        return answer;
    }
    static boolean addDic(String nick){
        HashSet<String> mini = new HashSet<>();
        for (int j = 0; j < nick.length()-1; j++) { //닉으로 미니 사전 만들기
            String word = nick.substring(j,j+2);
            mini.add(word);
        }
        //미니 사전 단어를 전체 단어 사전에 넣기
        Iterator<String> words = mini.iterator();
        boolean flag = false;
        while(words.hasNext()){
            String word = words.next();
            if(!twice_word.containsKey(word)){//전체 사전에 없을때 -> 그냥 넣는다.
                twice_word.put(word,false);
            } else{//  있을때, 중복된 닉네임 발견, 해당 단어를 true로, flag true로
                twice_word.replace(word,true);
                flag = true;
            }
        }
        return flag;
    }
}
