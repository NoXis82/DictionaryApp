package ru.umarsh.dictionaryapp.feature_dictionary.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.umarsh.dictionaryapp.core.util.Resource
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.WordInfo
import ru.umarsh.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}