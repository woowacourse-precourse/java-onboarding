package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = emailResult(checkCrews(exception(forms)));
        return answer;
    }

    /**
     * 예외 처리한 forms 반환 하는 함수
     */
    private static List<List<String>> exception(List<List<String>> forms){
        List<List<String>> newForms = new ArrayList<>(new ArrayList<>());
        for (List<String> form : forms) {
            if(isEmailValid(form.get(0)) && isNameValid(form.get(1))) newForms.add(form);
        }
        return  newForms;
    }

    /**
     * 이메일 도메인이 @email.com 인지 확인하는 함수
     */
    private static boolean isEmailDomain(String email){
        if (!email.endsWith("@email.com"))
            return false;
        else return true;
    }

    /**
     * 이메일 전체 길이가 11자 이상 20자 미만인지 확인하는 함수 구현
     */
    private static boolean isEmailLength(String email){
        if (email.length()>=11 && email.length()<20)
            return true;
        else return false;
    }

    /**
     * 이메일이 제한 사항을 만족하는지 확인하는 함수
     */
    private static boolean isEmailValid(String email){
        if(isEmailDomain(email)&&isEmailLength(email))
            return true;
        else return false;
    }

    /**
     * 닉네임에 한글만 있는지 확인하는 함수
     */
    private static boolean isNameHangul(String nickname){
        String hangul = "^[가-힣]*$";
        if(!nickname.matches(hangul))
            return false;
        else return true;
    }

    /**
     * 닉네임의 길이가 1자 이상 20자 미만인지 확인하는 함수
     */
    private static boolean isNameLength(String nickname){
        if(nickname.length()>=1 && nickname.length()<20)
            return true;
        else return false;
    }

    /**
     * 닉네임의 제한사항 만족 여부를 확인하는 함수
     */
    private static boolean isNameValid(String nickname){
        if(isNameHangul(nickname)&&isNameLength(nickname))
            return true;
        else return false;
    }

    /**
     * 이메일 오름차순으로 정렬
     */
    private static List<String> emailOrder(List<String> emails){
        Map<String, String> emailMap = new TreeMap<>();
        List<String> emailList = new ArrayList<>();

        for(int i=0;i<emails.size();i++)
            emailMap.put(emails.get(i).substring(0,emails.get(i).length()-10),emails.get(i));
        for (Map.Entry<String, String> entry : emailMap.entrySet())
            emailList.add(entry.getValue());

        return emailList;
    }

    /**
     * 이메일 중복 제거
     */
    private static List<String> emailRemoveDuplicated(List<String> emails){
        Set<String> emailSet = new HashSet<String>(emails);
        List<String> emailList = new ArrayList<String>(emailSet);
        return emailList;
    }

    /**
     * 이메일 제한 사항을 만족하는 리스트로 반환하는 함수
     */
    private static List<String> emailResult(List<String> emails){
        List<String> emailCheck = new ArrayList<>();
        emailCheck = emailRemoveDuplicated(emails);
        emailCheck = emailOrder(emails);
        return emailCheck;
    }

    /**
     * 닉네임에서 2자 뽑아내는 함수
     */
    private static String nicknamePickTwoLetter(String nickname,int nicknameIndex){
        return nickname.substring(nicknameIndex,nicknameIndex+2);
    }

    /**
     * 특정 닉네임에서 'nicknamePickTwoLetter'에서 뽑은 2자를 포함하고 있는지 여부 확인하고 반환 list에 담음
     */
    private static List<String> checkDuplicated(List<String> duplicateList,String pickedLetter, List<String> crew){
        if (crew.get(1).contains(pickedLetter))
            duplicateList.add(crew.get(0));
        return duplicateList;
    }

    /**
     * 크루원들의 닉네임 일치를 확인하여 일치하는 크루원들의 이메일을 반환하는 함수
     */
    private static List<String> checkCrews(List<List<String>> crews){
        List<String> duplicateList = new ArrayList<>();
        for (int i=0;i<crews.size()-1;i++){
            duplicateList = checkWithStandCrew(crews,i,duplicateList);
        }
        return duplicateList;
    }

    /**
     * 한 크루원을 기준으로 다른 크루원들의 중복 여부 확인하는 함수
     */
    private static List<String> checkWithStandCrew(List<List<String>> crews,int standIndex,List<String> duplicateList){
        String pickedLetter;
        for(int j=0;j <crews.get(standIndex).get(1).length()-1;j++) {
            pickedLetter = nicknamePickTwoLetter(crews.get(standIndex).get(1), j);
            duplicateList = checkCrew(crews,standIndex,duplicateList,pickedLetter);
        }
        return duplicateList;
    }

    /**
     * 기준 크루원을 통해 다른 크루원의 중복 여부를 확인하는 함수
     */
    private static List<String> checkCrew(List<List<String>> crews,int standIndex,List<String> duplicateList,String pickedLetter){
        int beforeDuplicateList = duplicateList.size();
        for(int k=standIndex+1;k<crews.size();k++){
            duplicateList = checkDuplicated(duplicateList,pickedLetter,crews.get(k));
        }
        if (beforeDuplicateList != duplicateList.size())
            duplicateList.add(crews.get(standIndex).get(0));
        return duplicateList;
    }
}
