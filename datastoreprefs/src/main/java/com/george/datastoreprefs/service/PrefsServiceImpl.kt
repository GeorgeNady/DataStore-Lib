package com.george.datastoreprefs.service

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import com.george.datastoreprefs.repo.PrefsRepo
import com.george.datastoreprefs.util.Constants.NAME
import kotlinx.coroutines.flow.first

internal class PrefsServiceImpl : PrefsRepo {

    override suspend fun <T> Context.savePrefs(prefsKey: Preferences.Key<T>, value: T) {
        val dataStore: DataStore<Preferences> = createDataStore(name = NAME)
        if (value is String || value is Int || value is Double || value is Float || value is Boolean) {
            dataStore.edit { it[prefsKey] = value }
        } else throw(TypeCastException("please use String, Int,Double, Float, Boolean"))
    }

    override suspend fun <T> Context.saveBulkPrefs(vararg keyValuePairs: Pair<Preferences.Key<T>, T>): Boolean {
        val dataStore: DataStore<Preferences> = createDataStore(name = NAME)
        return try {
            keyValuePairs.forEach {
                if (it.second is String || it.second is Int || it.second is Double || it.second is Float || it.second is Boolean) {
                    dataStore.edit { settings -> settings[it.first] = it.second }
                } else return false
            }
            true
        } catch (e: Exception) {
            Log.e("com.george.prefs", "saveBulk: $e", e)
            false
        }
    }

    override suspend fun <T> Context.readPrefs(prefsKey: Preferences.Key<T>): T? {
        val dataStore: DataStore<Preferences> = createDataStore(name = NAME)
        return dataStore.data.first()[prefsKey]
    }

}