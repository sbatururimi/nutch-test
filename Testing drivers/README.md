# How To
## Chrome driver
Using classes defined here, your can test your nutch setup.
For example, testing that you can you use the chrome driver alone:
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


**NB**
The headless mode (`--headless`)is required when a screen session is not available by default (for example no monitor attached to the server). You can consider an alternative way of doing with `Xvfb`

## Firefox driver
1) install firefox
```
apt install firefox
```
2) download the gecko driver from https://www.softwaretestinghelp.com/selenium-webdriver-selenium-tutorial-8/
For example:
``` 
wget https://github.com/mozilla/geckodriver/releases/download/v0.23.0/geckodriver-v0.23.0-linux64.tar.gz
```
3) Add required jars into classpath
```
# set the Java CLASSPATH environment variable 
export CLASSPATH=".:selenium-chrome-driver-3.141.5.jar:selenium-api-3.141.5.jar:selenium-support-3.141.5.jar:selenium-remote-driver-3.141.5.jar:okhttp-3.11.0.jar :okio-1.14.0.jar:guava-25.0-jre.jar:okhttp-3.11.0.jar:commons-exec-1.3.jar"
```

4)  compile the test code
```java
javac FirefoxDriverTest.java
```

5) launch the code
```java
java FirefoxDriverTest
```

6) It should print something like the following:
```bash
INFO: Detected dialect: OSS
Google
```
