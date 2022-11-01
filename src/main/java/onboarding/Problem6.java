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
 * @version 1.1 2022/11/01
 */

public class Problem6 {
    /*
     * 구현 사항
     *1. setFormMap : name 통해 email을 찾을 수 있도록 설정.
     *2-1. createNameOfCasesAndCount : 하나의 name을 가지고 만들 수 있는 모든 두 글자 문자열의 경우를 중복없이 따져 저장해두고, 각 문자열에 대한 개수를 1씩 누적함.
     *2-2. setNameCountMap : createNumberOfCases을 forms에 있는 모든 name에 대해 진행함으로써, 각 문자열의 개수가 모두 누적됨.
     *3. getNameList : setNameCountMap를 통해 센 각 문자열의 개수를 가지고 겹치는 문자열을 찾아 모두 저장.
     *4. getEmailList : 겹치는 문자열 list를 가지고 혼란을 일으킬 name을 찾아 해당되는 email을 모두 저장.
     *5. sortAndDeduplication : 해당 email 정렬 및 중복 제거
     *6. solution : 최종 email값 반환.
     */

    /**
     * 1-1. forms의  name을 key, email은 value로 저장할 HashMap.
     */
    private static Map<String, String> formMap = new HashMap<>();
    /**
     * 2-1-2. name을 가지고 만들어진 문자열들의 개수를 누적해줄 HashMap.
     */
    private static Map<String, Integer> nameCountMap = new HashMap<>();


    /**
     * 1. name을 key, email은 value로 하여 formMap에 put.
     *
     * @param forms user들의 name,email list.
     */
    private static void setFormMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            formMap.put(name, email);
        }
    }

    /**
     * 2-1. 하나의 name을 가지고 만들 수 있는 모든 두 글자 문자열의 경우를 중복없이 따져 저장해두고,
     * 각 문자열에 대한 개수를 1씩 누적함.
     *
     * @param name 한 user의 name
     */
    private static void createNameOfCasesAndCount(String name) {

        /* 2-1-1. 하나의 name을 가지고 만들 수 있는 두 글자 문자열들을 Set을 사용하여 중복없이 모두 저장함. */
        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < name.length() - 1; i++) {
            String newString = name.substring(i, i + 2);

            if (!nameSet.contains(newString)) {
                nameSet.add(newString);
            }
        }

        /* 2-1-2. 이렇게 만든 문자열들을 nameCountMap의 key로 사용하여 각 문자열에 대한 개수를 1씩 누적함 */
        nameSet.forEach((nameOfCase) -> {
            if (nameCountMap.containsKey(nameOfCase)) {
                nameCountMap.put(nameOfCase, nameCountMap.get(nameOfCase) + 1);
            } else {
                nameCountMap.put(nameOfCase, 1);
            }
        });

    }


    /**
     * 2-2. createNumberOfCases을 forms에 있는 모든 name에 대해 진행함으로써,
     * 각 문자열의 개수가 모두 누적됨.
     *
     * @param forms user들의 name,email list.
     */
    private static void setNameCountMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            createNameOfCasesAndCount(name);
        }
    }


    /**
     * 3. setNameCountMap를 통해 센 각 문자열의 개수를 가지고,
     * 겹치는 문자열을 찾아 모두 list에 저장.
     *
     * @return 겹치는 문자열 list.
     */
    private static List<String> getNameList() {

        List<String> nameList = new ArrayList<>();

        nameCountMap.forEach((name, count) -> {
            if (count >= 2) {       // 누적한 값(value)이 2이상이 될 때
                nameList.add(name);
            }
        });

        return nameList;
    }

    /**
     * 4. getNameList을 통해 받은 겹치는 문자열 list를 가지고
     * 혼란을 일으킬 원본 name(key)을 찾아 해당되는 email(value)을 모두 저장.
     *
     * @param nameList name이 겹치는 문자열 list
     * @return 겹치는 문자열이 포함된 모든 name을 통해 구한 email list.
     */
    private static List<String> getEmailList(List<String> nameList) {


        List<String> emailList = new ArrayList<>();

        /* 겹치는 문자열이 formMap의 key(name)에 포함되 있는지 확인하고, 포함되어 있다면 해당 email을 저장 */
        for (String nameA : nameList) {             // nameA : 겹치는 문자열.
            formMap.forEach((nameB, email) -> {     // nameB : forms의 name.
                if (nameB.contains(nameA)) {
                    emailList.add(email);
                }
            });
        }

        return emailList;
    }

    /**
     * 5. email 정렬 및 중복 제거.
     *
     * @param emailList getEmailList에서 받아온 email list.
     * @return 혼란을 일으킬 name의 email list.
     */
    private static List<String> sortAndDeduplication(List<String> emailList) {

        Set<String> set = new HashSet<>(emailList);
        List<String> newEmailList = new ArrayList<>(set);
        newEmailList.sort(Comparator.naturalOrder());

        return newEmailList;
    }

    /**
     * 6. 최종 email값 반환.
     *
     * @param forms user들의 name,email list.
     * @return 최종 email list.
     */
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
