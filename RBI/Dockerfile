FROM openjdk:25-rc-jdk

LABEL vendor=ByXanum

WORKDIR /iop

COPY IOP.RBI_1.1.jar /iop/IOP.RBI.jar
COPY config.properties /iop/config.properties

# Exponer puerto TCP
EXPOSE 5244/tcp

CMD ["java", "-jar", "IOP.RBI.jar"]


