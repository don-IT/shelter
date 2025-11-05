# Use latest Jenkins LTS with Java 17 (modern default)
FROM jenkins/jenkins:lts-jdk17

USER root

# Install OS packages needed (docker CLI, etc.)
RUN apt-get update && \
    apt-get install -y lsb-release python3-pip curl gnupg2

# Add Docker official repository (for docker CLI)
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
      https://download.docker.com/linux/debian/gpg && \
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
      https://download.docker.com/linux/debian $(lsb_release -cs) stable" \
      > /etc/apt/sources.list.d/docker.list

RUN apt-get update && apt-get install -y docker-ce-cli

USER jenkins

# Install plugins — blueocean latest, docker-workflow
# According to the plugin site, the latest Blue Ocean version is **1.27.23** and it requires Jenkins 2.479.3 or newer :contentReference[oaicite:0]{index=0}
RUN jenkins-plugin-cli --plugins "blueocean:1.27.23 docker-workflow:1.28"

# (Optional) you can pin other Blue Ocean sub-plugins if needed:
# RUN jenkins-plugin-cli --plugins "blueocean:1.27.23 blueocean-git-pipeline:1.27.23 blueocean-dashboard:1.27.23 docker-workflow:1.28"
