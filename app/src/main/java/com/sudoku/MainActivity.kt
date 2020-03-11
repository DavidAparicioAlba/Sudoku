package com.sudoku

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), com.sudoku.BoardView.OnTouchListener {

    private lateinit var viewModel: SudokuViewModel
    private lateinit var numberButtons: List<Button>

    override fun onCellTouched(row: Int, col: Int) {
            viewModel.sudokuGame.updateSelectedCell(row, col)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        sudokuView.registerListener(this)

        viewModel = ViewModelProviders.of(this).get(SudokuViewModel::class.java)
        viewModel.sudokuGame.selectedCellLiveData.observe(this, Observer { updateSelectedCellUI(it) })
        viewModel.sudokuGame.cellsLiveData.observe(this, Observer { updateCells(it) })
        viewModel.sudokuGame.isTakingNotesLiveData.observe(this, Observer { updateNoteTakingUI(it) })
        viewModel.sudokuGame.highlightedKeysLiveData.observe(this, Observer { updateHighlightedKeys(it) })
        viewModel.sudokuGame.isVictoryLiveData.observe(this, Observer { checkVictory(it) })


        numberButtons = listOf(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton,
            sevenButton, eightButton, nineButton)

        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener { viewModel.sudokuGame.handleInput(index + 1) }
        }

        notesButton.setOnClickListener { viewModel.sudokuGame.changeNoteTakingState() }
        deleteButton.setOnClickListener { viewModel.sudokuGame.delete() }
    }

    private fun updateCells(cells: List<Cell>?) = cells?.let {
        sudokuView.updateCells(cells)
        viewModel.sudokuGame.checkVictory(cells)
    }

    private fun checkVictory(isvivtory: Boolean){
        val toast = Toast.makeText(this, "victory", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        if (isvivtory) toast.show()
    }

    private fun updateSelectedCellUI(cell: Pair<Int, Int>?) = cell?.let {
        sudokuView.updateSelectedCellUI(cell.first, cell.second)
    }

    private fun updateNoteTakingUI(isNoteTaking: Boolean?) = isNoteTaking?.let {
        val color = if (it) ContextCompat.getColor(this, R.color.colorPrimary) else Color.LTGRAY
        notesButton.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
    }

    private fun updateHighlightedKeys(set: Set<Int>?) = set?.let {
        numberButtons.forEachIndexed { index, button ->
            val color = if (set.contains(index + 1)) ContextCompat.getColor(this, R.color.colorPrimary) else Color.LTGRAY
            button.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
