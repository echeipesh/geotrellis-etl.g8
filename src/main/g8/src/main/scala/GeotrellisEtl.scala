import geotrellis.raster._
import geotrellis.spark._
import geotrellis.spark.utils.SparkUtils
import geotrellis.spark.io.index.ZCurveKeyIndexMethod
import geotrellis.spark.SpatialKey
import geotrellis.spark.etl._


object GeotrellisEtl extends App {
  val etl = Etl[SpatialKey](args)

  implicit val sc = SparkUtils.createSparkContext("GeoTrellis ETL")
  val (id, rdd) = etl.ingest()

  // perform transfomations on ingested RDD here
  val output = rdd

  etl.save(id, output, ZCurveKeyIndexMethod)
  sc.stop()
}