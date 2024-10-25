# Data Model Server SDK

Data Model Server SDK Repository에 오신 것을 환영합니다. <br> 이 Repository는 Open DID에서 공통으로 사용하는 데이터 모델 객체에 대한 SDK를 제공합니다.

## 폴더 구조
```
did-datamodel-sdk-server
├── CHANGELOG.md
├── CLA.md
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── LICENSE
├── LICENSE-dependencies.md
├── MAINTAINERS.md
├── README.md
├── README_ko.md
├── RELEASE-PROCESS.md
├── SECURITY.md
└── source
    ├── did-datamodel-sdk-server
    │   ├── README.md
    │   ├── README_ko.md
    │   ├── build.gradle
    │   ├── gradle
    │   │   └── wrapper
    │   ├── build    
    │   ├── .gitignore
    │   ├── gradlew        
    │   ├── gradlew.bat
    │   ├── settings.gradle
    │   └── src
    └── release
        └── did-datamodel-sdk-server-1.0.0.jar
```

|  이름 |         역할                    |
| ------- | ------------------------------------ |
| source  |  SDK 소스코드 프로젝트             |
| README.md  |  프로젝트의 전체적인 개요 설명            |
| CLA.md             | Contributor License Agreement                |
| CHANGELOG.md| 프로젝트 버전별 변경사항           |
| CODE_OF_CONDUCT.md| 기여자의 행동강령            |
| CONTRIBUTING.md| 기여 절차 및 방법           |
| LICENSE                 | Apache 2.0                                      |
| LICENSE-dependencies.md| 프로젝트 의존성 라이브러리에 대한 라이선스            |
| MAINTAINERS.md          | 유지관리 가이드              |
| RELEASE-PROCESS.md      | 릴리즈 절차                                |
| SECURITY.md| 보안취약점 보고 및 보안정책            | 

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

## 라이브러리

라이브러리는 [Releases](https://github.com/OmniOneID/did-datamodel-sdk-server/releases) 에서 찾을 수 있습니다.

## DataModel SDK
1. 서버 프로젝트의 libs에 did-datamodel-sdk-server-1.0.0.jar 파일을 복사한다.
2. 서버 프로젝트의 build gradle에 아래 의존성을 추가한다.

```groovy
    implementation 'com.google.guava:guava:33.2.1-jre'
    implementation 'org.hibernate:hibernate-validator:7.0.0.Final'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'

    implementation files('libs/did-datamodel-sdk-server-1.0.0.jar')
```
3. `Gradle`을 동기화하여 의존성이 제대로 추가되었는지 확인한다.

## 기여

Contributing 및 pull request 제출 절차에 대한 자세한 내용은 [CONTRIBUTING.md](CONTRIBUTING.md)와 [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) 를 참조하세요.

## 라이선스
[Apache 2.0](LICENSE)

