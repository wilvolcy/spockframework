package com.example.studentgrade

import com.example.studentgrade.App.IStudentDatabase
import com.example.studentgrade.App.StudentGradeCalculator
import spock.lang.Specification

class MockTest extends Specification {
    //instantiating mock
    def mockDataBase = Mock(IStudentDatabase.class)
    def app = new StudentGradeCalculator(mockDataBase)

    def 'simple mock base test'() {
        when:
            app.calculateStudentGrade("123456")
        then :
            1 * mockDataBase.getStudentScores("123456")
            1 * mockDataBase.updateStudentGrade("123456",'C')
            1 * mockDataBase.getStudentGrade("123456")

    }
    def 'simple matchers generic'() {
        when:
            app.calculateStudentGrade("123456")
        then :
            1 * mockDataBase.getStudentScores(_ as String)
            1 * mockDataBase.updateStudentGrade(_ as String,'C')
            1 * mockDataBase.getStudentGrade(_ as String)

    }
    def 'simple matchers generic with order validation'() {
        when:
            app.calculateStudentGrade("123456")
        then :
            1 * mockDataBase.getStudentGrade(_ as String)
        then :
            1 * mockDataBase.getStudentScores(_ as String)
        then :
            1 * mockDataBase.updateStudentGrade(_ as String,'C')


    }
}
