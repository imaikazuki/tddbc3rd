package tddbc.sendai

/**
 * Created with IntelliJ IDEA.
 * User: kazuki
 * Date: 2013-10-12
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
class Interval {

  private int lowerEnd
  private int upperEnd

  Interval(int lower, int upper) {
    if (lower > upper) throw new RuntimeException()
    this.lowerEnd = lower
    this.upperEnd = upper
  }

  Integer getUpperEnd() { this.upperEnd }

  Integer getLowerEnd() { this.lowerEnd }

  @Override
  String toString() {
    return "[${lowerEnd},${upperEnd}]"
  }

  boolean contains(int i) {
    lowerEnd <= i && i <= upperEnd
  }
}
