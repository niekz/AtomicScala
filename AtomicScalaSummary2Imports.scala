/**
  * Created by johann on 2017/02/22.
  */

package io.ninja.royals

class Royalty(name: String, characteristic: String) {
  def title(): String = {
    "Sir " + characteristic + "alot"
  }

  def fancyTitle(): String = {
    "Sir " + name +
    " " + characteristic + "alot"
  }

}

class Crest(name: String, year: String){
  def description(): String = {
    if(name == "Bear" && year == "1875")
      "Bear in the year 1875"
    else
      ""
  }
}


