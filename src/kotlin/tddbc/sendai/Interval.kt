package tddbc.sendai

/**
 * Created with IntelliJ IDEA.
 * User: kazuki
 * Date: 2013-10-12
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public class Interval(lower : Int, upper : Int) {

  val lowerEnd = if(lower <= upper) { lower } else { throw RuntimeException() }
  val upperEnd = upper

  fun toString() : String = "[${lowerEnd},${upperEnd}]"

  fun equals(other : Interval) : Boolean
          = (this.lowerEnd == other.lowerEnd
              && this.upperEnd == other.upperEnd)

  fun contains(i : Int) : Boolean = lowerEnd <= i && i <= upperEnd

//  fun isConnectedTo(other : Interval) : Boolean
//          = (this.lowerEnd <= other.upperEnd && other.upperEnd <= this.upperEnd
//              || this.lowerEnd <= other.lowerEnd && other.lowerEnd <= this.upperEnd)
//    fun isConnectedTo(other : Interval) : Boolean
//            = (other.upperEnd in this.lowerEnd..this.upperEnd)
//                || (other.lowerEnd in this.lowerEnd..this.upperEnd)

  fun isConnectedTo(other : Interval) : Boolean
          = contains(other.lowerEnd) || contains(other.upperEnd)

}

