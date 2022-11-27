import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    private Map<String, Class> grupy;

    public ClassContainer() {
        this.grupy = new HashMap<>();
    }

    public Map<String, Class> getGrupy() {
        return grupy;
    }

    public Class getGrupy(String nazwaGrupy){
        for(Map.Entry elementMapy : this.grupy.entrySet()){
            Class varGrupa = (Class)elementMapy.getValue();
            if(varGrupa.getNazwaGrupy() == nazwaGrupy){
                return varGrupa;
            }
        }
        return new Class("Null", -1);
    }

    //dodaje nowa grupe
    public void addClass(String nazwaGrupy, int rozmiarGrupy) {
        this.grupy.put(nazwaGrupy, new Class(nazwaGrupy, rozmiarGrupy));
    }


    //usuwa dana grupe
    public void removeClass(String nazwaGrupy) {
        this.grupy.remove(nazwaGrupy);
    }


    //zwraca liste pustych grup
    public List<Class> findEmpty() {
        List<Class> pusteGrupy = new ArrayList<Class>();
        for (Map.Entry elementMapy : this.grupy.entrySet()) {
            Class varGrupa = (Class) elementMapy.getValue();
            if (varGrupa.getIloscStudentow() == 0) {
                pusteGrupy.add(varGrupa);
            }
        }
        return pusteGrupy;
    }

    public void setGrupy(Map<String, Class> grupy) {
        this.grupy = grupy;
    }

    //wyswietla podsumowanie informacji o grupie
    public void summary() {
        for (Map.Entry elementMapy : this.grupy.entrySet()) {
            Class varGrupa = (Class) elementMapy.getValue();
            String nazwaVarGrupy = (String) elementMapy.getKey();
            System.out.println("Informacje o grupach: ");
            System.out.println("Nazwa grupy:  " + nazwaVarGrupy);
            System.out.println("Ilosc studentow w grupie: " + varGrupa.getIloscStudentow());
            System.out.println("Maksymalna pojemnosc grupy:   " + varGrupa.getMaksymalnaIloscStudentow());
            System.out.println("Procentowe zapelnienie grupy:       " + varGrupa.getProcentZapelnieniaGrupy() + "[%]");
            System.out.println("");
        }
    }
}