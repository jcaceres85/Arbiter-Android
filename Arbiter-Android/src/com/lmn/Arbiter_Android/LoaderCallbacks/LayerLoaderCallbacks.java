package com.lmn.Arbiter_Android.LoaderCallbacks;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.lmn.Arbiter_Android.BaseClasses.Layer;
import com.lmn.Arbiter_Android.ListAdapters.LayerListAdapter;
import com.lmn.Arbiter_Android.Loaders.LayersListLoader;

public class LayerLoaderCallbacks implements LoaderManager.LoaderCallbacks<Layer[]>{

	private LayerListAdapter layerAdapter;
	private FragmentActivity activity;
	
	public LayerLoaderCallbacks(FragmentActivity activity, 
			LayerListAdapter adapter, int loaderId){
		this.layerAdapter = adapter;
		this.activity = activity;
		
		activity.getSupportLoaderManager().initLoader(loaderId, null, this);
	}
	
	@Override
	public Loader<Layer[]> onCreateLoader(int id, Bundle bundle) {
		// This is called when a new Loader needs to be created.  This
        // sample only has one Loader with no arguments, so it is simple.
        return new LayersListLoader(activity.getApplicationContext());
	}

	@Override
	public void onLoadFinished(Loader<Layer[]> loader, Layer[] data) {
		layerAdapter.setData(data);
	}

	@Override
	public void onLoaderReset(Loader<Layer[]> loader) {
		layerAdapter.setData(null);
	}	
}