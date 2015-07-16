#!/bin/sh

NAME=$name;format="lower,hyphen"$
JAR="target/scala-2.10/\$NAME-assembly-0.1-SNAPSHOT.jar"

CLASS=\$1
shift 1

spark-submit \
--class \$CLASS \
--master local[*] \
--driver-memory $local_memory$ \
\$JAR \
\$@