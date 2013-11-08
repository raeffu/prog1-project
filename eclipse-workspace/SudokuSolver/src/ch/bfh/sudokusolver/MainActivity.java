package ch.bfh.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "ch.bfh.sudokusolver.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set default text, empty sudoku
		EditText editText = (EditText) findViewById(R.id.edit_message);
		editText.setText(R.string.edit_message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		// Intent to lunch activity with Sudou Solution
		Intent intent = new Intent(this, DisplayMessageActivity.class);

		// Field with Sudoku string
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();

		// Validation of input
		if (validate(editText, message)) {
			intent.putExtra(EXTRA_MESSAGE, message);
			startActivity(intent);
		}
	}

	private boolean validate(EditText editText, String sudoku) {
		boolean valid = true;

		String[] sudokuValues = sudoku.split(",");
		// editText.setError(String.valueOf(sudokuValues.length));

		if (sudokuValues.length != 81) {
			editText.setError("Please enter 81 values (or empy fields)");
			valid = false;
		}

		for (String sudokuValue : sudokuValues) {
			if (!sudokuValue.equals("-")) {

				int number = Integer.parseInt(sudokuValue);
				if (number > 9) {
					editText.setError("Numbers 0-9 allowed");
					valid = false;
					break;
				}
			}
		}

		return valid;
	}

}
