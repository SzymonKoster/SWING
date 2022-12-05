import Enums.Gender;
import Enums.StudentCondition;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Class implements Comparator<Student> {
    private String nazwaGrupy;
    private List<Student> listaStudentow;
    private int maksymalnaIloscStudentow;

    ///nowe
    public Class(){
        this.listaStudentow = new ArrayList<Student>();
    }

    public Class(String nazwaGrupy, int maksymalnaIloscStudentow) {
        this.nazwaGrupy = nazwaGrupy;
        this.listaStudentow = new ArrayList<>();
        this.maksymalnaIloscStudentow = maksymalnaIloscStudentow;
    }

//    public Class(){
//        this.listaStudentow = new ArrayList<Student>();
//    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public List<Student> getListaStudentow() {
        return listaStudentow;
    }

    public void setListaStudentow(List<Student> listaStudentow) {
        this.listaStudentow = listaStudentow;
    }

    public int getMaksymalnaIloscStudentow() {
        return maksymalnaIloscStudentow;
    }

    public void setMaksymalnaIloscStudentow(int maksymalnaIloscStudentow) {
        this.maksymalnaIloscStudentow = maksymalnaIloscStudentow;
    }


    public int getIloscStudentow() {
        return this.listaStudentow.size();
    }

    public double getProcentZapelnieniaGrupy() {
        return (double) this.listaStudentow.size() / (double) this.maksymalnaIloscStudentow * 100.0;
    }



    //dodawanie studenta do grupy
    public void addStudent(Student dodawanyStudent) {
        for (Student studentzGrupy : this.listaStudentow) {
            if (studentzGrupy.getImie().equals(dodawanyStudent.getImie()) && studentzGrupy.getNazwisko().equals(dodawanyStudent.getNazwisko()))
                System.out.println("Student już jest przypisany do grupy");
        }
        if (this.listaStudentow.size() < this.maksymalnaIloscStudentow)
            this.listaStudentow.add(dodawanyStudent);
        else
            System.err.println("Grupa osiagnela maksymalna liczbe studentow");

    }

    //dodawanie studentowi punktow
    public void addPoints(Student varStudent, double points) {
        varStudent.setIloscPunktow(varStudent.getIloscPunktow() + points);
        //System.out.println("Aktualna ilosc punktow studenta: " + X.imie + " wynosi: " + X.iloscPunktow);
    }

    //usuwanie studenta
    public void getStudent(Student varStudent) {
        int index = this.listaStudentow.indexOf(varStudent);
        if (index == -1) {
            System.err.println("Nie ma takiego studenta w grupie");
        }
        if (varStudent.getIloscPunktow() == 0)
            this.listaStudentow.remove(index);
    }

    //zmiana stanu studenta
    public void changeCondition(Student varStudent, StudentCondition varStan) {
        varStudent.setStanStudenta(varStan);
    }

    //zmniejsza ilosc punktow
    public void removePoints(Student varStudent, double points) {
        varStudent.setIloscPunktow(varStudent.getIloscPunktow() - points);
    }

    //porownywanie nazwisk studentow
    public int compare(Student st1, Student st2) {
        int result = st1.getNazwisko().compareTo(st2.getNazwisko());

        if (result == 0) {
            return result;
        }
        return -1;
    }

    //zwraca studenta o danym nazwisku
    public Student search(String szukaneNazwisko) {
        Student varSzukany = new Student(-1, "", szukaneNazwisko, StudentCondition.Obecny, -1, Gender.mezczyzna, 1);
        for (Student szukanyZListy : this.listaStudentow) {
            if (this.compare(varSzukany, szukanyZListy) == 0) {
                szukanyZListy.print();
                return szukanyZListy;
            }
        }
        System.err.println("W grupie nie ma studenta o szukanym nzazwisku.");
        return varSzukany;
    }


    //zwraca wszystkich studentow z pasuajcym fragmentem imienia lub nazwiska
    public List<Student> searchPartial(String fraza) {
        List<Student> pasuajcyStudenci = new ArrayList<>();

        for (Student varStudent : this.listaStudentow) {
            if (varStudent.getImie().contains(fraza)) {
                pasuajcyStudenci.add(varStudent);
            } else if (varStudent.getNazwisko().contains(fraza)) {
                pasuajcyStudenci.add(varStudent);
            }
        }
        if (pasuajcyStudenci.size() == 0) {
            System.out.println("Nie znaleziono studentow zawierajacych wprowadzoną frazę");
        }
        for (Student i : pasuajcyStudenci) {
            i.print();
            System.out.println();
        }
        return pasuajcyStudenci;
    }

    //zwraca ilość osób o danym tym samym stanie
    public int countByCondition(StudentCondition varStan) {
        int counter = 0;
        for (Student varStudent : this.listaStudentow) {
            if (varStudent.getStanStudenta() == varStan) {
                counter++;
            }
        }
        System.out.println("Ilosc studentow o statusie '" + varStan + "' wynosi: " + counter);
        return counter;
    }


    //opis grupy
    public void summary() {
        for (Student opis : this.listaStudentow) {
            opis.print();
            System.out.println();
        }
    }


    public void sortByName() {
        Collections.sort(this.listaStudentow, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return CharSequence.compare(o1.getImie(), o2.getImie());
            }
        });
    }


    public void sortByPoints() {
        Collections.sort(this.listaStudentow, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return -1 * Double.compare(st1.getIloscPunktow(), st2.getIloscPunktow());
            }
        });
    }


    public Student max() {
        Student varStudent = Collections.max(this.listaStudentow, (o1, o2) -> {
            return Double.compare(o1.getIloscPunktow(), o2.getIloscPunktow());
        });
        varStudent.print();
        return varStudent;
    }


}

