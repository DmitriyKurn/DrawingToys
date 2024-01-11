import java.util.ArrayList;
import java.util.List;

public class Play {
    private List<Toy> toyList = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>();

    public Play(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public void play() {
        Toy prizeToy = RND.getPrizeToy(toyList);
        if (prizeToy == null) {
            System.out.println("Призовые игрушки закончились!\n");
            return;
        }
        prizeToys.add(prizeToy);
        toyList.remove(prizeToy);
        System.out.println("Призовая игрушка разыграна!\n");
    }

    public Toy getPrizeToy() {
        if (prizeToys.size() == 0) {
            System.out.println("Призовая игрушка не разыграна!\n");
            return null;
        }
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(prizeToy);
        prizeToy.setCount(prizeToy.getCount() - 1);
        if (prizeToy.getCount() != 0) {
            toyList.add(prizeToy);
        }
        return prizeToy;
    }

    public void setWeight(long id, double weight) {
        if (weight < 0 || weight > 100) {
            System.out.println("Введён неверный вес!\nВес должен быть в пределах от 0 до 100\n");
            return;
        }
        for (Toy toy :
                toyList) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                System.out.println("Для игрушки с Id " + id + "установлен вес " + weight);
                System.out.println(toy + "\n");
                return;
            }
        }
        for (Toy toy :
                prizeToys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                System.out.println("Для игрушки с Id " + id + "установлен вес " + weight);
                System.out.println(toy + "\n");
                return;
            }
        }
        System.out.println("Игрушка по Id " + id + " не найдена!\n");
    }

    public Toy addToy(String name, int count, double weight) {
        if (count <= 0) {
            System.out.println("Невозможно добавить отрицательное или нулевое число игруше\n");
            return null;
        }
        if (weight < 0 || weight > 100) {
            System.out.println("Введён неверный вес!\nВес должен быть в пределах от 0 до 100\n");
            return null;
        }
        int id = toyList.size() + prizeToys.size() + 1;
        Toy newToy = new Toy(id, name);
        newToy.setCount(count);
        newToy.setWeight(weight);
        toyList.add(newToy);
        return newToy;
    }

}
