package com.renatoramos.rickandmorty.data.store.local.paperdb.provider.characters

import com.renatoramos.rickandmorty.data.store.dto.characters.CharacterDTO
import io.paperdb.Paper
import io.reactivex.Observable


class CharacterProvider {

    fun add(repos: List<CharacterDTO>, page: Int, tagKey: String): Observable<List<CharacterDTO>> {
        val tagPage = tagKey+page

        return Observable.create<List<CharacterDTO>> { e ->
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

    fun getAll(page: Int, tagKey: String): Observable<List<CharacterDTO>> {
        val repoList = Paper.book().read<List<CharacterDTO>>(tagKey+page)

        return if (repoList != null) {
           Observable.just<List<CharacterDTO>>(repoList)
        } else {
            val characterDTOList: List<CharacterDTO> = listOf()
           Observable.just(characterDTOList)
        }
    }

    fun getById(id: Int?, page: Int, tagKey: String): Observable<CharacterDTO> {
        val repoList = Paper.book().read<List<CharacterDTO>>(tagKey+page)

        return if (repoList != null) {
           Observable.fromIterable(repoList).filter { repo -> repo.id == id }.map{
                    customer -> customer }
        } else {
            val characterDTOList: CharacterDTO? = null
           Observable.just<CharacterDTO>(characterDTOList)
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