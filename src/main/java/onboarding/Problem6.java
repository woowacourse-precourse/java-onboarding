package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (int i = 0; i < forms.size(); i++) {
            NickNameForm.addCrew(forms.get(i));
        }
        answer = NickNameForm.validateOverlap();
        return answer;
    }

    public static void main(String[] args) {
        Program6.initData();
        List<String> inputValues = Program6.start();
        String email = inputValues.get(0);
        String nickName = inputValues.get(1);
        Program6.validate(email, nickName);
        Program6.addCrew(email, nickName);
        List<String> result = Program6.validateOverlap();
        System.out.println("result = " + result);
    }
}

class Program6 {

    static void initData() {
        Crew first = new Crew("first@emali.com", "현지가");
        Crew second = new Crew("second@emali.com", "상엽이");
        Crew third = new Crew("third@emali.com", "종준이");
        NickNameForm.addCrew(first.toList());
        NickNameForm.addCrew(second.toList());
        NickNameForm.addCrew(third.toList());
    }

    static List<String> start() {
        ArrayList<String> result = new ArrayList<>();
        OutView6.printStart();
        result.add(Input6.inputEmail());
        result.add(Input6.inputNickName());
        return result;
    }

    static void validate( String inputEmail, String inputNickName) {
        Crew.validateEmailForm(inputEmail);
        Crew.validateEmailLength(inputEmail);
        Crew.validateNickNameForm(inputNickName);
        Crew.validateNickNameLength(inputNickName);
    }

    static void addCrew(String inputEmail, String inputNickName) {
        NickNameForm.addCrew(new Crew(inputEmail, inputNickName).toList());
    }

    static List<String> validateOverlap() {
        return NickNameForm.validateOverlap();
    }
}

class Input6 {
    static Scanner scanner = new Scanner(System.in);
    static String inputEmail() {
        return scanner.nextLine();
    }

    static String inputNickName() {
        return scanner.nextLine();
    }

}

class Crew {

    private final String email;
    private final String nickName;

    Crew(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    static void validateEmailLength(String email) {
        if (email.length() < 11 || 20 <= email.length()) {
            throw new IllegalStateException("11자 이상 20자 미만의 이메일을 입력해주세요");
        }
    }

    static void validateEmailForm(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(!m.matches()) {
            throw new IllegalStateException("올바를 형식의 이메일을 입력해 주세요");
        }
    }

    static void validateNickNameLength(String nickName) {
        if (nickName.length() < 1 || 20 <= nickName.length()) {
            throw new IllegalStateException("1자 이상 20자 미만의 닉네임을 입력해 주세요");
        }
    }

    static void validateNickNameForm(String nickName) {
        String regex = "[가-힣]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nickName);
        if(!m.matches()) {
            throw new IllegalStateException("한글만 입력해주세요");
        }
    }

    public List<String> toList() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(this.email);
        temp.add(this.nickName);
        return temp;
    }

}

class NickNameForm {
    private static final Map<String, String> registrationMap = new HashMap<>();

    static void addCrew(List<String> crew) {
        registrationMap.put(crew.get(0), crew.get(1));
    }
    static List<String> validateOverlap() {
        HashMap<String, List<String>> nickNameSplitMap = getNickNameSplitMap();

        HashSet<String> overlapNickNameSet = getOverlapNickNameSet(nickNameSplitMap);

        HashMap<String, String> reversedRegistrationMap = reverseKeyValue();

        ArrayList<String> overlapNickNamesList = getOverlapNickNameList(overlapNickNameSet, reversedRegistrationMap);
        Collections.sort(overlapNickNamesList);

        return overlapNickNamesList;
    }

    private static ArrayList<String> getOverlapNickNameList(HashSet<String> overlapNickNames, HashMap<String, String> reversedRegistrationMap) {
        Iterator<String> overlapNickNamesIterator = overlapNickNames.iterator();
        ArrayList<String> overlapNickNamesList = new ArrayList<>();

        while (overlapNickNamesIterator.hasNext()) {
            String overlapNickName = overlapNickNamesIterator.next();
            overlapNickNamesList.add(reversedRegistrationMap.get(overlapNickName));
        }
        return overlapNickNamesList;
    }

    private static HashMap<String, String> reverseKeyValue() {
        HashMap<String, String> temp = new HashMap<>();
        Set<Map.Entry<String, String>> registrationEntrySet = registrationMap.entrySet();
        Iterator<Map.Entry<String, String>> registrationIterator = registrationEntrySet.iterator();
        while (registrationIterator.hasNext()) {
            Map.Entry<String, String> registrationNext = registrationIterator.next();
            temp.put(registrationNext.getValue(), registrationNext.getKey());
        }
        return temp;
    }

    private static HashSet<String> getOverlapNickNameSet(HashMap<String, List<String>> nickNameSplitMap) {
        HashSet<String> overlapNickNames = new HashSet<>();

        String[] nickNameArr = nickNameSplitMap.keySet()
                .toArray(new String[0]);

        ArrayList<List<String>> base = new ArrayList<>(nickNameSplitMap.values());
        ArrayList<List<String>> comparator = new ArrayList<>(nickNameSplitMap.values());

        for (int i = 0; i < base.size(); i++) {
            compare(overlapNickNames, nickNameArr, base, comparator, i);
        }

        return overlapNickNames;
    }

    private static void compare(HashSet<String> overlapNickNames, String[] nickNameArr, ArrayList<List<String>> base, ArrayList<List<String>> comparator, int i) {
        for (int j = 0; j < comparator.size(); j++) {
            if (validateContains(base, comparator, i, j)) {
                overlapNickNames.add(nickNameArr[i]);
            }
        }
    }

    private static boolean validateContains(ArrayList<List<String>> base, ArrayList<List<String>> comparator, int i, int j) {
        for (int k = 0; k < comparator.get(j)
                .size(); k++) {
            if (i != j && base.get(i)
                    .contains(comparator.get(j).get(k))) {
                return true;
            }
        }
        return false;
    }


    private static HashMap<String, List<String>> getNickNameSplitMap() {
        HashMap<String, List<String>> nickNameSplitMap = new HashMap<>();
        Collection<String> nickName = registrationMap.values();
        Iterator<String> nickNameIterator = nickName.iterator();
        while (nickNameIterator.hasNext()) {
            ArrayList<String> nickNameSplit = new ArrayList<>();
            String nickNameValue = nickNameIterator.next();
            char[] nickNameSplitPart = nickNameValue
                    .toCharArray();
            for (int i = 0; i < nickNameSplitPart.length - 1; i++) {
                String temp = new StringBuffer()
                        .append(nickNameSplitPart[i])
                        .append(nickNameSplitPart[i + 1])
                        .toString();
                nickNameSplit.add(temp);
            }
            nickNameSplitMap.put(nickNameValue, nickNameSplit);
        }
        return nickNameSplitMap;
    }
}

class OutView6 {
    static void printStart() {
        System.out.println("이메일과 닉네임을 입력해 주세요");
    }
    static void printHead() {
        System.out.println("forms" + "\t" + "result");
    }

    static void printResult(List<List<String>> inputCrew, List<String> result) {
        System.out.println(inputCrew + "\t" + result);
    }
}