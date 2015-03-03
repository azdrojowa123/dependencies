package com.netapp.example

import com.netapp.example.MockPersons._
import xsbti.{MainResult, AppConfiguration}

object PersonAssertion extends App {
  def sameFamilyName(a: Person, b: Person): Boolean = {
    val aName = a.name.split(" ")(1)
    val bName = b.name.split(" ")(1)
    aName == bName
  }

  assert(sameFamilyName(karl, nina))
  assert(!sameFamilyName(john, nina))
}
