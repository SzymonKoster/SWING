package Enums;

public enum Gender {
    mezczyzna{
        @Override
        public String toString() {
            return "mezczyzna";
        }
    },
    kobieta{
        @Override
        public String toString(){
            return "kobieta";
        }
    },
}
