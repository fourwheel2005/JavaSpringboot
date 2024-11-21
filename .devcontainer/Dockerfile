FROM mcr.microsoft.com/vscode/devcontainers/base:ubuntu

# use this Dockerfile to install additional tools you might need, e.g.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>
# use this Dockerfile to install additional tools you might need, e.g.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>
# Set the environment variable to non-interactive mode (avoiding prompts)
ENV DEBIAN_FRONTEND=noninteractive

# Install Java (OpenJDK 17) and Maven (for Spring Boot)
RUN apt-get update \
    && apt-get install -y openjdk-17-jdk maven \
    && apt-get clean

# Install any additional tools you might need for development
# For example, you can add more tools like git, curl, etc.
# RUN apt-get install -y git curl

# Set JAVA_HOME for convenience
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Verify Java and Maven installation
RUN java -version
RUN mvn -version

# Set the working directory inside the container
WORKDIR /workspace

EXPOSE 8080