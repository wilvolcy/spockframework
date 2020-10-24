package com.example.studentgrade

import com.example.studentgrade.App.StudentDatabaseImpl
import com.example.studentgrade.App.StudentGradeCalculator
import spock.lang.Specification

class SpyTest extends Specification{

        def spyDatabase = Spy(StudentDatabaseImpl.class)
        def app = new StudentGradeCalculator(spyDatabase)
    def 'Spy test - 1'(){
        when :
            app.calculateStudentGrade('123')
        then :
            1 * spyDatabase.getStudentGrade('123')
            0 * spyDatabase.getStudentScores('123')
    }
}
