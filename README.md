# Installating Nutch
## Option 1: Nutch only
docker build --force-rm  -t nutch .

## Option 2:  selenium hub + nutch + solr
Selenium hub with 10 Chrome nodes and 10 Firefox nodes each in headless mode
```
docker-compose -f docker-compose_selenium_nutch_solr.yaml up -d --scale chrome=10 --scale firefox=10
```
## Option 3: nutch + solr

```
docker-compose -f docker-compose_nutch_solr.yaml up -d
```

## Option 4: selenium hub + nutch + solr + tor instances
```
docker-compose -f docker-compose_selenium_nutch_solr_tor.yaml up -d --scale firefox=40
```

# Installing Chrome Driver

This is an option when not using Selenium HUB.

1) Install Chrome browser:
* edit sources.list

```
vi /etc/apt/sources.list
# add at the bottom of the file
deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main
```

* Download the signing key
```
wget https://dl.google.com/linux/linux_signing_key.pub
apt-key add linux_signing_key.pub
```

* Install the stable version of Google Chrome
```
apt update
apt install google-chrome-stable
```

**NB**
You may need to upgrade and then update your packages:
```
apt upgrade
apt update
```

2) download chrome driver from the [download page](http://chromedriver.chromium.org/downloads)
```
cd ~
wget https://chromedriver.storage.googleapis.com/2.44/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
rm chromedriver_linux64.zip
```
3) Change the location of the ChromeDriver binary path if necessary in nutch-default.xml or nutch-site.xml by specifying
the value for `selenium.grid.binary`

# Installing Firefox Driver

This is an option when not using Selenium HUB.

1) Install Firefox browser:

```
apt install firefox
```

2) download gecko driver from the [download page](https://www.softwaretestinghelp.com/selenium-webdriver-selenium-tutorial-8/)
```
cd ~
wget https://github.com/mozilla/geckodriver/releases/download/v0.23.0/geckodriver-v0.23.0-linux64.tar.gz
tar -zxvf geckodriver-v0.23.0-linux64.tar.gz
rm geckodriver-v0.23.0-linux64.tar.gz
```
3) Change the location of the gecko binary path if necessary in nutch-default.xml or nutch-site.xml by specifying
the value for `selenium.grid.binary`

# Installing Opera Driver

This is an option when not using Selenium HUB. 

1) Install Opera browser by downloading the last version from [link](hhttp://http://download4.operacdn.com/ftp/pub/opera/desktop)

```
wget http://download4.operacdn.com/ftp/pub/opera/desktop/56.0.3051.99/linux/opera-stable_56.0.3051.99_amd64.deb
dpkg -i opera-stable_56.0.3051.99_amd64.deb
apt install -f
```
**NB**
Update to the appropriate Opera version.

2) download opera driver from the [download page](https://github.com/operasoftware/operachromiumdriver/releases)
```
cd ~
wget wget https://github.com/operasoftware/operachromiumdriver/releases/download/v.2.40/operadriver_linux64.zip
unzip operadriver_linux64.zip
rm operadriver_linux64.zip
mv operadriver_linux64/operadriver /root
chmod +x operadriver
```

3) Change the location of the gecko binary path if necessary in nutch-default.xml or nutch-site.xml by specifying
the value for `selenium.grid.binary`


# Run a test
1) Set the value for `selenium.driver` in `conf/nutch-site.xml` to the selenium driver you want to test
2) If you don't have a screen being attached to the server, set `selenium.enable.headless` to `true`
3) crawl
```
# connect to the nutch container
docker exec -it nutch bash

# execute the crawl
/root/nutch/bin/crawl -i -D solr.server.url=http://solr:8983/solr/mycore -s urls crawler 1
```

4) check the result
- Test your result in Solr by opening in your browser:
localhost:8983/
- navigate to the created node `mycore`,
- execute the default query fetch:
```
*:*
```

 ## License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/sbatururimi/nutch-test/blob/master/LICENSE.md)
