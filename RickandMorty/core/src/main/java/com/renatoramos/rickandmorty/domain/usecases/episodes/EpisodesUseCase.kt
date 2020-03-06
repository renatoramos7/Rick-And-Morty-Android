package com.renatoramos.rickandmorty.domain.usecases.episodes

import com.renatoramos.rickandmorty.data.store.dto.episodes.toEpisodeViewObject
import com.renatoramos.rickandmorty.data.store.repository.episodes.EpisodesRepository
import com.renatoramos.rickandmorty.domain.viewobject.episodes.EpisodeViewObject
import io.reactivex.Maybe
import javax.inject.Inject

class EpisodesUseCase @Inject constructor(
    private val episodesRepository: EpisodesRepository
) {
    fun requestAllEpisodes(page: Int): Maybe<MutableList<EpisodeViewObject>> {
        return episodesRepository.requestAllEpisodes(page).map { characterList ->
            characterList.map { it.toEpisodeViewObject() }.toMutableList()
        }
    }

}