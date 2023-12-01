package org.example;

import java.util.Objects;

public class Notebook {

    Integer id;
    String  brand;
    Integer ozy;
    Integer pzy;
    String  os;
    String  color;

    public Notebook(Integer id, String brand, Integer ozy, Integer pzy, String os, String color) {
        this.id = id;
        this.brand = brand;
        this.ozy = ozy;
        this.pzy = pzy;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "ИД=" + id +
                ", Бренд='" + brand + '\'' +
                ", Оперативная память=" + ozy + "Gb" +
                ", Постоянная пямять =" + pzy + "Gb" +
                ", OS='" + os + '\'' +
                ", Цвет='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(id, notebook.id)
                && Objects.equals(brand, notebook.brand)
                && Objects.equals(ozy, notebook.ozy)
                && Objects.equals(pzy, notebook.pzy)
                && Objects.equals(os, notebook.os)
                && Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, ozy, pzy, os, color);
    }
}
