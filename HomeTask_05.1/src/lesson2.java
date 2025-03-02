public class lesson2 {


    //  FirstName_LastName_Task<Number>
/*
   1
  22
 333
4444

0
rowNumbers = 4

1
Числа
[c]0123[row]
[0]	[1 раз] [число 1] => [0 + 1] == [строка + 1]
[1] [2 раз] [число 2] => [1 + 1] == [строка + 1]
[2] [3 раз] [число 3] => [2 + 1] == [строка + 1]
[3] [4 раз] [число 4] => [3 + 1] == [строка + 1]

2
Пробелы
[c]0123[row]
[0]	[3 раз] [пробел] => [4 - 1] == [rowNumbers - 1]
[1] [2 раз] [пробел] => [4 - 2] == [rowNumbers - 2]
[2] [1 раз] [пробел] => [4 - 3] == [rowNumbers - 3]
[3] [0 раз] [пробел] => [4 - 4] == [rowNumbers - 4]

2.2
[0]	[3 раз] [пробел] => [4 - 1] == [rowNumbers - 1] == [rowNumbers - строка + 1]
[1] [2 раз] [пробел] => [4 - 2] == [rowNumbers - 2] == [rowNumbers - строка + 1]
[2] [1 раз] [пробел] => [4 - 3] == [rowNumbers - 3] == [rowNumbers - строка + 1]
[3] [0 раз] [пробел] => [4 - 4] == [rowNumbers - 4] == [rowNumbers - строка + 1]


*/
    public static void main(String[] args) {
        int rowNumbers = 4;
        System.out.print("[c]0123");
        System.out.print("[row]");
        System.out.println("");
        for(int row = 0; row < rowNumbers; row++) { // Rows
            System.out.print("[" + row + "]");

            int number = row + 1;

            for(int repeatTimesSpaces =  rowNumbers - number; repeatTimesSpaces > 0; repeatTimesSpaces--) { // Column, spaces
                System.out.print(" ");
            }

            for(int repeatTimes =  number; repeatTimes > 0; repeatTimes--) { // Column, numbers
                System.out.print(number);
            }

            System.out.println("");
        }
    }
}

