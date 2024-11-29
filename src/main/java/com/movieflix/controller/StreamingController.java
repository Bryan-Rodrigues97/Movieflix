package com.movieflix.controller;

import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.StreamingResponse;
import com.movieflix.entity.Streaming;
import com.movieflix.mapper.StreamingMapper;
import com.movieflix.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController implements StreamingControllerInterface{

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        return ResponseEntity.ok(
            service.findAll()
                    .stream()
                    .map(StreamingMapper::toStreamingResponse)
                    .toList()
        );
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                StreamingMapper.toStreamingResponse(
                        service.save(
                                StreamingMapper.toStreaming(request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        Optional<Streaming> optionalStreaming = service.findById(id);
        return optionalStreaming
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
