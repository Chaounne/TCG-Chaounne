package me.chaounne.tcg.booster;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.chaounne.tcg.card.Card;

import java.util.List;

@Entity
@Table
public class Booster {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;

    //CREER PLUS TARD UNE ENTITEE EXTENSION
    @NotNull
    private String extensionName;

    @ManyToMany
    @JoinTable(
            name = "booster_cards",
            joinColumns = @JoinColumn(name = "booster_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

    @NotNull
    @Size(min = 1, max = 512)
    private String image;

    @NotNull
    private boolean isOpened;

    public Booster() {
    }

    public Booster(String extensionName, List<Card> cards, String image, boolean isOpened) {
        this.extensionName = extensionName;
        this.cards = cards;
        this.image = image;
        this.isOpened = isOpened;
    }

    public Booster(int id, String extensionName, List<Card> cards, String image, boolean isOpened) {
        this.id = id;
        this.extensionName = extensionName;
        this.cards = cards;
        this.image = image;
        this.isOpened = isOpened;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

}
