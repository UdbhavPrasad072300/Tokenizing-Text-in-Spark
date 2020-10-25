package main

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.spark.ml.feature.Tokenizer

object Start {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()

    import spark.implicits._

    val df:DataFrame = spark.read.text("src/main/resources/csv/PittsburghSep22_2020.txt")

    df.printSchema()
    df.show(false)

    val df2 = df.map(line => line.toString()).flatMap(line => line.split(" "))

    df2.show()

    df2.write.csv("output/tokenized.csv")

    println("Program has Finished")

    spark.stop()
  }
}