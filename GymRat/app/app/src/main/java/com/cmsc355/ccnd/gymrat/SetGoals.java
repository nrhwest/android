package com.cmsc355.ccnd.gymrat;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static com.cmsc355.ccnd.gymrat.SetGoalsDatabase.COLUMN_GOAL_NAME;
import static com.cmsc355.ccnd.gymrat.SetGoalsDatabase.COLUMN_GOAL_MESSAGE;

public class SetGoals extends AppCompatActivity {

    SetGoalsDatabase databaseHandler;
    SimpleCursorAdapter simpleCursorAdapter;
    EditText nameEdit;
    EditText messageEdit;
    ListView goalList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goals);


        nameEdit = (EditText) findViewById(R.id.GoalName);
        messageEdit = (EditText) findViewById(R.id.messageText);
        goalList = (ListView) findViewById(R.id.goalList);
        databaseHandler = new SetGoalsDatabase(this, null, null, 1);
        displayProductList();

    }

    private void displayProductList() {
        try {
            Cursor cursor = databaseHandler.getAll();
            if (cursor == null) {

                return;
            }
            if (cursor.getCount() == 0) {
                return;
            }
            String[] columns = new String[] {

              SetGoalsDatabase.COLUMN_GOAL_NAME,
              COLUMN_GOAL_MESSAGE
            };
            int[] boundTo = new int[] {
              R.id.goalAdpater,
              R.id.messageAdapter
            };
            simpleCursorAdapter = new SimpleCursorAdapter(this,
                    R.layout.goal_list,
                    cursor,
                    columns,
                    boundTo,
                    0);
            goalList.setAdapter(simpleCursorAdapter);
        } catch (Exception ex) {
            //Somehting went wrong
        }
    }

    public void addGoal(View view) {
        try {
            Goals goals = new Goals(nameEdit.getText().toString(),
                    (messageEdit.getText().toString()));

            databaseHandler.add(goals);

            nameEdit.setText("");
            messageEdit.setText("");
            displayProductList();
        } catch (Exception exception) {
            //Something went wrong
        }
    }


    public void deleteGoal(View view) {
        if (databaseHandler.delete(nameEdit.getText().toString())) {

            nameEdit.setText("");
            messageEdit.setText("");
            displayProductList();
        } else {
            //food Edit is Empty, problem
        }
    }

    public void deleteAllGoals(View view) {
        databaseHandler.deleteAll();

        nameEdit.setText("");
        messageEdit.setText("");
        goalList.setAdapter(null);
    }


}
