package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

  static List<List<String>> memberInfo;
  static List<String> keywordList;    //특정 멤버들이 공통적으로 가지고 있는 키워드의 리스트
  static HashSet<String> emailSet;
  static List<String> sortedEmailSet;

  public static List<String> solution(List<List<String>> forms) {
    try{
      init(forms);
      checkEmail();
      search();
      sortEmailSet();
      return sortedEmailSet;
    }catch(Exception e){
      return new ArrayList<>(Collections.emptyList());
    }

  }
  static void init(List<List<String>> forms){
    memberInfo = forms;
    emailSet = new HashSet<>();
    keywordList=new ArrayList<>(Collections.emptyList());
  }
  static void checkEmail() throws Exception{
    //이메일이 email.com으로 끝나는지 검증
    for (int i = 0; i < memberInfo.size(); i++) {
      String email[]=memberInfo.get(i).get(0).split("@");
      if(!(email.length>1&&email[1].equals("email.com"))){
        throw new Exception();
      }
    }
  }
  static void search() {
    for (int i = 0; i < memberInfo.size(); i++) {
      findShareKeyword(memberInfo.get(i));
    }
  }

  static void findShareKeyword(List<String> memberInfo) {
    //멤버 정보가 주어졌을 떄, 그 멤버와 공통된 substring을 갖는 멤버들을 set에 추가한다.
    String name = memberInfo.get(1);
    String email = memberInfo.get(0);
    for (int i = 0; i < name.length() - 1; i++) {
      String keyword = name.substring(i, i + 2);
      if (!keywordList.contains(keyword)&&findShareMember(email, keyword)) { //현재 키워드가 키워드 목록에 없다면
        keywordList.add(keyword);
        //System.out.println(keywordList);
      }
    }
  }

  static boolean findShareMember(String email, String keyword) {
    //특정 키워드를 이름에 포함하고 있는 멤버를 set에 추가(자기 자신은 제외), 그런 멤버가 있는 경우 true 반환
    String curName, curEmail;
    boolean flag=false;
    for (int i = 0; i < memberInfo.size(); i++) {
      curEmail = memberInfo.get(i).get(0);
      curName = memberInfo.get(i).get(1);
      if (!curEmail.equals(email) && curName.contains(keyword)) {
        emailSet.add(memberInfo.get(i).get(0));   //키워드를 포함하고 있는 경우 set에 추가한다.
        flag=true;
      }
    }
    if(flag) emailSet.add(email); //만약 자신 포함 해당 키워드를 가진 멤버가 2명 이상이라면(=나와 유사한 닉네임을 가진 멤버가 존재한다면) 나 자신도 set에 추가
    return flag;
  }
  static void sortEmailSet(){ //결과 Set 오름차순 정렬
    sortedEmailSet=new ArrayList<>(emailSet);
    Collections.sort(sortedEmailSet);
  }
}
