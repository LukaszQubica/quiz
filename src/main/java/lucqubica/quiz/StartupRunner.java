package lucqubica.quiz;

import lombok.extern.java.Log;
import lucqubica.quiz.entitys.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@Log

public class StartupRunner implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Executing startup actions ...");

        PlayerEntity player = new PlayerEntity("John");
        log.info("Created player " + player);

        entityManager.persist(player);
        log.info("Same player after persist " + player);
    }
}
