package education.cursor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // revert transaction after tests
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Test
    public void testFindByName() {
        repository.save(new Client("C++"));

        List<Client> books = repository.findByName("C++");
        assertEquals(1, books.size());

        assertThat(books).extracting(Client::getName).containsOnly("C++");
    }
}