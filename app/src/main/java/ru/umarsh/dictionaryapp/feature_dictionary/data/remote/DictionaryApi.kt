package ru.umarsh.dictionaryapp.feature_dictionary.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.umarsh.dictionaryapp.feature_dictionary.data.remote.dto.WordInfoDto

interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(@Path("word") word: String): List<WordInfoDto>
}