# Tokenizing-Text-in-Spark
Spark 3 in Scala to Tokenize Large Quantities of Text

## Packaging into .jar
```
sbt package
```

## Launching Application with spark-submit to local or cloud cluster
```
./bin/spark-submit \
  --class <main-class> \
  --master <master-url> \
  --deploy-mode <deploy-mode> \
  --conf <key>=<value> \
  ... # other options
  <application-jar> \
  [application-arguments]
  ```
