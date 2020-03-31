package com.sudoku

class Sudoku {
    companion object{
        val sudokus = arrayListOf<List<Cell>>(
            listOf(Cell(0,0, 4),Cell(0,1, 0), Cell(0,2, 0),Cell(0,3, 0),Cell(0,4, 0), Cell(0,5, 0),Cell(0,6, 5),Cell(0,7, 0), Cell(0,8, 0),
                Cell(1,0, 6),Cell(1,1, 1), Cell(1,2, 3),Cell(1,3, 0),Cell(1,4, 0), Cell(1,5, 0),Cell(1,6, 0),Cell(1,7, 2), Cell(1,8, 8),
                Cell(2,0, 0),Cell(2,1, 5), Cell(2,2, 0),Cell(2,3, 0),Cell(2,4, 0), Cell(2,5, 0),Cell(2,6, 0),Cell(2,7, 9), Cell(2,8, 3),
                Cell(3,0, 0),Cell(3,1, 0), Cell(3,2, 0),Cell(3,3, 0),Cell(3,4, 9), Cell(3,5, 3),Cell(3,6, 0),Cell(3,7, 0), Cell(3,8, 0),
                Cell(4,0, 0),Cell(4,1, 0), Cell(4,2, 2),Cell(4,3, 4),Cell(4,4, 0), Cell(4,5, 0),Cell(4,6, 8),Cell(4,7, 7), Cell(4,8, 0),
                Cell(5,0, 5),Cell(5,1, 7), Cell(5,2, 0),Cell(5,3, 2),Cell(5,4, 0), Cell(5,5, 0),Cell(5,6, 0),Cell(5,7, 3), Cell(5,8, 0),
                Cell(6,0, 0),Cell(6,1, 0), Cell(6,2, 6),Cell(6,3, 0),Cell(6,4, 0), Cell(6,5, 2),Cell(6,6, 3),Cell(6,7, 1), Cell(6,8, 7),
                Cell(7,0, 0),Cell(7,1, 0), Cell(7,2, 0),Cell(7,3, 1),Cell(7,4, 0), Cell(7,5, 0),Cell(7,6, 6),Cell(7,7, 0), Cell(7,8, 4),
                Cell(8,0, 0),Cell(8,1, 0), Cell(8,2, 1),Cell(8,3, 0),Cell(8,4, 6), Cell(8,5, 0),Cell(8,6, 9),Cell(8,7, 0), Cell(8,8, 0)),
            listOf(Cell(0,0, 3),Cell(0,1, 1), Cell(0,2, 0),Cell(0,3, 0),Cell(0,4, 4), Cell(0,5, 0),Cell(0,6, 6),Cell(0,7, 0), Cell(0,8, 2),
                Cell(1,0, 0),Cell(1,1, 0), Cell(1,2, 9),Cell(1,3, 0),Cell(1,4, 0), Cell(1,5, 0),Cell(1,6, 0),Cell(1,7, 0), Cell(1,8, 3),
                Cell(2,0, 0),Cell(2,1, 0), Cell(2,2, 0),Cell(2,3, 0),Cell(2,4, 0), Cell(2,5, 0),Cell(2,6, 7),Cell(2,7, 9), Cell(2,8, 4),
                Cell(3,0, 0),Cell(3,1, 0), Cell(3,2, 0),Cell(3,3, 0),Cell(3,4, 0), Cell(3,5, 7),Cell(3,6, 2),Cell(3,7, 0), Cell(3,8, 0),
                Cell(4,0, 0),Cell(4,1, 0), Cell(4,2, 7),Cell(4,3, 0),Cell(4,4, 0), Cell(4,5, 2),Cell(4,6, 0),Cell(4,7, 3), Cell(4,8, 1),
                Cell(5,0, 0),Cell(5,1, 0), Cell(5,2, 1),Cell(5,3, 0),Cell(5,4, 5), Cell(5,5, 0),Cell(5,6, 0),Cell(5,7, 0), Cell(5,8, 8),
                Cell(6,0, 0),Cell(6,1, 0), Cell(6,2, 2),Cell(6,3, 0),Cell(6,4, 8), Cell(6,5, 4),Cell(6,6, 0),Cell(6,7, 6), Cell(6,8, 0),
                Cell(7,0, 1),Cell(7,1, 4), Cell(7,2, 6),Cell(7,3, 0),Cell(7,4, 0), Cell(7,5, 3),Cell(7,6, 0),Cell(7,7, 0), Cell(7,8, 5),
                Cell(8,0, 7),Cell(8,1, 0), Cell(8,2, 0),Cell(8,3, 2),Cell(8,4, 0), Cell(8,5, 0),Cell(8,6, 0),Cell(8,7, 0), Cell(8,8, 0)),
            listOf(Cell(0,0, 0),Cell(0,1, 0), Cell(0,2, 0),Cell(0,3, 0),Cell(0,4, 0), Cell(0,5, 0),Cell(0,6, 0),Cell(0,7, 0), Cell(0,8, 0),
                Cell(1,0, 0),Cell(1,1, 0), Cell(1,2, 0),Cell(1,3, 0),Cell(1,4, 0), Cell(1,5, 0),Cell(1,6, 0),Cell(1,7, 0), Cell(1,8, 0),
                Cell(2,0, 0),Cell(2,1, 0), Cell(2,2, 0),Cell(2,3, 0),Cell(2,4, 0), Cell(2,5, 0),Cell(2,6, 0),Cell(2,7, 0), Cell(2,8, 0),
                Cell(3,0, 0),Cell(3,1, 0), Cell(3,2, 0),Cell(3,3, 0),Cell(3,4, 0), Cell(3,5, 0),Cell(3,6, 0),Cell(3,7, 0), Cell(3,8, 0),
                Cell(4,0, 0),Cell(4,1, 0), Cell(4,2, 0),Cell(4,3, 0),Cell(4,4, 0), Cell(4,5, 0),Cell(4,6, 0),Cell(4,7, 0), Cell(4,8, 0),
                Cell(5,0, 0),Cell(5,1, 0), Cell(5,2, 0),Cell(5,3, 0),Cell(5,4, 0), Cell(5,5, 0),Cell(5,6, 0),Cell(5,7, 0), Cell(5,8, 0),
                Cell(6,0, 0),Cell(6,1, 0), Cell(6,2, 0),Cell(6,3, 0),Cell(6,4, 0), Cell(6,5, 0),Cell(6,6, 0),Cell(6,7, 0), Cell(6,8, 0),
                Cell(7,0, 0),Cell(7,1, 0), Cell(7,2, 0),Cell(7,3, 0),Cell(7,4, 0), Cell(7,5, 0),Cell(7,6, 0),Cell(7,7, 0), Cell(7,8, 0),
                Cell(8,0, 0),Cell(8,1, 0), Cell(8,2, 0),Cell(8,3, 0),Cell(8,4, 0), Cell(8,5, 0),Cell(8,6, 0),Cell(8,7, 0), Cell(8,8, 0)),
            listOf(Cell(0,0, 0),Cell(0,1, 0), Cell(0,2, 0),Cell(0,3, 0),Cell(0,4, 0), Cell(0,5, 0),Cell(0,6, 0),Cell(0,7, 0), Cell(0,8, 0),
                Cell(1,0, 0),Cell(1,1, 0), Cell(1,2, 0),Cell(1,3, 0),Cell(1,4, 0), Cell(1,5, 0),Cell(1,6, 0),Cell(1,7, 0), Cell(1,8, 0),
                Cell(2,0, 0),Cell(2,1, 0), Cell(2,2, 0),Cell(2,3, 0),Cell(2,4, 0), Cell(2,5, 0),Cell(2,6, 0),Cell(2,7, 0), Cell(2,8, 0),
                Cell(3,0, 0),Cell(3,1, 0), Cell(3,2, 0),Cell(3,3, 0),Cell(3,4, 0), Cell(3,5, 0),Cell(3,6, 0),Cell(3,7, 0), Cell(3,8, 0),
                Cell(4,0, 0),Cell(4,1, 0), Cell(4,2, 0),Cell(4,3, 0),Cell(4,4, 0), Cell(4,5, 0),Cell(4,6, 0),Cell(4,7, 0), Cell(4,8, 0),
                Cell(5,0, 0),Cell(5,1, 0), Cell(5,2, 0),Cell(5,3, 0),Cell(5,4, 0), Cell(5,5, 0),Cell(5,6, 0),Cell(5,7, 0), Cell(5,8, 0),
                Cell(6,0, 0),Cell(6,1, 0), Cell(6,2, 0),Cell(6,3, 0),Cell(6,4, 0), Cell(6,5, 0),Cell(6,6, 0),Cell(6,7, 0), Cell(6,8, 0),
                Cell(7,0, 0),Cell(7,1, 0), Cell(7,2, 0),Cell(7,3, 0),Cell(7,4, 0), Cell(7,5, 0),Cell(7,6, 0),Cell(7,7, 0), Cell(7,8, 0),
                Cell(8,0, 0),Cell(8,1, 0), Cell(8,2, 0),Cell(8,3, 0),Cell(8,4, 0), Cell(8,5, 0),Cell(8,6, 0),Cell(8,7, 0), Cell(8,8, 0)),
            listOf(Cell(0,0, 0),Cell(0,1, 0), Cell(0,2, 0),Cell(0,3, 0),Cell(0,4, 0), Cell(0,5, 0),Cell(0,6, 0),Cell(0,7, 0), Cell(0,8, 0),
                Cell(1,0, 0),Cell(1,1, 0), Cell(1,2, 0),Cell(1,3, 0),Cell(1,4, 0), Cell(1,5, 0),Cell(1,6, 0),Cell(1,7, 0), Cell(1,8, 0),
                Cell(2,0, 0),Cell(2,1, 0), Cell(2,2, 0),Cell(2,3, 0),Cell(2,4, 0), Cell(2,5, 0),Cell(2,6, 0),Cell(2,7, 0), Cell(2,8, 0),
                Cell(3,0, 0),Cell(3,1, 0), Cell(3,2, 0),Cell(3,3, 0),Cell(3,4, 0), Cell(3,5, 0),Cell(3,6, 0),Cell(3,7, 0), Cell(3,8, 0),
                Cell(4,0, 0),Cell(4,1, 0), Cell(4,2, 0),Cell(4,3, 0),Cell(4,4, 0), Cell(4,5, 0),Cell(4,6, 0),Cell(4,7, 0), Cell(4,8, 0),
                Cell(5,0, 0),Cell(5,1, 0), Cell(5,2, 0),Cell(5,3, 0),Cell(5,4, 0), Cell(5,5, 0),Cell(5,6, 0),Cell(5,7, 0), Cell(5,8, 0),
                Cell(6,0, 0),Cell(6,1, 0), Cell(6,2, 0),Cell(6,3, 0),Cell(6,4, 0), Cell(6,5, 0),Cell(6,6, 0),Cell(6,7, 0), Cell(6,8, 0),
                Cell(7,0, 0),Cell(7,1, 0), Cell(7,2, 0),Cell(7,3, 0),Cell(7,4, 0), Cell(7,5, 0),Cell(7,6, 0),Cell(7,7, 0), Cell(7,8, 0),
                Cell(8,0, 0),Cell(8,1, 0), Cell(8,2, 0),Cell(8,3, 0),Cell(8,4, 0), Cell(8,5, 0),Cell(8,6, 0),Cell(8,7, 0), Cell(8,8, 0))

        )
    }
}