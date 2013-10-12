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

//    閉区間から文字列表記を取得しよう

  def "閉区間[6, 8]から、下端点を取得する"() {
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

}
