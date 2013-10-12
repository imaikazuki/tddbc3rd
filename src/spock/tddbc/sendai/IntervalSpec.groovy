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

  //閉区間が指定した整数を含むか (contains) 判定しよう
  def "閉区間[1, 5]は、3を含む"() {
    setup:
      def i
    when:
      i = new Interval(1, 5)
    then:
      assert i.contains(3)
  }

  def "閉区間[1, 5]は、8を含まない"() {
    setup:
    def i
    when:
    i = new Interval(1, 5)
    then:
    assert !i.contains(8)
  }

}
