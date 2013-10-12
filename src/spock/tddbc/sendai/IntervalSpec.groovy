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


//    下端点と上端点を与えて閉区間を生成しよう
//    閉区間から下端点と上端点を取得しよう
//    閉区間から文字列表記を取得しよう


    def "閉区間[4, 9]から、上端点を取得する"() {
        setup:
            def i = new Interval(4, 9)
        expect:
            assert i.upperEnd() == 9
    }

}
