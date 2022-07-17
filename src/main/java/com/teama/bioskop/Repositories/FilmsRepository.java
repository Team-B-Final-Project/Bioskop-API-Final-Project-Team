package com.teama.bioskop.Repositories;

import com.teama.bioskop.Models.Films;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<Films,Integer>{

    @Query(value = "Select * from films where is_playing =?1", nativeQuery=true)
    public List<Films> getFilmByIsPlaying(Boolean isPlaying);
    
    @Query("Select f from Films f where f.seatId.studioName =?1")
    public List<Films> getFilmByStudioName(String studioName);

    @Query("select f from Films f where lower(f.filmName) like lower(concat('%',:filmName,'%'))")
    public Page<Films> searchFilmsByFilmNamePaged(@Param("filmName") String filmName, Pageable pageable);
}
