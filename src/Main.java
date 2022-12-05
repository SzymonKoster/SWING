import Enums.Gender;
import Enums.StudentCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


////lab 3
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import java.awt.GridLayout;
//import java.awt.Insets;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTable;
//import javax.swing.JScrollPane;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //dodajemy kilku studentow
        Student Adam = new Student(1, "Adam", "Kowalski", StudentCondition.Obecny, 2001, Gender.mezczyzna, 90);
        Student Oskar = new Student(2, "Oskar", "Sandomierski", StudentCondition.Nieobecny, 2000, Gender.mezczyzna, 92);
        Student Bartek = new Student(3, "Bartek", "Adamczyk", StudentCondition.Chory, 2001, Gender.mezczyzna, 70);
        Student Zygmunt = new Student(4, "Zygmunt", "Lesny", StudentCondition.Obecny, 2000, Gender.mezczyzna, 99);
        Student Czarek = new Student(5, "Czarek", "Kowalski", StudentCondition.Odrabiajacy, 2001, Gender.mezczyzna, 62);
        Student Leszek = new Student(6, "Leszek", "Glowacki", StudentCondition.Chory, 1999, Gender.mezczyzna, 58);
        Student Kasia = new Student(7, "Kasia", "Glowacka", StudentCondition.Chory, 2003, Gender.kobieta, 50);
        Student Amelia = new Student(8, "Amelia", "Wozniak", StudentCondition.Nieobecny, 1998, Gender.kobieta, 27);
        Student Eleonora = new Student(9, "Eleonora", "Szymborska", StudentCondition.Chory, 2003, Gender.kobieta, 50);
        Student Marcin = new Student(10, "Marcin", "Kowalczyk", StudentCondition.Odrabiajacy, 1995, Gender.mezczyzna, 86);



        //tworze 3 grupy
        Class Grupa1 = new Class("Grupa1", 10);
        Class Grupa2 = new Class("Grupa2", 5);
        Class Grupa3 = new Class("Grupa3", 12);

        Grupa1.addStudent(Czarek);
        Grupa1.addStudent(Leszek);
        Grupa1.addStudent(Zygmunt);
        Grupa1.addStudent(Oskar);
        Grupa1.addStudent(Adam);
        Grupa1.addStudent(Bartek);
        Grupa1.addStudent(Marcin);
        Grupa1.addStudent(Kasia);
        Grupa2.addStudent(Eleonora);
        Grupa2.addStudent(Amelia);

//        Grupa1.summary();
//        System.out.println("---------------------------");

//        System.out.println("Dodajemy 5 pkt Adamowi");
//        Grupa1.addPoints(Adam,5);
//        Adam.print();

//        System.out.println("Usuwamy Marcina, bo ma 0 punktow");
//        Grupa1.removePoints(Marcin, 86);
//        Grupa1.getStudent(Marcin);
//        Grupa1.summary();

//        System.out.println("Zmieniamy Adama z 'obecny' na 'nieobecny");
//        Grupa1.changeCondition(Adam, StudentCondition.Nieobecny);


//        System.out.println("Szukamy Studenta z nazwiskiem Glowacki");
//        Grupa1.search("Glowacki");


//        System.out.println("Szukamy Studenta z fragmentem nazwiska glowa");
//        Grupa1.searchPartial("Glowa");

//        System.out.println("Ilosc nieobecnych studentow w grupie");
//        Grupa1.countByCondition(StudentCondition.Nieobecny);

//
//        System.out.println("Sortowanie studentow po imieniu");
//        Grupa1.sortByName();
//        Grupa1.summary();

//        System.out.println("Sortowanie studentow po ilosci punktow");
//        Grupa1.sortByPoints();
//        Grupa1.summary();


//        System.out.println("Zwraca studenta z najwieksza iloscia punktow");
//        Grupa1.max();


        //########################################################################//
        //Tworzymy kontener dla grup ze studentami
        ClassContainer InformatykaTechniczna = new ClassContainer();


        System.out.println("Tworzymy 3 klasy Studentow");
        InformatykaTechniczna.addClass("Grupa1", 10);
        InformatykaTechniczna.addClass("Grupa2", 5);
        InformatykaTechniczna.addClass("Grupa3", 12);
        InformatykaTechniczna.addClass("Grupa4", 20);


        System.out.println("\nUsuwamy grupe 4");
        InformatykaTechniczna.removeClass("Grupa4");


        Class temp = InformatykaTechniczna.getGrupy("Grupa1");
        temp.addStudent(Adam);
        temp.addStudent(Oskar);
        temp.addStudent(Bartek);

        temp = InformatykaTechniczna.getGrupy("Grupa2");
        temp.addStudent(Amelia);


        System.out.println("\nPuste grupy:");
        List<Class> pusteGrupy = new ArrayList<Class>();
        pusteGrupy = InformatykaTechniczna.findEmpty();
        for(Class varGrupa: pusteGrupy) {
            System.out.println(varGrupa.getNazwaGrupy());
        }


        System.out.println("");
        InformatykaTechniczna.summary();



//        // -- lab 3 --
//        JFrame frame = new JFrame("Students");
//        JLabel label = new JLabel("Students group", JLabel.CENTER);
//        /*
//            Okno dzieli sie na panele:
//            - panel userData - wykaz tabeli studentow w grupie lub grup studentow
//            - panel actions - przyciski w zaleznosci od tego czy grupa studentow czy grupy
//            * Akcje grupy
//                - dodaj grupe
//                - usun grupe
//                - zmien nazwe grupy, zmien limit grupy
//                - otworz grupe ( otwiera sie lista studentow w grupie)
//
//            * Akcje studentow
//                - dodaj studenta do grupy
//                - usun studenta z grupy
//                - zmien informacje o studencie
//
//             Tworzenie warstwy danych i warstwy graficznej
//        */
//        JPanel userData = new JPanel();
//
//
//        String[] studentColumns = {"ID", "First Name", "Last Name", "Student's Condition", "Year of Birth", "Scores"};
//        List<Student> studentsList = group.getStudentList();
//        String[][] data = new String[studentsList.size()][5];
//        String studentData[][] = new String[5][6];
//
//        int i = 0;
//        for(Student st: studentsList) {
//            studentData[i][0] = String.valueOf(i+1);
//            studentData[i][1] = st.getFirstName();
//            studentData[i][2] = st.getLastName();
//            studentData[i][3] = st.getStatusName();
//            studentData[i][4] = String.valueOf(st.getDateOfBirth());
//            studentData[i][5] = String.valueOf(st.getScores());
//            i++;
//        }
//
//        String[] groupColumns = { "ID", "Name", "Capacity" };
//        String[][] groupData = new String[10][3];
//        Class[] groupsTmp = new Class[3];
//        groupsTmp[0] = studentsGroup.getGroup("Grupa 1");
//        groupsTmp[1] = studentsGroup.getGroup("Grupa 3");
//        groupsTmp[2] = studentsGroup.getGroup("Grupa 4");
//
//        for(i = 0; i < 3; i++) {
//            groupData[i][0] = String.valueOf(i + 1);
//            groupData[i][1] = groupsTmp[i].getNameGroup();
//            groupData[i][2] = String.valueOf(groupsTmp[i].getMaxListSize());
//        }
//
//        ProgramFrame guiFrame = new ProgramFrame("Students Management System", "Student's Group", groupData, groupColumns);
//        guiFrame.initFrame();
//
//        //settings for the panel
//        //BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
//        //panel.setLayout(boxlayout);
//        //panel.setBorder(new EmptyBorder( new Insets(45, 70, 45, 70)));
//
//        // Create JTable
////        JTable jt = new JTable(data, columns);
////        JScrollPane sp = new JScrollPane(jt);
//
//
//
//        // defines buttons
//        //JButton jb1 = new JButton("Button 1");
//        //JButton jb2 = new JButton("Button 2");
//        //JButton jb3 = new JButton("Button 3");
//
//        //add buttons to the frame
//        //panel.add(jb1);
//        //panel.add(jb2);
//        //panel.add(jb3);
//
//        // add the label nad panel to the frame
//        //frame.setLayout(new GridLayout(2, 1));
//          frame.add(sp);
//        //frame.add(label);
//        //frame.add(panel);
//
////         Settings for the frame
////        frame.pack();
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setSize(700, 560);
////        frame.setVisible(true);

    }
}