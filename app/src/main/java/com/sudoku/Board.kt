package com.sudoku

class Board(val size: Int = 9, val cells: List<Cell>) {
    fun getCell(row: Int, col: Int) = cells[row * size + col]
}