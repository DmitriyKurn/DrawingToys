import java.util.List;

public class RND {

    public static Toy getPrizeToy(List<Toy> toyList) {
        if (toyList.size() == 0) {
            return null;
        }
        int weight = (int) ((Math.random() * (100 - 50)) + 50);
        for (Toy toy :
                toyList) {
            if (toy.getWeight() > weight) {
                return toy;
            }
        }
        weight = (int) ((Math.random() * (100 - 25)) + 25);
        for (Toy toy :
                toyList) {
            if (toy.getWeight() > weight) {
                return toy;
            }
        }
        weight = (int) (Math.random() * 100);
        for (Toy toy :
                toyList) {
            if (toy.getWeight() > weight) {
                return toy;
            }
        }
        int index = (int) (Math.random() * toyList.size());
        return toyList.get(index);
    }

}
