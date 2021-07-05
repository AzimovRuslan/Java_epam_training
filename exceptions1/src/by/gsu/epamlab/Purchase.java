package by.gsu.epamlab;

import java.util.Objects;

public class Purchase {
        private String name;
        private Byn price;
        private int number;

        public Purchase(String name, Byn price, int number) {
            this.name = name;
            this.price = price;
            this.number = number;
        }

        public Purchase() {
        }

        public Byn getCost() {
            return new Byn(price).mul(number);
        }

        public int getNumber() {
            return number;
        }

        public Byn getPrice() {
            return price;
        }

        protected String fieldsToString() {
            return name + ";" + price + ";" + number;
        }

        @Override
        public String toString() {
            return fieldsToString() + ";" + getCost();
        }

        public String getName() {
            return name;
        }

        public String fieldsToTable() {
            return name + "     " + price + "     " + number;
        }

        public String table() {
            return fieldsToTable() + "     " + "     " + "     " + getCost();
        }

        public Purchase setData() {
            return new Purchase(null, new Byn(0), 0);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null ) return false;
            if(!(object instanceof Purchase)) return false;
            Purchase purchase = (Purchase) object;
            return Objects.equals(name, purchase.name) && Objects.equals(getCost(), purchase.getCost());
        }
}
