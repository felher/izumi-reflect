/*
 * Copyright 2019-2020 Septimal Mind Ltd
 * Copyright 2020 John A. De Goes and the ZIO Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package izumi.fundamentals.platform.bytes

import java.nio.ByteBuffer

final class IzByteBuffer(private val bytes: ByteBuffer) extends AnyVal {
  def toByteArray: Array[Byte] = {
    val b = new Array[Byte](bytes.remaining())
    bytes.get(b)
    b
  }

  def readObject[T]: T = {
    import IzBytes._
    toByteArray.readObject[T]
  }
}