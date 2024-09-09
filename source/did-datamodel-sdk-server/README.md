# Data-Model-Server SDK Guide
This document is a guide for using the OpenDID Data-Model-Server SDK, which provides data model objects commonly used in Open DID, such as the `DidDocument`, `VerifiableCredential` classes, etc.


## S/W Specifications
| Category | Details                |
|------|----------------------------|
| Language  | Java 17|
| Build System  | Gradle 8.2 |

<br>

Build Method
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

## SDK Application Method
1. Copy the `did-datamodel-sdk-server-1.0.0.jar` file to the `libs` directory of the project where it will be used.
2. Add the following dependencies to the build.gradle file of the project where it will be used:

```groovy
    implementation files('libs/did-datamodel-sdk-server-1.0.0.jar')
    implementation 'com.google.guava:guava:33.2.1-jre'
    implementation 'org.hibernate:hibernate-validator:7.0.0.Final'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.projectlombok:lombok:1.18.34'
    annotationProcessor 'org.projectlombok:lombok:1.18.34'
```
3. Synchronize `Gradle` to ensure that the dependencies are added correctly.

<br>