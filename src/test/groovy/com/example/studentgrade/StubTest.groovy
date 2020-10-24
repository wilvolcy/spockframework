package com.example.studentgrade

import com.example.studentgrade.App.IStudentDatabase
import com.example.studentgrade.App.StudentGradeCalculator
import spock.lang.Specification

class StubTest extends Specification{
    // Stub
    def 'basic stub test'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >> 'A'
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'A'
    }
    def 'basic stub test-1'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >> 'C'
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'C'
    }
    def 'basic stub test-3'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >>  null
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'C'
    }
    def 'basic stub test-4'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >>  null
            studentDatabaseStub.getStudentScores('1234567')>>[10F,40F,50F]
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'A'
    }
    def 'basic stub test-5'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >>  null
            studentDatabaseStub.getStudentScores('1234567')>>[10F,40F]
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'C'
    }
    def 'basic stub test-6'(){
        given :
            def studentDatabaseStub = Stub(IStudentDatabase.class)
            def app = new StudentGradeCalculator(studentDatabaseStub)
            studentDatabaseStub.getStudentGrade('1234567') >>  null
            studentDatabaseStub.getStudentScores('1234567')>>[10F,40F,30F]
        when :
            def grade = app.calculateStudentGrade('1234567')
        then :
            grade == 'B'
    }
}
