def readUrl(config: String): Option[String] =
  if config == "prod" then Some("api.domain.com")
  else None

def getPort(url: String): Option[Int] =
  if url == "api.domain.com" then Some(443)
  else None

def getProdPortMethod(config: String): Option[Int] =
  readUrl(config).flatMap(url => getPort(url).map(port => port))

def getProdPortFor(config: String): Option[Int] =
  for
    url <- readUrl(config)
    port <- getPort(url)
  yield port

@main def main5(): Unit =
  println(getProdPortMethod("prod"))
  println(getProdPortFor("prod"))