package me.chaounne.tcg.card;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    public List<Card> cardList(){
        return List.of(
                // Commun (1) - 11 cartes
                new Card(1, "Card 1", 1, 100, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(2, "Card 2", 1, 150, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(3, "Card 3", 1, 120, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(4, "Card 4", 1, 130, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(5, "Card 5", 1, 110, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(6, "Card 6", 1, 140, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(7, "Card 7", 1, 160, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(8, "Card 8", 1, 180, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(9, "Card 9", 1, 190, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(10, "Card 10", 1, 170, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(11, "Card 11", 1, 200, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),

                // Peu commun (2) - 9 cartes
                new Card(12, "Card 12", 2, 250, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(13, "Card 13", 2, 270, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(14, "Card 14", 2, 300, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(15, "Card 15", 2, 320, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(16, "Card 16", 2, 350, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(17, "Card 17", 2, 330, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(18, "Card 18", 2, 280, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(19, "Card 19", 2, 260, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(20, "Card 20", 2, 310, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),

                // Rare (3) - 4 cartes
                new Card(21, "Card 21", 3, 400, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(22, "Card 22", 3, 450, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(23, "Card 23", 3, 480, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),
                new Card(24, "Card 24", 3, 500, "https://i.ibb.co/JdKDC9J/placeholder-card.png"),

                // Ultra rare (4) - 1 carte
                new Card(25, "Card 25", 4, 1000, "https://i.ibb.co/JdKDC9J/placeholder-card.png")
        );

    }
}
