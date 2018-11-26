FROM docker.target.com/tap/alpine-jre

ADD build/distributions/epic-hackathon-api.tar /

ENTRYPOINT ["/epic-hackathon-api/bin/epic-hackathon-api"]

#Set Time Zone to central
ENV TZ=America/Chicago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone