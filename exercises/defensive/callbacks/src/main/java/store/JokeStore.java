package store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Joke;

public class JokeStore {

  private static JokeStore store;
  private List<Joke> jokes = new ArrayList<>();
  private Random random = new Random();

  private JokeStore() {
    try(BufferedReader reader=new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResource("jokes.txt").openStream()))) {
      String line, statement = "";
      while ((line = reader.readLine()) != null) {
        if (!line.isEmpty()) {
          statement += " " + line;
        } else {
          if (!statement.isEmpty()) {
            jokes.add(new Joke(statement));
            statement = "";
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static JokeStore get() {
    if (store == null) {
      store = new JokeStore();
    }
    return store;
  }

  public Joke random() {
    return jokes.get(random.nextInt(jokes.size()));
  }
}