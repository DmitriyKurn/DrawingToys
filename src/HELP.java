public class HELP {
    public static final String HELP = "help";
    public static final String ADD = "add";
    public static final String GET = "get";
    public static final String SET_WEIGHT = "setWeight";
    public static final String PLAY = "play";
    public static final String EXIT = "exit";

    private static final String HELP_EXAMPLE = "help - для вывода списка команд";
    private static final String ADD_EXAMPLE = "add - для добавления новой игрушки в список\n" +
            "\t\tНеобходимо ввести ИМЯ КОЛИЧЕСТВО ВЕС\n" +
            "\t\tadd Plane 22 35";
    private static final String PLAY_EXAMPLE = "play - для розыгрыша игрушки";
    private static final String GET_EXAMPLE = "get - для получения разыгранной игрушки";
    private static final String SET_EXAMPLE = "setWeight - для изменения веса игрушки\n" +
            "\t\tНеобходимо ввести ИНДЕКС ВЕС\n" +
            "\t\tsetWeight 1 45";
    private static final String EXIT_EXAMPLE = "exit - для выхода из приложения";


    public static void printHelp() {
        System.out.println("Вот список команд");
        System.out.println("\t" + HELP_EXAMPLE);
        System.out.println("\t" + ADD_EXAMPLE);
        System.out.println("\t" + SET_EXAMPLE);
        System.out.println("\t" + GET_EXAMPLE);
        System.out.println("\t" + PLAY_EXAMPLE);
        System.out.println("\t" + EXIT_EXAMPLE);
        System.out.println();
    }

}
