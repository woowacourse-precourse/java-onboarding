package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_BEFORE_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_START_INDEX;
import static onboarding.problem2.consts.CryptogramStringConst.CRYPTOGRAM_SPLIT_VALUE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 암호문을 해독하는 기능을 제공하는 클래스
 */
public class Decryptor {

    /**
     * 중복 문자를 삭제했는지에 대한 여부
     */
    private static boolean isRemoveDuplicateCharacter = false;

    /**
     * 암호문을 한 글자씩 분리한 List
     */
    private static List<String> cryptogramList;

    /**
     * new 연산자를 통한 생성을 방지하기 위한 private 기본 생성자
     */
    private Decryptor() {
    }

    /**
     * 중복되는 문자가 없을 때 까지 반복하며 암호문을 해독하는 메소드
     *
     * @param cryptogram 암호문
     * @return 해독 결과
     */
    public static String decrypt(String cryptogram) {
        cryptogramList = Arrays.stream(cryptogram.split(CRYPTOGRAM_SPLIT_VALUE))
            .collect(Collectors.toList());
        isRemoveDuplicateCharacter = true;

        while (isRemoveDuplicateCharacter) {
            processDuplicateCharacter();
        }
        return decryptCharacterToString();
    }

    /**
     * 암호문의 길이만큼 반복하며 암호문의 각 문자가 중복되었는지 확인하는 메소드
     */
    private static void processDuplicateCharacter() {
        int startIndex;
        int nowIndex = CHARACTER_START_INDEX;

        isRemoveDuplicateCharacter = false;
        while (nowIndex < cryptogramList.size()) {
            startIndex = nowIndex - CHARACTER_BEFORE_INDEX;
            nowIndex = findDuplicateCharacter(nowIndex, startIndex);
        }
    }

    /**
     * 두 문자가 중복된 문자인지 확인하는 메소드
     *
     * @param nowIndex   중복 문자인지 확인할 다음 문자 인덱스
     * @param startIndex 중복 문자 검사를 시작한 암호문 인덱스
     * @return 다음으로 검색할 기준 문자 인덱스
     */
    private static int findDuplicateCharacter(int nowIndex, int startIndex) {
        String startCharacter = cryptogramList.get(startIndex);
        String nowCharacter = cryptogramList.get(nowIndex);

        if (startCharacter.equals(nowCharacter)) {
            deleteDuplicateCharacter(nowCharacter, startIndex);
            isRemoveDuplicateCharacter = true;
            return ++startIndex;
        }
        return ++nowIndex;
    }

    /**
     * 중복된 문자를 모두 삭제하는 메소드
     *
     * @param duplicateCharacter 중복된 문자
     * @param startIndex         암호문에서 중복된 문자인지 확인할 문자 인덱스
     */
    private static void deleteDuplicateCharacter(String duplicateCharacter, int startIndex) {
        while (isDuplicateCharacter(duplicateCharacter, startIndex)) {
            cryptogramList.remove(startIndex);
        }
    }

    /**
     * 인덱스 위치에 있는 문자의 삭제 여부를 판단하는 메소드
     *
     * @param duplicateCharacter 중복된 문자
     * @param startIndex         암호문에서 중복된 문자인지 확인할 문자 인덱스
     * @return
     */
    private static boolean isDuplicateCharacter(String duplicateCharacter, int startIndex) {
        return cryptogramList.size() > startIndex && cryptogramList.get(startIndex)
            .equals(duplicateCharacter);
    }

    /**
     * 해독한 암호문 List를 정상적인 문자열로 변환하는 메소드
     *
     * @return 해독 결과
     */
    private static String decryptCharacterToString() {
        StringBuilder decryptStringBuilder = new StringBuilder();

        cryptogramList.forEach(decryptStringBuilder::append);
        return decryptStringBuilder.toString();
    }
}
