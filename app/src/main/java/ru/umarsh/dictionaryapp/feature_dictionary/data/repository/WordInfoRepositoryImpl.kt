package ru.umarsh.dictionaryapp.feature_dictionary.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.umarsh.dictionaryapp.core.util.Resource
import ru.umarsh.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import ru.umarsh.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.WordInfo
import ru.umarsh.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {


    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))
        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Упс, что-то не так", data = wordInfos))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Не удалось связаться с сервером. Проверте соединение",
                    data = wordInfos
                )
            )
        }
        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}