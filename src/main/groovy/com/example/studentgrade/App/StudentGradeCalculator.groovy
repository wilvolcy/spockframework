package com.example.studentgrade.App

class StudentGradeCalculator {
    public IStudentDatabase studentDatabase

    StudentGradeCalculator(IStudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase
    }
    public String calculateStudentGrade(String studentId){
        String grade = studentDatabase.getStudentGrade(studentId)
        //Check if grade is already there
        if(grade != null && !grade.isEmpty()){
            return grade
        }
        List<Float> scoreList = studentDatabase.getStudentScores(studentId)
        Float totalScore = 0F
        if(scoreList != null ){
            totalScore = scoreList.stream().reduce(0F, { a, b -> a + b })
        }
        if(totalScore > 90){
            grade = "A"
        }else if(totalScore >70){
            grade = "B"
        }else {
            grade = "C"
        }
        //Update the data base
        studentDatabase.updateStudentGrade(studentId,grade)
        return grade
    }
}
