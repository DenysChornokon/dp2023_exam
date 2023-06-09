package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Tank;
import org.example.service.TankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tanks")
@RequiredArgsConstructor
public class TankController {
    private final TankService tankService;

    @GetMapping
    public List<Tank> getAllTanks() {
        return tankService.getAllTanks();
    }

    @GetMapping("/{id}")
    public Tank getTankById(@PathVariable Long id) {
        return tankService.getTankById(id);
    }

    @PostMapping
    public Tank createTank(@RequestBody Tank tank) {
        return tankService.createTank(tank);
    }

    @PutMapping("/{id}")
    public Tank updateTank(@PathVariable Long id, @RequestBody Tank tank) {
        return tankService.updateTank(id, tank);
    }

    @DeleteMapping("/{id}")
    public void deleteTank(@PathVariable Long id) {
        tankService.deleteTank(id);
    }
}
