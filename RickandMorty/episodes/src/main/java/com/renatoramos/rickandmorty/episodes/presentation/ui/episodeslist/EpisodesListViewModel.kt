package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.renatoramos.rickandmorty.common.base.BaseViewModel
import com.renatoramos.rickandmorty.common.util.State
import com.renatoramos.rickandmorty.domain.usecases.episodes.EpisodesUseCase
import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.datasource.EpisodesDataSource
import com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.datasource.EpisodesDataSourceFactory
import javax.inject.Inject

class EpisodesListViewModel @Inject constructor(private val episodesUseCase: EpisodesUseCase) :
    BaseViewModel() {

    lateinit var reposListLiveData: LiveData<PagedList<EpisodeViewObject>>
    private lateinit var episodesDataSourceFactory: EpisodesDataSourceFactory
    private val pageSize = 20

    override fun onCleared() {
        super.onCleared()
        onStopDisposable()
    }

    fun getAllEpisodes() {
        val compositeDisposable = getCompositeDisposable()

        episodesDataSourceFactory = EpisodesDataSourceFactory(
            compositeDisposable,
            episodesUseCase
        )

        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()

        reposListLiveData = LivePagedListBuilder(
            episodesDataSourceFactory,
            config
        ).build()
    }

    fun getState(): LiveData<State> {
        return Transformations.switchMap(
            episodesDataSourceFactory.listRepositoriesDataSourceLiveData,
            EpisodesDataSource::state
        )
    }

    fun retry() {
        episodesDataSourceFactory.listRepositoriesDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return reposListLiveData.value?.isEmpty() ?: true
    }

}