# Data Model Server SDK

Welcome to the Data Model Server SDK Repository. <br> This repository provides an SDK for data model objects commonly used in Open DID.

## Folder Structure
```
did-datamodel-sdk-server
├── CHANGELOG.md
├── CLA.md
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── LICENSE
├── dependencies-license.md
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

| Name                    | Description                                     |
| ----------------------- | ----------------------------------------------- |
| source                  | SDK source code project                         |
| README.md               | Overview and description of the project         |
| CLA.md                  | Contributor License Agreement                   |
| CHANGELOG.md            | Version-specific changes in the project         |
| CODE_OF_CONDUCT.md      | Code of conduct for contributors                |
| CONTRIBUTING.md         | Contribution guidelines and procedures          |
| LICENSE                 | Apache 2.0                                      |
| dependencies-license.md | Licenses for the project’s dependency libraries |
| MAINTAINERS.md          | General guidelines for maintaining              |
| RELEASE-PROCESS.md      | Release process                                 |
| SECURITY.md             | Security policies and vulnerability reporting   |

## Build Method
: Since this SDK is a Gradle project, Gradle must be installed.
1. Open the `build.gradle` file of the project and add the following content:
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
2. In the IDE, open the `Gradle task` window and execute the `build > build` task for the project.
3. Once the execution is complete, the `did-datamodel-sdk-server-1.0.0.jar` file will be generated in the `%Data-Model repository%/build/libs/` folder.

<br>

## Libraries

Libraries can be found in the [Releases](https://github.com/OmniOneID/did-datamodel-sdk-server/releases).

### DataModel SDK
1. Copy the did-data-model-sdk-server-1.0.0.jar file to the libs of the server project.
2. Add the following dependencies to the server project's build.gradle.

```groovy
    implementation 'com.google.guava:guava:33.2.1-jre'
    implementation 'org.hibernate:hibernate-validator:7.0.0.Final'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'

    implementation files('libs/did-datamodel-sdk-server-1.0.0.jar')
```
3. Sync `Gradle` to ensure the dependencies are properly added.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for details on our code of conduct, and the process for submitting pull requests to us.


## License
[Apache 2.0](LICENSE)
