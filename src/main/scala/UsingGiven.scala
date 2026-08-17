case class TraceContext(traceId: String)

def processTransaction(amount: Double)(using ctx: TraceContext): Unit =
  println(s"[Trace: ${ctx.traceId}] Перевод на сумму $amount выполнен")

@main def main6(): Unit =
  given traceContext: TraceContext = TraceContext("req-777")
  processTransaction(500)