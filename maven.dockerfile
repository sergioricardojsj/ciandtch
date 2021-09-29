FROM maven:3.8.1-jdk-11
WORKDIR /usr/src/ciandt
COPY . /usr/src/ciandt

ARG CHROME_VERSION=94.0.4606.61

RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install -y p7zip \
    p7zip-full \
    unace \
    zip \
    unzip \
    bzip2

RUN curl http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb; apt-get install -y -f
RUN rm /chrome.deb

CMD ["mvn", "clean", "test"]