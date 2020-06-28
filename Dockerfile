##
#cache busting...?
##
EXPOSE 80

##
#initialzie filesystem
##
FROM ubuntu AS _fs
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y ruby-full /
software-properties-common /

RUN gem install travis --no-document


##
#Set up shared drive
##
MOUNT: <local log path>
COPY travis.logs mountedLogFile.txt


##
#<!define goal in POM> and RUN mvn application
##
FROM 3-jdk-11 as mvn
CMD[]

##
#pipe logs, esp. Travis logs to <logs/> to shared drive
##
RUN["/bin/sh","travis logs > travis.logs"]

##
#Docker build script to run on PR, need to trigger #automatic builds on PR
##

docker run -v <local_dir>