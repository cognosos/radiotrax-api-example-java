
plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.9.8")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.9.8")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("org.apache.httpcomponents:httpclient:4.5.8")
}

application {
    mainClassName = "com.cognosos.radiotrax.apiclient.App"
}
