package ru.umarsh.dictionaryapp.feature_dictionary.data.remote.dto

import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning = Meaning(definitions.map { it.toDefinition() }, partOfSpeech)
}