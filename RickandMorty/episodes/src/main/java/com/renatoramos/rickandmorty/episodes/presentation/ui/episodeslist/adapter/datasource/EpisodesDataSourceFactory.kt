package com.renatoramos.rickandmorty.episodes.presentation.ui.episodeslist.adapter.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.renatoramos.rickandmorty.domain.usecases.episodes.EpisodesUseCase
import com.renatoramos.rickandmorty.domain.viewobject.characters.CharacterViewObject
import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import io.reactivex.disposables.CompositeDisposable

class EpisodesDataSourceFactory (
    private val compositeDisposable: CompositeDisposable,
    private val episodesUseCase: EpisodesUseCase
) : DataSource.Factory<Int, EpisodeViewObject>() {

    var listRepositoriesDataSourceLiveData = MutableLiveData<EpisodesDataSource>()

    override fun create(): DataSource<Int, EpisodeViewObject> {
        val listRepositoriesDataSource = EpisodesDataSource(compositeDisposable, episodesUseCase)
        listRepositoriesDataSourceLiveData.postValue(listRepositoriesDataSource)
        return listRepositoriesDataSource
    }
}
