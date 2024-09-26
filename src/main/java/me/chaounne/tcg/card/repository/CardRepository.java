package me.chaounne.tcg.card.repository;

import me.chaounne.tcg.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c WHERE c.name = ?1")
    Card findByName(String name);

    @Query("SELECT c FROM Card c WHERE c.id = ?1")
    Card findById(Integer id);
}
