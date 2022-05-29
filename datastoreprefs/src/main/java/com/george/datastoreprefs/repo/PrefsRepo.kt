package com.george.datastoreprefs.repo

import android.content.Context
import androidx.datastore.preferences.core.Preferences

interface PrefsRepo {

    suspend fun <T> Context.savePrefs(prefsKey: Preferences.Key<T>, value: T)

    suspend fun <T> Context.saveBulkPrefs(vararg keyValuePairs: Pair<Preferences.Key<T>, T>): Boolean

    suspend fun <T> Context.readPrefs(prefsKey: Preferences.Key<T>): T?

}