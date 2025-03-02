/*
### Задание 3. (Модуль 4. Цикли)
**Описание:**
Разработать алгоритм формирования матрицы для информационной системы обработки данных тестирования. Размер матрицы задаётся числом N. Модуль обязан заполнить матрицу следующим образом:
– Элементы первой строки и первого столбца заполняются согласно порядковому номеру строки или столбца.
– Остальные элементы вычисляются с учётом суммы порядковых номеров строки и столбца, заданного коэффициента и смещения.
После формирования матрицы необходимо вычислить сумму элементов главной диагонали. Результаты вычислений для выбранного элемента (с заданными индексами) должны быть задокументированы пошагово.

**Ввод/Вывод:**
- **Ввод:**
  – Значение N: `6`
  – Коэффициент: `5`
  – Смещение: `10`
- **Вывод:**
  – Полностью сформированная матрица размером 6×6
  – Числовое значение – сумма элементов главной диагонали
  – Подробное описание вычислений для элемента матрицы с индексами строки 3 и столбца 4

**Подсказки:**
- Организовать вложенные циклы для обхода матрицы с разделением логики заполнения первой строки и столбца от остальных элементов.
- Реализовать механизм промежуточного сохранения вычисленных значений для последующего суммирования.
- Контролировать корректность входных параметров и вывести соответствующее сообщение при ошибке.

**Области применения:**
- Системы обработки результатов тестирования и оценивания.
- Автоматизированные модули расчёта в образовательных информационных системах.

**Вопрос на интервью:**
Как вы организуете вложенные циклы для обработки матрицы большого размера, чтобы минимизировать затраты по времени и памяти?
 */

public class MatrixGenerator {
    public static void main(String[] args) {
        int N = 6;
        int coefficient = 5;
        int offset = 10;

        int[][] matrix = generateMatrix(N, coefficient, offset);

        System.out.println("Сформированная матрица:");
        printMatrix(matrix);

        int diagonalSum = calculateDiagonalSum(matrix);
        System.out.println("Сумма элементов главной диагонали: " + diagonalSum);

        int i = 2, j = 3; // 3-я строка, 4-й столбец в индексации Java
        System.out.println(explainElementComputation(i, j, coefficient, offset));
    }

    public static int[][] generateMatrix(int N, int coefficient, int offset) {
        if (N <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен быть больше 0.");
        }

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            matrix[0][i] = i + 1;
            matrix[i][0] = i + 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                matrix[i][j] = (i + 1 + j + 1) * coefficient + offset;
            }
        }

        return matrix;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static String explainElementComputation(int i, int j, int coefficient, int offset) {
        int rowNum = i + 1;
        int colNum = j + 1;
        int computedValue = (rowNum + colNum) * coefficient + offset;
        return "Элемент матрицы на позиции (" + rowNum + "," + colNum + ") вычисляется так:\n" +
                "(" + rowNum + " + " + colNum + ") * " + coefficient + " + " + offset + " = " + computedValue;
    }
}
