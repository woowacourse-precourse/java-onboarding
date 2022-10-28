package onboarding;

import java.util.*;
import java.util.regex.Pattern;

class CrewInfos{
    private String email;
    private String nickname;
    CrewInfos(List<String> form) {
        this.email = form.get(0);
        this.nickname = form.get(1);
    }
    public boolean checkConstaints(){
        if(!checkEmailDomain())
            return false;
        if(!checkEmailLength())
            return false;
        if(!checkNicknameLang())
            return false;
        if(!checkNicknameLength())
            return false;
        return true;
    }
    public boolean checkEmailDomain(){
        String emailDomain = this.email.substring(this.email.length()-10);
        if(emailDomain.equals("@email.com"))
            return true;
        return false;
    }
    public boolean checkEmailLength(){
        int emailLength = this.email.length();
        if(emailLength>=11 && emailLength<20)
            return true;
        return false;
    }
    public boolean checkNicknameLang(){
        String patterns = "^[가-힣]*$";
        boolean regex = Pattern.matches(patterns, this.nickname);
        return regex;
    }
    public boolean checkNicknameLength(){
        int nicknameLength = this.nickname.length();
        if(nicknameLength>=1 && nicknameLength<20)
            return true;
        return false;
    }
    public Set<String> getSubStr(){
        Set<String> subStrSet = new HashSet<>();;
        for(int i=2;i<=this.nickname.length();i++){
            for(int j=0;j<=this.nickname.length()-i;j++){
                subStrSet.add(this.nickname.substring(j,j+i));
            }
        }
        return subStrSet;
    }
}
public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        try{
            if(forms.size()<1 || forms.size()>10000)
                throw new IllegalArgumentException("Invalid Crew Count");
        }catch (Exception e){
            return Collections.emptyList();
        }

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        Set<String> answerSet = new HashSet<>();

        for(int i=0;i<forms.size();i++){
            CrewInfos crewInfos = new CrewInfos(forms.get(i));
            if(!crewInfos.checkConstaints())
                continue;
            Set<String> crewInfoSubStr = crewInfos.getSubStr();
            for(String str: crewInfoSubStr ){
                ArrayList<String> arrayList;
                if(hashMap.containsKey(str)) {
                    arrayList = hashMap.get(str);
                    arrayList.add(forms.get(i).get(0));
                    answerSet.addAll((new HashSet<String>(arrayList)));
                }
                else {
                    arrayList = new ArrayList<>();
                    arrayList.add(forms.get(i).get(0));
                }
                hashMap.put(str, arrayList);
            }
        }
        ArrayList<String> answerArray = new ArrayList<>(answerSet);
        Collections.sort(answerArray);
        return answerArray;
    }
}
