package codepath.apps.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends ActionBarActivity {

    public static final String EXTRA_ITEM_POS = "codepath.apps.simpletodo.ITEM_POS";
    public static final String EXTRA_ITEM_TEXT = "codepath.apps.simpletodo.ITEM_TEXT";
    public static final String EXTRA_NEW_TEXT = "codepath.apps.simpletodo.NEW_TEXT";

    Button mSaveButton;
    EditText mEditTodo;

    int mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        mEditTodo = (EditText)findViewById(R.id.txtEditTodo);

        mItem = getIntent().getIntExtra(EXTRA_ITEM_POS, 0);

        mEditTodo.setText(getIntent().getStringExtra(EXTRA_ITEM_TEXT));

        mSaveButton = (Button)findViewById(R.id.btnSave);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_NEW_TEXT, mEditTodo.getText().toString() );
                data.putExtra(EXTRA_ITEM_POS, mItem);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
