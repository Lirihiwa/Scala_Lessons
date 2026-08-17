trait CsvEncoder[A]:
  def encode(value: A): String

case class Employee(name: String, position: String, salary: Int)

// Так можно, но много кода
//given given_csvEncoder: CsvEncoder[Employee] = new CsvEncoder[Employee] {
//  def encode(value: Employee): String = s"${value.name},${value.position},${value.salary}"
//}

// А так намного лучше
given CsvEncoder[Employee] with
  def encode(value: Employee): String = s"${value.name},${value.position},${value.salary}"

def writeCsv[A](value: A)(using encoder: CsvEncoder[A]): String =
  encoder.encode(value)

@main def main8(): Unit =
  val employee = Employee("Alex", "DevOps", 250000)
  println(writeCsv(employee))