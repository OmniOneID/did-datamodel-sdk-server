# Data-Model-Server SDK Guide
본 문서는 OpenDID Data-Model-Server SDK 사용을 위한 가이드로, 
Open DID에서 공통으로 사용하는 데이터 모델 객체를 제공한다.
ex) DidDocument, VerifiableCredential 클래스 등


## S/W 사양
| 구분 | 내용                |
|------|----------------------------|
| Language  | Java 17|
| Build System  | Gradle 8.2 |

<br>

## 빌드 방법
: 본 SDK 그래들 프로젝트이므로 그래들이 설치 되어 있어야 한다.
1. 프로젝트의 `build.gradle` 파일을 열고, 아래와 같이 내용 추가한다.
```groovy
plugins {
    id 'java-library'
}

repositories {
    jcenter()
}

group = 'org.omnione.did'

jar {
    archiveBaseName.set('did-datamodel-sdk-server') 
    archiveVersion.set('1.0.0')
    archiveClassifier.set('') 
}

java {
    sourceCompatibility = '17'
    targetCompatibility = '17'
}

dependencies {
    implementation 'com.google.guava:guava:33.2.1-jre'
    implementation 'org.hibernate:hibernate-validator:7.0.0.Final'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'
}
```
2. 사용하는 IDE에서 `Gradle task` 창을 열고, 프로젝트의 `build > build > 태스크를 실행한다.
3. 실행이 완료되면 `%Data-Model repository%/build/libs/` 폴더에 `did-datamodel-sdk-server-1.0.0.jar` 파일을 생성된다.

<br>

## SDK 적용 방법
1. 사용 할 프로젝트의 libs에 did-datamodel-sdk-server-1.0.0.jar 파일을 복사한다.
2. 사용 할 프로젝트의 build gradle에 아래 의존성을 추가한다.

```groovy
    implementation files('libs/did-datamodel-sdk-server-1.0.0.jar')
    implementation 'com.google.guava:guava:33.2.1-jre'
    implementation 'org.glassfish:jakarta.el:4.0.2'
    implementation 'org.hibernate:hibernate-validator:7.0.0.Final'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'
```
3. `Gradle`을 동기화하여 의존성이 제대로 추가되었는지 확인한다.

<br>