package com.teama.bioskop.Controller;

import com.teama.bioskop.Models.Films;
import com.teama.bioskop.Services.FilmsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // annotation untuk menandakan bahwa suatu class adalah Controller
@AllArgsConstructor
public class FilmsController {
    private final FilmsService filmsService;

    @GetMapping("/films")
    public List<Films> getAll() {
        return this.filmsService.getAllFilms();

    }
}
