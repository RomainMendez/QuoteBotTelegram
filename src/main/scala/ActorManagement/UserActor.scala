package ActorManagement

import java.util.Random

import Bot.message.{AddMessage, RandomQuery}
import Data.{SavedMessage, SavedUser}
import akka.actor.Actor
import info.mukel.telegrambot4s.api.{Polling, TelegramBot}
import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.methods.{ForwardMessage, SendMessage}


class UserActor(user : SavedUser) extends Actor with TelegramBot with Polling with Commands  {
  def token = ""
  var allMessage : List[SavedMessage] = Nil
  val rand = new Random
  def receive : Receive = {
    case AddMessage(message) => {
      allMessage = message :: allMessage
    }
    case RandomQuery(id) => {
      if(allMessage.isEmpty) {
        request(SendMessage(id, "You have no message stored !"))
      }
      else {
        val chosen = rand.nextInt(allMessage.size)
        val toForward = allMessage(chosen)
        request(ForwardMessage(id, toForward.chatId, Some(true), toForward.chatId))
      }
    }
  }
}
