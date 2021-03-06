package com.github.koshitake2m2.petstorees.auth.domain.user

import cats.implicits.*
import com.github.koshitake2m2.petstorees.auth.domain.user.UserError.UserIdAssertionError
import com.github.koshitake2m2.petstorees.shared.pattern.Identifier
import eu.timepit.refined.api.Refined
import eu.timepit.refined.refineV
import eu.timepit.refined.string.Uuid

case class UserId(value: String Refined Uuid) extends Identifier
object UserId {
  def apply(rawId: String): Either[UserError, UserId] =
    refineV[Uuid](rawId).bimap(_ => UserIdAssertionError(rawId), UserId.apply)
}
