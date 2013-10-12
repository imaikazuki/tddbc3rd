package tddbc.sendai

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: kazuki
 * Date: 2013-10-12
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
class IntervalSpec extends Specification {

  def "閉区間[-3, 8]から、下端点を取得する"() {
    setup:
    def i = new Interval(-3, 8)
    expect:
    assert i.lowerEnd == -3
  }

  def "閉区間[4, 9]から、上端点を取得する"() {
    setup:
      def i = new Interval(4, 9)
    expect:
      assert i.upperEnd == 9
  }

  def "閉区間[-5, 10]の文字列表記 '[-5,10]' を取得する"() {
    setup:
      def i = new Interval(-5, 10)
    expect:
      assert i.toString() == "[-5,10]"
  }

  def "上端が下端より小さい閉区間[8, 3]は生成できない"() {
    setup:
      def i
    when:
      i = new Interval(8, 3)
    then:
      thrown RuntimeException
  }

  def "上端と下端が等しい閉区間[5, 5]は生成できる"() {
    setup:
      def i
    when:
      i = new Interval(5, 5)
    then:
      notThrown RuntimeException
      assert i.lowerEnd == i.upperEnd
  }

  def "閉区間が値を含むかを返す"() {
    setup:
      def i = new Interval(lower, upper)
    expect:
      assert i.contains(num) == result
    where:
      lower | upper | num | result
      3     |     8 |   5 | true
      8     |    10 |   3 | false
      3     |     3 |   3 | true
  }

  def "閉区間と閉区間の比較"() {
    setup:
      def left = new Interval(a, b)
      def right = new Interval(c, d)
    expect:
      assert result == (left == right)
    where:
      a  | b  | c  | d  | result
      3  | 8  | 3  | 8  | true
      3  | 8  | 1  | 6  | false
      3  | 8  | 1  | 8  | false
      3  | 8  | 3  | 6  | false

  }

}
