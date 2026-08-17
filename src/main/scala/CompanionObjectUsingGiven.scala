case class AppConfig(timeout: Int, url: String)

object AppConfig {

  def createTestConfig(): AppConfig =
    AppConfig(1000, "localhost")

  given defaultProdConfig: AppConfig =
    AppConfig(5000, "api.prod.com")

}

def startServer()(using config: AppConfig): Unit =
  println(s"Starting server at ${config.url} with timeout ${config.timeout}")

@main def main7(): Unit =
  startServer()
  println(AppConfig.createTestConfig())