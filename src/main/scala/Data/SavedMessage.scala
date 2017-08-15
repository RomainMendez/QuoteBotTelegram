package Data
/**
  * Represents all the data needed to forward a message
  * @param mId
  * @param cId
  * @param tagsList
  * @param authorGiven
  */
class SavedMessage(mId : Long, cId : Long, tagsList : List[String], authorGiven : SavedUser) {// Add informations related to the user
  /**
    * @return this SavedMessage into a list of SavedMessage, one message for every tag
    */
  def explode : List[SavedMessage] = if(tags.isEmpty) List(this) else tags.map(e => new SavedMessage(messageId, chatId, List(e), author))
  def messageId = mId
  def chatId = cId
  def tags = tagsList
  def author = authorGiven
}