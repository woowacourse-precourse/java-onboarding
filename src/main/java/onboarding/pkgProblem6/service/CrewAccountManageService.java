package onboarding.pkgProblem6.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CrewAccountManageService {
    TreeSet<String> duplicateAccount = new TreeSet<>();
    Map<String, String> duplicateWord = new HashMap<>();

    public TreeSet<String> getDuplicateAccount(){
        return duplicateAccount;
    }

    /**
     * 두 글자 이상의 중복된 단어를 포함한 닉네임을 신청한 크루들을 나타내는 메소드
     * @param forms 닉네임을 신청한 crew 정보와 목록
     */
    public void addAccountByDuplicateWord(List<List<String>> forms){
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            for(int i=0;i< name.length()-1;i++){
                String splitName = name.substring(i,i+2);

                if(!duplicateWord.containsKey(splitName)) {
                    duplicateWord.put(splitName,email);
                    continue;
                }
                duplicateAccount.add(email);
                duplicateAccount.add(duplicateWord.get(splitName));
            }
        }
    }
}
