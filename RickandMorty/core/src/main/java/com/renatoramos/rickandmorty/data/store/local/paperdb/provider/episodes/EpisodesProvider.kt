package com.renatoramos.rickandmorty.data.store.local.paperdb.provider.episodes

import com.renatoramos.rickandmorty.data.store.dto.episodes.EpisodeDTO
import io.paperdb.Paper
import io.reactivex.Observable

class EpisodesProvider {
    
    fun add(repos: List<EpisodeDTO>, page: Int, tagKey: String): Observable<List<EpisodeDTO>> {
        val tagPage = tagKey+page

        return Observable.create<List<EpisodeDTO>> { e ->
            try {
                Paper.book().delete(tagPage)
                Paper.book().write(tagPage, repos)
                e.onNext(repos)
                e.onComplete()
            } catch (exception: Exception) {
                e.onError(exception)
            }
        }
    }

    fun getAll(page: Int, tagKey: String): Observable<List<EpisodeDTO>> {
        val repoList = Paper.book().read<List<EpisodeDTO>>(tagKey+page)

        return if (repoList != null) {
            Observable.just<List<EpisodeDTO>>(repoList)
        } else {
            val episodeDTOList: List<EpisodeDTO> = listOf()
            Observable.just(episodeDTOList)
        }
    }

    fun getById(id: Int?, page: Int, tagKey: String): Observable<EpisodeDTO> {
        val repoList = Paper.book().read<List<EpisodeDTO>>(tagKey+page)

        return if (repoList != null) {
            Observable.fromIterable(repoList).filter { repo -> repo.id == id }.map{
                    customer -> customer }
        } else {
            val episodeDTOList: EpisodeDTO? = null
            Observable.just<EpisodeDTO>(episodeDTOList)
        }
    }

    fun delete(page: Int, tagKey: String): Observable<Void> {
        return Observable.create { e ->
            try {
                Paper.book().delete(tagKey+page)
                e.onComplete()
            } catch (exception: Exception) {
                e.onError(exception)
            }
        }
    }
}