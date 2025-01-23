package github.com.rosivaldolucas.uolhostchallenge.repository;

import github.com.rosivaldolucas.uolhostchallenge.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlayerRepositoryInFile implements PlayerRepository {

    private final String PATH_FILE_PLAYERS = "src/main/resources/players.txt";

    @Override
    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();

        File file = new File(PATH_FILE_PLAYERS);

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] split = line.split(";");

                String id = split[0];
                String name = split[1];
                String email = split[2];
                String phoneNumber = split[3];
                String codename = split[4];
                String codenameGroup = split[5];

                Player player = new Player(UUID.fromString(id), name, email, phoneNumber, codename, CodenameGroup.valueOf(codenameGroup));
                players.add(player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return players;
    }

    @Override
    public Optional<Player> findById(UUID playerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Player> findByEmail(String email) {
        File file = new File(PATH_FILE_PLAYERS);

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] split = line.split(";");

                if (split[2].equals(email)) {
                    String id = split[0];
                    String name = split[1];
                    String emailFile = split[2];
                    String phoneNumber = split[3];
                    String codename = split[4];
                    String codenameGroup = split[5];
                    return Optional.of(new Player(UUID.fromString(id), name, emailFile, phoneNumber, codename, CodenameGroup.valueOf(codenameGroup)));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Player player) {
        File file = new File(this.PATH_FILE_PLAYERS);

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(player.toString());
            fw.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Player player) {

    }

    @Override
    public void deleteById(UUID playerId) {

    }

}
