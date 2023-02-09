package ru.umarsh.dictionaryapp.feature_dictionary.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.umarsh.dictionaryapp.core.util.Resource
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.WordInfo

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}