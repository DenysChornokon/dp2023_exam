package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Tank;
import org.example.repository.TankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TankService {
    private static final Logger logger = LoggerFactory.getLogger(TankService.class);

    private final TankRepository tankRepository;

    public List<Tank> getAllTanks() {
        logger.info("Fetching all tanks");
        return tankRepository.findAll();
    }

    public Tank getTankById(Long id) {
        logger.info("Fetching tank with id: {}", id);
        return tankRepository.findById(id)
                .orElseThrow(() -> new TankNotFoundException("Tank not found with id: " + id));
    }

    public Tank createTank(Tank tank) {
        logger.info("Creating a new tank");
        return tankRepository.save(tank);
    }

    public Tank updateTank(Long id, Tank tank) {
        logger.info("Updating tank with id: {}", id);
        Tank existingTank = getTankById(id);
        existingTank.setName(tank.getName());
        existingTank.setCountry(tank.getCountry());
        existingTank.setYear(tank.getYear());
        existingTank.setWeight(tank.getWeight());
        return tankRepository.save(existingTank);
    }

    public void deleteTank(Long id) {
        logger.info("Deleting tank with id: {}", id);
        tankRepository.deleteById(id);
    }
}
