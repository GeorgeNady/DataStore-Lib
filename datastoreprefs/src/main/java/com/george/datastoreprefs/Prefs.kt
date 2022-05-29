package com.george.datastoreprefs

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import com.george.datastoreprefs.repo.PrefsRepo
import org.koin.java.KoinJavaComponent.inject

object Prefs {

    private val repo: PrefsRepo by inject(PrefsRepo::class.java)

    /**
     * # Save
     *
     */
    suspend fun <T> Context.savePrefs(prefsKey: Preferences.Key<T>, value: T) = repo.apply { savePrefs(prefsKey, value) }

    /**
     * # Save Bulk
     *
     */
    suspend fun <T> Context.saveBulkPrefs(vararg keyValuePairs: Pair<Preferences.Key<T>, T>) = repo.apply { saveBulkPrefs(*keyValuePairs) }

    /**
     * # Read
     *
     */
    suspend fun <T> Context.readPrefs(prefsKey: Preferences.Key<T>): T? {
        val result: T?
        repo.apply { result = readPrefs(prefsKey) }
        return result
    }


}