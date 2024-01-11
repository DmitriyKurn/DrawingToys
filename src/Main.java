import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static String warehouseFile = "src/data/warehouse.txt";

    public static void main(String[] args) {
        List<Toy> toyList = FileUtil.readToysFromFile(warehouseFile);
        Play play = new Play(toyList);
        HELP.printHelp();
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals(HELP.EXIT)) {
            try {
                String[] commands = scanner.nextLine().trim().split(" ");
                command = commands[0];
                switch (command) {
                    case HELP.HELP:
                        HELP.printHelp();
                        break;
                    case HELP.PLAY:
                        play.play();
                        break;
                    case HELP.GET:
                        Toy toy = play.getPrizeToy();
                        if (toy != null) {
                            System.out.println("Получена призовая игрушка " + toy + "\n");
                        }
                        break;
                    case HELP.ADD:
                        if (commands.length == 4) {
                            Toy newToy = play.addToy(
                                    commands[1],
                                    Integer.parseInt(commands[2]),
                                    Double.parseDouble(commands[3]));
                            System.out.println("Добавлена игрушка " + newToy);
                            FileUtil.appendToyToFile(warehouseFile, newToy);
                        } else {
                            System.out.println("Введено неверное количество параметров\n");
                        }
                        break;
                    case HELP.SET_WEIGHT:
                        if (commands.length == 3) {
                            play.setWeight(
                                    Long.parseLong(commands[1]),
                                    Double.parseDouble(commands[2]));
                        } else {
                            System.out.println("Введено неверное количество параметров\n");
                        }
                    case HELP.EXIT:
                        continue;
                    default:
                        System.out.println("Нет такой команды!\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Введена неверная команда!\n");
            }
        }
    }


}
/*
3:Robot, Count: 2, Weight: 12.0
4:Action Figure, Count: 4, Weight: 80.0
5:Board Game, Count: 6, Weight: 15.0
6:Stuffed Animal, Count: 7, Weight: 70.0
7:Puzzle, Count: 2, Weight: 10.0
8:Remote Control Car, Count: 1, Weight: 10.0
9:LEGO Set, Count: 3, Weight: 12.0
10:Teddy Bear, Count: 4, Weight: 36.0
 */