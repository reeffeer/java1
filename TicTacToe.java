import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static char[][] map;
    public final static int SIZE = 5;
    public final static int DOTS_TO_WIN = 4;

    public final static char DOT_EMPTY = '•';
    public final static char DOT_X = 'X';
    public final static char DOT_O = 'O';


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
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    count++;
            }
        }
        return count == 0;
    }


    //ход компьютера
    private static void aiTurn() {
        int x, y;

            //действия компьютера по одной главной диагонали
            if (map[1][1] == DOT_X && map[2][2] == DOT_X && map[3][3] == DOT_X ||
                    map[2][2] == DOT_X && map[3][3] == DOT_X && map[5][5] == DOT_X) {
                 x = 4;
                 y = 4;
                map[x][y] = DOT_O;
            }
            if (map[1][1] == DOT_X && map[3][3] == DOT_X && map[4][4] == DOT_X ||
                    map[3][3] == DOT_X &&  map[4][4] == DOT_X && map[5][5] == DOT_X) {
                x = 2;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][1] == DOT_X && map[2][2] == DOT_X && map[4][4] == DOT_X ||
                    map[2][2] == DOT_X &&  map[4][4] == DOT_X && map[5][5] == DOT_X) {
                x = 3;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[2][2] == DOT_X && map[3][3] == DOT_X && map[4][4] == DOT_X) {
                if (map[5][5] != DOT_EMPTY) {
                    x = 1;
                    y = 1;
                } else {
                    x = 5;
                    y = 5;
                }
                map[x][y] = DOT_O;
            }
            //действия компьютера по другой главной диагонали
            if (map[1][5] == DOT_X && map[2][4] == DOT_X && map[3][3] == DOT_X ||
                    map[2][4] == DOT_X && map[3][3] == DOT_X && map[5][1] == DOT_X) {
                x = 4;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][5] == DOT_X && map[3][3] == DOT_X && map[4][2] == DOT_X ||
                    map[3][3] == DOT_X &&  map[4][2] == DOT_X && map[5][1] == DOT_X) {
                x = 2;
                y = 4;
                map[x][y] = DOT_O;
            }
            if (map[1][5] == DOT_X && map[2][4] == DOT_X && map[4][2] == DOT_X ||
                    map[2][4] == DOT_X &&  map[4][2] == DOT_X && map[5][1] == DOT_X) {
                x = 3;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[2][4] == DOT_X && map[3][3] == DOT_X && map[4][2] == DOT_X) {
                if (map[5][1] != DOT_EMPTY) {
                    x = 1;
                    y = 5;
                } else {
                x = 5;
                y = 1;
                }
                map[x][y] = DOT_O;
            }
            //действия компьютера по 1 малой диагонали
            if (map[3][2] == DOT_X && map[4][3] == DOT_X && map[5][4] == DOT_X) {
                x = 2;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[2][1] == DOT_X && map[4][3] == DOT_X && map[5][4] == DOT_X) {
                x = 3;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[2][1] == DOT_X && map[3][2] == DOT_X && map[5][4] == DOT_X) {
                x = 4;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[2][1] == DOT_X && map[3][2] == DOT_X && map[4][3] == DOT_X) {
                x = 5;
                y = 4;
                map[x][y] = DOT_O;
            }
            //действия компьютера по 2 малой диагонали
            if (map[2][3] == DOT_X && map[3][4] == DOT_X && map[4][5] == DOT_X) {
                x = 1;
                y = 2;
                map[x][y] = DOT_O;
            }
            if (map[1][2] == DOT_X && map[3][4] == DOT_X && map[4][5] == DOT_X) {
                x = 2;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[1][2] == DOT_X && map[2][3] == DOT_X && map[4][5] == DOT_X) {
                x = 3;
                y = 4;
                map[x][y] = DOT_O;
            }
            if (map[1][2] == DOT_X && map[2][3] == DOT_X && map[3][4] == DOT_X) {
                x = 4;
                y = 5;
                map[x][y] = DOT_O;
            }
            //действия компьютера по 3 малой диагонали
            if (map[2][3] == DOT_X && map[3][4] == DOT_X && map[4][1] == DOT_X) {
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
            //действия компьютера по 4 малой диагонали
            if (map[3][4] == DOT_X && map[4][3] == DOT_X && map[5][2] == DOT_X) {
                x = 2;
                y = 5;
                map[x][y] = DOT_O;
            }
            if (map[2][5] == DOT_X && map[4][3] == DOT_X && map[5][2] == DOT_X) {
                x = 3;
                y = 4;
                map[x][y] = DOT_O;
            }
            if (map[2][5] == DOT_X && map[3][4] == DOT_X && map[5][2] == DOT_X) {
                x = 4;
                y = 3;
                map[x][y] = DOT_O;
            }
            if (map[2][5] == DOT_X && map[3][4] == DOT_X && map[4][3] == DOT_X) {
                x = 5;
                y = 2;
                map[x][y] = DOT_O;
            }
            //действия компьютера по вертикали
            //1
            if (map[2][1] == DOT_X && map[3][1] == DOT_X && map[4][1] == DOT_X) {
                if (map[1][1] != DOT_EMPTY) {
                    x = 5;
                } else {
                    x = 1;
                }
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[1][1] == DOT_X && map[3][1] == DOT_X && map[4][1] == DOT_X ||
                    map[3][1] == DOT_X && map[4][1] == DOT_X && map[5][1] == DOT_X) {
                x = 2;
                y = 1;
                map[x][y] = DOT_O;
            }
            if (map[1][1] == DOT_X && map[2][1] == DOT_X && map[4][1] == DOT_X ||
                    map[2][1] == DOT_X && map[4][1] == DOT_X && map[5][1] == DOT_X) {
                x = 3;
                y = 1;
                map[x][y] = DOT_O;
        }
        if (map[1][1] == DOT_X && map[2][1] == DOT_X && map[3][1] == DOT_X ||
                map[2][1] == DOT_X && map[3][1] == DOT_X && map[5][1] == DOT_X) {
            x = 4;
            y = 1;
            map[x][y] = DOT_O;
        }
        //2
        if (map[2][2] == DOT_X && map[3][2] == DOT_X && map[4][4] == DOT_X) {
            if (map[1][2] != DOT_EMPTY) {
                x = 5;
            } else {
                x = 1;
            }
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[1][2] == DOT_X && map[3][2] == DOT_X && map[4][2] == DOT_X ||
                map[3][2] == DOT_X && map[4][2] == DOT_X && map[5][2] == DOT_X) {
            x = 2;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[1][2] == DOT_X && map[2][2] == DOT_X && map[4][2] == DOT_X ||
                map[2][2] == DOT_X && map[4][2] == DOT_X && map[5][2] == DOT_X) {
            x = 3;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[1][2] == DOT_X && map[2][2] == DOT_X && map[3][2] == DOT_X ||
                map[2][2] == DOT_X && map[3][2] == DOT_X && map[5][2] == DOT_X) {
            x = 4;
            y = 2;
            map[x][y] = DOT_O;
        }
        //3
        if (map[2][3] == DOT_X && map[3][3] == DOT_X && map[4][3] == DOT_X) {
            if (map[1][3] != DOT_EMPTY) {
                x = 5;
            } else {
                x = 1;
            }
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[1][3] == DOT_X && map[3][3] == DOT_X && map[4][3] == DOT_X ||
                map[3][3] == DOT_X && map[4][3] == DOT_X && map[5][3] == DOT_X) {
            x = 2;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[1][3] == DOT_X && map[2][3] == DOT_X && map[4][3] == DOT_X ||
                map[2][3] == DOT_X && map[4][3] == DOT_X && map[5][3] == DOT_X) {
            x = 3;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[1][3] == DOT_X && map[2][3] == DOT_X && map[3][3] == DOT_X ||
                map[2][3] == DOT_X && map[3][3] == DOT_X && map[5][3] == DOT_X) {
            x = 4;
            y = 3;
            map[x][y] = DOT_O;
        }
        //4
        if (map[2][4] == DOT_X && map[3][4] == DOT_X && map[4][4] == DOT_X) {
            if (map[1][4] != DOT_EMPTY) {
                x = 5;
            } else {
                x = 1;
            }
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[1][4] == DOT_X && map[3][4] == DOT_X && map[4][4] == DOT_X ||
                map[3][4] == DOT_X && map[4][4] == DOT_X && map[5][4] == DOT_X) {
            x = 2;
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[1][4] == DOT_X && map[2][4] == DOT_X && map[4][4] == DOT_X ||
                map[2][4] == DOT_X && map[4][4] == DOT_X && map[5][4] == DOT_X) {
            x = 3;
            y = 4;
            map[x][y] = DOT_O;
        }
        if (map[1][4] == DOT_X && map[2][4] == DOT_X && map[3][4] == DOT_X ||
                map[2][4] == DOT_X && map[3][4] == DOT_X && map[5][4] == DOT_X) {
            x = 4;
            y = 4;
            map[x][y] = DOT_O;
        }
        //5
        if (map[2][5] == DOT_X && map[3][5] == DOT_X && map[4][5] == DOT_X) {
            if (map[1][5] != DOT_EMPTY) {
                x = 5;
            } else {
                x = 1;
            }
            y = 5;
            map[x][y] = DOT_O;
        }
        if (map[1][5] == DOT_X && map[3][5] == DOT_X && map[4][5] == DOT_X ||
                map[3][5] == DOT_X && map[4][5] == DOT_X && map[5][5] == DOT_X) {
            x = 5;
            y = 5;
            map[x][y] = DOT_O;
        }
        if (map[1][5] == DOT_X && map[2][5] == DOT_X && map[4][5] == DOT_X ||
                map[2][5] == DOT_X && map[4][5] == DOT_X && map[5][5] == DOT_X) {
            x = 3;
            y = 5;
            map[x][y] = DOT_O;
        }
        if (map[1][5] == DOT_X && map[2][5] == DOT_X && map[3][5] == DOT_X ||
                map[2][5] == DOT_X && map[3][5] == DOT_X && map[5][5] == DOT_X) {
            x = 4;
            y = 5;
            map[x][y] = DOT_O;
        }

        //действия компьютера по горизонтали
        //1
        if (map[1][2] == DOT_X && map[1][3] == DOT_X && map[1][4] == DOT_X) {
            if (map[1][1] != DOT_EMPTY) {
                y = 5;
            } else {
                y = 1;
            }
            x = 1;
            map[x][y] = DOT_O;
        }
        if (map[1][1] == DOT_X && map[1][3] == DOT_X && map[1][4] == DOT_X ||
                map[1][3] == DOT_X && map[1][4] == DOT_X && map[1][5] == DOT_X) {
            x = 1;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[1][1] == DOT_X && map[1][2] == DOT_X && map[1][4] == DOT_X ||
                map[1][2] == DOT_X && map[1][4] == DOT_X && map[1][5] == DOT_X) {
            x = 1;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[1][1] == DOT_X && map[1][2] == DOT_X && map[1][3] == DOT_X ||
                map[1][2] == DOT_X && map[1][3] == DOT_X && map[1][5] == DOT_X) {
            x = 1;
            y = 4;
            map[x][y] = DOT_O;
        }
        //2
        if (map[2][2] == DOT_X && map[2][3] == DOT_X && map[2][4] == DOT_X) {
            if (map[2][1] != DOT_EMPTY) {
                y = 5;
            } else {
                y = 1;
            }
            x = 2;
            map[x][y] = DOT_O;
        }
        if (map[2][1] == DOT_X && map[2][3] == DOT_X && map[2][4] == DOT_X ||
                map[2][3] == DOT_X && map[2][4] == DOT_X && map[2][5] == DOT_X) {
            x = 2;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[2][1] == DOT_X && map[2][2] == DOT_X && map[2][4] == DOT_X ||
                map[2][2] == DOT_X && map[2][4] == DOT_X && map[2][5] == DOT_X) {
            x = 2;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[2][1] == DOT_X && map[2][2] == DOT_X && map[2][3] == DOT_X ||
                map[2][2] == DOT_X && map[2][3] == DOT_X && map[2][5] == DOT_X) {
            x = 2;
            y = 4;
            map[x][y] = DOT_O;
        }
        //3
        if (map[3][2] == DOT_X && map[3][3] == DOT_X && map[3][4] == DOT_X) {
            if (map[3][1] != DOT_EMPTY) {
                y = 5;
            } else {
                y = 1;
            }
            x = 3;
            map[x][y] = DOT_O;
        }
        if (map[3][1] == DOT_X && map[3][3] == DOT_X && map[3][4] == DOT_X ||
                map[3][3] == DOT_X && map[3][4] == DOT_X && map[3][5] == DOT_X) {
            x = 3;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[3][1] == DOT_X && map[3][2] == DOT_X && map[3][4] == DOT_X ||
                map[3][2] == DOT_X && map[3][4] == DOT_X && map[3][5] == DOT_X) {
            x = 3;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[3][1] == DOT_X && map[3][2] == DOT_X && map[3][3] == DOT_X ||
                map[3][2] == DOT_X && map[3][3] == DOT_X && map[3][5] == DOT_X) {
            x = 3;
            y = 4;
            map[x][y] = DOT_O;
        }
        //4
        if (map[4][2] == DOT_X && map[4][3] == DOT_X && map[4][4] == DOT_X) {
            if (map[4][1] != DOT_EMPTY) {
                y = 5;
            } else {
                y = 1;
            }
            x = 4;
            map[x][y] = DOT_O;
        }
        if (map[4][1] == DOT_X && map[4][3] == DOT_X && map[4][4] == DOT_X ||
                map[4][3] == DOT_X && map[4][4] == DOT_X && map[4][5] == DOT_X) {
            x = 4;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[4][1] == DOT_X && map[4][2] == DOT_X && map[4][4] == DOT_X ||
                map[4][2] == DOT_X && map[4][4] == DOT_X && map[4][5] == DOT_X) {
            x = 4;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[4][1] == DOT_X && map[4][2] == DOT_X && map[4][3] == DOT_X ||
                map[4][2] == DOT_X && map[4][3] == DOT_X && map[4][5] == DOT_X) {
            x = 4;
            y = 4;
            map[x][y] = DOT_O;
        }
        //5
        if (map[5][2] == DOT_X && map[5][3] == DOT_X && map[5][4] == DOT_X) {
            if (map[5][1] != DOT_EMPTY) {
                y = 5;
            } else {
                y = 1;
            }
            x = 5;
            map[x][y] = DOT_O;
        }
        if (map[5][4] == DOT_X && map[5][3] == DOT_X && map[5][4] == DOT_X ||
                map[5][3] == DOT_X && map[5][4] == DOT_X && map[5][5] == DOT_X) {
            x = 5;
            y = 2;
            map[x][y] = DOT_O;
        }
        if (map[5][1] == DOT_X && map[5][2] == DOT_X && map[5][4] == DOT_X ||
                map[5][2] == DOT_X && map[5][4] == DOT_X && map[5][5] == DOT_X) {
            x = 5;
            y = 3;
            map[x][y] = DOT_O;
        }
        if (map[5][1] == DOT_X && map[5][2] == DOT_X && map[5][3] == DOT_X ||
                map[5][2] == DOT_X && map[5][3] == DOT_X && map[5][5] == DOT_X) {
            x = 5;
            y = 4;
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
        System.out.println("Please input dot coordinates, in format x y");
        do {
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!isCellValid(x - 1, y - 1)); // while(isCellValid(x, y) == false)
        map[x - 1][y - 1] = DOT_X;
    }

    //проверка наличия свободной ячейки в пределах игрового поля
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
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
        for (int i = 0; i < SIZE; i++) {
            System.out.print("  " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
