import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Toy> readToysFromFile(String fileName) {
        List<Toy> toys = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Toy toy = createToyFromLine(line);
                if (toy != null) {
                    toys.add(toy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toys;
    }

    private static Toy createToyFromLine(String line) {
        String[] parts = line.split(", ");

        if (parts.length == 3) {
            String[] idPart = parts[0].split(":");
            if (idPart.length == 2) {
                long id = Long.parseLong(idPart[0]);

                String name = idPart[1];

                String countPart = parts[1].substring(7);
                int count = Integer.parseInt(countPart);

                String weightPart = parts[2].substring(8);
                double weight = Double.parseDouble(weightPart);

                return new Toy(id, name, count, weight);
            }

            return null;
        }

        return null;
    }

    public static void appendToyToFile(String fileName, Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Добавляем новую игрушку в конец файла
            writer.write(toy.getId() + ":" + toy.getName() + ", Count: " + toy.getCount() + ", Weight: " + toy.getWeight());
            writer.newLine(); // Добавляем новую строку для следующей записи
            System.out.println("Новая игрушка добавлена в файл.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
