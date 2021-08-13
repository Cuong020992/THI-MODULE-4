package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity // đánh dấu đây là Entity => hibernate sẽ tạo bảng trong CSDL
@Table(name = "cities")
// tên mặc định là customer => @table để cài đặt lại thuộc tính của 1 bảng vd: đổi tên thành customers
public class City {
    @Id // đánh dấu đây là thuộc tính id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // đánh dấu thuộc tính này tự tăng
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String nameCity;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String country;


    private int area;
    private int population;
    private int gdp;
    private String detail;

    public City() {
    }

    public City(Long id, String nameCity, String country, int area, int population, int gdp, String detail) {
        this.id = id;
        this.nameCity = nameCity;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return String.format("City[id=%d, nameCity='%s', country='%s', area='%d',population='%d',gdp='%d',detail='%s',]", id, nameCity, country, area, population, gdp, detail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}