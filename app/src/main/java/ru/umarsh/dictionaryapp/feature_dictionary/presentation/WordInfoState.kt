package ru.umarsh.dictionaryapp.feature_dictionary.presentation

import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
