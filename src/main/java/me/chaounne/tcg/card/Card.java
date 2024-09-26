package me.chaounne.tcg.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.chaounne.tcg.booster.Booster;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Card {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    @DecimalMin("0")
    private int rare;

    @NotNull
    @DecimalMin("0.01")
    private int price;

//    @NotNull
    @Size(min = 1, max = 512)
    private String image;

    @ManyToMany(mappedBy = "cards")
    @JsonIgnore
    private List<Booster> boosters = new ArrayList<>();

    public Card() {
    }

    // Controleur a suppr, conserver uniquement pour dev
    public Card(int id, String name, int rare, int price) {
        this.id = id;
        this.name = name;
        this.rare = rare;
        this.price = price;
    }

    public Card(String name, int rare, int price) {
        this.name = name;
        this.rare = rare;
        this.price = price;
    }

    public Card(int id, String name, int rare, int price, String image) {
        this.id = id;
        this.name = name;
        this.rare = rare;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rare=" + rare +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Booster> getBoosters() {
        return boosters;
    }

    public void setBoosters(List<Booster> boosters) {
        this.boosters = boosters;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
