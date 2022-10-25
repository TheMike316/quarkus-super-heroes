package io.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED) // default
public class VillainService {

    private final double levelMultiplier;

    public VillainService(
            @ConfigProperty(name = "level.multiplier", defaultValue = "1.0") double levelMultiplier
    ) {
        this.levelMultiplier = levelMultiplier;
    }

    @Transactional(Transactional.TxType.SUPPORTS) // joins transaction if started; works without one if not
    public List<Villain> findAllVillains() {
        return Villain.listAll();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Villain findVillainById(Long id) {
        return Villain.findById(id);
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Villain findRandomVillain() {
        Villain villain = null;
        while (villain == null) {
            // potentially stack overflow due to infinite loop
            villain = Villain.findRandom();
        }
        return villain;
    }

    public Villain persistVillain(@Valid Villain villain) {
        villain.level = (int) Math.round(villain.level * levelMultiplier);
        villain.persist();
        return villain;
    }

    public Villain updateVillain(@Valid Villain villain) {
        Villain entity = Villain.findById(villain.id);
        entity.name = villain.name;
        entity.otherName = villain.otherName;
        entity.level = villain.level;
        entity.picture = villain.picture;
        entity.powers = villain.powers;
        return entity;
    }

    public void deleteVillain(Long id) {
        Villain.deleteById(id);
    }

}
