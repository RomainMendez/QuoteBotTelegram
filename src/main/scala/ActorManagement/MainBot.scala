package ActorManagement

import akka.actor.{Actor, ActorRef}
import info.mukel.telegrambot4s.api.{Polling, TelegramBot}
import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.models.Message

class MainBot(tk : String) extends Actor with TelegramBot with Polling with Commands{
  def token = tk
  type Id = Int
  var allActors : Map[Id, ActorRef] = Map()

  def receive : Receive = {
    case _ =>
  }

  onCommand("/quoteRandom"){implicit msg => {
    if(check(msg)){
      if(allActors.contains(msg.from.get.id)){ // i.e

      }

    }
    else{ // Should never happen or in extremely rare case
      reply{"This message is of incorrect type for this bot"}
    }

  }}

  onMessage{implicit msg => {


  }}
  def check(m : Message) : Boolean = {
    val hasAuthor = m.from.isDefined
    val hasText = m.text.isDefined

    hasAuthor && hasText
  }

}
