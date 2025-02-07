package com.example;

import java.util.Scanner;
import java.util.Objects;
//adding libraries
//добавляем библиотеки
public class Main {

    //variable to change Player
    //переменая для смены игрока
    private static boolean bollPlayer = true;

    public static void main(String[] args) {
        //variable to end while loop
        //переменняая для окоечания цикла
        boolean t = true;

        //game array
        //массив игры
        char[][] game = {
                {'O','1','2','3'},
                {'a', ' ', ' ',' '},
                {'b', ' ', ' ', ' '},
                {'c',' ',' ',' '}
        };

        //gaming loop (main)
        //игровой массив (главный)
        while (t){
            //changing Players
            //меняем игроков и "x" на "o"
            char choice = 'x';
            if(bollPlayer){
                System.out.println("Player (1) \ngoes with x");
                bollPlayer = !bollPlayer;
            }else {
                System.out.println("Player (2) \ngoes with o");
                bollPlayer = !bollPlayer;
                choice = 'o';
            }


            //save moving
            Scanner oBmove = new Scanner(System.in);
            System.out.print("Place (letter) + (number): ");
            String move = oBmove.nextLine();
            System.out.println();
            int[] coord = coordinate(move);  //adding to a variable "user-input data"
            //получив значение от пользователя мы разбиваем его на char и выполняем функцию
            //в итого у нас к прмеру coord[1,1]

            //проверяем не занята ли ячейка
            if(checkPo(game, coord[0], coord[1])){  //если checkPo возвращает true
                System.out.print("there is no such option, because this cell occupied.\n \n");
                bollPlayer = !bollPlayer;
                continue;
            }

            //цикл, проверяет заняты ли все ячейки
            int numCells = 0;
            for (int f = 0; f < game.length;f++){
                for(int s = 0; s < game[f].length;s++){
                    if(game[f][s] == ' '){
                        numCells++;

                    }
                }
            }
            //условие для Ничьи
            if (numCells < 2){
                System.out.println("It's a TIE!\n");
                t = false;
            }


            //создали цикл
            for(int i = 0; i < 4; i++) {
                boolean close = true;
                for (int j = 0; j < 4; j++) {
                    //если ввеленое значение равно "а1"
                    //то в ячейку game[0][0] присваиваем x или o зависит от игрока
                    if (Objects.equals(move, "a1")) {
                        game[1][1] = choice;
                    } else if (Objects.equals(move, "a2")) {
                        game[1][2] = choice;
                    } else if (Objects.equals(move, "a3")) {
                        game[1][3] = choice;
                    } else if (Objects.equals(move, "b1")) {
                        game[2][1] = choice;
                    } else if (Objects.equals(move, "b2")) {
                        game[2][2] = choice;
                    } else if (Objects.equals(move, "b3")) {
                        game[2][3] = choice;
                    } else if (Objects.equals(move, "c1")) {
                        game[3][1] = choice;
                    } else if (Objects.equals(move, "c2")) {
                        game[3][2] = choice;
                    } else if (Objects.equals(move, "c3")) {
                        game[3][3] = choice;
                    } else {
                        //если нету совпадений то выходим из цикла
                        close = false;
                        break;
                    }
                    //выводим на экран что получилось
                    System.out.print(" |" + game[i][j] + "| ");

                }
                //условие для разметки
//                if(i < 3){
//                    System.out.println("\n     ----------------");
//                }
                if(i == 0){
                    System.out.println("\n");
                } else if (i > 0 && i < 3) {
                    System.out.println("\n     ----------------");
                }
                //условие для выхода из цикла
                if (close == false) {
                    break;
                }
            }

            System.out.println("\n");
            //if player 1 won
            //прописываем услове для победы первого игрока
            if((game[1][1] == 'x') && (game[1][2] == 'x') && (game[1][3] == 'x')){   //если по горизонтали все ячейки затяны то игра прикрощается
                System.out.println("Player 1 won!!");
                t = false;              //если t больше не равно true то цикл while прикращается
                break;
            } else if ((game[2][1] == 'x') && (game[2][2] == 'x') && (game[2][3] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[3][1] == 'x') && (game[3][2] == 'x') && (game[3][3] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[1][1] == 'x') && (game[2][1] == 'x') && (game[3][1] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[1][2] == 'x') && (game[2][2] == 'x') && (game[3][2] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[1][3] == 'x') && (game[2][3] == 'x') && (game[3][3] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[1][1] == 'x') && (game[2][2] == 'x') && (game[3][3] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }else if ((game[1][3] == 'x') && (game[2][2] == 'x') && (game[3][1] == 'x')) {
                System.out.println("Player 1 won!!");
                t = false;
            }

            //if player 2 won
            //такое же услове для второго игрока
            if((game[1][1] == 'o') && (game[1][2] == 'o') && (game[1][3] == 'o')){
                System.out.println("Player 2 won!!");
                t = false;
            } else if ((game[2][1] == 'o') && (game[2][2] == 'o') && (game[2][3] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[3][1] == 'o') && (game[3][2] == 'o') && (game[3][3] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[1][1] == 'o') && (game[2][1] == 'o') && (game[3][1] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[1][2] == 'o') && (game[2][2] == 'o') && (game[3][2] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[1][3] == 'o') && (game[2][3] == 'o') && (game[3][3] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[1][1] == 'o') && (game[2][2] == 'o') && (game[3][3] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }else if ((game[1][3] == 'o') && (game[2][2] == 'o') && (game[3][1] == 'o')) {
                System.out.println("Player 2 won!!");
                t = false;
            }
        }
    }
    //функция проверяет совпадения с "x либо o"
    //принимает массив с индексами x,y
    private static boolean checkPo(char[][] array, int x, int y){
        if(Objects.equals(array[x][y], 'o') || Objects.equals(array[x][y], 'x')){   //сравнимает если елемент массива равен  x или o
            return true;
        }
        return false;
    }


    //function for coordinate
    //функция которая разбирает координаты
    private static int[] coordinate(String num){  //function takes string that wrote gamer   //принимает Строку написаную пользователем
        int[] coord = {0,0};
        switch (num){
            case "a1":   //if gamer wrote "a1"    //если пользователь написал "a1"
                coord[0] = 1;  //it means that it's game[0][0]
                coord[1] = 1;  //это значит что наши координаты game[0][0]
                break;    //since the answer matched we end switch    //как только ответ совпадёт ты разрываем выходим из switch case
            case "a2":
                coord[0] = 1;
                coord[1] = 2;
                break;
            case "a3":
                coord[0] = 1;
                coord[1] = 3;
                break;
            case "b1":
                coord[0] = 2;
                coord[1] = 1;
                break;
            case "b2":
                coord[0] = 2;
                coord[1] = 2;
                break;
            case "b3":
                coord[0] = 2;
                coord[1] = 3;
                break;
            case "c1":
                coord[0] = 3;
                coord[1] = 1;
                break;
            case "c2":
                coord[0] = 3;
                coord[1] = 2;
                break;
            case "c3":
                coord[0] = 3;
                coord[1] = 3;
                break;
            default:
                //if nothing matched  //если не один вариан не подойдёт
                System.out.print("\nthere is no such option, choose letter (a-c) + number (1-3), in this form 'b2'.");

                bollPlayer = !bollPlayer;

                break;
        }
        //at the end we return from switch case coordinates
        //мы воздващаем масив координат
        //like if gamer entered "a2"  we will become game[0][1] -- coordinates
        //если пользовательввел "a2" мы получим game[0][1]  --координаты
        return coord;
    }
}