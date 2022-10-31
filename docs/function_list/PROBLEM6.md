
# 👩🏻‍💻 기능 목록


## 📖 주 기능 함수

### 1️⃣ 크루원들의 닉네임 중복 여부를 확인하여 크루원들의 이메일 리스트를 반환하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | checkCrews | List<List<String>> crews | List<String> | 중복되는 닉네임을 가진 크루원들의 이메일 반환|

  
#### 1-1. 한 크루원을 기준으로 다른 크루원들의 중복 여부 확인하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | checkWithStandCrew | List<List<String>> crews, int standIndex,List<String> duplicateList | List<String> | 중복되는 닉네임을 가진 크루원들의 이메일 반환|

#### 1-2. 기준 크루원을 통해 다른 크루원의 중복 여부 확인하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | checkCrew | List<List<String>> crews, int standIndex,List<String> duplicateList,String pickedLetter | List<String> | 중복되는 닉네임을 가진 크루원의 이메일 반환|

  
#### 1-3. 닉네임에서 2자 뽑아내는 함수 
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | nicknamePickTwoLetter | String nickname,int nicknameIndex | String | 인덱스 기준으로 닉네임의 2자를 뽑아 반환 |

#### 1-4. 특정 크루원이 뽑은 2자를 포함하는지 확인하여 반환하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | checkDuplicated | List<String> duplicateList,String pickedLetter, List<String> crew | List<String> | 중복되는 닉네임을 가진 크루원의 이메일 반환 |
  

  
### 2️⃣ 중복되는 닉네임을 가진 크루원들의 이메일을 제한 사항을 만족하는 리스트로 반환하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | emailResult | List<String> emails | List<String> | 제한 사항을 만족하는 최종 이메일 리스트 반환 |

#### 2-1. 리스트에서 중복되는 리스트를 제거하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | emailRemoveDuplicated | List<String> emails | List<String> | 중복을 제거한 이메일 리스트 반환 |

#### 2-2. 이메일을 오름차순으로 정렬하는 함수
  
  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | emailOrder | List<String> emails | List<String> | 이메일을 오름차순으로 정렬하여 반환 |
___

## 📖 제한 사항을 확인 하는 기능

### 1️⃣ 이메일이 제한 사항을 만족하는지 확인하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isEmailValid | String email | boolean | 이메일 조건 만족 여부 반환 |
  
#### 1-1. 이메일 도메인이 @email.com 인지 확인하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isEmailDomain | String email | boolean | 이메일 도메인 조건 만족 여부 반환 |
  
#### 1-2. 이메일 전체 길이가 11자 이상 20자 미만 여부 확인하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isEmailLength | String email | boolean | 이메일 길이 조건 만족 여부 반환 |



### 2️⃣ 닉네임이 제한 사항을 만족하는지 확인하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isNameValid | String nickname | boolean | 닉네임 조건 만족 여부 반환 |
  
#### 2-1. 닉네임에 한글만 있는지 확인하는 함수

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isNameHangul | String nickname | boolean | 닉네임 한글 조건 만족 여부 반환 |
  
#### 2-2. 닉네임의 길이가 1자 이상 20자 미만인지 확인하는 함수 

  | 함수 명 | 매개변수 | 반환 타입 | 반환 |
  | --- | --- | --- | --- |
  | isNameLength | String nickname | boolean | 닉네임 길이 조건 만족 여부 반환 |
  
  
