package me.chaounne.tcg.card;

import me.chaounne.tcg.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class CardController {

    private final CardService cardService;
    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardService cardService, CardRepository cardRepository) {
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }

    @GetMapping(path = "/cards")
    public List<Card> cardList(){
        List <Card> cards = cardService.cardList();
        cardRepository.saveAll(cards);
        return cards;
    }

    @GetMapping(path = "/cards/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer id){
        Card card = cardRepository.findById(id);
        if(card == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping(path = "/cards/name/{name}")
    public ResponseEntity<Card> getCardByName(@PathVariable String name){
        Card card = cardRepository.findByName(name);
        if(card == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping(path = "/cards/get/{amount}")
    public ResponseEntity<List<Card>> getCardByAmount(@PathVariable Integer amount) {
        List<Card> cards = cardRepository.findAll();
        List<Card> booster = new ArrayList<Card>();
        int i = 0;
        while (i < amount) {
            int random = (int) (Math.random() * cards.size());
            if(booster.contains(cards.get(random))){
                continue;
            }
            booster.add(cards.get(random));
            i++;
        }
        return new ResponseEntity<>(booster, HttpStatus.OK);
    }

/**    @GetMapping(path = "/cards/get/booster")
*    public ResponseEntity<List<Card>> getBooster() {
*        List<Card> cards = cardRepository.findAll();
*        List<Card> booster = new ArrayList<>();
*        int common = 0;
*        int uncommon = 0;
*        int upper = 0;
*
*        while (booster.size() < 10) { // On arrête quand on a 10 cartes dans le booster
*            int random = (int) (Math.random() * cards.size());
*            Card card = cards.get(random);
*
*            // Vérifier si la carte est déjà dans le booster avant de l'ajouter
*            if (booster.contains(card)) {
*                continue;
*            }
*
*            // Vérification des raretés et ajout si conditions respectées
*            if (card.getRare() == 1 && common < 5) {
*                booster.add(card);
*                common++;
*            } else if (card.getRare() == 2 && uncommon < 3) {
*                booster.add(card);
*                uncommon++;
*            } else if (card.getRare() >= 3 && upper < 2) {
*                booster.add(card);
*                upper++;
*            }
*        }
*
*        booster.sort(Comparator.comparingInt(Card::getRare));
*
*        return new ResponseEntity<>(booster, HttpStatus.OK);
*    }
*/

}
