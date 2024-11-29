package com.movieflix.service;

import com.movieflix.entity.Category;
import com.movieflix.entity.Movie;
import com.movieflix.entity.Streaming;
import com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public List<Movie> findByCategory(Long categoryId) {
        return repository.findMovieByCategories(List.of(categoryId));
    }

    public Movie save(Movie movie){
        movie.setCategories(this.getCategoryList(movie.getCategories()));
        movie.setStreamings(this.getStreamingList(movie.getStreamings()));
        return repository.save(movie);
    }

    public Optional<Movie> update(Long movieId, Movie updMovie){
        Optional<Movie> optMovie = this.findById(movieId);
        if (optMovie.isPresent()){

            List<Category> categories = this.getCategoryList(updMovie.getCategories());
            List<Streaming> streamings = this.getStreamingList(updMovie.getStreamings());

            Movie movie = optMovie.get();
            movie.setTitle(updMovie.getTitle());
            movie.setDescription(updMovie.getDescription());
            movie.setRating(updMovie.getRating());
            movie.setReleaseDate(updMovie.getReleaseDate());

            movie.getCategories().clear();
            movie.getStreamings().clear();

            movie.getCategories().addAll(categories);
            movie.getStreamings().addAll(streamings);

            repository.save(movie);
            return Optional.of(movie);
        }

        return Optional.empty();
    }

    public  void deleteById(Long id){
        repository.deleteById(id);
    }

    private List<Category> getCategoryList(List<Category> categoryList) {
        List<Category> categoriesFound = new ArrayList<Category>();
        categoryList.forEach(category -> {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        });
        return categoriesFound;
    }

    private List<Streaming> getStreamingList(List<Streaming > streamingList) {
        List<Streaming> streamingsFound = new ArrayList<Streaming>();
        streamingList.forEach(streaming -> {
            streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add);
        });
        return streamingsFound;
    }
}
