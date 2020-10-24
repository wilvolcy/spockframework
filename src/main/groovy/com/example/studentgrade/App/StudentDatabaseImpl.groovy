package com.example.studentgrade.App

class StudentDatabaseImpl implements IStudentDatabase{
    private  Map<String,List<Float>> scoreMap;
    private  Map<String,String> gradeMap;

    StudentDatabaseImpl() {
        this.scoreMap = new HashMap<>()
        this.gradeMap = new HashMap<>()
        scoreMap.put("123",Arrays.asList(40F,30F,30F))
        scoreMap.put("456",Arrays.asList(10F,10F,30F))
        gradeMap.put("123","C")
        gradeMap.put("456","A")

    }

    @Override
    List<Float> getStudentScores(String studentId) {
        return scoreMap.get(studentId)
    }

    @Override
    void updateStudentGrade(String studentId, String grade) {
        gradeMap.put(studentId,grade)
    }

    @Override
    String getStudentGrade(String studentId) {
        return gradeMap.get(studentId)
    }
}
