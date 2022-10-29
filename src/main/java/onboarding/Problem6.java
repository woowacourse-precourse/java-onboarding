package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    static Map<String,String> formMap = new HashMap<>();
    static Map<String,Integer> nameCountMap = new HashMap<>();

    /*
    *기능 정리
    *1. forms의 이름을 key, email은 value로 <String,String> hashMap에 저장
    *2. 이름에 대해 두글자 이상으로 만들 수 있는 문자열 경우의 수를 모두 따짐.
    *3. 이 때 따진 문자열들에 대한 각 개수를 <String,int>hashMap을 통해 저장.
    *4. <String,int>hashMap의 value값이 2이상인 값은 중복된 이름이므로 해당 key(name)값을 nameList에 저장
    *5. nameList에 저장한 String을 <String,String> hashMap의 key(name)에 포함되어있는지 찾고 존재한다면 해당 email을 emailList에 저장
    *6. emailList 정렬 하고 중복 제거 후 return
    * */

    //1. 기능1
    static void setFormMap(List<List<String>> forms){
        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            formMap.put(name,email);
        }
    }

    //2. 기능2
    //함수 배치하는 순서 생각해볼 것
    static void createNumberOfCases(String name){
        for(int i=0; i<name.length()-1; i++){
            for(int j=i+1; j<name.length(); j++){
                String newString = name.substring(i,j+1);

                if(nameCountMap.get(newString) >= 2){
                    continue;
                }

                int count = 1;

                if(nameCountMap.containsKey(newString)){
                    count = nameCountMap.get(newString)+1;
                }
                nameCountMap.put(newString,count);
            }
        }
    }


    //3. 기능3
    static void setNameCountMap(List<List<String>> forms){
        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(2);
            createNumberOfCases(name);
        }
    }

    static List<String> getNameList(){

        List<String> nameList = new ArrayList<>();

        nameCountMap.forEach((name,count)->{
            if(count>=2){
                nameList.add(name);
            }
        });

        return nameList;
    }


    public static List<String> solution(List<List<String>> forms) {
        setFormMap(forms);
        List<String> answer =
        return answer;
    }
}
