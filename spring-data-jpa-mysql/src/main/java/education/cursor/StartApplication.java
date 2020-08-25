package education.cursor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientSortableRepository sortableRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

//        repository.save(new Client("Java"));
//        repository.save(new Client("Node"));
//        repository.save(new Client("Python"));

//        System.out.println("\nfindAll()");
//        repository.findAll().forEach(x -> System.out.println(x));

//        System.out.println("\nfindById(1L)");
//        repository.findById(1l).ifPresent(x -> System.out.println(x));

//        System.out.println("\nfindByName('Node')");
//        repository.findByName("Node").forEach(x -> System.out.println(x));

//        System.out.println("\nfindByName('Node')");
//        repository.findByUsernameIsNull().forEach(x -> System.out.println(x));
//
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "name"));
//        sortableRepository.findAll(sort).forEach(System.out::println);

        Pageable pageable = new PageRequest(0, 2, sort);
        sortableRepository.findAll(pageable).forEach(System.out::println);

        Pageable pageable1 = new PageRequest(2, 2, sort);
        sortableRepository.findAll(pageable1).forEach(System.out::println);

    }

}