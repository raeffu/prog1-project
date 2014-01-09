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
		EditText editText = (EditText) findViewById(R.id.message);
		editText.setText(R.string.sudoku_string_easy);
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
		Intent intent = new Intent(this, DisplayResultActivity.class);

		// Field with Sudoku string
		EditText editText = (EditText) findViewById(R.id.message);
		String message = editText.getText().toString();
		message = message.replaceAll("\\n", "");
		
		String[] stringValues = message.split(",");
    int[] sudokuValues = new int[stringValues.length];

    for (int i = 0; i < stringValues.length; i++) {
      sudokuValues[i] = Integer.parseInt(stringValues[i]);
    }
		
		// Validation of input
		if (validate(editText, sudokuValues)) {
			intent.putExtra(EXTRA_MESSAGE, sudokuValues);
			startActivity(intent);
		}
	}

	private boolean validate(EditText editText, int[] sudokuValues) {
		boolean valid = true;

		if (sudokuValues.length != 81) {
			editText.setError("You entered "
					+ String.valueOf(sudokuValues.length) + " values instead of 81");
			valid = false;
		}

		for (int sudokuValue : sudokuValues) {
			if (sudokuValue != 0) {

				if (sudokuValue > 9) {
					editText.setError("Numbers 1-9 allowed");
					valid = false;
					break;
				}
			}
		}
		return valid;
	}
}
