package ru.umarsh.dictionaryapp.feature_dictionary.data.remote.dto

import ru.umarsh.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String? = null,
    val phonetics: List<PhoneticDto>? = null,
    val word: String
) {

    fun toWordInfoEntity(): WordInfoEntity =
        WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic ?: "",
            word = word
        )
}