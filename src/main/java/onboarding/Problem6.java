package onboarding;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/*
 *  🚀 기능 명세
    연속된 2글자의 이름을 관리하는 컬렉션 클래스(CollectionOfContinuousChar)
    * key(연속된 2글자) : value(이메일) 형태로 관리 (collectionOfContinuousChar)
    * 이름에서, 연속된 2글자 이상의 중복이 발생한 크루의 이메일을 관리 (duplicatedNameEmailSet)
    * 이름에서, 연속된 2글자 이상의 중복이 발생한 크루의 이메일을 오름차순으로 반환 (getDuplicatedNameEmailList)
    * 크루의 이름을 두글자씩 slice 해가며 collectionOfContinuousChar에 추가 / 중복 발생 시 duplicatedNameEmailSet에 이름 추가 (insertName)

 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CollectionOfContinuousChar collectionOfContinuousChar = new CollectionOfContinuousChar();

        for(List<String> crewInfo : forms){
            collectionOfContinuousChar.insertName(crewInfo.get(0), crewInfo.get(1));
        }

        return collectionOfContinuousChar.getDuplicatedNameEmailList();
    }
}

class CollectionOfContinuousChar{
    Map<String,String> collectionOfContinuousChar = new HashMap<String,String>();
    Set<String> duplicatedNameEmailSet = new HashSet<String>();

    public void insertName(String email, String name){
        boolean duplicatedFlag = false;

        for(int i = 0 ; i < name.length() - 1 ; i++){
            String continuousChar = "" + name.charAt(i) + name.charAt(i + 1);

            if(collectionOfContinuousChar.get(continuousChar) != null) {
                duplicatedNameEmailSet.add(collectionOfContinuousChar.get(continuousChar));
                duplicatedFlag = true;
            }
            collectionOfContinuousChar.put(continuousChar, email);
        }
        if(duplicatedFlag)  duplicatedNameEmailSet.add(email);
    }

    public List<String> getDuplicatedNameEmailList(){
        List<String> sortedList = new ArrayList<String>(duplicatedNameEmailSet);
        Collections.sort(sortedList);
        return sortedList;
    }
}