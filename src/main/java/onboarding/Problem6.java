package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem6 {

  private static Map<String, String> crewInfo;
  private static final int MAX_CREW_SIZE = 10000;
  private static final String EMAIL_DOMAIN = "email.com";
  private static final int MIN_EMAIL_LENGTH = 11;
  private static final int MAX_EMAIL_LENGTH = 20;
  private static final int MAX_NICKNAME_LENGTH = 20;
  private static final String NICKNAME_REGEX = "^[가-힣]*$";
  private static final String[] EXCEPTION_LIST = {"-99999"};

  public static List<String> solution(List<List<String>> forms) {
    if (isAllowedCrewSize(forms.size())) {
      classifyForms(forms);
      return hasDuplicatedNickNameMemberEmails();
    }
    ArrayList<String> returnList = new ArrayList<>(Arrays.asList(EXCEPTION_LIST));
    return returnList;
  }

  private static void classifyForms(List<List<String>> forms) {
    crewInfo = new HashMap<>();
    for (List<String> form : forms) {
      String email = form.get(0);
      String nickName = form.get(1);
      if (isAllowedEmail(email) && isAllowedNickName(nickName)) {
        crewInfo.put(email, nickName);
      }
    }
  }

  public static List<String> hasDuplicatedNickNameMemberEmails() {
    ArrayList<String> nickNames = new ArrayList<>(crewInfo.values());
    List<String> listOfExistWord = makeListOfExistWord(nickNames);
    List<String> listOfDuplicatedWord = makeListOfDuplicatedWord(nickNames, listOfExistWord);
    List<String> duplicatedNickNames = makeKListOfDuplicatedNickNames(nickNames,
        listOfDuplicatedWord);

    List<String> listOfDuplicatedNickNameMemberEmail = new ArrayList<>();
    for (Entry<String, String> crewMember : crewInfo.entrySet()) {
      makeListOfDuplicatedNickNameMemberEmail(duplicatedNickNames,
          listOfDuplicatedNickNameMemberEmail, crewMember);
    }
    listOfDuplicatedNickNameMemberEmail.sort(Comparator.naturalOrder());
    return listOfDuplicatedNickNameMemberEmail;
  }

  /**
   * 닉네임에 포함된 모든 2글자 단어 리스트업 후 반환
   */
  private static List<String> makeListOfExistWord(List<String> nickNames) {
    ArrayList<String> listOfExistWords = new ArrayList<>();
    for (String nickName : nickNames) {
      addExistChar(listOfExistWords, nickName);
    }
    return listOfExistWords.stream().distinct().collect(Collectors.toList());
  }

  private static void addExistChar(ArrayList<String> listOfExistWord, String nickName) {
    for (int i = 0; i < nickName.length() - 1; i++) {
      String word = String.valueOf(nickName.charAt(i)) + (nickName.charAt(i + 1));
      listOfExistWord.add(word);
    }
  }

  /**
   * 중복된 단어 리스트업 후 반환
   */
  private static List<String> makeListOfDuplicatedWord(ArrayList<String> nickNames,
      List<String> listOfExistWord) {
    ArrayList<String> listOfDuplicatedWord = new ArrayList<>();
    for (String word : listOfExistWord) {
      long count = nickNames.stream()
          .filter(nickname -> nickname.contains(word))
          .count();
      if (count >= 2) {
        listOfDuplicatedWord.add(word);
      }
    }
    return listOfDuplicatedWord;
  }

  /**
   * 중복된 닉네임 리스트업 후 반환
   */
  private static ArrayList<String> makeKListOfDuplicatedNickNames(ArrayList<String> nickNames,
      List<String> listOfDuplicatedWord) {
    ArrayList<String> duplicatedNickNames = new ArrayList<>();
    for (String duplicatedWord : listOfDuplicatedWord) {
      nickNames.stream()
          .filter(nickname -> nickname.contains(duplicatedWord))
          .forEach(duplicatedNickNames::add);
    }
    return duplicatedNickNames;
  }

  /**
   * 중복된 닉네임을 가진 크루원의 이메일 리스트업 후 반환
   */
  private static void makeListOfDuplicatedNickNameMemberEmail(List<String> duplicatedNickNames,
      List<String> listOfDuplicatedNickNameMemberEmail, Entry<String, String> crewMember) {
    for (String duplicatedNickName : duplicatedNickNames) {
      if (crewMember.getValue().equals(duplicatedNickName)) {
        listOfDuplicatedNickNameMemberEmail.add(crewMember.getKey());
      }
    }
  }

  public static boolean isAllowedCrewSize(int crewSize) throws IllegalStateException {
    if (crewSize < 1 || crewSize > MAX_CREW_SIZE) {
      throw new IllegalStateException("허용된 크루 사이즈가 아닙니다.");
    }
    return true;
  }

  public static boolean isAllowedEmail(String email) throws IllegalStateException {
    if (email.length() < MIN_EMAIL_LENGTH || email.length() > MAX_EMAIL_LENGTH) {
      throw new IllegalStateException("이메일의 길이기 11~20자가 아닙니다.");
    }
    if (!email.contains("@")) {
      throw new IllegalStateException("이메일 형식이 아닙니다");
    }
    String domain = email.split("@")[1];
    if (!domain.equals(EMAIL_DOMAIN)) {
      throw new IllegalStateException("허용된 이메일 도메인이 아닙니다");
    }
    return true;
  }

  public static boolean isAllowedNickName(String nickName) throws IllegalStateException {
    if (nickName.length() < 1 || nickName.length() > MAX_NICKNAME_LENGTH) {
      throw new IllegalStateException("닉네임의 길이기 1~20자가 아닙니다.");
    }
    if (!nickName.matches(NICKNAME_REGEX)) {
      throw new IllegalStateException("한글만 입력 가능합니다.");
    }
    return true;
  }
}
