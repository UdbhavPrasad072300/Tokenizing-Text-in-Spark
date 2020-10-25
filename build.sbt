
name := "Tokenizing_Text_in_Spark"

version := "1.0"

scalaVersion := "2.12.10"

libraryDependencies += "org.scalafx" % "scalafx_2.11" % "8.0.102-R11"
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "3.0.1"

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.7"
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.7.7"
libraryDependencies += "org.apache.hadoop" % "hadoop-streaming" % "2.7.7"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"

assemblyJarName in assembly := s"${name.value.replace(' ', '-')}-${version.value}.jar"
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)