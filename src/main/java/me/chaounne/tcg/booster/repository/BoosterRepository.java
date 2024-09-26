package me.chaounne.tcg.booster.repository;

import me.chaounne.tcg.booster.Booster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoosterRepository extends JpaRepository<Booster, Long> {

    @Query("SELECT b FROM Booster b WHERE b.id = ?1")
    Booster findById(Integer id);
}
