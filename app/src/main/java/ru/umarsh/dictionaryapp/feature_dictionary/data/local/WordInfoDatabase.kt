package ru.umarsh.dictionaryapp.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.umarsh.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    version = 1,
    entities = [
        WordInfoEntity::class
    ]
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {

    abstract val dao: WordInfoDao
}