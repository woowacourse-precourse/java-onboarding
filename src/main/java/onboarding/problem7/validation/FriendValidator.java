package onboarding.problem7.validation;

import onboarding.problem7.vo.Relation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FriendValidator {

    public static final String INVALID_ID_LENGTH_MESSAGE_FORMAT = "사용자 아이디의 길이는 %d 이상 %d 이하이어야 합니다.";
    public static final int MIN_ID_LENGTH_RANGE = 1;
    public static final int MAX_ID_LENGTH_RANGE = 30;
    public static final String INVALID_RELATIONS_SIZE_MESSAGE_FORMAT = "주어진 친구 관계는 %d개 이상 %d개 이하여야 합니다.";
    public static final int MIN_RELATION_SIZE = 1;
    public static final int MAX_RELATION_SIZE = 10_000;
    public static final String INVALID_VISITORS_SIZE_MESSAGE_FORMAT = "주어진 방문자 수는 %d개 이상 %d개 이하여야 합니다.";
    public static final int MIN_VISITORS_SIZE = 0;
    public static final int MAX_VISITORS_SIZE = 10_000;
    public static final String INVALID_RELATION_SIZE_MESSAGE_FORMAT = "친구관계는 길이 %d의 리스트/배열이어야 합니다.";
    public static final int VALID_RELATION_SIZE = 2;
    public static final String INVALID_ID_FORMAT_MESSAGE = "사용자 아이디는 알파벳 소문자만 허용합니다.";
    public static final String ID_FORMAT_REGEX = "^[a-z]*$";
    public static final String DUPLICATING_RELATION_MESSAGE = "동일한 친구 관계를 중복해서 제공할 수 없습니다.";

    public static void validateUser(String user) {
        isIdLengthValid(user);
        isIdOnlyAlphabetLowerCase(user);
    }

    public static void validateRelations(List<List<String>> relations) {
        isRelationsSizeValid(relations);

        relations.forEach(relation -> {
            isRelationSizeValid(relation);
            relation.forEach(FriendValidator::isIdOnlyAlphabetLowerCase);
        });

        List<Relation> relationList = relations.stream().map(Relation::of).collect(Collectors.toList());
        hasRelationsDuplicateRelation(relationList);
    }

    public static void validateVisitors(List<String> visitors) {
        isVisitorSizeValid(visitors);
    }

    private static void hasRelationsDuplicateRelation(List<Relation> relations) {
        relations.forEach(relation -> {
            if (1 < Collections.frequency(relations, relation)) {
                throw new IllegalArgumentException(DUPLICATING_RELATION_MESSAGE);
            }
        });
    }

    private static void isIdOnlyAlphabetLowerCase(String id) {
        if (!id.matches(ID_FORMAT_REGEX)) {
            throw new IllegalArgumentException(INVALID_ID_FORMAT_MESSAGE);
        }
    }

    private static void isRelationSizeValid(List<String> relation) {
        if (relation.size() != 2) {
            throw new IllegalArgumentException(String.format(INVALID_RELATION_SIZE_MESSAGE_FORMAT, VALID_RELATION_SIZE));
        }
    }

    private static void isVisitorSizeValid(List<String> visitors) {
        if (visitors == null || MAX_VISITORS_SIZE < visitors.size()) {
            throw new IllegalArgumentException(String.format(INVALID_VISITORS_SIZE_MESSAGE_FORMAT, MIN_VISITORS_SIZE, MAX_VISITORS_SIZE));
        }
    }

    private static void isRelationsSizeValid(List<List<String>> relations) {
        if (relations == null || relations.size() < MIN_RELATION_SIZE || MAX_RELATION_SIZE < relations.size()) {
            throw new IllegalArgumentException(String.format(INVALID_RELATIONS_SIZE_MESSAGE_FORMAT, MIN_RELATION_SIZE, MAX_RELATION_SIZE));
        }
    }

    private static void isIdLengthValid(String id) {
        if (id == null || id.length() < MIN_ID_LENGTH_RANGE || MAX_ID_LENGTH_RANGE < id.length()) {
            throw new IllegalArgumentException(String.format(INVALID_ID_LENGTH_MESSAGE_FORMAT, MIN_ID_LENGTH_RANGE, MAX_ID_LENGTH_RANGE));
        }
    }
}
