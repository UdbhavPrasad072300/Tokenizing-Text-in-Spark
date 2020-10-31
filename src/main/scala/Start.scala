package main

import org.apache.spark.sql.{SparkSession, DataFrame}

import org.apache.spark.sql.functions._
import org.apache.spark.sql.Column
import org.apache.spark.ml.feature.Tokenizer

object Start {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("Tokenizing-Text-in-Spark")
      .getOrCreate()

    import spark.implicits._

    spark.sparkContext.setLogLevel("ERROR")

    val df:DataFrame = spark.read.text("src/main/resources/csv/*.txt")
    df.printSchema()
    df.show()

    val df2 = df.map(line => line.toString()).flatMap(line => line.split(" "))

    val tokenizer = new Tokenizer().setInputCol("value").setOutputCol("words")
    val tokenized = tokenizer.transform(df2)

    val output = tokenized.drop("value")

    def stringify(c: Column) = concat(concat_ws(",", c))

    output.show()

    output.withColumn("words", stringify($"words")).write.csv("output/tokenized.csv")

    println("Program has Finished")
    spark.stop()
  }
}