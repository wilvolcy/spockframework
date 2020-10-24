package com.example.studentgrade.App

interface IStudentDatabase {
    List<Float> getStudentScores(String studentId)
    void updateStudentGrade(String studentId, String grade)
    String getStudentGrade(String studentId)
}