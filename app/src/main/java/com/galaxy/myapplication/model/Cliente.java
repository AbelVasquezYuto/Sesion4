package com.galaxy.myapplication.model;

public class Cliente {

    public static final String TABLE_NAME = "tabla_cliente";
    public static final String ID_FIELD = "id";
    public static final String NAME__FIELD = "names";
    public static final String LASTNAME_FIELD = "lastname";
    public static final String ADRESS_FIELD = "adress";
    public static final String AGE_FIELD = "age";


    private Integer id;
    private String name;
    private String lastname;
    private String adress;
    private Integer age;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", adress='" + adress + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
