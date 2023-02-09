package ru.umarsh.dictionaryapp.feature_dictionary.data.remote.dto

import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Phonetic

data class PhoneticDto(
    val audio: String,
    val text: String
) {
    fun toPhonetic(): Phonetic = Phonetic(audio, text)
}