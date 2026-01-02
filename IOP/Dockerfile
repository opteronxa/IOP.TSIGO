FROM openjdk:25-jdk

LABEL vendor=ByXanum

WORKDIR /iop

COPY IOP.TOPFLY/IOP.TOPFLY_2.0.jar /iop/IOP.TOPFLY.jar
COPY IOP.TOPFLY/config.properties /iop/config.properties

# Exponer puerto TCP
EXPOSE 5244/tcp

# Exponer puerto UDP
EXPOSE 6671/udp


CMD ["java", "-jar", "IOP.TOPFLY.jar"]


