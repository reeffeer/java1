import java.util.Random;
import java.util.Scanner;
public class TicTacToe {

    public static char[][] map;
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        game();
    }

    //игровая логика
    private static void game() {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("You win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw game!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("The AI win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw game!");
                break;
            }
        }
        System.out.println("The end");
    }

    //проверка на победу
    private static boolean checkWin(char symb) {

        for (int i = 0; i < SIZE; i++) {
            if (((map[i][0] == symb || map[i][4] == symb) && map[i][1] == symb &&
                    map[i][2] == symb &&
                    map[i][3] == symb) ||
                    ((map[0][i] == symb || map[4][i] == symb) && map[1][i] == symb &&
                            map[2][i] == symb &&
                            map[3][i] == symb)) {
                return true;
            }  //проверка основных диагоналей
            if (((map[0][0] == symb || map[4][4] == symb) && map[1][1] == symb &&
                    map[2][2] == symb &&
                    map[3][3] == symb) ||
                    ((map[4][0] == symb || map[0][4] == symb) && map[3][1] == symb &&
                            map[2][2] == symb &&
                            map[1][3] == symb)) {
                return true;
            } //проверка 1 и 2 малых диагоналей
            if ((map[1][0] == symb && map[2][1] == symb &&
                    map[3][2] == symb &&
                    map[4][3] == symb) ||
                    (map[0][1] == symb && map[1][2] == symb &&
                            map[2][3] == symb &&
                            map[3][4] == symb)) {
                return true;
            } //проверка 3 и 4 малых диагоналей
            if ((map[0][3] == symb && map[1][2] == symb &&
                    map[2][1] == symb &&
                    map[3][0] == symb) ||
                    (map[1][4] == symb && map[2][3] == symb &&
                            map[3][2] == symb &&
                            map[4][1] == symb)) {
                return true;
            }
        }
        return false;
    }


    //проверка на ничью
    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    //ход компьютера
    private static void aiTurn() {
        int x, y;

            //действия компьютера по одной главной диагонали
            if (map[0][0] == DOT_X && map[1][1] == DOT_X && map[2][2] == DOT_X ||
                    map[1][1] == DOT_X && map[2][2] == DOT_X && map[4][4] == DOT_X) {
                 x = 3;
                 y = 3;
                map[x][y] = DOT_O;
            }
            if (map[0][0] == DOT_X && map[2][2] == DOT_X && map[3][3] == DOT_X ||
                    map[2][2] == DOT_X &&  map[3][3] == DOT_X && map[4][4] == DOT_X) {
                x = 1;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[0][0] == DOT_X && map[1][1] == DOT_X && map[3][3] == DOT_X ||
                    map[1][1] == DOT_X &&  map[3][3] == DOT_X && map[4][4] == DOT_X) {
                x = 2;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][1] == DOT_X && map[2][2] == DOT_X && map[3][3] == DOT_X) {
                if (map[4][4] != DOT_EMPTY) {
                    x = 0;
                    y = 0;
                } else {
                    x = 4;
                    y = 4;
                }
                map[x][y] = DOT_O;
            }
            //действия компьютера по другой главной диагонали
            if (map[0][4] == DOT_X && map[1][3] == DOT_X && map[2][2] == DOT_X ||
                    map[1][3] == DOT_X && map[2][2] == DOT_X && map[4][0] == DOT_X) {
                x = 3;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[0][4] == DOT_X && map[2][2] == DOT_X && map[3][1] == DOT_X ||
                    map[2][2] == DOT_X &&  map[3][1] == DOT_X && map[4][0] == DOT_X) {
                x = 1;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[0][4] == DOT_X && map[1][3] == DOT_X && map[3][1] == DOT_X ||
                    map[1][3] == DOT_X &&  map[3][1] == DOT_X && map[4][0] == DOT_X) {
                x = 2;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][3] == DOT_X && map[2][2] == DOT_X && map[3][1] == DOT_X) {
                if (map[4][0] != DOT_EMPTY) {
                    x = 0;
                    y = 4;
                } else {
                x = 4;
                y = 0;
                }
                map[x][y] = DOT_O;
            }
            //действия компьютера по 1 малой диагонали
            if (map[2][1] == DOT_X && map[3][2] == DOT_X && map[4][3] == DOT_X) {
                x = 1;
                y = 0;
                map[x][y] = DOT_O;
            }
            if (map[1][0] == DOT_X && map[3][2] == DOT_X && map[4][3] == DOT_X) {
                x = 2;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[1][0] == DOT_X && map[2][1] == DOT_X && map[4][3] == DOT_X) {
                x = 3;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][0] == DOT_X && map[2][1] == DOT_X && map[3][2] == DOT_X) {
                x = 4;
                y = 3;
                map[x][y] = DOT_O;
            }
            //действия компьютера по 2 малой диагонали
            if (map[1][2] == DOT_X && map[2][3] == DOT_X && map[3][4] == DOT_X) {
                x = 0;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[0][1] == DOT_X && map[2][3] == DOT_X && map[3][4] == DOT_X) {
                x = 1;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[0][1] == DOT_X && map[1][2] == DOT_X && map[3][4] == DOT_X) {
                x = 2;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[0][1] == DOT_X && map[1][2] == DOT_X && map[2][3] == DOT_X) {
                x = 3;
                y = 4;
                map[x][y] = DOT_O;
            }
            //действия компьютера по 3 малой диагонали
            if (map[1][2] == DOT_X && map[2][1] == DOT_X && map[3][0] == DOT_X) {
                x = 0;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[0][3] == DOT_X && map[2][1] == DOT_X && map[3][0] == DOT_X) {
                x = 1;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[0][3] == DOT_X && map[1][2] == DOT_X && map[3][0] == DOT_X) {
                x = 2;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[0][3] == DOT_X && map[1][2] == DOT_X && map[2][1] == DOT_X) {
                x = 3;
                y = 0;
                map[x][y] = DOT_O;
            }
            //действия компьютера по 4 малой диагонали
            if (map[2][3] == DOT_X && map[3][2] == DOT_X && map[4][1] == DOT_X) {
                x = 1;
                y = 4;
                map[x][y] = DOT_O;
            }
            if (map[1][4] == DOT_X && map[3][2] == DOT_X && map[4][1] == DOT_X) {
                x = 2;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[1][4] == DOT_X && map[2][3] == DOT_X && map[4][1] == DOT_X) {
                x = 3;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][4] == DOT_X && map[2][3] == DOT_X && map[3][2] == DOT_X) {
                x = 4;
                y = 1;
                map[x][y] = DOT_O;
            }
            //действия компьютера по вертикали
            //1
            if (map[1][0] == DOT_X && map[2][0] == DOT_X && map[3][0] == DOT_X) {
                if (map[0][0] != DOT_EMPTY) {
                    x = 4;
                } else {
                    x = 0;
                }
                y = 0;
                map[x][y] = DOT_O;
            }
            if (map[0][0] == DOT_X && map[2][0] == DOT_X && map[3][0] == DOT_X ||
                    map[2][0] == DOT_X && map[3][0] == DOT_X && map[4][0] == DOT_X) {
                x = 1;
                y = 0;
                map[x][y] = DOT_O;
            }
            if (map[0][0] == DOT_X && map[1][0] == DOT_X && map[3][0] == DOT_X ||
                    map[1][0] == DOT_X && map[3][0] == DOT_X && map[4][0] == DOT_X) {
                x = 2;
                y = 0;
                map[x][y] = DOT_O;
        }
        if (map[0][0] == DOT_X && map[1][0] == DOT_X && map[2][0] == DOT_X ||
                map[1][0] == DOT_X && map[2][0] == DOT_X && map[4][0] == DOT_X) {
            x = 3;
            y = 0;
            map[x][y] = DOT_O;
        }
        //2
        if (map[1][1] == DOT_X && map[2][1] == DOT_X && map[3][1] == DOT_X) {
            if (map[0][1] != DOT_EMPTY) {
                x = 4;
            } else {
                x = 0;
            }
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[0][1] == DOT_X && map[2][1] == DOT_X && map[3][1] == DOT_X ||
                map[2][1] == DOT_X && map[3][1] == DOT_X && map[4][1] == DOT_X) {
            x = 1;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[0][1] == DOT_X && map[1][1] == DOT_X && map[3][1] == DOT_X ||
                map[1][1] == DOT_X && map[3][1] == DOT_X && map[4][1] == DOT_X) {
            x = 2;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[0][1] == DOT_X && map[1][1] == DOT_X && map[2][1] == DOT_X ||
                map[1][1] == DOT_X && map[2][1] == DOT_X && map[4][1] == DOT_X) {
            x = 3;
            y = 1;
            map[x][y] = DOT_O;
        }
        //3
        if (map[1][2] == DOT_X && map[2][2] == DOT_X && map[3][2] == DOT_X) {
            if (map[0][2] != DOT_EMPTY) {
                x = 4;
            } else {
                x = 0;
            }
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[0][2] == DOT_X && map[2][2] == DOT_X && map[3][2] == DOT_X ||
                map[2][2] == DOT_X && map[3][2] == DOT_X && map[4][2] == DOT_X) {
            x = 1;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[0][2] == DOT_X && map[1][2] == DOT_X && map[3][2] == DOT_X ||
                map[1][2] == DOT_X && map[3][2] == DOT_X && map[4][2] == DOT_X) {
            x = 2;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[0][2] == DOT_X && map[1][2] == DOT_X && map[2][2] == DOT_X ||
                map[1][2] == DOT_X && map[2][2] == DOT_X && map[4][2] == DOT_X) {
            x = 3;
            y = 2;
            map[x][y] = DOT_O;
        }
        //4
        if (map[1][3] == DOT_X && map[2][3] == DOT_X && map[3][3] == DOT_X) {
            if (map[0][3] != DOT_EMPTY) {
                x = 4;
            } else {
                x = 0;
            }
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[0][3] == DOT_X && map[2][3] == DOT_X && map[3][3] == DOT_X ||
                map[2][3] == DOT_X && map[3][3] == DOT_X && map[4][3] == DOT_X) {
            x = 1;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[0][3] == DOT_X && map[1][3] == DOT_X && map[3][3] == DOT_X ||
                map[1][3] == DOT_X && map[3][3] == DOT_X && map[4][3] == DOT_X) {
            x = 2;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[0][3] == DOT_X && map[1][3] == DOT_X && map[2][3] == DOT_X ||
                map[1][3] == DOT_X && map[2][3] == DOT_X && map[4][3] == DOT_X) {
            x = 3;
            y = 3;
            map[x][y] = DOT_O;
        }
        //5
        if (map[1][4] == DOT_X && map[2][4] == DOT_X && map[3][4] == DOT_X) {
            if (map[0][4] != DOT_EMPTY) {
                x = 4;
            } else {
                x = 0;
            }
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[0][4] == DOT_X && map[2][4] == DOT_X && map[3][4] == DOT_X ||
                map[2][4] == DOT_X && map[3][4] == DOT_X && map[4][4] == DOT_X) {
            x = 1;
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[0][4] == DOT_X && map[1][4] == DOT_X && map[3][4] == DOT_X ||
                map[1][4] == DOT_X && map[3][4] == DOT_X && map[4][4] == DOT_X) {
            x = 2;
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[0][4] == DOT_X && map[1][4] == DOT_X && map[2][4] == DOT_X ||
                map[1][4] == DOT_X && map[2][4] == DOT_X && map[4][4] == DOT_X) {
            x = 3;
            y = 4;
            map[x][y] = DOT_O;
        }

        //действия компьютера по горизонтали
        //1
        if (map[0][1] == DOT_X && map[0][2] == DOT_X && map[0][3] == DOT_X) {
            if (map[0][0] != DOT_EMPTY) {
                y = 4;
            } else {
                y = 0;
            }
            x = 0;
            map[x][y] = DOT_O;
        }
        if (map[0][0] == DOT_X && map[0][2] == DOT_X && map[0][3] == DOT_X ||
                map[0][2] == DOT_X && map[0][3] == DOT_X && map[0][4] == DOT_X) {
            x = 0;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[0][0] == DOT_X && map[0][1] == DOT_X && map[0][3] == DOT_X ||
                map[0][1] == DOT_X && map[0][3] == DOT_X && map[0][4] == DOT_X) {
            x = 0;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[0][0] == DOT_X && map[0][1] == DOT_X && map[0][2] == DOT_X ||
                map[0][1] == DOT_X && map[0][2] == DOT_X && map[0][4] == DOT_X) {
            x = 0;
            y = 3;
            map[x][y] = DOT_O;
        }
        //2
        if (map[1][1] == DOT_X && map[1][2] == DOT_X && map[1][3] == DOT_X) {
            if (map[1][0] != DOT_EMPTY) {
                y = 4;
            } else {
                y = 0;
            }
            x = 1;
            map[x][y] = DOT_O;
        }
        if (map[1][0] == DOT_X && map[1][2] == DOT_X && map[1][3] == DOT_X ||
                map[1][2] == DOT_X && map[1][3] == DOT_X && map[1][4] == DOT_X) {
            x = 1;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[1][0] == DOT_X && map[1][1] == DOT_X && map[1][2] == DOT_X ||
                map[1][1] == DOT_X && map[1][3] == DOT_X && map[1][4] == DOT_X) {
            x = 1;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[1][0] == DOT_X && map[1][1] == DOT_X && map[1][2] == DOT_X ||
                map[1][1] == DOT_X && map[1][2] == DOT_X && map[1][4] == DOT_X) {
            x = 1;
            y = 3;
            map[x][y] = DOT_O;
        }
        //3
        if (map[2][1] == DOT_X && map[2][2] == DOT_X && map[2][3] == DOT_X) {
            if (map[2][0] != DOT_EMPTY) {
                y = 4;
            } else {
                y = 0;
            }
            x = 2;
            map[x][y] = DOT_O;
        }
        if (map[2][0] == DOT_X && map[2][2] == DOT_X && map[2][3] == DOT_X ||
                map[2][2] == DOT_X && map[2][3] == DOT_X && map[2][4] == DOT_X) {
            x = 2;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[2][0] == DOT_X && map[2][1] == DOT_X && map[2][3] == DOT_X ||
                map[2][1] == DOT_X && map[2][3] == DOT_X && map[2][4] == DOT_X) {
            x = 2;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[2][0] == DOT_X && map[2][1] == DOT_X && map[2][2] == DOT_X ||
                map[2][1] == DOT_X && map[2][2] == DOT_X && map[2][4] == DOT_X) {
            x = 2;
            y = 3;
            map[x][y] = DOT_O;
        }
        //4
        if (map[3][1] == DOT_X && map[3][2] == DOT_X && map[3][3] == DOT_X) {
            if (map[3][0] != DOT_EMPTY) {
                y = 4;
            } else {
                y = 0;
            }
            x = 3;
            map[x][y] = DOT_O;
        }
        if (map[3][0] == DOT_X && map[3][2] == DOT_X && map[3][3] == DOT_X ||
                map[3][2] == DOT_X && map[3][3] == DOT_X && map[3][4] == DOT_X) {
            x = 3;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[3][0] == DOT_X && map[3][1] == DOT_X && map[3][3] == DOT_X ||
                map[3][1] == DOT_X && map[3][3] == DOT_X && map[3][4] == DOT_X) {
            x = 3;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[3][0] == DOT_X && map[3][1] == DOT_X && map[3][2] == DOT_X ||
                map[3][1] == DOT_X && map[3][2] == DOT_X && map[3][4] == DOT_X) {
            x = 3;
            y = 3;
            map[x][y] = DOT_O;
        }
        //5
        if (map[4][1] == DOT_X && map[4][2] == DOT_X && map[4][3] == DOT_X) {
            if (map[4][0] != DOT_EMPTY) {
                y = 4;
            } else {
                y = 0;
            }
            x = 4;
            map[x][y] = DOT_O;
        }
        if (map[4][0] == DOT_X && map[4][2] == DOT_X && map[4][3] == DOT_X ||
                map[4][2] == DOT_X && map[4][3] == DOT_X && map[4][4] == DOT_X) {
            x = 4;
            y = 1;
            map[x][y] = DOT_O;
        }
        if (map[4][0] == DOT_X && map[4][1] == DOT_X && map[4][3] == DOT_X ||
                map[4][1] == DOT_X && map[4][3] == DOT_X && map[4][4] == DOT_X) {
            x = 4;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[4][0] == DOT_X && map[4][1] == DOT_X && map[4][2] == DOT_X ||
                map[4][1] == DOT_X && map[4][2] == DOT_X && map[4][4] == DOT_X) {
            x = 4;
            y = 3;
            map[x][y] = DOT_O;
        }
            else {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
                map[x][y] = DOT_O;
            }
    }


    //ход человека
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    //проверка наличия свободной ячейки в пределах игрового поля
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    //инициализация карты
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //вывод карты в консоль
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
