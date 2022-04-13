package com.github.koshitake2m2.petstorees.core

import cats.implicits.*
import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.{MaxSize, NonEmpty}
import eu.timepit.refined.refineV
import io.estatico.newtype.macros.newtype

package object seller {
  private type SellerNameRule = NonEmpty And MaxSize[100]
  @newtype case class SellerName(value: String Refined SellerNameRule)
  object SellerName {
    def apply(rawName: String): Either[Throwable, SellerName] =
      refineV[SellerNameRule](rawName).bimap(e => new Throwable(e), SellerName.apply)
  }
}
