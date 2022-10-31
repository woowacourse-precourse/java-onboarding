package onboarding;

import java.util.*;

/**
 * 헷갈리는 닉네임 찾기 문제
 * <p>
 * 문제 설명 :
 * 우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다.
 * 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.
 * 혼란을 막기 위해 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다.
 * 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.
 * 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
 * <p>
 * 제한사항 :
 * - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
 * - 크루는 1명 이상 10,000명 이하이다.
 * - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 * - 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
 * - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 * - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 *
 * @author scyllacore
 * @version 1.1 2022/10/31
 */

public class Problem6 {
    /*
     * 구현 사항
     *1. forms의 이름을 key, email은 value로 <String,String> hashMap에 저장
     *2. 이름에 대해 두글자 이상으로 만들 수 있는 문자열 경우의 수를 모두 따짐.
     *3. 이 때 따진 문자열들에 대한 각 개수를 <String,int>hashMap을 통해 저장.
     *4. <String,int>hashMap의 value값이 2이상인 값은 중복된 이름이므로 해당 key(name)값을 nameList에 저장
     *5. nameList에 저장한 String을 <String,String> hashMap의 key(name)에 포함되어있는지 찾고 존재한다면 해당 email을 emailList에 저장
     *6. emailList 정렬 하고 중복 제거 후 return
     */

    /**
     *
     */
    static Map<String, String> formMap = new HashMap<>();
    /**
     *
     */
    static Map<String, Integer> nameCountMap = new HashMap<>();


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

        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < name.length() - 1; i++) {
            String newString = name.substring(i, i + 2);

            if(!nameSet.contains(newString)){
                nameSet.add(newString);
            }
        }

        nameSet.forEach((nameCase) -> {
            if (nameCountMap.containsKey(nameCase)) {
                nameCountMap.put(nameCase, nameCountMap.get(nameCase) + 1);
            } else {
                nameCountMap.put(nameCase, 1);
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
        // ★nameA,B로 고칠 것
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
