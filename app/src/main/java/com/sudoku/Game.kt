package com.sudoku

import android.util.Log
import androidx.lifecycle.MutableLiveData
import java.lang.Math.random
import kotlin.random.Random

class Game {

    var selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()
    var cellsLiveData = MutableLiveData<List<Cell>>()
    val isTakingNotesLiveData = MutableLiveData<Boolean>()
    val highlightedKeysLiveData = MutableLiveData<Set<Int>>()

    private var selectedRow = -1
    private var selectedCol = -1
    private var isTakingNotes = false

    val board: Board

    private var sumRow: Int = 0
    private var sumCol: Int = 0
    private var sumSquare: Int = 0

    var victory = false

    val isVictoryLiveData = MutableLiveData<Boolean>()
    var sudokus = Sudoku.sudokus

    var sudokunumberlist = Random.nextInt(0,4)

    init {
        Log.d("initGame", "init")
        val cells = sudokus[0]
        for (i in 0 until sudokus[0].size){
            if (sudokus[0][i].value != 0){
                sudokus[0][i].isStartingCell = true
            }
        }
        board = Board(9, cells)

        selectedCellLiveData.postValue(Pair(selectedRow, selectedCol))
        cellsLiveData.postValue(board.cells)
        isTakingNotesLiveData.postValue(isTakingNotes)
        isVictoryLiveData.postValue(victory)

    }

    fun checkVictory(cells: List<Cell>){
        for (i in 0..8){
            for (j in 0..8){
                sumRow += cells[(i*9)+j].value
                sumCol += cells[(j*9)+i].value

            }
            sumSquare = cells[0 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[1 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[2 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[9 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[10 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[11 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[18 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[19 + ((i/3)*27) + ((i%3)*3)].value+
                    cells[20 + ((i/3)*27) + ((i%3)*3)].value

            if (sumRow != 45) {
                Log.d("sumatoryrow", sumRow.toString())
                sumRow = 0
                sumCol = 0
                sumSquare = 0
                break
            }
            if (sumCol != 45) {
                Log.d("sumatoryCol", sumCol.toString())
                sumRow = 0
                sumCol = 0
                sumSquare = 0
                break
            }
            if (sumSquare != 45){
                Log.d("sumatorysquare", sumSquare.toString())
                sumSquare = 0
                sumRow = 0
                sumCol = 0
                break
            }
            if (i == 8){
                isVictoryLiveData.postValue(sumRow == 45 && sumCol == 45 && sumSquare == 45)
            }
            sumCol=0
            sumRow=0
            sumSquare=0

        }





        Log.d("isFinished", isVictoryLiveData.value.toString())

    }

    fun handleInput(number: Int) {
        if (selectedRow == -1 || selectedCol == -1) return
        val cell = board.getCell(selectedRow, selectedCol)
        if (cell.isStartingCell) return

        if (isTakingNotes) {
            if (cell.notes.contains(number)) {
                cell.notes.remove(number)
            } else {
                cell.notes.add(number)
            }
            highlightedKeysLiveData.postValue(cell.notes)
        } else {
            cell.value = number
        }
        cellsLiveData.postValue(board.cells)
    }


    fun updateSelectedCell(row: Int, col: Int) {
        val cell = board.getCell(row, col)
        if (!cell.isStartingCell) {
            selectedRow = row
            selectedCol = col
            selectedCellLiveData.postValue(Pair(row, col))

            if (isTakingNotes) {
                highlightedKeysLiveData.postValue(cell.notes)
            }
        }
    }

    fun changeNoteTakingState() {
        isTakingNotes = !isTakingNotes
        isTakingNotesLiveData.postValue(isTakingNotes)

        val curNotes = if (isTakingNotes) {
            board.getCell(selectedRow, selectedCol).notes
        } else {
            setOf<Int>()
        }
        highlightedKeysLiveData.postValue(curNotes)
    }

    fun delete() {
        val cell = board.getCell(selectedRow, selectedCol)
        if (isTakingNotes) {
            cell.notes.clear()
            highlightedKeysLiveData.postValue(setOf())
        } else {
            cell.value = 0
        }
        cellsLiveData.postValue(board.cells)
    }
}