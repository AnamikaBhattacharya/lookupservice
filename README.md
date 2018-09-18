# lookupservice

#This is a sample rest url lookup service which is used to provide the url reputation for the input url.

#In order to deploy the service goto target folder and get the lookupservice.war
#Put the war file in tomcat webapps folder and start the tomcat.

#The get request looks like:
#http://<IP:port>/lookupservice/restapi/urlinfo?url=<url>

#Sample: http://localhost:8080/lookupservice/restapi/urlinfo?url=http://google.com

#and the response is like:
#{

#   "reputation": "Safe",

 #   "url": "http://google.com"

#}

The supported reputation is:
safe
malicious
unknown

To update the url reputation the request is:
POST http://localhost:8080/lookupservice/restapi/urlinfo
Request body sample:
[{
    "reputation": "malicious",
    "url": "http://malicious.com"
},
{
    "reputation": "Safe",
    "url": "http://gmail.com"
}]

 

