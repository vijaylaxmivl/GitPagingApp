package com.vl.gitpagingapp.viemodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.vl.gitpagingapp.model.GitResponse;
import com.vl.gitpagingapp.view.adapter.ItemDataSource;
import com.vl.gitpagingapp.view.adapter.ItemDataSourceFactory;

public class ItemViewModel extends ViewModel {

    public LiveData<PagedList<GitResponse>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, GitResponse>> liveDataSource;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
