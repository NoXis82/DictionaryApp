package ru.umarsh.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Meaning
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Long? = null,
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
) {
    fun toWordInfo(): WordInfo =
        WordInfo(
            meanings = meanings,
            phonetic = phonetic,
            word = word
        )
}
