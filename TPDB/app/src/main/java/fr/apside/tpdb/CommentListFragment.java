package fr.apside.tpdb;

import android.app.ListFragment;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by christophe on 18/06/15.
 */
public class CommentListFragment extends ListFragment {
    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CommentsDataSource ds = new CommentsDataSource(getActivity());


        try {
            ds.open();
//            ArrayAdapter<Comment> arrayAdapter = new ArrayAdapter<Comment>(getActivity(), android.R.layout.simple_list_item_1, ds.getAllComments());
//            setListAdapter(arrayAdapter);

            SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_2, ds.getAllCommentsCursor(), new String[]{"comment", "_id"}, new int[]{android.R.id.text1, android.R.id.text2}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            setListAdapter(simpleCursorAdapter);
            /*
            ds.createComment("comment 1");
            ds.createComment("comment 2");
            ds.createComment("comment 3");
            ds.createComment("comment 4");
            ds.createComment("comment 5");
            */

            ds.close();
        } catch (SQLException e) {
            Log.e("MY_APP", "Ouch", e);
        }

    }
}
