import Enums.Gender;
import Enums.StudentCondition;

public class Student implements Comparable<Student> {
    private int nrAlbumu;
    private String imie;
    private String nazwisko;
    private StudentCondition stanStudenta;
    private int rokUrodzenia;
    private Gender plec;
    private double iloscPunktow;


    public Student(int nrAlbumu, String imie, String nazwisko, StudentCondition stanStudenta, int rokUrodzenia, Gender plec, double iloscPunktow) {
        this.nrAlbumu = nrAlbumu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanStudenta = stanStudenta;
        this.rokUrodzenia = rokUrodzenia;
        this.plec = plec;
        this.iloscPunktow = iloscPunktow;
    }

    public void print() {
        System.out.println("Informacje o studencie: ");
        System.out.println("Nr albumu:  " + nrAlbumu);
        System.out.println("Imie:       " + imie);
        System.out.println("Nazwisko:   " + nazwisko);
        System.out.println("Stan:       " + stanStudenta);
        System.out.println("Rok urodzenia: " + rokUrodzenia);
        System.out.println("Plec:       " + plec);
        System.out.println("Ilosc punktow: " + iloscPunktow);
    }

    //porownywanie studentow ze wzgledu na nazwisko
    @Override
    public int compareTo(Student porowywanyStudent) {
        if (this.getNazwisko().equals(porowywanyStudent.nazwisko)) return 0;
        else return 1;
    }

    public int getNrAlbumu() {
        return nrAlbumu;
    }

    public void setNrAlbumu(int nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public StudentCondition getStanStudenta() {
        return stanStudenta;
    }

    public void setStanStudenta(StudentCondition stanStudenta) {
        this.stanStudenta = stanStudenta;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public Gender getPlec() {
        return plec;
    }

    public void setPlec(Gender plec) {
        this.plec = plec;
    }

    public double getIloscPunktow() {
        return iloscPunktow;
    }

    public void setIloscPunktow(double iloscPunktow) {
        this.iloscPunktow = iloscPunktow;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "nrAlbumu=" + nrAlbumu +
//                ", imie='" + imie + '\'' +
//                ", nazwisko='" + nazwisko + '\'' +
//                ", stanStudenta=" + stanStudenta +
//                ", rokUrodzenia=" + rokUrodzenia +
//                ", iloscPunktow=" + iloscPunktow +
//                '}';
//    }

}