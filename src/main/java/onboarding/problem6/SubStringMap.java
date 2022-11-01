package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class SubStringMap {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;
    List<String> emailList;
    List<String> nicknameList;
    public HashMap<String, List<String>> subStrMap;
    List<List<String>> forms;
    List<String> subNicknameList;
    public SubStringMap(List<List<String>> forms){
        this.subStrMap = new HashMap<>();
        this.forms = forms;
        this.emailList = new ArrayList<>();
        this.nicknameList = new ArrayList<>();
        this.subNicknameList = new ArrayList<>();
    }

    private void makeSubStrMap(){
        insertEmailToList();
        insertNicknameToList();
        for(int idx=0;idx<nicknameList.size();idx++){
            insertData(nicknameList.get(idx),emailList.get(idx));
        }
    }

    private void insertEmailToList(){
        for(int idx=0;idx<forms.size();idx++){
            emailList.add(idx,forms.get(idx).get(EMAIL));
        }
    }
    private void insertNicknameToList(){
        for(int idx=0;idx<forms.size();idx++){
            nicknameList.add(idx,forms.get(idx).get(NICKNAME));
        }
    }
    private void insertData(String nickname, String email){
        List<String> tempNicknameList = new ArrayList<>();
        for (int idx=0; idx<nickname.length()-1;idx++){
            tempNicknameList.add(nickname.substring(idx,idx+2));
        }
        for(int idx=0;idx<tempNicknameList.size();idx++){
            String tempNickname = tempNicknameList.get(idx);
            if(subStrMap.containsKey(tempNickname)){
                List<String> tempList = new ArrayList<>(subStrMap.get(tempNickname));
                tempList.add(email);
                subStrMap.put(tempNickname,new ArrayList<>(tempList));
            }else{
                subStrMap.put(tempNickname,List.of(email));
            }
        }
        subNicknameList.addAll(tempNicknameList);
        subNicknameList = subNicknameList.stream().distinct().collect(Collectors.toList());
    }

    public List<String> findDuplicate(){
        makeSubStrMap();
        List<String> result = new ArrayList<>();
        for(int idx=0;idx<subNicknameList.size();idx++) {
            if(subStrMap.get(subNicknameList.get(idx)).size() >= 2){
                result.addAll(subStrMap.get(subNicknameList.get(idx)));
            }
        }
        Collections.sort(result);
        return result;
    }
}
