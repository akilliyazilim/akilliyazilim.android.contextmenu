package akilliyazilim.android.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {

	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(R.id.list);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getResources()
						.getStringArray(R.array.Gazeteler));
		mListView.setAdapter(adapter);
		registerForContextMenu(mListView);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		String[] gazeteler = getResources().getStringArray(R.array.Gazeteler);

		switch (item.getItemId()) {
		case R.id.itemDuzenle:
			Toast.makeText(
					getApplicationContext(),
					gazeteler[(int) info.id] + " gazetesi icin "
							+ getResources().getString(R.string.menuDuzenle)
							+ " menüsü kullanýlýyor", Toast.LENGTH_LONG).show();
			return true;

		case R.id.itemFavori:
			Toast.makeText(
					getApplicationContext(),
					gazeteler[(int) info.id] + " gazetesi icin "
							+ getResources().getString(R.string.menuFavori)
							+ " menüsü kullanýlýyor", Toast.LENGTH_LONG).show();
			return true;

		case R.id.itemSil:
			Toast.makeText(
					getApplicationContext(),
					gazeteler[(int) info.id] + " gazetesi icin "
							+ getResources().getString(R.string.menuSil)
							+ " menüsü kullanýlýyor", Toast.LENGTH_LONG).show();
			return true;

		case R.id.itemGoruntule:
			Toast.makeText(
					getApplicationContext(),
					gazeteler[(int) info.id] + " gazetesi icin "
							+ getResources().getString(R.string.menuGoruntule)
							+ " menüsü kullanýlýyor", Toast.LENGTH_LONG).show();
			return true;
		}
		return true;
	}

}
