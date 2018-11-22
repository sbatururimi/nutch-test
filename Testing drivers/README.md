# How To
Using classes defined here, your can test your nutch setup.
For example, testing that you can you the chrome driver alone:
1) Place the class of interest into the compiled nutch folder.
Ex: move `ChromeDriverTest.java` into `/nutch/plugins/lib-selenium` where nutch is a symlink to nutch_source/runtime/local
2) Add required jars into classpath
```
# set the Java CLASSPATH environment variable 
export CLASSPATH=".:selenium-chrome-driver-3.141.5.jar:selenium-api-3.141.5.jar:selenium-support-3.141.5.jar:selenium-remote-driver-3.141.5.jar:okhttp-3.11.0.jar :okio-1.14.0.jar:guava-25.0-jre.jar:okhttp-3.11.0.jar:commons-exec-1.3.jar"
```
**NB** The version of jar to be added may vary.

3)  compile the test code
```java
javac ChromeDriverTest.java
```

4) launch the code
```java
java ChromeDriverTest
```

5) It should print something like the following:
```bash
INFO: Detected dialect: OSS
Google
```