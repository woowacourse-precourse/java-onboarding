# [Problem 6](https://www.notion.so/6-24d85fe50cd7480ebdb40154de1db510) 기능별 명세

## 1. public static Map<String, String> listToMap(List<List<String\>> forms) {}

### input
- **List<List<String\>> forms**
  (이메일, 닉네임)의 쌍으로 이루어진 정보가 각 크루별로 리스트에 저장되어 있으며, 이 리스트들을 저장하고 있는 리스트가 forms.

### output
- **(Map<String, String\>)** 이중 리스트 형태의 데이터를 key가 닉네임, value가 이메일인 Map 데이터로 변환한 결과.
- 
### 기능 상세
이메일과 닉네임 한 쌍이 한 명의 크루에 대한 정보이므로 리스트 데이터로서 이메일은 인덱스 0, 닉네임은 인덱스 1로 접근하기보다<br>
닉네임을 key 값으로, 이메일을 value 값으로 하는 Map으로 변환해 사용하는 것이 편하고 직관적입니다.</br>
이를 위해 문제에서 주어지는 List<List<String>> 타입 데이터 forms를 Map으로 변환하는 기능을 하는 메소드입니다.

## 2. public static List<String\> validateEmailPattern(Map<String, String> forms) {}

### input
- **Map<String, String\> forms**
  key를 닉네임, value를 이메일로 하여 저장된 각 크루들의 Map 데이터.

### output
- **(List<String\>)** 문제에서 주어진 조건에 부합하지 않는 이메일 형식들을 저장한 리스트.

### 기능 상세
forms 내 데이터 중 이메일들이 문제에서 주어진 조건에 부합하는지 확인하는 기능을 합니다. 만족시켜야 하는 이메일 형식은 다음과 같습니다.
- 기본적인 이메일의 형식을 지켜야 합니다.
- 전체 길이가 11자 이상 20자 미만이어야 합니다.
- 이메일의 도메인 email.com이어야 합니다.
위 조건에 맞추어 컴파일한 패턴과 이메일과의 매칭 여부를 파악하고, 매칭되지 않는 이메일들을 저장한 리스트를 반환합니다.