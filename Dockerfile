FROM ubuntu:latest
LABEL authors="renanmeneses"

ENTRYPOINT ["top", "-b"]