import Enums.Gender;
import Enums.StudentCondition;

import java.util.ArrayList;
import java.util.List;

public class ModelDane {
    private List<String> studentColumns;
    private List<Student> studentsInGroup;

    private List<String> groupColumns;
    private ClassContainer studentGroups;

    public ModelDane()
    {
        this.groupColumns = new ArrayList<String>();
        this.groupColumns.add("Group Name");
        this.groupColumns.add("Size Group");
        this.groupColumns.add("Group Status(%)");
        this.studentGroups = new ClassContainer();

        this.studentColumns = new ArrayList<String>();
        this.studentColumns.add("First Name");
        this.studentColumns.add("Last Name");
        this.studentColumns.add("Status");
        this.studentColumns.add("Year of Birth");
        this.studentColumns.add("Scores");
        this.studentsInGroup = new ArrayList<Student>();

    }


    public List<String> getStudentColumns() {
        return studentColumns;
    }

    public void setStudentColumns(List<String> studentColumns) {
        this.studentColumns = studentColumns;
    }

    public List<Student> getStudentsInGroup() {
        return studentsInGroup;
    }

    public void addStudentToGroup(Student student)
    {
        this.studentsInGroup.add(student);
    }

    public void addGroup(Class group) {
        this.studentGroups.addClass(group.getNazwaGrupy(), group.getMaksymalnaIloscStudentow());
    }

    public void setStudentsInGroup(List<Student> studentsInGroup) {
        this.studentsInGroup = studentsInGroup;
    }

    public List<String> getGroupColumns() {
        return groupColumns;
    }

    public void setGroupColumns(List<String> groupColumns) {
        this.groupColumns = groupColumns;
    }

    public List<Class> getGroups() {
        List<Class> groups = new ArrayList<Class>(this.studentGroups.getGrupy().values());
        return groups;
    }

    public void init()
    {

        studentGroups.addClass("Grupa 1", 5);
        studentGroups.addClass("Grupa 2", 7);
        studentGroups.addClass("Grupa 3", 2);

        Student st1 = new Student(1, "Adam", "Pierwszy", StudentCondition.Obecny, 1999, Gender.mezczyzna , 90);
        Student st2 = new Student(2, "Adam", "Pierwszymat", StudentCondition.Obecny, 1999, Gender.mezczyzna,90);
        Student st3 = new Student(3, "Tomasz", "Drugi", StudentCondition.Obecny, 2001, Gender.mezczyzna,90);
        Student st4 = new Student(4, "Paweł", "Trzeci", StudentCondition.Obecny, 2000, Gender.mezczyzna,90);
        Student st5 = new Student(5, "Marcin", "Czwarty", StudentCondition.Obecny, 1999, Gender.mezczyzna,90);
        Student st6 = new Student(6, "Marek", "Piąty", StudentCondition.Obecny, 1998, Gender.mezczyzna,90);

        Class tmp = studentGroups.getGrupy("Grupa 1");
        tmp.addStudent(st1);
        tmp.addStudent(st2);
        tmp.addStudent(st3);

        tmp = studentGroups.getGrupy("Grupa 3");
        tmp.addStudent(st4);

        tmp = studentGroups.getGrupy("Grupa 2");
        tmp.addStudent(st5);
        tmp.addStudent(st6);


    }

}
