package Bot.message

import Data.SavedMessage

//TODO : Add messages to allow verification of arrival of every messages
sealed trait ActorMessage
case class RandomQuery(chatId : Long) extends ActorMessage
case class AddMessage(message : SavedMessage) extends ActorMessage
case object SaveOnDisk extends ActorMessage