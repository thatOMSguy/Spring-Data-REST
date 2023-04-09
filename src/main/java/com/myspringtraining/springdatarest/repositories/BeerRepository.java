package com.myspringtraining.springdatarest.repositories;



import com.myspringtraining.springdatarest.domain.Beer;
import com.myspringtraining.springdatarest.domain.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(path = "beer", collectionResourceRel = "beer")
/**
 *will customize my api link to http://localhost:8080/api/v1/beer
 * from http://localhost:8080/api/v1/beers
 * the secnd param changes the collection inside response from beers to beer
 * "beer": [
 {
 "beerName": "Mango Bobs",
 this one -> "beer"
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
