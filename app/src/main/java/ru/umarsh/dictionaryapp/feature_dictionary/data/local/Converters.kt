package ru.umarsh.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import ru.umarsh.dictionaryapp.feature_dictionary.data.util.JsonParser
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Meaning
import ru.umarsh.dictionaryapp.feature_dictionary.domain.model.Phonetic

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromPhoneticsJson(json: String): List<Phonetic> {
        return jsonParser.fromJson<ArrayList<Phonetic>>(
            json,
            object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toPhoneticsJson(phonetics: List<Phonetic>): String {
        return jsonParser.toJson(
            phonetics,
            object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: "[]"
    }
}