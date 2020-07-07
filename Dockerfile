
##
#initialzie filesystem
##
FROM ubuntu AS fs

##
#RUN apt-get update && apt-get install -y ruby-full /
#software-properties-common /
#install docker on docker
##
#RUN run apt-get update && curl -fsSL https://get.docker.com -o get-docker.sh && sudo sh get-docker.sh


##
#cache busting...?
##
EXPOSE 80

#RUN gem install travis --no-document


##
#Set up shared drive
##
#MOUNT: <local log path>
COPY travis.logs mountedLogFile.txt


##
#<!define goal in POM> and RUN mvn application
##
FROM 3-jdk-11 as mvn
#Copy into mvn the src files, POM.xml
RUN["mvn","clean","install"]

##
#pipe logs, esp. Travis logs to <logs/> to shared drive
##
RUN["/bin/sh","travis logs > travis.logs"]

