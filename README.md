# How to use
## Option 1: Nutch only
docker build --force-rm  -t nutch .

## Option 2:  selenium hub + nutch + solr
Selenium hub with 10 Chrome nodes and 10 Firefox nodes each in headless mode
```
docker-compose -f docker-compose_selenium_nutch_solr.yaml up -d --scale chrome=10 --scale firefox=10 -f docker-compose_selenium_nutch_solr.yaml
```
## Option 2: nutch + solr

```
docker-compose -f docker-compose_nutch_solr.yaml up -d
```

### Installing Chrome Driver

This is an option when not using Selenium.

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

2) download chrome driver from the [download page](http://chromedriver.chromium.org/downloads)
```
cd ~
wget https://chromedriver.storage.googleapis.com/2.44/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
rm chromedriver_linux64.zip
```
3) Change the location of the ChromeDriver binary path if necessary in nutch-default.xml or nutch-site.xml by specifying
the value for `webdriver.chrome.driver`

# Run a test
1) crawl
```
# connect to the nutch container
docker exec -it nutch bash

# execute the crawl
/root/nutch/bin/crawl -i -D solr.server.url=http://solr:8983/solr/mycore -s urls crawler 1
```

2) check the result
Test your result in Solr by opening in your browser:
localhost:8983/
and going to the created node `mycore`, then executing the default fetch.
