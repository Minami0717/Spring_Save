package com.green.jpaexam.provider;

import com.green.jpaexam.provider.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService service;

    @PostMapping
    public ResponseEntity<ProviderInsVo> postProvider(@RequestBody ProviderInsDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProviderSelVo>> getProvider() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<ProviderUpdVo> putProvider(@RequestBody ProviderUpdDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<Integer> delProvider(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
