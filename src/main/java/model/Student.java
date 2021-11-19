package model;

public class Student {
    private int idStudent;
    private String name;
    private String className;

    public Student(int idStudent, String name, String className) {
        this.idStudent = idStudent;
        this.name = name;
        this.className = className;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}

