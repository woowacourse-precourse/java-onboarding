package onboarding;

import java.util.*;

public class Problem6 {

    static Map<String, String> formMap = new HashMap<>();
    static Map<String, Integer> nameCountMap = new HashMap<>();

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
    static void setFormMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            formMap.put(name, email);
        }
    }

    //2. 기능2
    //함수 배치하는 순서 생각해볼 것
    static void createNumberOfCases(String name) {

        Map<String, Integer> temporaryNameCountMap = new HashMap<>();

        for (int i = 0; i < name.length() - 1; i++) {
            for (int j = i + 1; j < name.length(); j++) {
                String newString = name.substring(i, j + 1);
                
                /*
                *  if (nameCountMap.get(newString) >= 2) {
                    continue;
                } 위험함
                * */

                //int count = 1;

                /*
                if (nameCountMap.containsKey(newString)) {
                    count = 2; nameCountMap.get(newString) + 1; 한 이름에서 똑같은 경우의 문자열이 또 나올 때
                }
                */

                temporaryNameCountMap.put(newString, 1);
            }
        }

        temporaryNameCountMap.forEach((nameCase,count)->{
            if(nameCountMap.containsKey(nameCase)){
            nameCountMap.put(nameCase,nameCountMap.get(nameCase)+1);
            }
            else{
                nameCountMap.put(nameCase,1);
            }
        });

    }


    //3. 기능3
    static void setNameCountMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            createNumberOfCases(name);
        }
    }

    //4. 기능4
    static List<String> getNameList() {

        List<String> nameList = new ArrayList<>();

        nameCountMap.forEach((name, count) -> {
            if (count >= 2) {
                nameList.add(name);
            }
        });

        return nameList;
    }

    //5. 기능5
    static List<String> getEmailList(List<String> nameList) {


        List<String> emailList = new ArrayList<>();

        for (String name1 : nameList) {
            formMap.forEach((name2, email) -> {
                if (name2.contains(name1)) {
                    emailList.add(email);
                }
            });

        }

        return emailList;
    }

    //6. 기능6
    static List<String> sortAndDeduplication(List<String> emailList) {

        Set<String> set = new HashSet<>(emailList); //중복제거
        List<String> newEmailList = new ArrayList<>(set);
        newEmailList.sort(Comparator.naturalOrder());

        return newEmailList;
    }

    public static List<String> solution(List<List<String>> forms) {

        setFormMap(forms);
        setNameCountMap(forms);

        List<String> nameList = getNameList();
        List<String> emailList = getEmailList(nameList);
        emailList = sortAndDeduplication(emailList);

        List<String> answer = emailList;
        return answer;
    }
}
