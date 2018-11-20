# Nutch only
docker build --force-rm  -t nutch .

# All services
Selenium hub with 10 Chrome nodes and 10 Firefox nodes each in headless mode
```
docker-compose up -d --scale chrome=10 --scale firefox=10 
```