package me.chaounne.tcg.booster;

import me.chaounne.tcg.booster.repository.BoosterRepository;
import me.chaounne.tcg.card.Card;
import me.chaounne.tcg.card.CardService;
import me.chaounne.tcg.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class BoosterController {

    private final BoosterService boosterService;
    private final BoosterRepository boosterRepository;
    private final CardService cardService;
    private final CardRepository cardRepository;

    @Autowired
    public BoosterController(BoosterService boosterService, BoosterRepository boosterRepository, CardService cardService, CardRepository cardRepository){
        this.boosterService = boosterService;
        this.boosterRepository = boosterRepository;
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }

    @GetMapping(path = "/boosters")
    public List<Booster> boosterList(){
        List <Booster> boosters = boosterRepository.findAll();
        return boosters;
    }

    @GetMapping(path = "/boosters/{id}")
    public Booster getBoosterById(Integer id){
        Booster booster = boosterRepository.findById(id);
        return booster;
    }

    @GetMapping(path = "/boosters/new")
    public ResponseEntity<Booster> getNewBooster() {
        List<Booster> boosters = boosterRepository.findAll();
        List<Card> allCards = cardRepository.findAll();
        List<Card> cards = new ArrayList<>();
        int common = 0;
        int rare = 0;
        int upper = 0;

        while (cards.size() < 10){
            System.out.println("cards size: " + cards.size());
            int random = (int) (Math.random() * allCards.size());
            Card card = allCards.get(random);

            if(card.getRare() == 1 && common < 5){
                cards.add(card);
                common++;
            } else if(card.getRare() == 2 && rare < 3){
                cards.add(card);
                rare++;
            } else if(card.getRare() == 3 && upper < 2){
                cards.add(card);
                upper++;
            } else {
                continue;
            }

            allCards.remove(card);
        }

        cards.sort(Comparator.comparingInt(Card::getRare));
        System.out.println(cards);

        Booster booster = new Booster("Dev", cards, "https://i.ibb.co/tqhJcym/placeholder-booster.png", false);

        boosterRepository.save(booster);

        return new ResponseEntity<>(booster, HttpStatus.CREATED);
    }
}
