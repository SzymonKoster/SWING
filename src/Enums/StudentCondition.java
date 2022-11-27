package Enums;

public enum StudentCondition {
    Odrabiajacy {
        @Override
        public String toString() {
            return "Odrabiajacy";
        }
    },
    Chory {
        @Override
        public String toString() {
            return "Chory";
        }
    },
    Nieobecny {
        @Override
        public String toString() {
            return "Nieobecny";
        }
    },
    Obecny {
        @Override
        public String toString() {
            return "Obecny";
        }
    },
}