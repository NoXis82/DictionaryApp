package ru.umarsh.dictionaryapp.feature_dictionary.data.remote.dto

import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition(): Definition = Definition(antonyms, definition, example, synonyms)
}