package ru.umarsh.dictionaryapp.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.umarsh.dictionaryapp.BuildConfig
import ru.umarsh.dictionaryapp.feature_dictionary.data.local.Converters
import ru.umarsh.dictionaryapp.feature_dictionary.data.local.WordInfoDatabase
import ru.umarsh.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import ru.umarsh.dictionaryapp.feature_dictionary.data.repository.WordInfoRepositoryImpl
import ru.umarsh.dictionaryapp.feature_dictionary.data.util.GsonParser
import ru.umarsh.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import ru.umarsh.dictionaryapp.feature_dictionary.domain.use_case.GetWordInfo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(api: DictionaryApi, db: WordInfoDatabase): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(application: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            application, WordInfoDatabase::class.java, "word_db"
        )
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}