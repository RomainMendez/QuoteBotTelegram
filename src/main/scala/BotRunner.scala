import akka.actor.ActorSystem

object BotRunner extends App{
  override def main(args : Array[String]) : Unit = {
    println("Initializing ... ")
    val context = ActorSystem("TestSystem")
  }
}
